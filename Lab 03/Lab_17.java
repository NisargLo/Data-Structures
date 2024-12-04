// Write a program to find whether the array contains a duplicate number or not.

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Lab_17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many numbers will you enter :");
        int n=sc.nextInt(), i;
        String str=new String("");
        int[] a=new int[n];
        for(i=0;i<a.length;i++){
            System.out.println("Enter element "+(i+1));
            a[i]=sc.nextInt();
        }
        // Create Set (Only stores unique elements)
        Set<Integer> uniqueSet = new HashSet<>();
        // Add all elements to set (duplicate won't get added)
        for (int num : a) {
            // return false if element is not added
            boolean is_added=uniqueSet.add(num);
            if(!is_added){
                str+=num+", ";
            }
        }
        str=str.substring(0, str.length()-2);
        System.out.println("Duplicate elements in Array : "+str);
    }
}