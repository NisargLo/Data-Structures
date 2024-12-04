// WAP to find the sum of 1 + (1+2) + (1+2+3) + (1+2+3+4) + … + (1+2+3+4+…+n).

import java.util.*;

public class Lab_11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number :");
        int n=sc.nextInt(),c_out=0,c_in;
        for(int i=1;i<=n;i++){
            c_in=0;
            for(int j=1;j<=i;j++){
                c_in += j;
            }
            c_out += c_in;
        }
        System.out.println("Sum of series = "+c_out);
    }
}
