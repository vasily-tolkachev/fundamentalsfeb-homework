package subtasks.one;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class CrazyLogger {
    private StringBuilder log = new StringBuilder();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-YYYY : hh-mm");
    private static final char SPLIT_SIGN = ';';

    void addNote(String note) {
        note = deleteServiceSymbol(note);
        log.append('\n')
                .append(LocalDateTime.now().format(formatter))
                .append(" - ")
                .append(note)
                .append(SPLIT_SIGN);
    }

    private String deleteServiceSymbol(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.indexOf(String.valueOf(SPLIT_SIGN)) > -1) {
            stringBuilder.deleteCharAt(stringBuilder.indexOf(";"));
        }
        return stringBuilder.toString();
    }

    void showNotesContainingString(String stringFragment) {
        String[] strings = log.toString().split(String.valueOf(SPLIT_SIGN));
        for (String note : strings) {
            if (note.contains(stringFragment)) {
                System.out.print("\nThis note contains fragment \"" + stringFragment + "\"");
                System.out.print(note);
            }
        }
    }

    void showAll() {
        System.out.println(log.toString());
    }
}
