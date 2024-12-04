/*
    How stack can be used to recognize strings aca, bcb, abcba, abbcbba?
    Write a program to solve the above problem.
 */

import java.util.Scanner;

public class Lab_39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String str = sc.next();
        Char_Stack cs = new Char_Stack(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.toLowerCase().charAt(i) != 'a' && str.toLowerCase().charAt(i) != 'b'
                    && str.toLowerCase().charAt(i) != 'c') {
                System.out.println("String not recognized.");
                return;
            } else {
                cs.push(str.charAt(i));
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != cs.pop()) {
                System.out.println("String not recognized.");
                return;
            }
        }
        System.out.println("String recognized.");
    }
}

class Char_Stack {
    private final char[] stack_array;
    private int top = -1;
    private final int size;

    protected Char_Stack(int size) {
        this.size = size;
        this.stack_array = new char[this.size];
    }

    protected void push(char x) {
        if (top >= size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack_array[top] = x;
    }

    protected char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return '0';
        }
        top--;
        return stack_array[top + 1];
    }

    // user enters 0 based index :-
    protected char peep(int index) {
        if (top - index < 0) {
            System.out.println("Stack Underflow");
            return '0';
        }
        if (index < 0 || index > top) {
            System.out.println("Invalid index");
            return '0';
        }
        return stack_array[top - index];
    }

    // user enters 0 based index :-
    protected void change(int index, char x) {
        if (top - index < 0) {
            System.out.println("Stack Underflow");
            return;
        }
        if (index < 0 || index > top) {
            System.out.println("Invalid index");
            return;
        }
        stack_array[top - index] = x;
    }

    protected void display() {
        if (isEmpty()) {
            System.out.println("Empty Stack...");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < top; i++) {
            System.out.print(stack_array[i] + ", ");
        }
        System.out.print(stack_array[top] + "]\n");
    }

    protected boolean isEmpty() {
        return top == -1;
    }
}
