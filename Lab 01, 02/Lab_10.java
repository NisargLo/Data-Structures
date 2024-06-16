// WAP to convert number of days into year, week & days [e.g. 375 days mean 1 year, 1 week and 3 days].

import java.util.*;

public class Lab_10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter days :");
        int d1=sc.nextInt(),w,y,d2;
        y = d1/365;
        w = (d1%365)/7;
        d2 = (d1%365)%7;
        System.out.println(d1+" days mean "+y+" year, "+w+" week and "+d2+" days.");
    }
}
