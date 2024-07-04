/*
    Write a program to implement a node structure for singly linked list.
    Read the data in a node, print the node.

    class Linked_List is used from Lab_57
 */

import java.util.*;

public class Lab_56 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Linked_List ll=new Linked_List();
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
    public int info;
    public Node link;

    public Node(int data){
        this.info=data;
        this.link=null;
    }
}