// Write a program to calculate area of a Circle (A = πr2).

import java.util.*;

public class Lab_01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter radius :");
        double r=sc.nextDouble();
        System.out.println("Area = "+(Math.PI*Math.pow(r, 2)));
    }
}