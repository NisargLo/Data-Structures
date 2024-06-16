/*
    WAP to convert seconds into hours, minutes & seconds and print in HH:MM:SS
    [e.g. 10000 seconds mean 2:46:40 (2 Hours, 46 Minutes, 40 Seconds)].
*/

import java.util.*;

public class Lab_09 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Seconds :");
        int s=sc.nextInt(),m=0,h=0;
        while(s>=60){
            m++;
            s-=60;
            if(m>=60){
                h++;
                m-=60;
            }
        }
        System.out.println("HH:MM:SS = "+h+":"+m+":"+s);
    }
}
