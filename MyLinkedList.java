import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    MyNode<T> head, tail; //First and last nodes
    int length = 0;

    @Override
    public void add(T item) { //Adds element to the end of array
        MyNode<T> newNode = new MyNode<>(item);
        if(head == null){
            head = tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void set(int index, T item) { //Changes value of element by the index
        validateIndex(index, length - 1);
        MyNode<T> currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        currentNode.data = item;
    }

    @Override
    public void add(int index, T item) { //Adds new element by index
        validateIndex(index, length);
        MyNode<T> newNode = new MyNode<>(item);
        MyNode<T> currentNode = head;
        if(index == 0){
            addFirst(item);
            return;
        }
        else if (index == length){
            addLast(item);
            return;
        }
        else{
            for(int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
            currentNode.prev.next = newNode;
            newNode.prev = currentNode.prev;
            currentNode.prev = newNode;
            newNode.next = currentNode;
            length++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        length++;
    }

    @Override
    public void addLast(T item) {
        add(item);
        length++;
    }

    @Override
    public T get(int index) {
        validateIndex(index, length - 1);
        MyNode<T> currentNode;
        if(index <= length / 2){
            currentNode = head;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
        }
        else{
            currentNode = tail;
            for(int i = length - 1; i > index; i--){
                currentNode = currentNode.prev;
            }
        }
        return currentNode.data;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public boolean remove(int index) { //Removes element by index
        validateIndex(index, length - 1);
        if(index == 0){
            removeFirst();
        }
        else if(index == length - 1){
            removeLast();
        }
        else{
            MyNode<T> currentNode = head;
            validateIndex(index, length - 1);
            for(int i = 0; i < index - 1; i++){
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = currentNode;
        }
        length--;
        return false;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        head.prev = null;
        length--;
    }

    @Override
    public void removeLast() {
        tail = tail.prev;
        length--;
    }

    @Override
    public void sort() {
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
            MyNode<T> currentNode = head;
            for(int i = 0; i < length; i++){
                if (currentNode.data == object){
                    return i;
                }
                currentNode = currentNode.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) { //Returns last index of element
        if(exists(object)){
            MyNode<T> currentNode = tail;
            for(int i = length - 1; i >= 0; i--){
                if (currentNode.data == object){
                    return i;
                }
                currentNode = currentNode.prev;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) { //Checks existence of object in list
        MyNode<T> currentNode = head;
        while(currentNode != null){
            if (currentNode.data == object){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() { //Returns list of objects as array
        Object[] arr = new Object[length];
        MyNode<T> currentNode = head;
        for (int i = 0; i < length; i++){
            arr[i] = currentNode;
            currentNode = currentNode.next;
        }
        return arr;
    }

    @Override
    public void clear() { //Clears the list
        head = tail = null;
    }

    @Override
    public int size() {
        return length;
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

    private class MyIterator implements Iterator<T>{ //Required for implementing Iterable
        MyNode<T> current = head;
        @Override
        public boolean hasNext() { //Checks is this the end of list
            return current != null;
        }

        @Override
        public T next() { //Returns next element of list
            T data = current.data;
            current = current.next;
            return data;
        }
    }
    private static class MyNode<T>{ //That need to create nodes
        T data;
        MyNode<T> next;
        MyNode<T> prev;
        MyNode(T newData){
            this.data = newData;
        }
    }
}