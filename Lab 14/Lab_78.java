/*
	Write a menu driven program to implement Binary Search Tree (BST) & perform following operations
        Preorder Traversal, Postorder Traversal, Inorder Traversal
 */

import java.util.Scanner;

public class Lab_78 {
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
		System.out.println("\nPre-order Traversal:");
		preorder_traverse(tree.root);
		System.out.println("\n\nIn-order Traversal:");
		inorder_traverse(tree.root);
		System.out.println("\n\nPost-order Traversal:");
		postorder_traverse(tree.root);
		System.out.println("\n\nConverse Pre-order Traversal:");
		converse_preorder_traverse(tree.root);
		System.out.println("\n\nConverse In-order Traversal:");
		converse_inorder_traverse(tree.root);
		System.out.println("\n\nConverse Post-order Traversal:");
		converse_postorder_traverse(tree.root);
	}
	
	protected static void preorder_traverse(Int_Tree_Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.info + "  ");
		preorder_traverse(node.left);
		preorder_traverse(node.right);
	}
	
	protected static void inorder_traverse(Int_Tree_Node node) {
		if (node == null) {
			return;
		}
		inorder_traverse(node.left);
		System.out.print(node.info + "  ");
		inorder_traverse(node.right);
	}
	
	protected static void postorder_traverse(Int_Tree_Node node) {
		if (node == null) {
			return;
		}
		postorder_traverse(node.left);
		postorder_traverse(node.right);
		System.out.print(node.info + "  ");
	}
	
	protected static void converse_preorder_traverse(Int_Tree_Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.info + "  ");
		converse_preorder_traverse(node.right);
		converse_preorder_traverse(node.left);
	}
	
	protected static void converse_inorder_traverse(Int_Tree_Node node) {
		if (node == null) {
			return;
		}
		converse_inorder_traverse(node.right);
		System.out.print(node.info + "  ");
		converse_inorder_traverse(node.left);
	}
	
	protected static void converse_postorder_traverse(Int_Tree_Node node) {
		if (node == null) {
			return;
		}
		converse_postorder_traverse(node.right);
		converse_postorder_traverse(node.left);
		System.out.print(node.info + "  ");
	}
}
