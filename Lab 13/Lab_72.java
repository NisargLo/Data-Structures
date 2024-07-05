/*
    Write a menu driven program to implement following operations on the doubly linked list.
        Insert a node at the front of the linked list.
        Insert a node at the end of the linked list. (Home Work)
        Delete a node from specified position.
        Display all nodes. (Home Work)

    class Node is used from Lab_56
 */

import java.util.Scanner;

public class Lab_72 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Doubly_Linked_List dll = new Doubly_Linked_List();
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
            System.out.println("Enter 10 for displayDoublyLinkedList() :");
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

class Doubly_Linked_List{
    Node first=null;

    protected void insertAtFirstPosition(int data){
        System.out.println("insertAtFirstPosition(int data)");
    }

    protected void insertAtLastPosition(int data){
        System.out.println("insertAtLastPosition(int data)");
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

    protected void deleteGivenDataFromDoublyLinkedList(int data){
        System.out.println("deleteGivenDataFromDoublyLinkedList(int data)");
    }

    protected void deleteAllNodes() {
        System.out.println("deleteAllNodes()");
    }

    protected void displayDoublyLinkedList() {
        System.out.println("displayDoublyLinkedList()");
    }
}