/*
    Percy the peacock loves colorful parties. He has a stack of different feathers.
    He wears the bottom one to parties and puts it on top later.
    When he buys new feathers, he adds them on top.
    Can you write a program to pick his party feather?

        For example: You have 10 queries, each separated by a space.
                    If a query is "buy_<color-name>", he adds that colored feather on top.
                    If it's "fetch", the program prints the bottom feather color and moves it to the top.
                    His suitcase starts empty.

        Input: 10
            buy_red, buy_blue, buy_green, fetch, fetch, buy_yellow, fetch, fetch, fetch, fetch

        Output:
            red, blue, green, red, blue, yellow
 */

import java.util.Scanner;

public class Lab_54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queries:");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter queries separated by commas:");
        String[] queries = sc.nextLine().trim().split(", ");
        System.out.println();
        String_Circular_Queue queue = new String_Circular_Queue(n);
        for (String query : queries) {
            if (query.startsWith("buy_")) {
                String color = query.substring(4);
                queue.enqueue(color);
            } else if (query.equals("fetch")) {
                if (!queue.isEmpty()) {
                    String bottomFeather = queue.dequeue();
                    System.out.println(bottomFeather);
                    queue.enqueue(bottomFeather);
                } else {
                    System.out.println("No feathers to fetch.");
                }
            }
        }
        queue.makeQueueEmpty();
        sc.close();
    }
}

class String_Circular_Queue{
    private int front = -1;
    private int rear = -1;
    private final int size;
    private String[] arr;

    protected String_Circular_Queue(int size) {
        this.size=size;
        this.arr=new String[size];
    }

    protected void enqueue(String data) {
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

    protected String dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow...");
            return null;
        }
        String data=arr[front];
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