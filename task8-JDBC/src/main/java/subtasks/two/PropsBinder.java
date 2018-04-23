package subtasks.two;

import io.vavr.Function1;
import io.vavr.Function2;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface PropsBinder {

    static <T> T getFromProperties(Class<T> aClass) {
        return getFromProperties(aClass, aClass.getSimpleName());
    }

    @SneakyThrows
    static <T> T getFromProperties(Class<T> aClass, String fileName) {
        val properties = getProperties(fileName);
        val constructor = getMaxParamsCountConstructor(aClass);
        Object[] args = getConstructorArgs(properties, constructor);

        return constructor.newInstance(args);
    }

    @NotNull
    @SneakyThrows
    static Properties getProperties(String fileName) {
        val properties = new Properties();
        val name = String.format("/%s.properties", fileName);
        try (val inputStream = PropsBinder.class.getResourceAsStream(name)) {
            properties.load(inputStream);
        }
        return properties;
    }

    static <T> Object[] getConstructorArgs(@NotNull Properties properties,
                                           @NotNull Constructor<T> constructor) {

        Function<Parameter, @NotNull Object> parseParam =
                Function2.narrow(PropsBinder::getParameterFunction)
                        .apply(properties::getProperty);

        List<Object> list = new ArrayList<>();
        for (Parameter parameter : constructor.getParameters()) {
            Object o = parseParam.apply(parameter);
            list.add(o);
        }
        return list.toArray();
    }

//    @NotNull
//    private static <T> Constructor<T> getMaxParamsCountConstructor(Class<T> aClass) {
//        //noinspection unchecked
//        return Arrays.stream(((Constructor<T>[]) aClass.getConstructors()))
//                .max(Comparator.comparingInt(Constructor::getParameterCount))
//                .orElseThrow(RuntimeException::new);
//    }

    @NotNull
    static <T> Constructor<T> getMaxParamsCountConstructor(Class<T> aClass) {
        boolean seen = false;
        Constructor<T> best = null;
        Comparator<Constructor<T>> comparator = Comparator.comparingInt(Constructor::getParameterCount);
        //noinspection unchecked
        for (Constructor<T> tConstructor : ((Constructor<T>[]) aClass.getConstructors())) {
            if (!seen || comparator.compare(tConstructor, best) > 0) {
                seen = true;
                best = tConstructor;
            }
        }
        return (seen ? Optional.of(best) : Optional.<Constructor<T>>empty())
                .orElseThrow(RuntimeException::new);
    }

    @NotNull
    static Object getParameterFunction(UnaryOperator<String> mapper,
                                       Parameter parameter) {
        String name = parameter.getName();
        String value = mapper.apply(name);
        Class<?> type = parameter.getType();
        if (type == String.class) return value;
        else if (type == Double.class || type == double.class)
            return Double.parseDouble(value);
        else if (type == Long.class || type == long.class)
            return Long.parseLong(value);
        else if (type == Boolean.class || type == boolean.class)
            return Boolean.parseBoolean(value);
        else if (type == Float.class || type == float.class)
            return Float.parseFloat(value);
        else if (type == Integer.class || type == int.class)
            return Integer.parseInt(value);
        else if (type == Byte.class || type == byte.class)
            return Byte.parseByte(value);
        else if (type == Short.class || type == short.class)
            return Short.parseShort(value);
        else throw new RuntimeException("type was not recognized!");
    }
}
