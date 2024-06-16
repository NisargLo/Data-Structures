// Write a program to find whether the array contains a duplicate number or not.
// Note : This program can find and print if there is 1 duplicate element, not more than 1.

import java.util.Scanner;

public class Lab_17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many numbers will you enter :");
        int n=sc.nextInt(),i,j,temp,flag=1;
        String str=new String("");
        int[] a=new int[n];
        for(i=0;i<n;i++){
            System.out.println("Enter element "+(i+1));
            a[i]=sc.nextInt();
        }
        for(i=0;i<n;i++){
            temp=a[i];
            for(j=i+1;j<n;j++){
                if(a[j]==temp && j!=i){
                    str += a[j]+", ";
                    flag=0;
                }
            }
        }
        if(flag==1){
            System.out.println("No Duplicate Elements");
        }
        else{
            str = str.substring(0, str.length()-2);
            System.out.print("Duplicate Elements : "+str);
        }
    }
}
