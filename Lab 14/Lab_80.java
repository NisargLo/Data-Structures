//Write a program to check whether the given tree is symmetric or not.

import java.util.Scanner;

public class Lab_80 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Int_Binary_Search_Tree[] tree=new Int_Binary_Search_Tree[2];
		for(int i=0;i<tree.length;i++) {
			tree[i] = new Int_Binary_Search_Tree();
			System.out.println("\nTree "+(i+1)+" :-\nEnter -1 to exit :");
			int n;
			while (true) {
				System.out.println("Enter No :");
				n = sc.nextInt();
				if (n == -1) {
					break;
				}
				tree[i].insert(n);
			}
			tree[i].display();
		}
		boolean isSymmetric = compareBST(tree[0].root, tree[1].root);
		if (isSymmetric) {
			System.out.println("\nThe two trees are symmetric.");
		} else {
			System.out.println("\nThe two trees are not symmetric.");
		}
	}
	
	private static boolean compareBST(Int_Tree_Node node1, Int_Tree_Node node2){
		if (node1==null || node2==null) {
			return node1==node2;
		}
		else if(node1.info!=node2.info){
			return false;
		}
		return compareBST(node1.left,node2.right) && compareBST(node1.right,node2.left);
	}
}