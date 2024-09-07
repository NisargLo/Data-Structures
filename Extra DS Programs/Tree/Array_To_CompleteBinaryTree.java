// Convert an array to a strict binary tree.

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

        System.out.println("\nTree Structure:");
        tree.printTree(tree.root, "", true);
        System.out.println("\nPre-order Traversal:");
        tree.preorder_traverse(tree.root);
        System.out.println("\n\nIn-order Traversal:");
        tree.inorder_traverse(tree.root);
        System.out.println("\n\nPost-order Traversal:");
        tree.postorder_traverse(tree.root);
        System.out.println("\n\nConverse Pre-order Traversal:");
        tree.converse_preorder_traverse(tree.root);
        System.out.println("\n\nConverse In-order Traversal:");
        tree.converse_inorder_traverse(tree.root);
        System.out.println("\n\nConverse Post-order Traversal:");
        tree.converse_postorder_traverse(tree.root);
    }
}

class Int_Tree_Node {
    int info;
    Int_Tree_Node left;
    Int_Tree_Node right;

    public Int_Tree_Node(int data) {
        this.info = data;
        this.left = null;
        this.right = null;
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

    protected void printTree(Int_Tree_Node node, String indent, boolean last) {
        if (node == null) {
            return;
        }
        System.out.print(indent);
        if (last) {
            System.out.print("└── ");
            indent += "    ";
        } else {
            System.out.print("├── ");
            indent += "|   ";
        }
        System.out.println(node.info);
        printTree(node.left, indent, false);
        printTree(node.right, indent, true);
    }

    protected void preorder_traverse(Int_Tree_Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.info + "  ");
        preorder_traverse(node.left);
        preorder_traverse(node.right);
    }

    protected void inorder_traverse(Int_Tree_Node node) {
        if (node == null) {
            return;
        }
        inorder_traverse(node.left);
        System.out.print(node.info + "  ");
        inorder_traverse(node.right);
    }

    protected void postorder_traverse(Int_Tree_Node node) {
        if (node == null) {
            return;
        }
        postorder_traverse(node.left);
        postorder_traverse(node.right);
        System.out.print(node.info + "  ");
    }

    protected void converse_preorder_traverse(Int_Tree_Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.info + "  ");
        converse_preorder_traverse(node.right);
        converse_preorder_traverse(node.left);
    }

    protected void converse_inorder_traverse(Int_Tree_Node node) {
        if (node == null) {
            return;
        }
        converse_inorder_traverse(node.right);
        System.out.print(node.info + "  ");
        converse_inorder_traverse(node.left);
    }

    protected void converse_postorder_traverse(Int_Tree_Node node) {
        if (node == null) {
            return;
        }
        converse_postorder_traverse(node.right);
        converse_postorder_traverse(node.left);
        System.out.print(node.info + "  ");
    }
}