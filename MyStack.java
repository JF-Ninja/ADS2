public class MyStack<T>{
    private MyLinkedList<T> list = new MyLinkedList<>();

    public boolean isEmpty(){
        return list.size() != 0;
    }

    public int size(){
        return list.size();
    }

    public T peek(){ //Returns last element of stack
        return list.getLast();
    }

    public void push(T item){
        list.addLast(item);
    }

    public void pop(){
        list.removeLast();
    }
}