// Write a program to implement Heap Sort using Array.
/*
   	Time Complexity:
    Best Case: (O(n * log n))
    Average Case: (O(n * log n))
    Worst Case: (O(n * log n))
    Description: Efficient and in-place, but not stable.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab_98 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		if(n==0){
			System.out.println("Empty Array...");
			return;
		}
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			System.out.println("Enter element " + (i + 1) + ":");
			a[i] = sc.nextInt();
		}
		sc.close();
		System.out.println("Array before Shell Sort - " + Arrays.toString(a));
		heap_Sort();
		System.out.println("Array after Shell Sort - " + Arrays.toString(a));
	}
	
	private static void heap_Sort(){
	
	}
}
