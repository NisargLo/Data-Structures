/*
    Write a menu driven program to implement Binary Search Tree (BST) & perform following operations 
    Insert a node, Delete a node, Search a node
 */

import java.util.*;

public class BST_Recursive {
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

class IntTreeNode {
    IntTreeNode left;
    IntTreeNode right;
    int data;

    IntTreeNode(int data) {
        this.data = data;
    }
}

class BinarySearchTree_1 {
    private IntTreeNode root;

    protected void insert(int newData) {
        root = insertRecursive(root, newData);
    }

    private static IntTreeNode insertRecursive(IntTreeNode node, int newData) {
        if (node == null) {
            return new IntTreeNode(newData);
        }
        if (newData < node.data) {
            node.left = insertRecursive(node.left, newData);
        }
        else {
            node.right = insertRecursive(node.right, newData);
        }
        return node;
    }
    
//    protected void search(int data) {
//        int searchLevel = 0;
//        boolean isFound = searchRecord(root, data, searchLevel);
//        if(!isfound){
//
//        }
//    }

}