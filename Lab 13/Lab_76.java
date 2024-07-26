// Write a program to perform addition of two polynomial equations using appropriate data structure.

import java.util.Scanner;

public class Lab_76 {
    private static Int_LinkedList ill1;
    private static Int_LinkedList ill2;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter degree of polynomial 1:");
        byte d1=sc.nextByte();
        System.out.println("Enter degree of polynomial 2:");
        byte d2=sc.nextByte();
        int[] arr_d1 = new int[d1];
        int[] arr_d2 = new int[d2];

        System.out.println("\nPolynomial 1:-");
        for(byte i=d1;i>0;i--){
            System.out.println("Enter coefficient of X^"+i+":");
            arr_d1[d1-i]=sc.nextInt();
        }
        System.out.println("Add constant:");
        int const1=sc.nextInt();
        System.out.println("\nPolynomial 2:-");
        for(byte i=d2;i>0;i--){
            System.out.println("Enter coefficient of X^"+i+":");
            arr_d2[d2-i]=sc.nextInt();
        }
        System.out.println("Add constant:");
        int const2=sc.nextInt();

        store_Polynomials(const1,const2,arr_d1,arr_d2);
        add_2_Polynomials(d1,d2);
        display_Polynomial(d1,d2);
    }

    private static void store_Polynomials(int const1, int const2, int[] arr_d1, int[] arr_d2){
        ill1=new Int_LinkedList();
        ill2=new Int_LinkedList();

        for (int num : arr_d1) {
            ill1.insertAtLastPosition(num);
        }
        ill1.insertAtLastPosition(const1);
        for (int num : arr_d2) {
            ill2.insertAtLastPosition(num);
        }
        ill2.insertAtLastPosition(const2);
    }

    private static void add_2_Polynomials(byte d1, byte d2){
        if(d2>d1){
            byte temp=d2;
            d2=d1;
            d1=temp;

            Int_LinkedList tempList=ill2;
            ill2=ill1;
            ill1=tempList;
        }

        byte diff= (byte)(d1-d2);
        Node current1=ill1.first;
        Node current2=ill2.first;

        for(byte i=1;i<=diff;i++){
            current1=current1.link;
        }
        while(current1!=null){
            current1.info += current2.info;
            current1=current1.link;
            current2=current2.link;
        }
   }

   private static void display_Polynomial(byte d1, byte d2){
       if (ill1.first == null) {
           System.out.println("Empty Polynomial...");
           return;
       }

       Node current = ill1.first;
       System.out.print("\nResultant Polynomial = ");

       byte i;
       if(d1>d2){
           i=d1;
       }
       else{
           i=d2;
       }

       while (current.link != null) {
           System.out.print(current.info+"X^"+i+" + ");
           current = current.link;
           i--;
       }
       System.out.println(current.info);
   }
}