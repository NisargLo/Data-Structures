// Read two 2x2 matrices and perform addition of matrices into third matrix and print it

import java.util.Scanner;

public class Lab_30{
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int[][] a=new int[2][2];
          int[][] b=new int[2][2];
          int[][] c=new int[2][2];
          int i,j;
          for(i=0;i<a.length;i++){
               for(j=0;j<a[i].length;j++){
                    System.out.println("Enter a["+(i+1)+"]["+(j+1)+"] :");
                    a[i][j]=sc.nextInt();
               }
          }
          for(i=0;i<b.length;i++){
               for(j=0;j<b[i].length;j++){
                    System.out.println("Enter b["+(i+1)+"]["+(j+1)+"] :");
                    b[i][j]=sc.nextInt();
                    c[i][j] = a[i][j] + b[i][j];
               }
          }
          System.out.println("\nMatrix Sum :-");
          for(i=0;i<c.length;i++){
               for(j=0;j<c[i].length;j++){
                    System.out.print(c[i][j]+"\t");
               }
               System.out.println();
          }
     }
}