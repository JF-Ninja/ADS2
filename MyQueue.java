public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();
    public T enqueue(T item) { // Adds item to the end of the list
        list.addLast(item);
        return item;
    }
    public T dequeue(){ // Removes the first item of the list
        T removingItem = peek();
        list.removeFirst();
        return removingItem;
    }
    public T peek() {  // Gets the first item of the list
        if (isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
    public int size() {
        return list.size();
    }
}