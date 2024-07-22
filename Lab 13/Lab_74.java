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
        Int_Circular_LinkedList icl1=new Int_Circular_LinkedList();
        Int_Circular_LinkedList icl2=new Int_Circular_LinkedList();
        if (icl.first != null) {
            splitLinkedListInto2Halves(icl,icl1,icl2);
            System.out.print("1 ");
            icl1.displayCircularLinkedList();
            System.out.print("2 ");
            icl2.displayCircularLinkedList();
        }
        else {
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static void splitLinkedListInto2Halves(Int_Circular_LinkedList icl, Int_Circular_LinkedList icl1, Int_Circular_LinkedList icl2){
        if(icl.first==null){
            return;
        }
        int c=1;
        Node current=icl.first;
        while(current.link!=icl.first){
            current=current.link;
            c++;
        }
        current=icl.first;
        int i=1;
        while(i<=c/2){
              icl1.insertAtLastPosition(current.info);
              current=current.link;
              i++;
        }
        while(current!=icl.first){
            icl2.insertAtLastPosition(current.info);
            current=current.link;
        }
    }
}
