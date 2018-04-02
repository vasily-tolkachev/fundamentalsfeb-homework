package subtasks.four;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Movies implements Serializable {
    private static final transient Logger log = LogManager.getLogger(Main.class);
    private Map<String, List<Actor>> movieList;

    Movies() {
        movieList = new HashMap<>();
    }

    void addActor(String movieName, Actor actor) {
        if (movieList.containsKey(movieName)) {
            List<Actor> actorList = movieList.get(movieName);
            if (!actorList.contains(actor)) {
                actorList.add(actor);
            }
        } else {
            log.info("Movies.addActor The movie {} is not at the list yet", movieName);
        }
    }

    void addMovie(String movieName) {
        if (!movieList.containsKey(movieName)) {
            List<Actor> actorList = new ArrayList<>();
            movieList.put(movieName, actorList);
        }
    }

    void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<Actor>> entry : movieList.entrySet()) {
            stringBuilder.append("Movie name: ").append(entry.getKey()).append("\n");
            List<Actor> actorList = entry.getValue();
            if (!actorList.isEmpty()) {
                for (Actor actor : actorList) {
                    stringBuilder.append(actor).append("\n");
                }
                stringBuilder.append('\n');
            }
        }
        log.info("\n{}", stringBuilder.toString());
    }
}
