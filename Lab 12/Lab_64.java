// Write a program to reverse a linked list.

import java.util.Scanner;

public class Lab_64 {
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
            reverseLinkedList(ill);
            System.out.print("Reversed ");
            ill.displayLinkedList();
        }
        else{
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static void reverseLinkedList(Int_LinkedList ill){
        Node previous=null;
        Node next;
        Node current=ill.first;
        while(current!=null){
            next=current.link;
            current.link=previous; //Reverse Code
            previous=current;
            current=next;
        }
        ill.first=previous;
    }
}
