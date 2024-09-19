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
		if (n == 0) {
			System.out.println("Empty Array...");
			return;
		}
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			System.out.println("Enter element " + (i + 1) + ":");
			a[i] = sc.nextInt();
		}
		sc.close();
		System.out.println("Array before Heap Sort - " + Arrays.toString(a));
		heap_Sort(a);
		System.out.println("Array after Heap Sort - " + Arrays.toString(a));
	}

	private static void heap_Sort(int[] a) {
		int l = a.length;

		// l/2-1 -> gives index of last parent
		for (int i = l / 2 - 1; i >= 0; i--) {
			heapify(a, l, i);
		}

		for (int i = l - 1; i >= 0; i--) {
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			heapify(a, i, 0);
		}
	}

	private static void heapify(int[] a, int l, int root) {
		int max = root;
		int left = 2 * root + 1;
		int right = 2 * root + 2;

		if (left < l && a[left] > a[max]) {
			max = left;
		}
		if (right < l && a[right] > a[max]) {
			max = right;
		}

		if (max != root) {
			int temp = a[root];
			a[root] = a[max];
			a[max] = temp;
			heapify(a, l, max);
		}
	}
}
