// WAP to remove duplicate elements from a singly linked list.

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class Lab_62 {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        Scanner sc=new Scanner(System.in);
        Int_LinkedList ll=new Int_LinkedList();
        System.out.println("Enter -1 to exit :");
        int n;
        while(true){
            System.out.println("Enter No :");
            n=sc.nextInt();
            if(n==-1){
                break;
            }
            ll.insertAtLastPosition(n);
        }
        System.out.println("\nBefore removing duplicate elements.");
        ll.displayLinkedList();
        if(ll.first==null){
            System.out.println("Empty LinkedList...");
            return;
        }
        Node current=ll.first;
        set.add(current.info);
        while(current.link!=null){
            current=current.link;
            set.add(current.info);
        }
        ll.deleteAllNodes();
        for (Integer element : set) {
            ll.insertAtLastPosition(element);
        }
        System.out.println("\nAfter removing duplicate elements.");
        ll.displayLinkedList();
    }
}
