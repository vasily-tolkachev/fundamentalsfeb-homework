package subtasks.two;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Select language: 1 - Russian, 2 - English");
        Scanner in = new Scanner(System.in);
        Locale currentLocale = in.nextInt() == 1 ? Locale.forLanguageTag("ru") : Locale.ENGLISH;
        ResourceBundle qs = ResourceBundle.getBundle("subtasks.two.questionBundle", currentLocale);

        String stringBuilder = qs.getString("question1")
                + "\n" + qs.getString("question2")
                + "\n" + qs.getString("question3") + '\n';
        System.out.println(stringBuilder);

        System.out.println("Which question do you want to know an answer:");
        System.out.printf("Answer is %s%n", qs.getString("answer" + in.next()));
        System.out.println("Try again y/n: ");
        if (in.next().equals("y")) {
            main(new String[]{});
        }
    }
}