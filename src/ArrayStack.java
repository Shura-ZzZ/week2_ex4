import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>{

    private final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int size;

    private Gen<?>[] array;

    private static class Gen<E> {
        E object;

        public Gen(E object) {
            this.object = object;
        }
    }

    public ArrayStack(int initSize) {
        array = new Gen<?>[initSize];
        this.size = 0;

    }

    private void grow() throws Exception {
        int oldSize = array.length;
        int newSize = 2 * oldSize;
        if (newSize - MAX_ARRAY_SIZE > 0)
            throw new Exception("can't enlarge the array");
        array = Arrays.copyOf(array, newSize);
    }

    @Override
    public void push(E element) {
        if (size == array.length) {
            try {
                grow();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

        }
        Gen<E> object = new Gen<E>(element);
        array[size] = object;
        size++;

    }

    @Override
    public E pop() {
        if (size == 0)
            return null;
        E result = (E) array[size - 1].object;
        size--;
        array[size] = null;
        return result;
    }

    @Override
    public E peek() {
        if (size == 0)
            return null;
        E result = (E) array[size - 1].object;
        return result;
    }

    @Override
    public boolean empty() {
        return size ==0;
    }

    //По заданию это реализовывать не нужно
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
