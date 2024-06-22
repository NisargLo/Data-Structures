// Write a program to find factors of a given number.

import java.util.*;

public class Lab_07 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number :");
        int n=sc.nextInt();
        System.out.print("Factors : ");
        for(int i=1;i<=n;i++){
            if(n%i==0){
                if(i!=n){
                    System.out.print(i+", ");
                }
                else{
                    System.out.print(i);
                }
            }
        }
    }
}
