// Write a program to delete a number from an array that is already sorted in an ascending order.

import java.util.*;

public class Lab_24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=sc.nextInt(),i,j;
        int getIndex=0;
        int[] a=new int[n];
        int[] b=new int[n-1];
        for (i=0;i<n;i++) {
            System.out.println("Enter element " + (i+1) + ":");
            a[i]=sc.nextInt();
        }

        // In case if user doesn't provide values in ascending order :-
        Arrays.sort(a);

        System.out.println("Enter number to delete :");
        int no_to_delete = sc.nextInt();
        for(i=0;i<a.length;i++){
            if(no_to_delete<=a[i]){
                getIndex=i;
                break;
            }
        }
        for (i = 0, j = 0; i < a.length; i++) {
            if (i != getIndex) {
                b[j++] = a[i];
            }
        }
        System.out.println("Array before deletion: "+Arrays.toString(a));
        System.out.println("Array after deletion: "+Arrays.toString(b));
    }
}
