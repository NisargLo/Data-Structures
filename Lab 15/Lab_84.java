/*
	Write a program to implement phone book dictionary using Binary Search Tree which provides following operations:
		Add new entry in phone book,
		Remove entry from phone book,
		Search phone number
		List all entries in ascending order of name and
		List all entries in descending order of name
 */

import java.util.Scanner;

class Lab_84 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String name, phone;
		String_Binary_Search_Tree bst = new String_Binary_Search_Tree();
		while (choice != -1) {
			System.out.println("\nEnter 1 to Add New Entry:");
			System.out.println("Enter 2 to Update Entry:");
			System.out.println("Enter 3 to Remove Entry:");
			System.out.println("Enter 4 to Delete Entire Tree:");
			System.out.println("Enter 5 to Search for a Phone Number:");
			System.out.println("Enter 6 to List Entries in Ascending Order:");
			System.out.println("Enter 7 to List Entries in Descending Order:");
			System.out.println("Enter 8 to Check if Tree is Empty:");
			System.out.println("Enter -1 to Exit:");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
				case 1 -> {
					System.out.println("Enter Name:");
					name = sc.nextLine();
					System.out.println("Enter Phone Number:");
					phone = sc.nextLine();
					bst.insert(name, phone);
				}
				
				case 2 -> {
					System.out.println("Enter Existing Name:");
					name = sc.nextLine();
					System.out.println("Enter New Phone Number:");
					phone = sc.nextLine();
					bst.update(name, phone);
				}
				
				case 3 -> {
					System.out.println("Enter Name to Remove:");
					name = sc.nextLine();
					bst.delete(name);
				}
				
				case 4 -> bst.deleteEntireTree();
				
				case 5 -> {
					System.out.println("Enter Name to Search:");
					name = sc.nextLine();
					if (bst.search(name)) {
						System.out.println("Entry found: " + name);
					} else {
						System.out.println("Entry not found.");
					}
				}
				
				case 6 -> bst.displayAscending();
				
				case 7 -> bst.displayDescending();
				
				case 8 -> System.out.println("Tree is empty: " + bst.isEmpty());
				
				case -1 -> System.out.println("Program Over...");
				
				default -> System.out.println("Invalid choice.");
			}
		}
		sc.close();
	}
}

class String_Binary_Search_Tree {
	String_Tree_Node root;
	
	protected void insert(String name, String phone) {
		root = insertRecursive(root, name, phone);
	}
	
	private String_Tree_Node insertRecursive(String_Tree_Node node, String name, String phone) {
		if (node == null) {
			return new String_Tree_Node(name, phone);
		}
		if (name.compareTo(node.entry.name) < 0) {
			node.left = insertRecursive(node.left, name, phone);
		} else if (name.compareTo(node.entry.name) > 0) {
			node.right = insertRecursive(node.right, name, phone);
		} else {
			System.out.println(name + " already exists.");
		}
		return node;
	}
	
	protected void update(String name, String newPhone) {
		if (search(name)) {
			root = deleteRecursive(root, name);
			insert(name, newPhone);
			System.out.println("Successfully updated.");
		} else {
			System.out.println(name + " not found.");
		}
	}
	
	protected boolean search(String name) {
		return searchRecursive(root, name) != null;
	}
	
	private String_Tree_Node searchRecursive(String_Tree_Node node, String name) {
		if (node == null || node.entry.name.equals(name)) {
			return node;
		}
		if (name.compareTo(node.entry.name) > 0) {
			return searchRecursive(node.right, name);
		} else {
			return searchRecursive(node.left, name);
		}
	}
	
	protected void delete(String name) {
		if (search(name)) {
			root = deleteRecursive(root, name);
			System.out.println("Successfully deleted.");
		} else {
			System.out.println(name + " not found.");
		}
	}
	
	private String_Tree_Node deleteRecursive(String_Tree_Node node, String name) {
		if (node == null) {
			return null;
		}
		if (name.compareTo(node.entry.name) < 0) {
			node.left = deleteRecursive(node.left, name);
		} else if (name.compareTo(node.entry.name) > 0) {
			node.right = deleteRecursive(node.right, name);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			node.entry = minValue(node.right);
			node.right = deleteRecursive(node.right, node.entry.name);
		}
		return node;
	}
	
	private String_Entry minValue(String_Tree_Node node) {
		String_Entry min = node.entry;
		while (node.left != null) {
			node = node.left;
			min = node.entry;
		}
		return min;
	}
	
	public void displayAscending() {
		if (root == null) {
			System.out.println("Phone book is empty.");
			return;
		}
		displayRecursiveAscending(root);
	}
	
	private void displayRecursiveAscending(String_Tree_Node node) {
		if (node != null) {
			displayRecursiveAscending(node.left);
			System.out.println(node.entry.name + ": " + node.entry.phone);
			displayRecursiveAscending(node.right);
		}
	}
	
	public void displayDescending() {
		if (root == null) {
			System.out.println("Phone book is empty.");
			return;
		}
		displayRecursiveDescending(root);
	}
	
	private void displayRecursiveDescending(String_Tree_Node node) {
		if (node != null) {
			displayRecursiveDescending(node.right);
			System.out.println(node.entry.name + ": " + node.entry.phone);
			displayRecursiveDescending(node.left);
		}
	}
	
	protected void deleteEntireTree() {
		root = null;
	}
	
	protected boolean isEmpty() {
		return root == null;
	}
}

class String_Tree_Node {
	String_Entry entry;
	String_Tree_Node left, right;
	
	public String_Tree_Node(String name, String phone) {
		this.entry = new String_Entry(name, phone);
		this.left = this.right = null;
	}
}

class String_Entry {
	String name;
	String phone;
	
	public String_Entry(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
}