package subtasks.six.seven;

import java.lang.annotation.*;

@Documented
public @interface Preamble {
    String author();
    String dateOfCreation() default "3/24/2018";
}
