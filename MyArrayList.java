import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{
    private final static int DEFAULT_CAPACITY = 5;
    private Object[] arr; //Main array of list
    MyArrayList(){
        this(DEFAULT_CAPACITY);
    }
    MyArrayList(int initialCapacity){
        arr = new Object[initialCapacity];
    }
    private int length = 0;
    @Override
    public void add(T item) { //Adds element to the end of array
        if(length == arr.length){
            increaseCapacity();
        }
        arr[length] = item;
        length++;
    }

    @Override
    public void set(int index, T item) { //Changes value of element by the index
        arr[index] = item;
    }

    @Override
    public void add(int index, T item) { //Adds new element by index
        if(length == arr.length){
            increaseCapacity();
        }
        validateIndex(index, length);
        for(int i = length; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = item;
        length++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) { //Returns element by the index
        validateIndex(index, length - 1);
        return (T) arr[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(length - 1);
    }

    @Override
    public boolean remove(int index) { //Removes element by index
        validateIndex(index, length - 1);
        for(int i = index; i < length - 1; i++){
            arr[i] = arr[i + 1];
        }
        length--;
        return true;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {
        T[] arrTemp = (T[]) new Comparable[length];
        System.arraycopy(arr, 0, arrTemp, 0, length);
        Arrays.sort(arrTemp);
        System.arraycopy(arrTemp, 0, arr, 0, length);
    }

    @Override
    public int index0f(Object object) {
        return 0;
    }

    @Override
    public int lastIndex0f(Object object) {
        return 0;
    }

    @Override
    public int indexOf(Object object) { //Returns first index of element
        if(exists(object)){
            for(int i = 0; i < length; i++){
                if (arr[i] == object){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) { //Returns last index of element
        if(exists(object)){
            for(int i = length - 1; i >= 0; i--){
                if (arr[i] == object){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) { //Checks existence of object in list
        for(int i = 0; i < length; i++){
            if (object == arr[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() { //Returns list of objects as array
        Object[] newArr = new Object[length];
        for(int i = 0; i < length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    @Override
    public void clear() { //Clears the list
        length = 0;
        arr = new Object[DEFAULT_CAPACITY];
    }
    @Override
    public int size() {
        return length;
    }

    private void increaseCapacity(){
        Object[] arrTemp = new Object[arr.length*2];
        System.arraycopy(arr, 0, arrTemp, 0, length);
        arr = arrTemp;
    }


    public void validateIndex(int index, int limit){ //Checks is index valid
        if (index > limit){
            throw new IndexOutOfBoundsException("Index out of range!");
        }
    }

    @Override
    public Iterator<T> iterator() { //Need to implement Iterable.
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        int cursor = 0;
        @Override
        public boolean hasNext() { //Checks is this the end of list
            return cursor != length;
        }

        @Override
        public T next() {
            T nextItem = get(cursor);
            cursor++;
            return nextItem;
        }
    }
}