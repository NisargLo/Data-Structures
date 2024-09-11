// Write a program to implement Shell Sort using Array.
/*
     Time Complexity:
     Best Case: (O(n * log n))
     Average Case: (O(n * log^2 n))
     Worst Case: (O(n * log^2 n))
     Description: Efficient for Medium-Sized arrays, Partially Sorted Data, Memory Constraints, but not stable.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab_99 {
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
		shell_sort(a);
		System.out.println("Array after Shell Sort - " + Arrays.toString(a));
	}
	
	private static void shell_sort(int[] a) {
		int l = a.length;
		for (int gap = l / 2; gap >= 1; gap /= 2) {
			for (int i = gap; i < l; i++) {
				int temp = a[i];
				int j = i;
				while (j >= gap && a[j - gap] > temp) {
					a[j] = a[j - gap];
					j -= gap;
				}
				a[j] = temp;
			}
		}
	}
}
