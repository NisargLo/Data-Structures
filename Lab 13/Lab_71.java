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
            System.out.println("Enter 10 for isEmpty() :");
            System.out.println("Enter 11 for displayCircularLinkedList() :");
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
                    System.out.println(cll.isEmpty());
                    break;

                case 11:
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
        Node newNode=new Node(data);
        if(first==null){
            first=newNode;
            last=newNode;
            newNode.link=newNode;
            return;
        }
        if(newNode.info<first.info){
            last.link=newNode;
            newNode.link=first;
            first=newNode;
            return;
        }
        else if(newNode.info>=last.info){
            newNode.link=first;
            last.link=newNode;
            last=newNode;
            return;
        }
        Node current=first;
        while(current!=last && newNode.info>=current.link.info){
            current=current.link;
        }
        newNode.link=current.link;
        current.link=newNode;
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, int data){
        Node newNode=new Node(data);
        if(first==null){
            if(index!=1){
                System.out.println("Although you have written index - "+index+"\nInserted at first position as Circular LinkedList was empty.");
            }
            first=newNode;
            last=newNode;
            newNode.link=newNode;
            return;
        }
        Node current=first;
        int c=1;
        while(current.link!=first){
            current=current.link;
            c++;
        }
        if(index<1 || index>c+1){
            System.out.println("Invalid Index..");
            return;
        }
        if(index==1){
            newNode.link=first;
            last.link=newNode;
            first=newNode;
            return;
        }
        else if(index==c+1){
            last.link=newNode;
            newNode.link=first;
            last=newNode;
            return;
        }
        current=first;
        for (int i = 1; i < index - 1 && current != last; i++) {
            current = current.link;
        }
        newNode.link=current.link;
        current.link=newNode;
    }

    protected void deleteFromFirstPosition(){
        if(first==null){
            System.out.println("Empty Circular LinkedList...");
            return;
        }
        first=first.link;
        last.link=first;
    }

    protected void deleteFromLastPosition(){
        if(first==null){
            System.out.println("Empty Circular LinkedList...");
            return;
        }
        Node current=first;
        while(current.link!=last){
            current=current.link;
        }
        current.link=first;
        last=current;
    }

    // user enters 1 based index :-
    protected void deleteFromSpecificPosition(int index){
        if(first==null){
            System.out.println("Empty Circular LinkedList...");
            return;
        }
        Node current=first;
        int c=1;
        while(current.link!=first){
            current=current.link;
            c++;
        }
        if(index<1 || index>c){
            System.out.println("Invalid Index..");
            return;
        }
        if(index==1){
            first=first.link;
            last.link=first;
            return;
        }
        else if(index==c){
            current=first;
            while(current.link!=last){
                current=current.link;
            }
            current.link=first;
            last=current;
            return;
        }
        current=first;
        for(int i=1;i<index-1;i++){
            current=current.link;
        }
        current.link=(current.link).link;
    }

    protected void deleteGivenDataFromCircularLinkedList(int data){
        if(first==null){
            System.out.println("Empty Circular LinkedList...");
            return;
        }
        Node newNode=new Node(data);
        Node current;
        if(newNode.info==first.info){
            first=first.link;
            last.link=first;
            return;
        }
        else if(newNode.info==last.info){
            current=first;
            while((current.link).link!=first){
                current=current.link;
            }
            current.link=first;
            last=current;
            return;
        }
        current=first;
        while (current.link != first) {
            if (current.link.info == data) {
                current.link = current.link.link;
                return;
            }
            current = current.link;
        }
    }

    protected void deleteAllNodes() {
        first=null;
        last=null;
    }

    protected boolean isEmpty() {
        return first==null;
    }

    protected void displayCircularLinkedList() {
        if (first == null) {
            System.out.println("Empty Circular LinkedList...");
            return;
        }
        Node current = first;
        System.out.print("Circular LinkedList : [");
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