// Write a program to delete duplicate numbers from an array.

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Lab_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many numbers will you enter :");
        int n = sc.nextInt(), i, j;
        int[] a = new int[n];
        // Scan...
        for (i = 0; i < a.length; i++) {
            System.out.println("Enter element " + (i + 1) + " :");
            a[i] = sc.nextInt();
        }
        // Create Set (Only stores unique elements)
        Set<Integer> uniqueSet = new HashSet<>();
        // Add all elements to set (duplicate won't get added)
        for (int num : a) {
            uniqueSet.add(num);
        }
        // Get back unique elements from Set to another Array
        int[] b = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            b[index++] = num;
        }
        // Print...
        System.out.println("Updated Array : ");
        for (i = 0; i < b.length; i++) {
            System.out.println("No. " + (i + 1) + " = " + b[i]);
        }
    }
}