package subtask.five;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String... args) {
        final int dimension = 30;

        int[][] matrix = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                matrix[row][col] = ((col == row) || (col == matrix.length - 1 - row)) ? 1 : 0;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int[] row : matrix) {
            builder.append('\n');
            for (int element : row) {
                builder.append(element);
            }
        }
        builder.append('\n');
        log.info(builder.toString());
    }
}
