/*
     Create array of object of class Student_Detail with attributes Enrollment_No,
     Name, Semester, CPI for 5 students, scan their information and print it.
 */

import java.util.*;

public class Lab_35 {
     public static void main(String[] args) {
          Student_Detail[] sd=new Student_Detail[5];
          byte i;
          for (i=0;i<sd.length;i++) {
               sd[i]=new Student_Detail();
               sd[i].read_Student((byte)(i+1));
          }
          for (i=0;i<sd.length;i++) {
               sd[i].write_Student((byte)(i+1));
           }
     }
}

class Student_Detail{
     long enrollment_no;
     String name;
     byte semester;
     float spi;

     protected void read_Student(byte i){
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter Student "+i+" Enrollment No :");
          enrollment_no=sc.nextLong();
          sc.nextLine();
          System.out.println("Enter Student "+i+" Name :");
          name=sc.nextLine();
          System.out.println("Enter Student "+i+" Semester :");
          semester=sc.nextByte();
          System.out.println("Enter Student "+i+" SPI :");
          spi=sc.nextFloat();
     }

     protected void write_Student(byte i){
          System.out.println("Student "+i+" Enrollment No - "+enrollment_no);
          System.out.println("Student "+i+" Name - "+name);
          System.out.println("Student "+i+" Semester - "+semester);
          System.out.println("Student "+i+" SPI - "+spi);
     }
}