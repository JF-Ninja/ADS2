public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void set(int index, T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    boolean remove(int index);
    void removeFirst();
    void removeLast();
    void sort();
    int index0f(Object object);
    int lastIndex0f(Object object);

    //Function returns first index of element if it exists in list
    int indexOf(Object object);

    //Function returns last index of element if it exists in list
    int lastIndexOf(Object object);

    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();
}