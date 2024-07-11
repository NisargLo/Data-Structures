/*
    Write a program to determine if an input character string is of the form aibi where i >= 1 i.e.,
    Number of ‘a’ should be equal to number of ‘b’.
 */

import java.util.Scanner;

public class Lab_40 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String :");
        String str=sc.next();
        Char_Stack cs=new Char_Stack(str.length());
        for(int i=0;i<str.length();i++){
            if(str.toLowerCase().charAt(i)!='a' && str.toLowerCase().charAt(i)!='b'){
                System.out.println("Invalid String.");
                return;
            }
            else{
                cs.push(str.charAt(i));
            }
        }
        int a=0,b=0;
        while(!cs.isEmpty()){
            char c = cs.pop();
            if(c=='a' || c=='A'){
                a++;
            }
            else{
                b++;
            }
        }
        if(a==b){
            System.out.println("char 'A' == 'B'");
        }
        else{
            System.out.println("char 'A' != 'B'");
        }
    }
}
