// Write a program to copy a linked list.

import java.util.Scanner;

public class Lab_63 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Int_LinkedList ill1=new Int_LinkedList();
        System.out.println("Enter -1 to exit :");
        int n;
        while(true){
            System.out.println("Enter No :");
            n=sc.nextInt();
            if(n==-1){
                break;
            }
            ill1.insertAtLastPosition(n);
        }
        if(ill1.first!=null){
            Int_LinkedList ill2=copyLinkedList(ill1);
            System.out.print("\nNew ");
            ill2.displayLinkedList();
        }
        else{
            System.out.println("\nYour linkedlist is empty.");
        }
    }

    private static Int_LinkedList copyLinkedList(Int_LinkedList ill1){
        Int_LinkedList ill2=new Int_LinkedList();
        Node current=ill1.first;
        ill2.insertAtLastPosition(current.info);
        while(current.link!=null){
            current=current.link;
            ill2.insertAtLastPosition(current.info);
        }
        return ill2;
    }
}
