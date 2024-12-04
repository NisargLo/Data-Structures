/*
    Create a class BankAccount with attributes like account number, balance, account holder and name.
    Create an array of BankAccount objects to store bank accounts.
    Implement methods to deposit money, withdraw money and check balance.
 */

import java.util.Scanner;

public class Lab_37 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many bank accounts are there ?");
        int n=sc.nextInt();
        BankAccount[] ba=new BankAccount[n];
        for(int i=0;i<ba.length;i++){
            ba[i]=new BankAccount();
            System.out.println("\nBank Account "+(i+1)+" :");
            System.out.println("Enter Account No. :");
            ba[i].account_no=sc.next();
            sc.nextLine();
            System.out.println("Enter Name :");
            ba[i].name=sc.nextLine();
            System.out.println("Enter Account Holder :");
            ba[i].account_holder=sc.nextLine();
            System.out.println("Enter Balance :");
            ba[i].balance=sc.nextDouble();
            System.out.println("Do you want to deposit or withdraw money?");
            String s=sc.next();
            if(s.trim().equalsIgnoreCase("Deposit")){
                ba[i].deposit_Money();
                ba[i].invalid=false;
            }
            else if(s.trim().equalsIgnoreCase("Withdraw")){
                ba[i].withdraw_Money();
                ba[i].invalid=false;
            }
            else{
                System.out.println("Invalid");
                ba[i].invalid=true;
            }
        }
        for(int i=0;i<ba.length;i++){
            System.out.println("\nBank Account "+(i+1)+" :");
            System.out.println("Account No - "+ba[i].account_no);
            System.out.println("Name - "+ba[i].name);
            System.out.println("Account Holder - "+ba[i].account_holder);
            if(ba[i].unsuccessfull_withdraw){
                System.out.println("Balance (Not Updated) - "+ba[i].balance+" Rs.");
            }
            else if(ba[i].invalid){
                System.out.println("Balance (Not Updated) - "+ba[i].balance+" Rs.");
            }
            else{
                System.out.println("Updated balance - "+ba[i].balance+" Rs.");
            }
        }
    }
}

class BankAccount{
    String account_no;
    double balance;
    String account_holder;
    String name;
    boolean invalid,unsuccessfull_withdraw;

    protected void deposit_Money(){
        Scanner sc=new Scanner(System.in);
        System.out.println("How much money do you want to deposit?\nYour balance - "+balance+" Rs.");
        double d=sc.nextDouble();
        balance += d;
    }

    protected void withdraw_Money() {
        Scanner sc=new Scanner(System.in);
        System.out.println("How much money do you want to withdraw?\nYour balance - "+balance+" Rs.");
        double w=sc.nextDouble();
        if(w<=balance){
            balance -= w;
        }
        else{
            this.unsuccessfull_withdraw=true;
            try {
                throw new Bank_Balance_Exception("Insufficient Balance...");
            }
            catch (Bank_Balance_Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class Bank_Balance_Exception extends Exception{
    Bank_Balance_Exception(String msg){
        super(msg);
    }
}