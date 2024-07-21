/*
    Write a menu driven program to implement following operations on the singly linked list.
        Insert a node at the front of the linked list.
        Insert a node at the end of the linked list.
        Display all nodes.
        Delete a first node of the linked list.
        Delete a last node of the linked list.
        Delete a node from specified position.
 */

import java.util.Scanner;

public class Lab_57 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Int_LinkedList ll = new Int_LinkedList();
        int choice=0;
        while (choice!=-1) {
            System.out.println("\nEnter 1 for insertAtFirstPosition() :");
            System.out.println("Enter 2 for insertAtLastPosition() :");
            System.out.println("Enter 3 for insertAtOrder() :");
            System.out.println("Enter 4 for insertAtSpecificPosition() :");
            System.out.println("Enter 5 for deleteFromFirstPosition() :");
            System.out.println("Enter 6 for deleteFromLastPosition() :");
            System.out.println("Enter 7 for deleteFromSpecificPosition() :");
            System.out.println("Enter 8 for deleteGivenDataFromLinkedList() :");
            System.out.println("Enter 9 for deleteAllNodes() :");
            System.out.println("Enter 10 for isEmpty() :");
            System.out.println("Enter 11 for displayLinkedList() :");
            System.out.println("Enter -1 to exit :");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Number :");
                    int num1=sc.nextInt();
                    ll.insertAtFirstPosition(num1);
                    break;

                case 2:
                    System.out.println("Enter Number :");
                    int num2=sc.nextInt();
                    ll.insertAtLastPosition(num2);
                    break;

                case 3:
                    System.out.println("Enter Number :");
                    int num3=sc.nextInt();
                    ll.insertAtOrder(num3);
                    break;

                case 4:
                    System.out.println("Enter Index :");
                    int index1=sc.nextInt();
                    System.out.println("Enter Number :");
                    int num4=sc.nextInt();
                    ll.insertAtSpecificPosition(index1, num4);
                    break;

                case 5:
                    ll.deleteFromFirstPosition();
                    break;

                case 6:
                    ll.deleteFromLastPosition();
                    break;

                case 7:
                    System.out.println("Enter Index :");
                    int index2=sc.nextInt();
                    ll.deleteFromSpecificPosition(index2);
                    break;

                case 8:
                    System.out.println("Enter Number :");
                    int num5=sc.nextInt();
                    ll.deleteGivenDataFromLinkedList(num5);
                    break;

                case 9:
                    ll.deleteAllNodes();
                    break;

                case 10:
                    System.out.println(ll.isEmpty());
                    break;

                case 11:
                    ll.displayLinkedList();
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

class Int_LinkedList{
    Node first=null;

    protected void insertAtFirstPosition(int data){
        Node newNode=new Node(data);
        newNode.link=first;
        first=newNode;
    }

    protected void insertAtLastPosition(int data){
        Node newNode=new Node(data);
        if(first==null){
            first=newNode;
            return;
        }
        Node current=first;
        while(current.link!=null){
            current=current.link;
        }
        current.link=newNode;
    }

    protected void insertAtOrder(int data) {
        Node newNode = new Node(data);
        if (first == null || newNode.info <= first.info) {
            newNode.link = first;
            first = newNode;
            return;
        }
        Node current = first;
        while (current.link != null && newNode.info >= current.link.info) {
            current = current.link;
        }
        newNode.link = current.link;
        current.link = newNode;
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, int data) {
        Node newNode = new Node(data);
        if (index <= 0) {
            System.out.println("Invalid index.");
            return;
        }
        if (index == 1) {
            newNode.link = first;
            first = newNode;
            return;
        }
        Node current = first;
        int currentIndex = 1;
        while (current != null && currentIndex < index - 1) {
            current = current.link;
            currentIndex++;
        }
        if (current == null) {
            System.out.println("Index out of bounds.");
            return;
        }
        newNode.link = current.link;
        current.link = newNode;
    }

    protected void deleteFromFirstPosition(){
        if(first==null){
            System.out.println("Empty LinkedList...");
            return;
        }
        first=first.link;
    }

     protected void deleteFromLastPosition(){
         if(first==null){
             System.out.println("Empty LinkedList...");
             return;
         }
         Node current=first;
         while((current.link).link!=null){
             current=current.link;
         }
         current.link=null;
    }

    // user enters 1 based index :-
    protected void deleteFromSpecificPosition(int index){
        if(first==null){
            System.out.println("Empty LinkedList...");
            return;
        }
        Node current=first;
        int currentIndex=1;
        while(currentIndex<index-1 && current.link!=null){
            current=current.link;
            currentIndex++;
        }
        assert current.link != null;
        current.link=(current.link).link;
    }

    protected void deleteGivenDataFromLinkedList(int data){
        if(first==null){
            System.out.println("Empty LinkedList...");
            return;
        }
        if(first.info==data){
            first=first.link;
            return;
        }
        Node current=first;
        while(current.link!=null && current.link.info!=data){
            current=current.link;
        }
        if(current.link==null){
            System.out.println("No such element in LinkedList...");
            return;
        }
        current.link=(current.link).link;
    }

    protected void deleteAllNodes() {
        first=null;
    }

    protected boolean isEmpty() {
        return first==null;
    }

    protected void displayLinkedList() {
        if(first==null){
            System.out.println("Empty LinkedList...");
            return;
        }
        Node current = first;
        String str="";
        System.out.print("LinkedList : [");
        while (current != null) {
            str += current.info+", ";
            current = current.link;
        }
        str=str.substring(0, str.length()-2);
        str += "]";
        System.out.println(str);
    }
}