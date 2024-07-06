// Write a program to count the number of nodes in a singly circularly linked list.

import java.util.Scanner;

public class Lab_58 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Int_Circular_LinkedList cll=new Int_Circular_LinkedList();
        System.out.println("Enter -1 to exit :");
        int n;
        while(true){
            System.out.println("Enter No :");
            n=sc.nextInt();
            if(n==-1){
                break;
            }
            cll.insertAtLastPosition(n);
        }
        cll.displayCircularLinkedList();
        System.out.println("\nSize (No of nodes) of this circular linked list is "+sizeOfCircularLinkedList(cll));
    }

    private static int sizeOfCircularLinkedList(Int_Circular_LinkedList c_list){
        int size=1;
        if(c_list.first==null){
            return 0;
        }
        Node current=c_list.first;
        while(current.link!=c_list.first){
            current=current.link;
            size++;
        }
        return size;
    }
}
