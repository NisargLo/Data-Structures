/*
     Write a menu driven program to implement following operations on the Queue using an Array
          ENQUEUE
          DEQUEUE
          DISPLAY
 */

import java.util.Scanner;

public class Lab_50 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of Queue :");
          int size = sc.nextInt();
          Int_Queue q = new Int_Queue(size);
          int choice = 0;
          while (choice != -1) {
               System.out.println("\nEnter 1 for enqueue() :");
               System.out.println("Enter 2 for dequeue() :");
               System.out.println("Enter 3 for display() :");
               System.out.println("Enter 4 for makeQueueEmpty():");
               System.out.println("Enter 5 for isEmpty() :");
               System.out.println("Enter -1 to exit :");
               choice = sc.nextInt();
               switch (choice) {
                    case 1 -> {
                         System.out.println("Enter Number :");
                         int num = sc.nextInt();
                         q.enqueue(num);
                    }

                    case 2 -> {
                         int dequeue = q.dequeue();
                         if (dequeue != Integer.MIN_VALUE) {
                              System.out.println("dequeue() - "+dequeue);
                         }
                    }

                    case 3 -> q.display();

                    case 4 -> q.makeQueueEmpty();

                    case 5 -> System.out.println(q.isEmpty());

                    case -1 -> System.out.println("Program Over...");

                    default -> System.out.println("Invalid choice.");
               }
          }
          sc.close();
     }
}

class Int_Queue {
     private int front = -1;
     private int rear = -1;
     private final int size;
     private int[] arr;

     protected Int_Queue(int size) {
          this.size = size;
          arr = new int[size];
     }

     protected void enqueue(int data) {
          if (rear >= size - 1) {
               System.out.println("Queue Overflow...");
               return;
          } else {
               rear++;
               arr[rear] = data;
          }
          if (front == -1) {
               front = 0;
          }
     }

     protected int dequeue() {
          if (front == -1) {
               System.out.println("Queue Underflow...");
               return Integer.MIN_VALUE;
          }
          int data=arr[front];
          if (front == rear) {
               front = -1;
               rear = -1;
          }
          else{
               front++;
          }
          return data;
     }

     protected void display() {
          if (front == -1) {
               System.out.println("Queue is empty...");
               return;
          }
          System.out.print("Queue - [");
          for (int i = front; i <= rear; i++) {
               System.out.print(arr[i] + ", ");
          }
          System.out.println("\b\b]");
     }

     protected void makeQueueEmpty(){
          arr=null;
          front = -1;
          rear = -1;
     }

     protected boolean isEmpty(){
          return front==-1 && rear==-1;
     }
}
