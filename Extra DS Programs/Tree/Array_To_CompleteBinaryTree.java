// Convert an array to a Complete Binary Tree.

import java.util.Scanner;

public class Array_To_CompleteBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = sc.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter element " + (i + 1));
            a[i] = sc.nextInt();
        }
        Int_Complete_Binary_Tree tree = new Int_Complete_Binary_Tree();

        tree.root = tree.arrayToCompleteBinaryTree(0, a);
        // index=0 as started from the root node
        
        tree.displayRecursive(tree.root, "", true);
    }
}

class Int_Complete_Binary_Tree {
    Int_Tree_Node root = null;

    protected Int_Tree_Node arrayToCompleteBinaryTree(int index, int[] a) {
        if (index >= a.length) {
            return null;
        }
        Int_Tree_Node newNode = new Int_Tree_Node(a[index]);
        newNode.left = arrayToCompleteBinaryTree(2 * index + 1, a);
        newNode.right = arrayToCompleteBinaryTree(2 * index + 2, a);
        return newNode;
    }
    
    protected void displayRecursive(Int_Tree_Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.info); // ├── for left sub-tree, └── for right sub-tree
            displayRecursive(node.left, prefix + (isTail ? "    " : "│   "), false);
            displayRecursive(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }
}