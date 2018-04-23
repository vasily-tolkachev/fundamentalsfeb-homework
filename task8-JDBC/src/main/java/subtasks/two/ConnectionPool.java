package subtasks.two;

import io.vavr.Function2;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;
import java.util.Spliterators;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterator.ORDERED;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public class ConnectionPool implements Supplier<Connection>, Closeable {

    final BlockingQueue<PooledConnection> connectionQueue;
    volatile boolean opened;

    public ConnectionPool() {
        this("db");
    }

    @SneakyThrows
    public ConnectionPool(String fileName) {

        ConnectionFactory connectionFactory = PropsBinder.getFromProperties(
                ConnectionFactory.class, fileName);

        Function<Connection, PooledConnection> pooledConnectionFactory =
                Function2.narrow(PooledConnection::new)
                        .apply(this::closePolledConnection);

        int poolSize = connectionFactory.getPoolSize();
        connectionQueue = IntStream.range(0, poolSize)
                .mapToObj(__ -> connectionFactory.get())
                .map(pooledConnectionFactory)
                .collect(Collectors.toCollection(() -> new ArrayBlockingQueue<>(poolSize)));

        Function<String, Optional<String>> getFileAsString = Function2.narrow(
                ConnectionPool::getFileAsString)
                .apply(connectionFactory.getInitScriptsPath());

        try (Connection connection = get();
             val statement = connection.createStatement()) {
            statement.executeUpdate(
                    IntStream.iterate(1, operand -> operand + 1)
                            .mapToObj(String::valueOf)
                            .map(getFileAsString)
                            .takeWhile(Optional::isPresent)
                            .map(Optional::get)
                            .collect(Collectors.joining()));
        }
    }

    @SneakyThrows
    private static Optional<String> getFileAsString(String initScriptsPath, String name) {
        val path = String.format("/%s/%s.sql", initScriptsPath, name);
        return Optional.ofNullable(ConnectionPool.class.getResourceAsStream(path))
                .map(Scanner::new)
                .map(scanner -> scanner.useDelimiter(System.lineSeparator())) //peek
                .map(ConnectionPool::withStream)
                .map(ConnectionPool::collect);
    }

    private static Tuple2<Scanner, Stream<String>> withStream(Scanner scanner) {
        return Tuple.of(scanner, StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(scanner, ORDERED),
                false));
    }

    private static String collect(Tuple2<Scanner, Stream<String>> scannerAndStreamTuple) {
        try (scannerAndStreamTuple._1) {
            val lines = scannerAndStreamTuple._2;
            return lines.collect(Collectors.joining());
        }
    }

    @SneakyThrows
    private void closePolledConnection(PooledConnection connection) {
        if (opened) {
            if (connection.isClosed())
                throw new RuntimeException("Attempting to close closed connection.");
            if (connection.isReadOnly())
                connection.setReadOnly(false);
            if (!connectionQueue.offer(connection))
                throw new SQLException("Error allocating connection in the pool.");
        } else
            connection.reallyClose();
    }

    public Connection takeConnection() {
        try {
            return connectionQueue.take();
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(
                    "Error connecting to the data source.", e);
        }
    }

    @Override
    public Connection get() {
        return takeConnection();
    }

    @Override
    public void close() {
        opened = false;
        connectionQueue.forEach(PooledConnection::reallyClose);
    }
}
