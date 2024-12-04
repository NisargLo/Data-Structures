// Write a program for evaluation of postfix Expression using Stack.

import java.util.Scanner;

public class Lab_47 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter the postfix expression:");
          String postfix = sc.nextLine();
          sc.close();
          int result = evaluatePostfix(postfix);
          System.out.println("Result of evaluating postfix - " + result);
     }

     private static int evaluatePostfix(String postfix) {
          Int_Stack is = new Int_Stack(postfix.length());
          int value;
          for (int i = 0; i < postfix.length(); i++) {
               char temp = postfix.charAt(i);
               if (Character.isDigit(temp)) {
                    is.push(Integer.parseInt(temp + ""));
               } else {
                    int operand_2 = is.pop();
                    int operand_1 = is.pop();
                    value = performOperation(operand_1, operand_2, temp);
                    is.push(value);
               }
          }
          return is.pop();
     }

     private static int performOperation(int operand_1, int operand_2, char temp) {
         return switch (temp) {
             case '+' -> operand_1 + operand_2;
             case '-' -> operand_1 - operand_2;
             case '*' -> operand_1 * operand_2;
             case '/' -> operand_1 / operand_2;
             case '^' -> (int) Math.pow(operand_1, operand_2);
             default -> 0;
         };
     }
}