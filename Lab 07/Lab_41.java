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
             Enter No of Test Cases: 4
             ()
             ([)]
             ([{}()])[{}]
             [{{}]
        Output:
             1
             0
             1
             0
 */

import java.util.Scanner;

public class Lab_41 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Char_Stack cs=new Char_Stack();
        System.out.println("Enter Parenthesis String :");
        String str=sc.next();
        cs.size=str.length();
        cs.stack_array=new char[cs.size];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='(' && str.charAt(i)!=')' && str.charAt(i)!='{' && str.charAt(i)!='}' && str.charAt(i)!='[' && str.charAt(i)!=']'){
                System.out.println("Enter Valid Parenthesis String.");
                return;
            }
            else{
                cs.push(str.charAt(i));
            }
        }
    }
}
