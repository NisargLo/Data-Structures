/*
     Create methods to convert temperature from Celsius to Fahrenheit and vice versa. 
     Take temperature input from user and call the appropriate conversion method.
 */

import java.util.*;

public class Lab_36 {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          Temperature t=new Temperature();
          System.out.println("Celsius or Fahrenheit?");
          String s=sc.next();
          if(s.equalsIgnoreCase("Celsius")){
               System.out.println("Enter Celsius :");
               float c=sc.nextFloat();
               float f=t.convertToFahrenheit(c);
               System.out.println("Fahrenheit = "+f);
          }
          else if(s.equalsIgnoreCase("Fahrenheit")){
               System.out.println("Enter Fahrenheit :");
               float f=sc.nextFloat();
               float c=t.convertToCelsius(f);
               System.out.println("Celsius = "+c);
          }
          else{
               System.out.println("Invalid");
          }
     }
}

class Temperature{
     protected float convertToFahrenheit(float c){
          return 9f/5*c+32;
     }

     protected float convertToCelsius(float f){
          return (f-32)*5/9;
     }
}