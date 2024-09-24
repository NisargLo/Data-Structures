/*
    Write a menu-driven program to implement Binary Search Tree (BST) & perform following operations
    Insert a node, Delete a node, Search a node
 */

import java.util.Scanner;

public class Lab_77 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int num;
        Int_Binary_Search_Tree bst=new Int_Binary_Search_Tree();
        while (choice != -1) {
            System.out.println("\nEnter 1 for insert():");
            System.out.println("Enter 2 for update():");
            System.out.println("Enter 3 for delete():");
            System.out.println("Enter 4 for deleteEntireTree():");
            System.out.println("Enter 5 for search():");
            System.out.println("Enter 6 for display():");
            System.out.println("Enter 7 for isEmpty():");
            System.out.println("Enter -1 to exit:");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter Number :");
                    num = sc.nextInt();
                    bst.insert(num);
                }
                
                case 2 -> {
                    System.out.println("Enter Old Number :");
                    int oldNum = sc.nextInt();
                    System.out.println("Enter New Number :");
                    num = sc.nextInt();
                    bst.update(oldNum, num);
                }
                
                case 3 -> {
                    System.out.println("Enter Number :");
                    num = sc.nextInt();
                    bst.delete(num);
                }
                
                case 4 -> bst.deleteEntireTree();
                
                case 5 -> {
                    System.out.println("Enter Number :");
                    num = sc.nextInt();
                    if(bst.search(num)){
                        System.out.println(num + " found.");
                    }
                    else{
                        System.out.println(num + " not found.");
                    }
                }
                
                case 6 -> bst.display();
                
                case 7 -> System.out.println("Empty: "+bst.isEmpty());
                
                case -1 -> System.out.println("Program Over...");
                
                default -> System.out.println("Invalid");
            }
        }
    }
}

class Int_Binary_Search_Tree {
    Int_Tree_Node root;
    
    protected void insert(int data) {
        root = insertRecursive(root, data);
    }
    
    private static Int_Tree_Node insertRecursive(Int_Tree_Node node, int data) {
        if (node == null) {
            return new Int_Tree_Node(data);
        }
        if (data < node.info) {
            node.left = insertRecursive(node.left, data);
        }
        else if(data > node.info){
            node.right = insertRecursive(node.right, data);
        }
        else{
            System.out.println(data + " already exists.");
        }
        return node;
    }
    
    protected void update(int oldData, int newData) {
        if(search(oldData)) {
            System.out.println("Successfully updated.");
        }
        root = deleteRecursive(root, oldData);
        root = insertRecursive(root, newData);
    }

    protected boolean search(int data){
        return searchRecursive(root, data) != null;
    }
    
    private static Int_Tree_Node searchRecursive(Int_Tree_Node node, int data) {
        if(node==null || node.info==data){
            return node;
        }
        if(data>node.info){
            return searchRecursive(node.right, data);
        }
        else{
            return searchRecursive(node.left, data);
        }
    }
    
    protected void delete(int data) {
        if (!search(data)) {
            System.out.println(data + " not found.");
            return;
        }
        root = deleteRecursive(root, data);
        System.out.println("Successfully deleted.");
    }
    
    private static Int_Tree_Node deleteRecursive(Int_Tree_Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.info) {
            node.left = deleteRecursive(node.left, data);
        }
        else if(data > node.info){
            node.right = deleteRecursive(node.right, data);
        }
        else{
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            node.info=minValue(node.right);
            node.right=deleteRecursive(node.right, node.info);
        }
        return node;
    }
    
    private static int minValue(Int_Tree_Node node){
        int min=node.info;
        while(node.left!=null){
            node=node.left;
            min=node.info;
        }
        return min;
    }
    
    public void display() {
        if(isEmpty()){
            System.out.println("Empty Binary Search Tree.");
            return;
        }
        System.out.println("\nBinary Search Tree:-");
        displayRecursive(root, "", true);
    }
    
    private void displayRecursive(Int_Tree_Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.info); // ├── for left sub-tree, └── for right sub-tree
            displayRecursive(node.left, prefix + (isTail ? "    " : "│   "), false);
            displayRecursive(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }
    
    protected void deleteEntireTree() {
        this.root=null;
    }
    
    protected boolean isEmpty(){
        return this.root==null;
    }
}