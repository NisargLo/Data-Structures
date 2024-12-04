/*
    Bucket Sort

    Time Complexity:
    Best Case: (O(n + k))
    Average Case: (O(n + k))
    Worst Case: (O(n^2))
    Description: Efficient for uniformly distributed data, stable.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Bucket_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Int_LinkedList ill=new Int_LinkedList();
		System.out.println("Enter -1 to exit :");
		int n;
		while(true){
			System.out.println("Enter No :");
			n=sc.nextInt();
			if(n==-1){
				break;
			}
			ill.insertAtLastPosition(n);
		}
		if(ill.isEmpty()){
			System.out.println("Empty LinkedList...");
			return;
		}
		sc.close();
		System.out.println("\nBefore Bucket Sort :- ");
		ill.displayLinkedList();
		bucket_Sort(ill);
		System.out.println("\nAfter Bucket Sort :- ");
		ill.displayLinkedList();
	}
	
	private static void bucket_Sort(Int_LinkedList ill){
		int min = findMin(ill);
		int max = findMax(ill);
		int bucketCount = max - min + 1;
		
		ArrayList<Int_LinkedList> buckets=new ArrayList<>(bucketCount);
		for (int i = 0; i < bucketCount; i++) {
			buckets.add(new Int_LinkedList());
		}
		int[] arr = linkedListToArray(ill);
		for (int num : arr) {
			int index = num - min;
			buckets.get(index).insertAtLastPosition(num);
		}
		
		ill.deleteAllNodes();
		for(Int_LinkedList bucket : buckets){
			Int_LinkedList sortedBucket = insertion_Sort(bucket);
			Node current = sortedBucket.first;
			while (current != null) {
				ill.insertAtLastPosition(current.info);
				current = current.link;
			}
		}
	}
	
	private static int findMin(Int_LinkedList ill) {
		if (ill.first == null) {
			return Integer.MIN_VALUE;
		}
		Node current = ill.first;
		int min = current.info;
		while (current != null) {
			if (current.info < min) {
				min = current.info;
			}
			current = current.link;
		}
		return min;
	}
	
	private static int findMax(Int_LinkedList ill) {
		if (ill.first == null) {
			return Integer.MAX_VALUE;
		}
		Node current = ill.first;
		int max = current.info;
		while (current != null) {
			if (current.info > max) {
				max = current.info;
			}
			current = current.link;
		}
		return max;
	}
	
	private static int[] linkedListToArray(Int_LinkedList ill) {
		int c = 0;
		Node current = ill.first;
		while (current != null) {
			c++;
			current = current.link;
		}
		int[] array = new int[c];
		current = ill.first;
		int index = 0;
		while (current != null) {
			array[index++] = current.info;
			current = current.link;
		}
		return array;
	}
	
	private static Int_LinkedList insertion_Sort(Int_LinkedList ill) {
		Int_LinkedList sortedList = new Int_LinkedList();
		Node current = ill.first;
		while (current != null) {
			sortedList.insertAtOrder(current.info);
			current = current.link;
		}
		return sortedList;
	}
}
