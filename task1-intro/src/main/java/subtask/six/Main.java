package subtask.six;

public class Main {
    public static void main(String... args) {
        Notebook notebook = new Notebook();
        notebook.addNote("note1");
        notebook.addNote("note2");
        notebook.addNote("note3");
        notebook.addNote("note4");
        notebook.showNotes();
        notebook.removeNote(1);
        notebook.showNotes();
        notebook.editNote(2, "changed note");
        notebook.showNotes();
    }
}
