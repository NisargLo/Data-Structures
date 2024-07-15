/*
    Write a menu driven program to implement following operations on the circular linked list.
        Insert a node at the front of the linked list.
        Insert a node at the end of the linked list.
        Delete a node from specified position.
        Display all nodes.
 */

import java.util.Scanner;

public class Lab_71 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Int_Circular_LinkedList cll = new Int_Circular_LinkedList();
        int choice=0;
        while (choice!=-1) {
            System.out.println("\nEnter 1 for insertAtFirstPosition() :");
            System.out.println("Enter 2 for insertAtLastPosition() :");
            System.out.println("Enter 3 for insertAtOrder() :");
            System.out.println("Enter 4 for insertAtSpecificPosition() :");
            System.out.println("Enter 5 for deleteFromFirstPosition() :");
            System.out.println("Enter 6 for deleteFromLastPosition() :");
            System.out.println("Enter 7 for deleteFromSpecificPosition() :");
            System.out.println("Enter 8 for deleteGivenDataFromCircularLinkedList() :");
            System.out.println("Enter 9 for deleteAllNodes() :");
            System.out.println("Enter 10 for displayCircularLinkedList() :");
            System.out.println("Enter -1 to exit :");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Number :");
                    int num1=sc.nextInt();
                    cll.insertAtFirstPosition(num1);
                    break;

                case 2:
                    System.out.println("Enter Number :");
                    int num2=sc.nextInt();
                    cll.insertAtLastPosition(num2);
                    break;

                case 3:
                    System.out.println("Enter Number :");
                    int num3=sc.nextInt();
                    cll.insertAtOrder(num3);
                    break;

                case 4:
                    System.out.println("Enter Index :");
                    int index1=sc.nextInt();
                    System.out.println("Enter Number :");
                    int num4=sc.nextInt();
                    cll.insertAtSpecificPosition(index1, num4);
                    break;

                case 5:
                    cll.deleteFromFirstPosition();
                    break;

                case 6:
                    cll.deleteFromLastPosition();
                    break;

                case 7:
                    System.out.println("Enter Index :");
                    int index2=sc.nextInt();
                    cll.deleteFromSpecificPosition(index2);
                    break;

                case 8:
                    System.out.println("Enter Number :");
                    int num5=sc.nextInt();
                    cll.deleteGivenDataFromCircularLinkedList(num5);
                    break;

                case 9:
                    cll.deleteAllNodes();
                    break;

                case 10:
                    cll.displayCircularLinkedList();
                    break;

                case -1:
                    System.out.println("Program Over...");
                    break;

                default:
                    System.out.println("Invalid");
            }
        }
    }
}

class Int_Circular_LinkedList{
    Node first=null;
    Node last=null;

    protected void insertAtFirstPosition(int data){
        Node newNode=new Node(data);
        if(first==null){
            first=newNode;
            last=newNode;
            newNode.link=newNode;
            return;
        }
        newNode.link=first;
        last.link=newNode;
        first=newNode;
    }

    protected void insertAtLastPosition(int data){
        Node newNode=new Node(data);
        if(first==null){
            first=newNode;
            last=newNode;
            newNode.link=newNode;
            return;
        }
        last.link=newNode;
        newNode.link=first;
        last=newNode;
    }

    protected void insertAtOrder(int data) {
        System.out.println("insertAtOrder(int data)");
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, int data){
        System.out.println("insertAtSpecificPosition(int index, int data)");
    }

    protected void deleteFromFirstPosition(){
        System.out.println("deleteFromFirstPosition()");
    }

    protected void deleteFromLastPosition(){
        System.out.println("deleteFromLastPosition()");
    }

    // user enters 1 based index :-
    protected void deleteFromSpecificPosition(int index){
        System.out.println("deleteFromSpecificPosition(int index)");
    }

    protected void deleteGivenDataFromCircularLinkedList(int data){
        System.out.println("deleteGivenDataFromCircularLinkedList(int data)");
    }

    protected void deleteAllNodes() {
        System.out.println("deleteAllNodes()");
    }

    protected void displayCircularLinkedList() {
        if (first == null) {
            System.out.println("Empty Circular LinkedList...");
            return;
        }
        Node current = first;
        System.out.print("Linked List : [");
        do {
            System.out.print(current.info);
            current = current.link;
            if (current != first) {
                System.out.print(", ");
            }
        } while (current != first);
        System.out.println("]");
    }
}