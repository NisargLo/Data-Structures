/*
    Write a menu driven program to implement following operations on the doubly linked list.
        Insert a node at the front(first) of the linked list.
        Insert a node at the back(last) of the linked list.
        (Homework)
        Delete a node from specified position.
        Display all nodes.
        (Homework)
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
            System.out.println("Enter 11 for display_firstTolast_DoublyLinkedList() :");
            System.out.println("Enter 12 for display_lastTofirst_DoublyLinkedList() :");
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
                    dll.display_firstTolast_DoublyLinkedList();
                    break;

                case 12:
                    dll.display_lastTofirst_DoublyLinkedList();
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
    Doubly_Node first=null;
    Doubly_Node last=null;

    protected void insertAtFirstPosition(int data){
        Doubly_Node newNode=new Doubly_Node(data);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }
        newNode.next=first;
        first.previous=newNode;
        first=newNode;
    }

    protected void insertAtLastPosition(int data){
        Doubly_Node newNode=new Doubly_Node(data);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }
        last.next=newNode;
        newNode.previous=last;
        last=newNode;
    }

    protected void insertAtOrder(int data) {
        Doubly_Node newNode=new Doubly_Node(data);
        if(first==null){
            first=newNode;
            last=newNode;
            return;
        }
        if(newNode.info<first.info){
            newNode.next=first;
            first.previous=newNode;
            first=newNode;
            return;
        }
        Doubly_Node current=first;
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
        last=current;
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, int data){
        Doubly_Node newNode=new Doubly_Node(data);
        if(first==null){
            if(index!=1){
                System.out.println("Although you have written index - "+index+"\nInserted at first position as Doubly LinkedList was empty.");
            }
            first=newNode;
            last=newNode;
            return;
        }
        int c=1;
        Doubly_Node current=first;
        while(current.next!=null){
            current=current.next;
            c++;
        }
        if(index<1 || index>c+1){
            System.out.println("Invalid Index..");
            return;
        }
        if (index==1) {
            newNode.next=first;
            first.previous=newNode;
            first=newNode;
            return;
        }
        if(index==c+1){
            last.next=newNode;
            newNode.previous=last;
            last=newNode;
            return;
        }
        current=first;
        for(int i=1;i<index-1;i++){
            current=current.next;
        }
        newNode.next=current.next;
        newNode.previous=current;
        current.next.previous=newNode;
        current.next=newNode;
    }

    protected void deleteFromFirstPosition(){
        if(first==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        if(first.next==null){
            first=null;
            last=null;
            return;
        }
        first=first.next;
        first.previous=null;
    }

    protected void deleteFromLastPosition(){
        if(last==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        if(last.previous==null){
            first=null;
            last=null;
            return;
        }
        last=last.previous;
        last.next=null;
    }

    // user enters 1 based index :-
    protected void deleteFromSpecificPosition(int index){
        if(first==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        if(index==1){
            if(first.next==null){
                first=null;
                last=null;
                return;
            }
            first=first.next;
            first.previous=null;
            return;
        }
        Doubly_Node current=first;
        int c=1;
        while(current.next!=null){
            current=current.next;
            c++;
        }
        if(index<1 || index>c+1){
            System.out.println("Invalid Index..");
            return;
        }
        if(index==c+1){
            if(last.previous==null){
                first=null;
                last=null;
                return;
            }
            last=last.previous;
            last.next=null;
            return;
        }
        current=first;
        for(int i=1;i<index-1;i++){
            current=current.next;
        }
        current.next=current.next.next;
        if(current.next!=null){
            current.next.previous=current;
        }
    }

    protected void deleteGivenDataFromDoublyLinkedList(int data){
        if(first==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        if(first.next==null){
            first=null;
            last=null;
            return;
        }
        if(data==first.info){
            first=first.next;
            first.previous=null;
            return;
        }
        if(data==last.info){
            last=last.previous;
            last.next=null;
            return;
        }
        Doubly_Node current=first;
        while(current.next.info!=data){
            current=current.next;
        }
        current.next=current.next.next;
        if(current.next!=null){
            current.next.previous=current;
        }
    }

    protected void deleteAllNodes() {
        first=null;
        last=null;
    }

    protected boolean isEmpty() {
        return (first==null && last==null);
    }

    protected void display_firstTolast_DoublyLinkedList() {
        if(first==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        Doubly_Node current = first;
        System.out.print("Doubly LinkedList (first to last) : [");
        do {
            System.out.print(current.info);
            current = current.next;
            if (current != null) {
                System.out.print(", ");
            }
        } while (current != null);
        System.out.println("]");
    }

    protected void display_lastTofirst_DoublyLinkedList() {
        if(last==null){
            System.out.println("Empty Doubly LinkedList...");
            return;
        }
        Doubly_Node current = last;
        System.out.print("Doubly LinkedList (last to first) : [");
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