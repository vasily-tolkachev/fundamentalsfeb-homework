package subtasks.four;

public class Main {

    public static void main(String... args) {
        Movies movies = new Movies();
        movies.addMovie("Titanic");
        movies.addMovie("Pulp fiction");
        movies.addMovie("Kill Bill");
        movies.print();
        movies.addActor("Titanic", new Actor("Leonardo", "DiCaprio"));

        movies.addActor("Kill Bill", new Actor("Uma", "Thurman"));
        movies.addActor("Kill Bill", new Actor("Lucy", "Liu"));

        movies.addActor("Pulp fiction", new Actor("Uma", "Thurman"));
        movies.addActor("Pulp fiction", new Actor("John", "Travolta"));
        movies.print();
    }
}
