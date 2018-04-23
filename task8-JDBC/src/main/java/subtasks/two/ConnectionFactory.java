package subtasks.two;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Supplier;

import static lombok.AccessLevel.NONE;
import static lombok.AccessLevel.PUBLIC;

@Value
@Getter(NONE)
public class ConnectionFactory implements Supplier<Connection> {

    String driver;
    String url;
    String user;
    String password;

    @Getter(PUBLIC)
    int poolSize;

    @Getter(PUBLIC)
    String initScriptsPath;

    @Override
    @SneakyThrows
    public Connection get() {
        return DriverManager.getConnection(url, user, password);
    }
}
