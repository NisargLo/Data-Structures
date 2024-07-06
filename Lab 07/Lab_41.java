/*
    Chef has a string which contains only the characters '{', '}', '[', ']', '(' and ')'.
    Now Chef wants to know if the given string is balanced or not.
    If is balanced then print 1, otherwise print 0.

    A balanced parenthesis string is defined as follows:
        The empty string is balanced
        If P is balanced then (P), {P}, [P] is also balanced
        if P and Q are balanced PQ is also balanced
        "([])", "({})[()]" are balanced parenthesis strings
        "([{]})", "())" are not balanced.

    Input:
        The first line of the input contains a single integer T denoting the number of test cases.
        The description of T test cases follows.
        The first and only line of each test case contains a single string

    Output:
        For each test case, print a single line containing the answer.

    Example of Input & Output
        Input:
            Enter No of Test Cases: 4
            ()
            ([)]
            ([{}()])[{}]
            [{{}]
        Output:
            1
            0
            1
            0
 */

import java.util.Scanner;

public class Lab_41 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many testcases do you want to enter ?");
        int n=sc.nextInt();
        String[] str=new String[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter Parenthesis String "+(i+1)+" :");
            str[i]=sc.next();
        }
        System.out.println();
        for(int i=0;i<n;i++){
            if(isValid(str[i])){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }

    private static boolean isValid(String s) {
        Char_Stack stk = new Char_Stack();
        stk.size=s.length();
        stk.stack_array=new char[stk.size];
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stk.push(')');
            }
            else if (c == '{') {
                stk.push('}');
            }
            else if (c == '[') {
                stk.push(']');
            }
            else if (stk.isEmpty() || stk.pop()!=c) {
                return false;
            }
        }
        return stk.isEmpty();
    }
}
