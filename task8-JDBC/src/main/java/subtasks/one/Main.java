

package subtasks.one;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String... args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test");
             Statement statement = connection.createStatement();
             PreparedStatement selectSpeciesStatement = connection.prepareStatement(
                     "select id, name from species"
             );
             PreparedStatement insertStatement = connection.prepareStatement(
                     "insert into species"
                             + "(id, name) values"
                             + "(?,?)"
             );
             PreparedStatement updateStatement = connection.prepareStatement(
                     "UPDATE species SET name = ? where id = ?"
             );
        ) {
            setupDatabase(statement);

            Map<Integer, String> speciesTable = getSpeciesTable(selectSpeciesStatement);
            System.out.println(speciesTable);

            insertStatement.setInt(1, 10);
            insertStatement.setString(2, "Deer");

            insertStatement.executeUpdate();

            System.out.println();
            speciesTable = getSpeciesTable(selectSpeciesStatement);
            System.out.println(speciesTable);

            updateStatement.setString(1, "Cow");
            updateStatement.setInt(2, 3);

            updateStatement.executeUpdate();

            System.out.println();
            speciesTable = getSpeciesTable(selectSpeciesStatement);
            System.out.println(speciesTable);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
        }
    }

    private static Map<Integer, String> getSpeciesTable(PreparedStatement preparedStatement)
            throws SQLException {
        try (
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            Map<Integer, String> idToNameMap = new HashMap<>();
            while (resultSet.next()) {
                Object idField = resultSet.getObject("id");
                Object idName = resultSet.getObject("name");
                int id = 0;
                if (idField instanceof Integer) {
                    id = (Integer) idField;
                }
                String name = "";
                if (idName instanceof String) {
                    name = (String) idName;
                }
                idToNameMap.put(id, name);
            }
            return idToNameMap;
        }
    }

    static void setupDatabase(Statement statement) {
        try {
            statement.executeUpdate("drop table species");
            statement.executeUpdate("create table species("
                    + "id integer primary key, "
                    + "name varchar(255))"
            );

            statement.executeUpdate("insert into species values(1, 'African elephant')");
            statement.executeUpdate("insert into species values(2, 'Zebra')");
            statement.executeUpdate("insert into species values(3, 'Tiger')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
