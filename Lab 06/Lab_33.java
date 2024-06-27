// Write a program to swap two numbers using user-defines method.

import java.util.Scanner;

public class Lab_33 {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          Swap sw=new Swap();
          System.out.println("Enter number 1 :");
          sw.a = sc.nextInt();
          System.out.println("Enter number 2 :");
          sw.b = sc.nextInt();
          sw.swapNo();
          System.out.println("After Swap : \nA - "+sw.a+", B - "+sw.b);
     }
}

class Swap{
     int a,b;
     protected void swapNo(){
          a=a^b;
          b=a^b;
          a=a^b;
     }
}