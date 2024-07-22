//WAP to delete alternate nodes of a doubly linked list.

import java.util.Scanner;

public class Lab_73 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          Int_Doubly_LinkedList idl = new Int_Doubly_LinkedList();
          System.out.println("Enter -1 to exit :");
          int n;
          while (true) {
               System.out.println("Enter No :");
               n = sc.nextInt();
               if (n == -1) {
                    break;
               }
               idl.insertAtLastPosition(n);
          }
          if (idl.first != null) {
               deleteAlternateNodes(idl);
               System.out.print("Resultant ");
               idl.display_firstTolast_DoublyLinkedList();
               System.out.print("Resultant ");
               idl.display_lastTofirst_DoublyLinkedList();
          } 
          else {
               System.out.println("\nYou have not entered any numbers.");
          }
     }

     private static void deleteAlternateNodes(Int_Doubly_LinkedList idl) {
          if (idl.first == null || idl.first.next == null) {
               return;
          }
          Doubly_Node current = idl.first;
          while (current.next != null) {
               if (current.next.next != null) {
                    current.next = current.next.next;
                    current.next.previous = current;
                    if (current.next == idl.last) {
                         idl.last = current;
                    }
               }
               current = current.next;
               if (current.next == idl.last) {
                    idl.last = idl.last.previous;
                    idl.last.next = null;
               }
          }
     }
}