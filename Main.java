import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList<String> arr = new MyLinkedList<>();
        arr.add("ADS");
        arr.sort();
        MyLinkedList<Integer> arrInt = new MyLinkedList<>();
        arrInt.add(91391);
        arrInt.add(1, 99);
        arrInt.sort();
        for(int i : arrInt){
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}