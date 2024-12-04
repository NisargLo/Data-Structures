// Remove Kth node from end in single linkedlist.

import java.util.Scanner;

public class Remove_Kth_Node_From_End {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Int_LinkedList ill=new Int_LinkedList();
        System.out.println("Enter -1 to exit :");
        int n;
        while(true){
            System.out.println("Enter No :");
            n=sc.nextInt();
            if(n==-1){
                break;
            }
            ill.insertAtLastPosition(n);
        }
        System.out.println("Enter K:");
        int k=sc.nextInt();
        if(ill.first!=null){
            swap_Kth_nodes(ill,k);
            System.out.print("Updated ");
            ill.displayLinkedList();
        }
        else{
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static void swap_Kth_nodes(Int_LinkedList ill, int k) {
        if (k <= 0) {
            System.out.println("Invalid value of K.");
            return;
        }

        Node current = ill.first;
        int length = 1;
        while (current != null) {
            length++;
            current = current.link;
        }
        --length;
        if(k>length){
            System.out.println("Invalid value of K.");
            return;
        }

        ill.deleteFromSpecificPosition(length-k+1);
    }
}
