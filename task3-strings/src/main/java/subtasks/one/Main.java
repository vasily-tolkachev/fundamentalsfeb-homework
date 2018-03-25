package subtasks.one;

class Main {
    public static void main(String... args) {
        CrazyLogger logger = new CrazyLogger();
        logger.addNote("Having that many numbers in a row gets to be hard to read,\n" +
                "though. The second line of code shows how you can create LocalDate and LocalTime\n" +
                "objects separately first and then combine them to create a LocalDateTime object.");
        logger.addNote("Although Java allows you to hide a variable defined in a parent class with one defined in\n" +
                "a child class, it is considered an extremely poor coding practice. ");
        logger.addNote("If the method returns a value, it must be the same or a subclass of the method in the\n" +
                "parent class, known as covariant return types.");
        logger.showAll();
        logger.showNotesContainingString("class");
    }
}