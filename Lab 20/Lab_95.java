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
    private static int[] a=null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        if(n==0){
            System.out.println("Empty Array...");
            return;
        }
        a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            a[i] = sc.nextInt();
        }
        System.out.println("Array before Radix Sort: " + Arrays.toString(a));
        radix_Sort(a.length);
        System.out.println("Array after Radix Sort: " + Arrays.toString(a));
    }

    private static void radix_Sort(int l){
        int max = get_max_element(l);
        for(int exp=1;max/exp>0;exp*=10){
            a=counting_Sort(exp);
        }
    }

    private static int get_max_element(int l){
        int max = a[0];
        for(int i=1;i<l;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        return max;
    }

    private static int[] counting_Sort(int exp) {
        int l=a.length;

        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(int i=0;i<l;i++){
            int index=(a[i]/exp)%10;
            count[index]++;
        }

        for (int i=0;i<9;i++) {
            count[i+1]+=count[i];
        }

        int[] b=new int[l];
        for (int i=l-1;i>=0;i--) {
            int index = (a[i] / exp) % 10;
            b[count[index]-1]=a[i];
            count[index]--;
        }
        return b;
    }
}