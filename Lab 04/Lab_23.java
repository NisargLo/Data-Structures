// Write a program to insert a number in an array that is already sorted in an ascending order.

import java.util.*;

public class Lab_23 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=sc.nextInt(),i,j;
        int getIndex=0;
        int[] a=new int[n];
        int[] b=new int[n+1];
        for (i=0;i<a.length;i++) {
            System.out.println("Enter element " + (i+1) + ":");
            a[i]=sc.nextInt();
        }

        // In case if user doesn't provide values in ascending order :-
        Arrays.sort(a);

        System.out.println("Enter number to insert :");
        int no_to_insert = sc.nextInt();
        for(i=0;i<a.length;i++){
            if(no_to_insert<=a[i]){
                getIndex=i;
                break;
            }
            else{
                getIndex=i+1;
            }
        }
        for (i = 0, j = 0; i < b.length; i++, j++) {
            if (getIndex == i) {
                b[i] = no_to_insert;
                j--;
            } else {
                b[i] = a[j];
            }
        }
        System.out.println("Array before insertion: "+Arrays.toString(a));
        System.out.println("Array after insertion: "+Arrays.toString(b));
    }
}