/*
    Suppose you are senior developer for an Relational Database Management System
    named "Array Database" where everything is implemented using only array, today
    your task is to implement aggregate function like sum, min, max, avg.
    For simplicity, assume that your database can only store integers.
 */

import java.util.*;

public class Lab_28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any of these Operations ('Sum', 'Min', 'Max', 'Avg') :");
        String s= sc.nextLine();
        boolean b_sum=false, b_min=false, b_max=false, b_avg=false;
        System.out.println("How many numbers will you enter :");
        int n = sc.nextInt(), i;
        int[] a = new int[n];
        for (i = 0; i < a.length; i++) {
            System.out.println("Enter element " + (i + 1) + " :");
            a[i] = sc.nextInt();
        }
        for(i=0;i<s.length();i++){
            if(s.toLowerCase().contains("sum") && !b_sum){
                int sum=Sum(a);
                System.out.println("Sum = "+sum);
                b_sum=true;
            }
            if(s.toLowerCase().contains("min") && !b_min){
                int min=Min(a);
                System.out.println("Min = "+min);
                b_min=true;
            }
            if(s.toLowerCase().contains("max") && !b_max){
                int max=Max(a);
                System.out.println("Max = "+max);
                 b_max=true;
            }
            if(s.toLowerCase().contains("avg") && !b_avg){
                int avg=Avg(a);
                System.out.println("Avg = "+avg);
                b_avg=true;
            }
        }
    }

    private static int Sum(int[] a){
        int total=0;
        for(int num : a){
            total+=num;
        }
        return total;
    }

    private static int Min(int[] a){
        int min=a[0];
        for(int num : a){
            min=Math.min(min,num);
        }
        return min;
    }

    private static int Max(int[] a){
        int max=a[0];
        for(int num : a){
            max=Math.max(max,num);
        }
        return max;
    }

    private static int Avg(int[] a){
        int avg=0;
        for(int num : a){
            avg+=num;
        }
        avg/=a.length;
        return avg;
    }
}
