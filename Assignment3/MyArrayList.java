package Assignment.Assignment3;

public class MyArrayList<T> implements MyList<T> {

    private Object[] data;
    private int size;
    private int capacity;

    public MyArrayList() {
        this.capacity = 1;
        this.size = 0;
        this.data = new Object[capacity];
    }

    private void growArray() {
        capacity = capacity * 2;
        Object[] newData = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void add(T element) {
        if (size == capacity) {
            growArray();
        }
        data[size] = element;
        size++;
    }

    @Override
    public void insert(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (size == capacity) {
            growArray();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (size == 0) {
            throw new IllegalStateException("List is empty!");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        return (T) data[index];
    }

    @Override
    public void delete(int index) {
        if (size == 0) {
            throw new IllegalStateException("Cannot delete from empty list!");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        System.out.print("MyArrayList: [");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
