// Write a program to implement stack using singly linked list.

import java.util.Scanner;

public class Lab_60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack_Using_LinkedList S = new Stack_Using_LinkedList();
        String choice = "";
        while (!choice.equalsIgnoreCase("None")) {
            System.out.println("\nEnter Operation (push, pop, peep, change, display, isEmpty, none) :");
            choice = sc.next();
            switch (choice) {
                case "push":
                    System.out.println("Enter Number :");
                    int num1 = sc.nextInt();
                    S.push(num1);
                    break;

                case "pop":
                    System.out.println("pop() - " + S.pop());
                    break;

                case "peep":
                    System.out.println("Enter Index :");
                    int indexPeep = sc.nextInt();
                    System.out.println("peep() - " + S.peep(indexPeep));
                    break;

                case "change":
                    System.out.println("Enter Index :");
                    int indexChange = sc.nextInt();
                    System.out.println("Enter Number :");
                    int num2 = sc.nextInt();
                    S.change(indexChange, num2);
                    break;

                case "display":
                    S.display();
                    break;

                case "isEmpty":
                    if (S.isEmpty()) {
                        System.out.println("Empty Stack");
                    }
                    else {
                        System.out.println("Non-Empty Stack");
                    }
                    break;

                case "none":
                    System.out.println("Program Over...");
                    break;

                default:
                    System.out.println("Invalid");
            }
        }
    }
}

class Stack_Using_LinkedList {
    Node first = null;

    protected void push(int data) {
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

    protected int pop() {
        if (first == null) {
            return 0;
        }
        Node current = first;
        while ((current.link).link != null) {
            current = current.link;
        }
        int temp = (current.link).info;
        current.link = null;
        return temp;
    }

    // user enters 1 based index :-
    protected int peep(int index) {
        if (first == null) {
            return -1;
        }
        Node current = first;
        int count = 1;
        while (current.link != null) {
            current = current.link;
            count++;
        }
        if (index > count) {
            System.out.println("Stack Overflow...");
            return -1;
        }
        int i = 1;
        current = first;
        while (current.link != null && i != count - index + 1) {
            current = current.link;
            i++;
        }
        return current.info;
    }

    // user enters 1 based index :-
    protected void change(int index, int X) {
        if (first == null) {
            System.out.println("Empty Stack...");
        }
        Node current = first;
        int count = 1;
        while (current.link != null) {
            current = current.link;
            count++;
        }
        if (index > count) {
            System.out.println("Stack Overflow...");
        }
        int i = 1;
        current = first;
        while (current.link != null && i != count - index + 1) {
            current = current.link;
            i++;
        }
        current.info = X;
    }

    protected void display() {
        if (first == null) {
            System.out.println("Empty Stack...");
            return;
        }
        Node current = first;
        String str = "";
        str += "[";
        while (current != null) {
            str += current.info + ", ";
            current = current.link;
        }
        str = str.substring(0, str.length() - 2);
        str += "]\n";
        System.out.println("Stack - "+str);
    }

    protected boolean isEmpty() {
        return first == null;
    }
}
