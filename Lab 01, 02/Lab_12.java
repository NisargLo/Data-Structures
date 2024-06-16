// WAP to print Armstrong number from 1 to n.

import java.util.*;

public class Lab_12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=new String("");
        System.out.println("Enter number :");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            int temp=i,c=0,r,ans=0;
            while(i!=0){
                i/=10;
                c++;
            }
            i=temp;
            while(i!=0){
                r=i%10;
                i/=10;
                ans+=(int)Math.pow(r, c);
            }
            i=temp;
            if(ans==i){
                str+=ans+", ";
            }
        }
        str=str.substring(0, str.length()-2);
        System.out.println("Armstrong number from 1 to "+n+" are "+str);
    }
}
