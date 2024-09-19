/*
    Write a program to implement a node structure for singly linked list.
    Read the data in a node, print the node.
 */

import java.util.*;

public class Lab_56 {
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
        ll.displayLinkedList();
    }
}

class Node {
    int info;
    Node link;

    public Node(int data){
        this.info=data;
    }
}