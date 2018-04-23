package subtasks.two;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.val;

import java.sql.Connection;
import java.sql.ResultSet;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class Main {

    static String SQL =
            "select id, first_name, last_name, permission, dob, email, password, address, telephone from Person";

    @SneakyThrows
    public static void main(String... args) {
        @Cleanup
        val connectionPool = new ConnectionPool();

        try (Connection connection = connectionPool.get();
             val statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            if (resultSet.next())
                resultSet.getString("first_name");
        }
    }
}


