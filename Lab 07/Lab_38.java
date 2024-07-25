/*
    Write a menu driven program to implement following operations on the Stack using an Array
        PUSH, POP, DISPLAY
        PEEP, CHANGE
 */

import java.util.*;

public class Lab_38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of stack :");
        int n = sc.nextInt();
        Int_Stack S = new Int_Stack(n);
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
                    int pop=S.pop();
                    if(pop!=Integer.MIN_VALUE){
                        System.out.println("pop() - " + pop);
                    }
                    break;

                case "peep":
                    System.out.println("Enter Index :");
                    int indexPeep = sc.nextInt();
                    int peep=S.peep(indexPeep);
                    if(peep!=Integer.MIN_VALUE){
                        System.out.println("pop() - " + peep);
                    }
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

class Int_Stack {
    int[] stack_array;
    private int top = -1;
    int size;

    protected Int_Stack(int size) {
        this.size=size;
        this.stack_array=new int[this.size];
    }

    protected void push(int x) {
        if (top >= size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack_array[top] = x;
    }

    protected int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        int data = stack_array[top];
        top--;
        return data;
    }

    // user enters 1 based index :-
    protected int peep(int index) {
        if (top + 1 - index < 0) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        return stack_array[top + 1 - index];
    }

    // user enters 1 based index :-
    protected void change(int index, int x) {
        if (top + 1 - index < 0) {
            System.out.println("Stack Underflow");
            return;
        }
        stack_array[top + 1 - index] = x;
    }

    protected void display() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        }
        System.out.print("Stack - [");
        for (int i = 0; i < top; i++) {
            System.out.print(stack_array[i] + ", ");
        }
        System.out.print(stack_array[top] + "]\n");
    }

    protected boolean isEmpty() {
        return top == -1;
    }
}
