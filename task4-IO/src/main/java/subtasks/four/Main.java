package subtasks.four;

import java.io.*;

public class Main {
    private static final String FILE_NAME = "task4-IO/src/main/java/subtasks/four/Movies.txt";

    public static void main(String... args) throws IOException, ClassNotFoundException {
        Movies movies;
        File file = new File(FILE_NAME);
        movies = !file.createNewFile() ? ObjectReader.getMovies(file) : new Movies();
        movies.print();
        movies.addMovie("Titanic");
        movies.addMovie("Pulp fiction");
        movies.addMovie("Kill Bill");

        movies.addActor("Titanic", new Actor("Leonardo", "DiCaprio"));

        movies.addActor("Kill Bill", new Actor("Uma", "Thurman"));
        movies.addActor("Kill Bill", new Actor("Lucy", "Liu"));

        movies.addActor("Pulp fiction", new Actor("Uma", "Thurman"));
        movies.addActor("Pulp fiction", new Actor("John", "Travolta"));

        ObjectReader.writeMoviesToFile(movies, file);
    }
}
