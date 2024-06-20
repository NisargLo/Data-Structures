// Write a program to insert a number at a given location in an array.

import java.util.*;

public class Lab_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers will you enter :");
        int n = sc.nextInt(), i, j;
        int[] a = new int[n];
        for (i = 0; i < a.length; i++) {
            System.out.println("Enter element " + (i + 1) + " :");
            a[i] = sc.nextInt();
        }
        System.out.println("Enter number to insert :");
        int no_to_replace = sc.nextInt();
        System.out.println("Enter index on which No. is inserted :");
        int getIndex = sc.nextInt();
        if (getIndex < 0 || getIndex >= a.length) {
            System.out.println("Invalid index.\nProgram will exit.");
            System.exit(0);
        }
        int[] b = new int[n + 1];
        for (i = 0, j = 0; i < b.length; i++, j++) {
            if (getIndex == i) {
                b[i] = no_to_replace;
                j--;
            } else {
                b[i] = a[j];
            }
        }
        for (i = 0; i < b.length; i++) {
            System.out.println("No. " + (i + 1) + " = " + b[i]);
        }
    }
}