// Find middle Node in LinkedList with only 1 loop.

import java.util.Scanner;

public class Find_Middle_Node {
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
            Node middle=findMiddleNode(ill);
            assert middle != null;
            System.out.println("Middle Node Value - "+middle.info);
        }
        else{
            System.out.println("\nYou have not entered any numbers.");
        }
    }

    private static Node findMiddleNode(Int_LinkedList ill){
        if(ill.first==null){
            System.out.println("Empty LinkedList...");
            return null;
        }
        if(ill.first.link==null){
            System.out.println("Only 1 element...");
            return null;
        }
        Node pointer1=ill.first;
        Node pointer2=ill.first;

        // Using only 1 while loop...
        while(pointer2.link!=null){
            if(pointer2.link.link!=null){
                pointer1=pointer1.link;
                pointer2=pointer2.link.link;
            }
            else{
                break;
            }
        }

        return pointer1;
    }
}
