// Write a program to determine whether the entered character is vowel or not.

import java.util.*;

public class Lab_03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=new String("AEIOUaeiou");
        System.out.println("Enter character :");
        char c=sc.next().charAt(0);
        if(s.contains(c+"")){
            System.out.println("Vowel");
        }
        else{
            System.out.println("Consonant");
        }
    }
}
