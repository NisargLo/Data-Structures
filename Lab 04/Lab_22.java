import java.util.*;

public class Lab_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            System.out.println("Enter element "+(i+1)+" :");
            a[i] = sc.nextInt();
        }
        System.out.println("Enter index at which number is to be deleted :");
        int getIndex = sc.nextInt();  
        if (getIndex < 0 || getIndex >= a.length) {
            System.out.println("Invalid index.\nProgram will exit.");
            System.exit(0);
        }
        int[] b = new int[n - 1];
        for (int i = 0, j = 0; i < a.length; i++) {
            if (i != getIndex) {
                b[j++] = a[i];
            }
        }
        System.out.println("Array before deletion: "+Arrays.toString(a));
        System.out.println("Array after deletion: "+Arrays.toString(b));
    }
}
