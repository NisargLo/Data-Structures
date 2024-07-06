/*
    How stack can be used to recognize strings aca, bcb, abcba, abbcbba?
    Write a program to solve the above problem.
 */

import java.util.Scanner;

public class Lab_39 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Char_Stack cs=new Char_Stack();
        System.out.println("Enter String :");
        String str=sc.next();
        cs.size=str.length();
        cs.stack_array=new char[cs.size];
        for(int i=0;i<str.length();i++){
            if(str.toLowerCase().charAt(i)!='a' && str.toLowerCase().charAt(i)!='b' && str.toLowerCase().charAt(i)!='c'){
                System.out.println("String not recognized.");
                return;
            }
            else{
                cs.push(str.charAt(i));
            }
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=cs.pop()){
                System.out.println("String not recognized.");
                return;
            }
        }
        System.out.println("String recognized.");
    }
}

class Char_Stack {
    char[] stack_array;
    private int top = -1;
    int size;

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

    protected char peep(int index) {
        if (top + 1 - index <= 0 || index > top + 1) {
            System.out.println("Stack Underflow");
            return 0;
        }
        return stack_array[top + 1 - index];
    }

    protected void change(int index, char x) {
        if (top + 1 - index <= 0) {
            System.out.println("Stack Underflow");
            return;
        }
        stack_array[top + 1 - index] = x;
    }

    protected void display() {
        System.out.print("[");
        for (int i = 0; i < top; i++) {
            System.out.print(stack_array[i] + ", ");
        }
        System.out.print(stack_array[top] + "]\n");
    }

    protected boolean isEmpty() {
        return top==-1;
    }
}