/*
     Write a menu driven program to implement following operations on a circular queue using an Array
          Insert
          Delete
          Display all elements of the queue
 */

import java.util.Scanner;

public class Lab_51 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of Queue :");
          int size = sc.nextInt();
          Int_Circular_Queue cq = new Int_Circular_Queue(size);
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
                         cq.enqueue(num);
                    }

                    case 2 -> {
                         int dequeue = cq.dequeue();
                         if (dequeue != Integer.MIN_VALUE) {
                              System.out.println("dequeue() - "+dequeue);
                         }
                    }

                    case 3 -> cq.display();

                    case 4 -> cq.makeQueueEmpty();

                    case 5 -> System.out.println(cq.isEmpty());

                    case -1 -> System.out.println("Program Over...");

                    default -> System.out.println("Invalid choice.");
               }
          }
          sc.close();
     }
}

class Int_Circular_Queue {
     private int front = -1;
     private int rear = -1;
     private final int size;
     private int[] arr;

     protected Int_Circular_Queue(int size) {
          this.size=size;
          this.arr=new int[size];
     }

     protected void enqueue(int data) {
          if (front==(rear+1)%size) {
               System.out.println("Queue Overflow...");
               return;
          }
          if (front == -1) {
               front = 0;
          }
          rear=(rear+1)%size;
          arr[rear]=data;
     }

     protected int dequeue() {
          if (front == -1) {
               System.out.println("Queue Underflow...");
               return Integer.MIN_VALUE;
          }
          int data=arr[front];
          if (front==rear) {
               front = -1;
               rear = -1;
          }
          else{
               front=(front+1)%size;
          }
          return data;
     }

     protected void display() {
          if (front == -1) {
               System.out.println("Queue is empty...");
               return;
          }
          System.out.print("Circular Queue - [");
          for (int i=front; i!=rear; i=(i+1)%size) {
               System.out.print(arr[i] + ", ");
          }
          System.out.println(arr[rear]+"]");
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
