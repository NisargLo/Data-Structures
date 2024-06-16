// WAP to print Pascal triangle.

import java.util.Scanner;

public class Lab_19 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of rows :");
        int rows = sc.nextInt();
        for (int i=0;i<rows;i++) {
            for(int j=rows;j>=i;j--){
                System.out.print("  ");
            }
            for (int k=0;k<=i;k++) {
                System.out.printf("%4d",calculateCombination(i,k));
            }
            System.out.println();
        }
    }

    private static int calculateCombination(int n, int r) {
        return factorial(n)/(factorial(r)*factorial(n-r));
    }

    private static int factorial(int n) {
        int m=1;
        for(int i=n;i>=1;i--){
            m*=i;
        }
        return m;
    }
}