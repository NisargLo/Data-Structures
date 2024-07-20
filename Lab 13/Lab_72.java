/*
    Write a menu driven program to implement following operations on the doubly linked list.
        Insert a node at the front(head) of the linked list.
        Insert a node at the back(tail) of the linked list. (Home Work)
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
            System.out.println("Enter 11 for display_headToTail_DoublyLinkedList() :");
            System.out.println("Enter 12 for display_tailToHead_DoublyLinkedList() :");
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
                    dll.display_headToTail_DoublyLinkedList();
                    break;

                case 12:
                    dll.display_tailToHead_DoublyLinkedList();
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
    Doubly_Node head=null;
    Doubly_Node tail=null;

    protected void insertAtFirstPosition(int data){
        Doubly_Node newNode=new Doubly_Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        newNode.next=head;
        head.previous=newNode;
        head=newNode;
    }

    protected void insertAtLastPosition(int data){
        Doubly_Node newNode=new Doubly_Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.previous=tail;
        tail=newNode;
    }

    protected void insertAtOrder(int data) {
        Doubly_Node newNode=new Doubly_Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        if(newNode.info<head.info){
            newNode.next=head;
            head.previous=newNode;
            head=newNode;
            return;
        }
        Doubly_Node current=head;
        while(current.next!=null && newNode.info>=current.next.info){
            current=current.next;
        }
        if(current.next != null) {
            (current.next).previous = newNode;
        }
        newNode.next=current.next;
        newNode.previous=current;
        current.next=newNode;
        while(current.next!=null){
            current=current.next;
        }
        tail=current;
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, int data){
        Doubly_Node newNode=new Doubly_Node(data);
        if(head==null){
            if(index!=1){
                System.out.println("Although you have written index - "+index+"\nInserted at first position as Doubly LinkedList was empty.");
            }
            head=newNode;
            tail=newNode;
            return;
        }
        int c=1;
        Doubly_Node current=head;
        while(current.next!=null){
            current=current.next;
            c++;
        }
        if(index<1 || index>c+1){
            System.out.println("Invalid Index..");
            return;
        }
        if (index==1) {
            newNode.next=head;
            head.previous=newNode;
            head=newNode;
            return;
        }
        if(index==c+1){
            tail.next=newNode;
            newNode.previous=tail;
            tail=newNode;
            return;
        }
        current=head;
        for(int i=1;i<index-1;i++){
            current=current.next;
        }
        newNode.next=current.next;
        newNode.previous=current;
        current.next.previous=newNode;
        current.next=newNode;
    }

    protected void deleteFromFirstPosition(){
        if(head==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        if(head.next==null){
            head=null;
            tail=null;
            return;
        }
        head=head.next;
        head.previous=null;
    }

    protected void deleteFromLastPosition(){
        if(tail==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        if(tail.previous==null){
            head=null;
            tail=null;
            return;
        }
        tail=tail.previous;
        tail.next=null;
    }

    // user enters 1 based index :-
    protected void deleteFromSpecificPosition(int index){
        if(head==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        if(index==1){
            if(head.next==null){
                head=null;
                tail=null;
                return;
            }
            head=head.next;
            head.previous=null;
            return;
        }
        Doubly_Node current=head;
        int c=1;
        while(current.next!=null){
            current=current.next;
        }

    }

    protected void deleteGivenDataFromDoublyLinkedList(int data){
        System.out.println("deleteGivenDataFromDoublyLinkedList(int data)");
    }

    protected void deleteAllNodes() {
        head=null;
        tail=null;
    }

    protected boolean isEmpty() {
        return head==null;
    }

    protected void display_headToTail_DoublyLinkedList() {
        if(head==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        Doubly_Node current = head;
        System.out.print("Doubly LinkedList (Head to Tail) : [");
        do {
            System.out.print(current.info);
            current = current.next;
            if (current != null) {
                System.out.print(", ");
            }
        } while (current != null);
        System.out.println("]");
    }

    protected void display_tailToHead_DoublyLinkedList() {
        if(tail==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        Doubly_Node current = tail;
        System.out.print("Doubly LinkedList (Tail to Head) : [");
        do {
            System.out.print(current.info);
            current = current.previous;
            if (current != null) {
                System.out.print(", ");
            }
        } while (current != null);
        System.out.println("]");
    }
}