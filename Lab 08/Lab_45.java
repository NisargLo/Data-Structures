// Write a program to convert infix notation to postfix notation using stack.

import java.util.*;

class Lab_45 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter Infix :");
          String infix = sc.nextLine();
          String postfix = reversePolish(infix);
          if(postfix!=null){
               System.out.println("Postfix : "+postfix);
          }
     }

     private static String reversePolish(String infix){
          infix += ")";
          Char_Stack cs = new Char_Stack(infix.length());
          byte rank = 0;
          cs.push('(');
          String polish = "";
          for (int i=0;i<infix.length();i++) {
               if (cs.isEmpty()) {
                    System.out.println("Invalid Infix.");
                    return null;
               }
               char next = infix.charAt(i);
               while (stackPrecedenceFunction(cs.peep(1))>inputPrecedenceFunction(next)) {
                    char temp = cs.pop();
                    polish += temp;
                    rank += rankFunction(temp);
                    if(rank<1){
                         System.out.println("Invalid Infix..");
                         return null;
                    }
               }
               if(stackPrecedenceFunction(cs.peep(1))!=inputPrecedenceFunction(next)){
                    cs.push(next);
               }
               else{
                    cs.pop();
               }
          }
          if(rank!=1){
               System.out.println("Invalid Infix..");
               return null;
          }
          return polish;
     }

     private static byte inputPrecedenceFunction(char c) {
          if (c == '+' || c == '-') {
               return 1;
          } else if (c == '*' || c == '/') {
               return 3;
          } else if (c == '^') {
               return 6;
          } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
               return 7;
          } else if (c == '(') {
               return 9;
          } else if (c == ')') {
               return 0;
          }
          return 0;
     }

     private static byte stackPrecedenceFunction(char c) {
          if (c == '+' || c == '-') {
               return 2;
          } else if (c == '*' || c == '/') {
               return 4;
          } else if (c == '^') {
               return 5;
          } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
               return 8;
          } else if (c == '(') {
               return 0;
          }
          return 0;
     }

     private static byte rankFunction(char c) {
          String s = "+-*/^";
          if (s.contains(c + "")) {
               return -1;
          } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
               return 1;
          }
          return 0;
     }
}
