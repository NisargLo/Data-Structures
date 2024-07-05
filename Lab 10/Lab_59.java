/*
    WAP to check whether 2 singly linked lists are same or not.

    class Linked_List is used from Lab_57
 */

import java.util.Scanner;

public class Lab_59 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Linked_List[] list=new Linked_List[2];
        for(int i=0;i<list.length;i++) {
            list[i] = new Linked_List();
            System.out.println("\nLinkedList "+(i+1)+" :-\nEnter -1 to exit :");
            int n;
            while (true) {
                System.out.println("Enter No :");
                n = sc.nextInt();
                if (n == -1) {
                    break;
                }
                list[i].insertAtLastPosition(n);
            }
            list[i].displayLinkedList();
        }
        boolean isEqual = compareLinkedList(list[0], list[1]);
        if (isEqual) {
            System.out.println("\nThe two linked lists are equal.");
        } else {
            System.out.println("\nThe two linked lists are not equal.");
        }
    }

    private static boolean compareLinkedList(Linked_List list1, Linked_List list2) {
        Node current1 = list1.first;
        Node current2 = list2.first;
        while (current1 != null && current2 != null) {
            if (current1.info != current2.info) {
                return false;
            }
            current1 = current1.link;
            current2 = current2.link;
        }
        return (current1==null && current2==null);
    }
}