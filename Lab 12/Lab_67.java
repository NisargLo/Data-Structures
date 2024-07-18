/*
    WAP to perform given operation in the linked list.
    There exist a Linked List.
    Add a node that contains the GCD of that two nodes between every pair adjacent node of LinkedList.
    Input:
        [18, 6, 10, 3]
    Output:
        [18, 10, 6, 6, 2, 1, 3]
 */

import java.util.Scanner;

public class Lab_67 {
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
        if(ill.first!=null){
            insert_GCD_between_2_nodes(ill);
            System.out.print("Resultant ");
            ill.displayLinkedList();
        }
        else{
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static void insert_GCD_between_2_nodes(Int_LinkedList ill){
        Node current=ill.first;
        Node next;
        while(current.link!=null){
            next=current.link;
            int gcd=get_GCD(current.info,next.info);
            Node temp=new Node(gcd);
            current.link=temp;
            temp.link=next;
            current=next;
        }
    }

    private static int get_GCD(int a, int b){
        if (b == 0) {
            return a;
        }
        return get_GCD(b, a % b);
    }
}
