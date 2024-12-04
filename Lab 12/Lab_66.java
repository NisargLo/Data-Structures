// WAP to swap Kth node from beginning with Kth node from end in a singly linked list.

import java.util.Scanner;

public class Lab_66 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Int_LinkedList ill=new Int_LinkedList();
        System.out.println("Enter -1 to exit :");
        int n;
        while(true){
            System.out.println("Enter No :");
            n=sc.nextInt();
            if(n==-1){
                break;
            }
            ill.insertAtLastPosition(n);
        }
        System.out.println("Enter K:");
        int k=sc.nextInt();
        if(ill.first!=null){
            swap_Kth_nodes(ill,k);
            System.out.print("Updated ");
            ill.displayLinkedList();
        }
        else{
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static void swap_Kth_nodes(Int_LinkedList ill, int k) {
        if (k <= 0) {
            System.out.println("Invalid value of K.");
            return;
        }

        int length = 0;
        Node current = ill.first;
        while (current != null) {
            length++;
            current = current.link;
        }
        if (length < k) {
            System.out.println("K is larger than the length of the list.");
            return;
        }

        Node startPrev = null;
        Node start = ill.first;
        for (int i = 1; i < k; i++) {
            startPrev = start;
            start = start.link;
        }

        Node endPrev = null;
        Node end = ill.first;
        for (int i = 0; i < length - k; i++) {
            endPrev = end;
            end = end.link;
        }

        if (start == end) {
            return;
        }

        if (startPrev == null) {
            ill.first = end;
        } else {
            startPrev.link = end;
        }

        if (endPrev == null) {
            ill.first = start;
        } else {
            endPrev.link = start;
        }

        Node temp = start.link;
        start.link = end.link;
        end.link = temp;
    }
}
