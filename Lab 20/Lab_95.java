//Write a program to implement Radix Sort using Array.
/*
    Time Complexity:
    Best Case: (O(nk))
    Average Case: (O(nk))
    Worst Case: (O(nk))
    Description: Efficient for a large range of integers, stable.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Lab_95 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            a[i] = sc.nextInt();
        }
        System.out.println("Array before Radix Sort: " + Arrays.toString(a));
        radix_Sort(a, a.length);
        System.out.println("Array after Radix Sort: " + Arrays.toString(a));
    }

    private static void radix_Sort(int[] a, int l){

    }

    private static int[] counting_Sort(int[] a, int l) {
        if (a.length == 0) {
            return null;
        }

        int max = a[0], min = a[0];
        for (int num : a) {
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }

        int range=max-min+1;
        int[] count = new int[range];

        for(int i=0;i<count.length;i++){
            count[a[i]-min]++;
        }

        for (int i=0;i<count.length-1;i++) {
            count[i+1]+=count[i];
        }

        int[] b=new int[a.length];
        for (int i=a.length-1;i>=0;i--) {
            b[count[a[i]-min]-1]=a[i];
            count[a[i]-min]--;
        }
        return b;
    }
}
