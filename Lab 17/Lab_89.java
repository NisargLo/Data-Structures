// Implement a Dictionary (key, value) pair using Hash-table.

import java.util.Scanner;

public class Lab_89 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		int key, value, oldKey, newKey;
		Int_HashTable hashTable = new Int_HashTable(10);
		while (true) {
			System.out.println("\nEnter 1 for put():");
			System.out.println("Enter 2 for get():");
			System.out.println("Enter 3 for remove():");
			System.out.println("Enter 4 for update():");
			System.out.println("Enter 5 for display():");
			System.out.println("Enter -1 to exit:");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1:
					System.out.println("Enter key:");
					key = sc.nextInt();
					System.out.println("Enter value:");
					value = sc.nextInt();
					hashTable.put(key, value);
					break;
				
				case 2:
					System.out.println("Enter key to retrieve value:");
					key = sc.nextInt();
					Integer result = hashTable.get(key);
					if (result != null) {
						System.out.println("Value for key " + key + ": " + result);
					} else {
						System.out.println("Key not found.");
					}
					break;
				
				case 3:
					System.out.println("Enter key to delete:");
					key = sc.nextInt();
					hashTable.remove(key);
					break;
				
				case 4:
					System.out.println("Enter old key to update:");
					oldKey = sc.nextInt();
					System.out.println("Enter new key:");
					newKey = sc.nextInt();
					System.out.println("Enter new value for updated key:");
					value = sc.nextInt();
					hashTable.remove(oldKey);
					hashTable.put(newKey, value);
					break;
					
				case 5:
					hashTable.display();
					break;
					
				case -1:
					System.out.println("Program Over...");
					sc.close();
					return;
				
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}

class Int_HashTable {
	private final int[] keys;
	private final int[] values;
	private final boolean[] deleted;
	private final int size;
	private int count;
	
	public Int_HashTable(int size) {
		this.size = size;
		this.keys = new int[size];
		this.values = new int[size];
		this.deleted = new boolean[size];
		this.count = 0;
		for (int i = 0; i < size; i++) {
			keys[i] = Integer.MIN_VALUE;
			deleted[i] = false;
		}
	}
	
	private int hash(int key) {
		return key % size;
	}
	
	public void put(int key, int value) {
		int index = hash(key);
		int originalIndex = index;
		while (keys[index] != Integer.MIN_VALUE && keys[index] != key && !deleted[index]) {
			index = (index + 1) % size;
			if (index == originalIndex) {
				System.out.println("HashTable is full, cannot insert.");
				return;
			}
		}
		keys[index] = key;
		values[index] = value;
		deleted[index] = false;
		count++;
	}
	
	public Integer get(int key) {
		int index = hash(key);
		int originalIndex = index;
		while (keys[index] != Integer.MIN_VALUE) {
			if (keys[index] == key && !deleted[index]) {
				return values[index];
			}
			index = (index + 1) % size;
			if (index == originalIndex) {
				break;
			}
		}
		return null;
	}
	
	public void remove(int key) {
		int index = hash(key);
		int originalIndex = index;
		while (keys[index] != Integer.MIN_VALUE) {
			if (keys[index] == key && !deleted[index]) {
				deleted[index] = true;
				keys[index] = Integer.MIN_VALUE;
				count--;
				return;
			}
			index = (index + 1) % size;
			if (index == originalIndex) {
				break;
			}
		}
		System.out.println("Key not found for removal.");
	}
	
	public void display() {
		System.out.print("HashTable: ");
		for (int i = 0; i < size; i++) {
			if (keys[i] != Integer.MIN_VALUE && !deleted[i]) {
				System.out.print("[" + keys[i] + ":" + values[i] + "] ");
			}
		}
		System.out.println();
	}
}
