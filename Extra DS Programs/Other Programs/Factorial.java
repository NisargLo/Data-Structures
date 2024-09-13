// Factorial using Recursion (Stack)

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number: ");
        int n=sc.nextInt();
        Stack_Using_LinkedList stack=new Stack_Using_LinkedList();
        long ans=recursionUsingStack(n,stack);
        System.out.println(n+"! = "+ans);
    }

    private static long recursionUsingStack(int n, Stack_Using_LinkedList stack){
        stack.push(n);
        if(n==1){
            long ans=1;
            while (stack.isEmpty()){
                ans*=stack.pop();
            }
            return ans;
        }
        long ans=recursionUsingStack(n-1,stack);
        return n*ans;
    }
}
