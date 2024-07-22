//WAP to split a circular linked list into two halves.

import java.util.Scanner;

public class Lab_74 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Int_Circular_LinkedList icl = new Int_Circular_LinkedList();
        System.out.println("Enter -1 to exit :");
        int n;
        while (true) {
            System.out.println("Enter No :");
            n = sc.nextInt();
            if (n == -1) {
                break;
            }
            icl.insertAtLastPosition(n);
        }
        if (icl.first != null) {
            splitLinkedListInto2Halves(icl);
            System.out.print("Resultant ");
            icl.displayCircularLinkedList();
        } else {
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static void splitLinkedListInto2Halves(Int_Circular_LinkedList icl){
        if(icl.first==null){
            return;
        }
        int i=1;
        Node current=icl.first;
        while(current.link!=icl.first){
            
        }
    }
}
