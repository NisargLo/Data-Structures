/*
    Write a program to swap two consecutive nodes in the linked list.
    Don’t change the values of nodes, implement by changing the link of the nodes.
    Input: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
    Output: 2 → 1 → 4 → 3 → 6 → 5 → 8 → 7
 */

import java.util.Scanner;

public class Lab_68 {
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
        if(ill.first!=null){
            swap_2_consecutive_nodes(ill);
            System.out.print("Resultant ");
            ill.displayLinkedList();
        }
        else{
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static void swap_2_consecutive_nodes(Int_LinkedList ill) {
        Node previous = ill.first;
        Node current = previous.link;
        ill.first = current;
        while (true) {
            Node next = current.link;
            current.link = previous;
            if (next == null || next.link == null) {
                previous.link = next;
                break;
            }
            else {
                previous.link = next.link;
                previous = next;
                current = previous.link;
            }
        }
    }
}
