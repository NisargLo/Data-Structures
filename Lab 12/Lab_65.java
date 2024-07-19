// Write a program to sort elements of a linked list.

import java.util.Scanner;

public class Lab_65 {
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
            sortLinkedList(ill);
            System.out.print("Sorted ");
            ill.displayLinkedList();
        }
        else{
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static void sortLinkedList(Int_LinkedList ill){
        Node current=ill.first;
        Node next;
        int temp;
        while(current!=null){
            next=current.link;
            while(next!=null){
                if(current.info>next.info){
                    temp=next.info;
                    next.info=current.info;
                    current.info=temp;
                }
                next=next.link;
            }
            current=current.link;
        }
    }
}
