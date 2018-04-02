package subtasks.four;

import java.io.*;

class ObjectReader {
    private ObjectReader() {}

    static Movies getMovies(File file) throws IOException, ClassNotFoundException {
        Movies movies = new Movies();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))) {
            Object object = objectInputStream.readObject();
            if (object instanceof Movies) {
                movies = (Movies) object;
            }
        } catch (EOFException e) {}
        return movies;
    }

    static void writeMoviesToFile(Movies movies, File file) throws IOException {
        if (movies != null) {
            try (
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                            new BufferedOutputStream(new FileOutputStream(file)))
            ) {
                objectOutputStream.writeObject(movies);
            }
        }
    }
}