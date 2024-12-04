/*
	In an array of 20 elements, arrange 15 different values, which are generated randomly between 1,00,000 to 9,99,999.
	Use hash function to generate key and linear probing to avoid collision.
	H(x) = (x mod 18) + 2.
	Write a program to input and display the final values of array.
 */

import java.util.*;

public class Lab_88 {
	static final int SIZE = 20;
	static final int NUM_VALUES = 15;
	
	public static void main(String[] args) {
		int[] hashTable = new int[SIZE];
		Arrays.fill(hashTable, -1);
		Set<Integer> insertedValues = new HashSet<>();
		Random rand = new Random();
		while (insertedValues.size() < NUM_VALUES) {
			int randomValue = generateRandomValue();
			if (!insertedValues.contains(randomValue)) {
				insertedValues.add(randomValue);
				insert(hashTable, randomValue);
			}
		}
		displayHashTable(hashTable);
	}
	
	private static int hashFunction(int x) {
		return (x % 18) + 2;
	}
	
	public static int generateRandomValue() {
		Random rand = new Random();
		return rand.nextInt(900000) + 100000;
	}
	
	public static void insert(int[] table, int value) {
		int index = hashFunction(value);
		while (table[index] != -1) {
			index = (index + 1) % SIZE;
		}
		table[index] = value;
	}
	
	public static void displayHashTable(int[] table) {
		System.out.println("\nHash Table:");
		for (int i = 0; i < SIZE; i++) {
			if (table[i] != -1) {
				System.out.println("Index " + i + ": " + table[i]);
			} else {
				System.out.println("Index " + i + ": (Empty)");
			}
		}
	}
}

