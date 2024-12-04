// Write a program to construct a binary tree from given postorder and preorder traversal sequence.

import java.util.Scanner;

public class Lab_82 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter length of preorder & postorder traversal: ");
		int n=sc.nextInt();
		int[] pre=new int[n];
		int[] post=new int[n];
		for(int i=0;i<n;i++){
			System.out.println("Enter number "+(i+1)+" for preorder traversal: ");
			pre[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			System.out.println("Enter number "+(i+1)+" for postorder traversal: ");
			post[i]=sc.nextInt();
		}
		Int_Binary_Search_Tree bst=give_BST(pre, post);
		bst.display();
	}
	
	private static Int_Binary_Search_Tree give_BST(int[] preorder, int[] postorder) {
		Int_Binary_Search_Tree bst = new Int_Binary_Search_Tree();
		build_BST(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1, bst);
		return bst;
	}
	
	private static void build_BST(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd, Int_Binary_Search_Tree bst) {
		if (preStart > preEnd || postStart > postEnd) {
			return;
		}
		int rootValue = preorder[preStart];
		bst.insert(rootValue);
		if (preStart == preEnd) {
			return;
		}
		int leftSubtreeRootValue = preorder[preStart + 1];
		int leftSubtreeRootIndexInPost = findInPostorder(postorder, postStart, postEnd, leftSubtreeRootValue);
		int leftSubtreeSize = leftSubtreeRootIndexInPost - postStart + 1;
		build_BST(preorder, postorder, preStart + 1, preStart + leftSubtreeSize, postStart, leftSubtreeRootIndexInPost, bst);
		build_BST(preorder, postorder, preStart + leftSubtreeSize + 1, preEnd, leftSubtreeRootIndexInPost + 1, postEnd - 1, bst);
	}
	
	private static int findInPostorder(int[] postorder, int postStart, int postEnd, int value) {
		for (int i = postStart; i <= postEnd; i++) {
			if (postorder[i] == value) {
				return i;
			}
		}
		return -1;
	}
}
