// Write a program to implement queue using singly linked list.

import java.util.Scanner;

public class Lab_61 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          Queue_Using_LinkedList qul=new Queue_Using_LinkedList();
          String choice = "";
          while (!choice.equalsIgnoreCase("None")) {
               System.out.println("\nEnter Operation (add, remove, display, none) :");
               choice = sc.next();
               switch (choice) {
                    case "add":
                         System.out.println("Enter Number :");
                         int num1 = sc.nextInt();
                         qul.add(num1);
                         break;

                    case "remove":
                         qul.remove();
                         break;

                    case "display":
                         qul.display();
                         break;

                    case "none":
                         System.out.println("Program Over...");
                         break;

                    default:
                         System.out.println("Invalid");
               }
          }
     }
}

class Queue_Using_LinkedList{
     Node first=null;

     protected void add(int data){
          Node newNode=new Node(data);
          newNode.link=first;
          first=newNode;
     }

     protected void remove(){
          if(first==null){
               System.out.println("Empty Queue...");
               return;
          }
          first=first.link;
     }

     protected void display(){
          if(first==null){
               System.out.println("Empty Queue...");
               return;
          }
          Node current = first;
          String str="";
          System.out.print("Queue : [");
          while (current != null) {
               str += current.info+", ";
               current = current.link;
          }
          str=str.substring(0, str.length()-2);
          str += "]";
          System.out.println(str);
     }
}
