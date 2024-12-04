/*
    Write a menu driven program to implement Binary Search Tree (BST) & perform following operations 
    Insert a node, Delete a node, Search a node
 *//*


import java.util.*;

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int num, index;
        while (choice != -1) {
            System.out.println("\nEnter 1 for insertAtFirstPosition() :");
            System.out.println("Enter 2 for insertAtLastPosition() :");
            System.out.println("Enter 3 for insertAtOrder() :");
            System.out.println("Enter 4 for insertAtSpecificPosition() :");
            System.out.println("Enter -1 to exit :");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Number :");
                    num = sc.nextInt();
                }

                case 2 -> {
                    System.out.println("Enter Number :");
                    num = sc.nextInt();
                }

                case 3 -> {
                    System.out.println("Enter Number :");
                    num = sc.nextInt();
                }

                case 4 -> {
                    System.out.println("Enter Index :");
                    index = sc.nextInt();
                    System.out.println("Enter Number :");
                    num = sc.nextInt();
                }

                case -1 -> System.out.println("Program Over...");

                default -> System.out.println("Invalid");
            }
        }

    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int data) {
        this.data = data;
    }
}

class BinarySearchTree {
    TreeNode root;

    protected void insertIterative(int data) {
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while (true) {
            parent = current;
            if (data < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    
    protected void display(int data) {

    }
}*/
