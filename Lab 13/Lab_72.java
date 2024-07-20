/*
    Write a menu driven program to implement following operations on the doubly linked list.
        Insert a node at the front(right) of the linked list.
        Insert a node at the back(left) of the linked list. (Home Work)
        Delete a node from specified position.
        Display all nodes. (Home Work)
 */

import java.util.Scanner;

public class Lab_72 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Int_Doubly_LinkedList dll = new Int_Doubly_LinkedList();
        int choice=0;
        while (choice!=-1) {
            System.out.println("\nEnter 1 for insertAtFirstPosition() :");
            System.out.println("Enter 2 for insertAtLastPosition() :");
            System.out.println("Enter 3 for insertAtOrder() :");
            System.out.println("Enter 4 for insertAtSpecificPosition() :");
            System.out.println("Enter 5 for deleteFromFirstPosition() :");
            System.out.println("Enter 6 for deleteFromLastPosition() :");
            System.out.println("Enter 7 for deleteFromSpecificPosition() :");
            System.out.println("Enter 8 for deleteGivenDataFromDoublyLinkedList() :");
            System.out.println("Enter 9 for deleteAllNodes() :");
            System.out.println("Enter 10 for isEmpty() :");
            System.out.println("Enter 11 for displayDoublyLinkedList() :");
            System.out.println("Enter -1 to exit :");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Number :");
                    int num1=sc.nextInt();
                    dll.insertAtFirstPosition(num1);
                    break;

                case 2:
                    System.out.println("Enter Number :");
                    int num2=sc.nextInt();
                    dll.insertAtLastPosition(num2);
                    break;

                case 3:
                    System.out.println("Enter Number :");
                    int num3=sc.nextInt();
                    dll.insertAtOrder(num3);
                    break;

                case 4:
                    System.out.println("Enter Index :");
                    int index1=sc.nextInt();
                    System.out.println("Enter Number :");
                    int num4=sc.nextInt();
                    dll.insertAtSpecificPosition(index1, num4);
                    break;

                case 5:
                    dll.deleteFromFirstPosition();
                    break;

                case 6:
                    dll.deleteFromLastPosition();
                    break;

                case 7:
                    System.out.println("Enter Index :");
                    int index2=sc.nextInt();
                    dll.deleteFromSpecificPosition(index2);
                    break;

                case 8:
                    System.out.println("Enter Number :");
                    int num5=sc.nextInt();
                    dll.deleteGivenDataFromDoublyLinkedList(num5);
                    break;

                case 9:
                    dll.deleteAllNodes();
                    break;

                case 10:
                    System.out.println(dll.isEmpty());
                    break;

                case 11:
                    dll.displayDoublyLinkedList();
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

class Doubly_Node {
    public int info;
    public Doubly_Node previous;
    public Doubly_Node next;

    public Doubly_Node(int data) {
        this.info = data;
        this.previous = null;
        this.next = null;
    }

    public Doubly_Node(int data, Doubly_Node previousLink, Doubly_Node nextLink) {
        this.info = data;
        this.previous = previousLink;
        this.next = nextLink;
    }
}

class Int_Doubly_LinkedList{
    Doubly_Node right=null;
    Doubly_Node left=null;

    protected void insertAtFirstPosition(int data){
        Doubly_Node newNode=new Doubly_Node(data);
        newNode.next=right;
        newNode.previous=left;
        right=newNode;
    }

    protected void insertAtLastPosition(int data){
        Doubly_Node newNode=new Doubly_Node(data);
        if(right==null){
            newNode.next=right;
            newNode.previous=left;
            right=newNode;
            return;
        }
        Doubly_Node current=right;

    }

    protected void insertAtOrder(int data) {
        System.out.println("insertAtOrder(int data)");
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, int data){
        /*Node newNode=new Node(data);
        if(first==null){
            if(index!=1){
                System.out.println("Although you have written index - "+index+"\nInserted at first position as Circular LinkedList was empty.");
            }
            first=newNode;
            last=newNode;
            newNode.link=newNode;
            return;
        }*/
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

    protected void deleteGivenDataFromDoublyLinkedList(int data){
        System.out.println("deleteGivenDataFromDoublyLinkedList(int data)");
    }

    protected void deleteAllNodes() {
        right=null;
        left=null;
    }

    protected boolean isEmpty() {
        return right==null;
    }

    protected void displayDoublyLinkedList() {
        if(right==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        Doubly_Node current = right;
        System.out.print("Doubly LinkedList : [");
        do {
            System.out.print(current.info);
            current = current.next;
            if (current != null) {
                System.out.print(", ");
            }
        } while (current != null);
        System.out.println("]");
    }
}