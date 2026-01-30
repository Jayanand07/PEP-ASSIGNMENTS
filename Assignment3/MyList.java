package Assignment.Assignment3;

public interface MyList<T> {
    void add(T element);

    void insert(T element, int index);

    T get(int index);

    void delete(int index);

    int size();

    boolean isEmpty();
}
