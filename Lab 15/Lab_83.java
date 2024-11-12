// WAP to find the smallest and largest elements in the Binary Search Tree.

import java.util.Scanner;

public class Lab_83 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Int_Binary_Search_Tree tree=new Int_Binary_Search_Tree();
		System.out.println("Enter -1 to exit :");
		int num;
		while (true) {
			System.out.println("Enter Number :");
			num = sc.nextInt();
			if(num==-1){
				break;
			}
			tree.insert(num);
		}
		tree.display();
		int small = get_Smallest_No(tree);
		int large = get_Largest_No(tree);
		System.out.println("\nSmallest no. in binary search tree: "+small);
		System.out.println("Largest no. in binary search tree: "+large);
	}
	
	private static int get_Smallest_No(Int_Binary_Search_Tree bst) {
		if (bst.root == null) {
			System.out.println("The tree is empty");
			return Integer.MIN_VALUE;
		}
		
		Int_Tree_Node current = bst.root;
		while (current.left != null) {
			current = current.left;
		}
		return current.info;
	}
	
	private static int get_Largest_No(Int_Binary_Search_Tree bst) {
		if (bst.root == null) {
			System.out.println("The tree is empty");
			return Integer.MAX_VALUE;
		}
		
		Int_Tree_Node current = bst.root;
		while (current.right != null) {
			current = current.right;
		}
		return current.info;
	}
}
