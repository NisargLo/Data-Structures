/*
     Write a program to remove the duplicates nodes from given sorted Linked List.
        Input: 1 → 1 → 6 → 13 → 13 → 13 → 27 → 27
        Output: 1 → 6 → 13 → 27
 */

import java.util.Scanner;

public class Lab_69 {
    public static void main(String[] args) {
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
        System.out.print("\nBefore filtering duplicates - ");
        ll.displayLinkedList();
        deleteDuplicates(ll.first);
        System.out.print("\nAfter filtering duplicates - ");
        ll.displayLinkedList();
    }

    private static void deleteDuplicates(Node first) {
        if (first == null || first.link == null) {
            return;
        }
        Node current = first;
        while (current.link != null) {
            if (current.info == current.link.info) {
                current.link = current.link.link;
            }
            else {
                current = current.link;
            }
        }
    }
}
