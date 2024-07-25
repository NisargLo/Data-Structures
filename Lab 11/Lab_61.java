// Write a program to implement queue using singly linked list.

import java.util.Scanner;

public class Lab_61 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          Queue_Using_LinkedList qul=new Queue_Using_LinkedList();
          int choice = 0;
          while (choice != -1) {
               System.out.println("\nEnter 1 for enqueue() :");
               System.out.println("Enter 2 for dequeue() :");
               System.out.println("Enter 3 for display() :");
               System.out.println("Enter 4 for isEmpty() :");
               System.out.println("Enter -1 to exit :");
               choice = sc.nextInt();
               switch (choice) {
                    case 1:
                         System.out.println("Enter Number :");
                         int num = sc.nextInt();
                         qul.enqueue(num);
                         break;

                    case 2:
                         int dequeue= qul.dequeue();
                         if(dequeue!=Integer.MIN_VALUE){
                              System.out.println("dequeue() - "+dequeue);
                         }
                         break;

                    case 3:
                         qul.display();
                         break;

                    case 4:
                         System.out.println(qul.isEmpty());
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

class Queue_Using_LinkedList {
     Node first = null;

     protected void enqueue(int data) {
          Node newNode = new Node(data);
          if (first == null) {
               first = newNode;
               return;
          }
          Node current = first;
          while (current.link != null) {
               current = current.link;
          }
          current.link = newNode;
     }

     protected int dequeue() {
          if (first == null) {
               System.out.println("Empty Queue...");
               return Integer.MIN_VALUE;
          }
          int removedValue = first.info;
          first = first.link;
          return removedValue;
     }

     protected void display() {
          if (first == null) {
               System.out.println("Empty Queue...");
               return;
          }
          Node current = first;
          System.out.print("Queue - [");
          while (current.link != null) {
               System.out.print(current.info+", ");
               current = current.link;
          }
          System.out.println(current.info+"]");
     }

     protected boolean isEmpty() {
          return first == null;
     }
}