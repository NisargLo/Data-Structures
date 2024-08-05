/*
     Implement Priority Queue using an array that performs the following operations:
     INSERT, DELETE, DISPLAY
 */

import java.util.Scanner;

public class Lab_53 {
     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter size of Queue :");
          int size = sc.nextInt();
          Int_Priority_Queue pq = new Int_Priority_Queue(size);
          int choice = 0;
          while (choice != -1) {
               System.out.println("\nEnter 1 for enqueue() :");
               System.out.println("Enter 2 for dequeue() :");
               System.out.println("Enter 3 for display() :");
               System.out.println("Enter 4 for makeQueueEmpty() :");
               System.out.println("Enter 5 for isEmpty() :");
               System.out.println("Enter -1 to exit :");
               choice = sc.nextInt();
               switch (choice) {
                    case 1 -> {
                         System.out.println("Enter Number :");
                         int num = sc.nextInt();
                         System.out.println("Enter Priority :");
                         int priority = sc.nextInt();
                         pq.enqueue(num, priority);
                    }

                    case 2 -> System.out.println("dequeue() - " + pq.dequeue());

                    case 3 -> pq.display();

                    case 4 -> pq.makeQueueEmpty();

                    case 5 -> System.out.println(pq.isEmpty());

                    default -> System.out.println("Program Over...");
               }
          }
     }
}

class Int_Priority_Queue {
     private int[/*value*/][/*priority*/] queue;
     private int size;
     private final int capacity;

     public Int_Priority_Queue(int capacity) {
          this.capacity = capacity;
          this.queue = new int[capacity][2];
          this.size = 0;
     }

     public void enqueue(int value, int priority) {
          if (size == capacity) {
               System.out.println("Queue Overflow...");
               return;
          }
          int i;
          for (i = size - 1; i >= 0; i--) {
               if (priority > queue[i][1]) {
                    queue[i + 1] = queue[i];
               } else {
                    break;
               }
          }
          queue[i + 1] = new int[]{value, priority};
          size++;
     }

     public int dequeue() {
          if (size == 0) {
               System.out.println("Empty Queue...");
               return Integer.MIN_VALUE;
          }
          int highestPriorityElement = queue[0][0];
          System.arraycopy(queue, 1, queue, 0, size-1);
          size--;
          return highestPriorityElement;
     }

     public void display() {
          if (size == 0) {
               System.out.println("Empty Queue...");
               return;
          }
          System.out.print("Queue: [");
          for (int i = 0; i < size-1; i++) {
               System.out.print(queue[i][0]+" ("+queue[i][1]+"), ");
          }
          System.out.println(queue[size-1][0]+" ("+queue[size-1][1]+")]");
     }

     public void makeQueueEmpty() {
          size = 0;
          queue=null;
     }

     public boolean isEmpty() {
          return size == 0;
     }
}