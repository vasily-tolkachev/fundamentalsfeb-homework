package subtask.six;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * My own realization of an ArrayList class
 * It's made for practice
 * @param <T>
 */
public class List<T> implements Iterable<T> {
    private T[] array;
    /**
     * Capacity of List
     */
    private int n = 0;

    List() {
        array = (T[]) new Object[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Method to add new item.
     * If array to small to add something it'l be resized
     */
    void add(T item) {
        if (array.length == n) {
            this.resize(2 * array.length);
        }
        array[n++] = item;
    }

    void set(int index, T item) {
        array[index] = item;
    }

    /**
     * The method remove index from the list.
     * If arrays size is only 1/4 of it's capacity array will be resized
     * @param index - index of element to remove
     */
    void remove(int index) {
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        n--;
        if (n > 0 && n == array.length / 4)
            resize(array.length / 2);
    }

    /**
     * Method to resize an array
     * @param capacity new capacity
     */
    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(array, 0, copy, 0, n);
        array = copy;
    }

    public int size() {
        return n;
    }

    @NotNull
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[i++];
        }
    }
}