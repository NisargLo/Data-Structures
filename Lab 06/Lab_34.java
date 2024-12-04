/*
     Create class Employee_Detail with attributes Employee_ID, Name, Designation, and Salary. 
     Write a program to read the detail from user and print it. 
 */

import java.util.Scanner;

public class Lab_34 {
     public static void main(String[] args) {
          Employee_Detail ed=new Employee_Detail();
          ed.read_Employee();
          ed.write_Employee();
     }
}

class Employee_Detail{
     long employee_id;
     String name;
     String designation;
     double salary;

     protected void read_Employee(){
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter Employee Id :");
          employee_id=sc.nextLong();
          sc.nextLine();
          System.out.println("Enter Name :");
          name=sc.nextLine();
          System.out.println("Enter Designation :");
          designation=sc.nextLine();
          System.out.println("Enter Salary :");
          salary=sc.nextDouble();
     }

     protected void write_Employee(){
          System.out.println("\nEmployee ID - "+employee_id);
          System.out.println("Name - "+name);
          System.out.println("Designation - "+designation);
          System.out.println("Salary - "+salary);
     }
}