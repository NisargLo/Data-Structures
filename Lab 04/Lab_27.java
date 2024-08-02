// WAP to replace lowercase characters by uppercase & vice-versa in a user specified string.

import java.util.*;

public class Lab_27 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder res= new StringBuilder();
        System.out.println("Enter string :");
        String s=sc.nextLine();
        System.out.println("String before replacing: "+s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                 res.append((s.charAt(i) + "").toUpperCase());
            }
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                res.append((s.charAt(i) + "").toLowerCase());
            }
            else{
                res.append(s.charAt(i));
            }
        }
        System.out.println("String after replacing: "+res);
    }
}
