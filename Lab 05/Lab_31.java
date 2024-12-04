// Read two 2x2 matrices and perform addition of matrices into third matrix and print it

import java.util.Scanner;

public class Lab_31{
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int[][] a=new int[3][2];
          int[][] b=new int[2][3];
          int[][] c=new int[3][3];
          int i,j,k;
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
               }
          }
          for(i=0;i<3;i++){
               for(j=0;j<3;j++){
                    for(k=0;k<2;k++){
                        c[i][j]+=(a[i][k]*b[k][j]); 
                    }
               }
          }
          System.out.println("\nMatrix Multiplication :-");
          for(i=0;i<c.length;i++){
               for(j=0;j<c[i].length;j++){
                    System.out.print(c[i][j]+"\t");
               }
               System.out.println();
          }
     }
}