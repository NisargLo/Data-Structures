// WAP to replace lowercase characters by uppercase & vice-versa in a user specified string.

import java.util.*;

public class Lab_27 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String res=new String("");
        System.out.println("Enter string :");
        String s=sc.nextLine();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                 res+=(s.charAt(i)+"").toUpperCase();
            }
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                res+=(s.charAt(i)+"").toLowerCase();
            }
            else{
                res+=s.charAt(i);
            }
        }
        System.out.println("Resultant String : "+res);
    }
}
