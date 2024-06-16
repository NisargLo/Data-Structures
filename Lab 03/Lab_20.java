// WAP to sort the N names in alphabetical order.

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Lab_20 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many names will you enter :");
        int n=sc.nextInt(),i;
        String[] s=new String[n];
        byte[] a=new byte[n];
        for(i=0;i<n;i++){
            System.out.println("Enter name "+(i+1));
            s[i]=sc.next().trim();
        }
        for(i=0;i<n;i++){
            if(s[i].charAt(0)>='A' && s[i].charAt(0)<='Z'){
                s[i]=s[i].toLowerCase();
                a[i]=1;
            }
            else{
                a[i]=0;
            }
        }
        Arrays.sort(s);
        for(i=0;i<n;i++){
            if(a[i]==1){
                s[i]=s[i].toUpperCase();
            }
        }
        System.out.print("Alphabetical Order : ");
        for(i=0;i<n-1;i++){
            System.out.print(s[i]+", ");
        }
        System.out.print(s[s.length-1]);
    }
}
