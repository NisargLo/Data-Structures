/*
    Write a menu driven program to implement following operations on the Doubled Ended Queue using an Array.
        Insert at front end, Insert at rear end
        Delete from front end, Delete from rear end
        Display all elements of the queue
 */

import java.util.Scanner;

public class Lab_52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of Queue:");
        int size = sc.nextInt();
        Int_Doubled_Ended_Queue dq = new Int_Doubled_Ended_Queue(size);
        int choice = 0;
        while (choice != -1) {
            System.out.println("\nEnter 1 for enqueue_rear():");
            System.out.println("Enter 2 for enqueue_front():");
            System.out.println("Enter 3 for dequeue_front():");
            System.out.println("Enter 4 for dequeue_rear():");
            System.out.println("Enter 5 for display():");
            System.out.println("Enter 6 for makeQueueEmpty():");
            System.out.println("Enter 7 for isEmpty():");
            System.out.println("Enter -1 to exit:");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Number:");
                    int num = sc.nextInt();
                    dq.enqueue_rear(num);
                }

                case 2 -> {
                    System.out.println("Enter Number:");
                    int num = sc.nextInt();
                    dq.enqueue_front(num);
                }

                case 3 -> {
                    int dequeue = dq.dequeue_front();
                    if (dequeue != Integer.MIN_VALUE) {
                        System.out.println("dequeue_front() - " + dequeue);
                    }
                }

                case 4 -> {
                    int dequeue = dq.dequeue_rear();
                    if (dequeue != Integer.MIN_VALUE) {
                        System.out.println("dequeue_rear() - " + dequeue);
                    }
                }

                case 5 -> dq.display();

                case 6 -> dq.makeQueueEmpty();

                case 7 -> System.out.println(dq.isEmpty());

                case -1 -> System.out.println("Program Over...");

                default -> System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}

class Int_Doubled_Ended_Queue{
    private int front = -1;
    private int rear = -1;
    private final int size;
    private final int[] arr;

    protected Int_Doubled_Ended_Queue(int size) {
        this.size=size;
        this.arr=new int[size];
    }

    protected void enqueue_rear(int data) {
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

    protected void enqueue_front (int data){
        if ((front-1+size)%size==rear) {
            System.out.println("Queue Overflow...");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else{
            front=(front-1+size)%size;
        }
        arr[front]=data;
    }

    protected int dequeue_front() {
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

    protected int dequeue_rear(){
        if(front==-1){
            System.out.println("Queue Underflow...");
            return Integer.MIN_VALUE;
        }
        int data=arr[rear];
        if(front==rear){
            front=-1;
            rear=-1;
        } else{
            rear=(rear-1+size)%size;
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
        front = -1;
        rear = -1;
    }

    protected boolean isEmpty(){
        return front==-1 && rear==-1;
    }
}