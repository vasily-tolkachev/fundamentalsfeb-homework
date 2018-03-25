package subtask.six;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Notebook class to collect, show and edit(put new instead old) users notes
 */
class Notebook {
    private static final Logger log = LogManager.getLogger(Main.class);

    private List<Note> noteList;

    Notebook() {
        noteList = new List<>();
    }

    void addNote(String noteStr) {
        noteList.add(new Note(noteStr));
    }

    void removeNote (int index) {
        noteList.remove(index);
    }

    void editNote (int index, String newText) {
       noteList.set(index, new Note(newText));
    }

    void showNotes() {
        StringBuilder builder = new StringBuilder();
        builder.append("Current notes:");
        for ( Note note: noteList) {
            builder.append("\nNote: ").append(note.getString());
        }
        builder.append("\n");
        log.info(builder.toString());
    }
}
