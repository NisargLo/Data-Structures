// Write a program for evaluation of prefix Expression using Stack.

import java.util.Scanner;

public class Lab_48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the prefix expression:");
        String prefix = sc.nextLine();
        sc.close();
        int result = evaluatePrefix(prefix);
        System.out.println("Result of evaluating prefix - " + result);
    }

    private static int evaluatePrefix(String prefix) {
        Int_Stack is = new Int_Stack(prefix.length());
        int value;
        for (int i = prefix.length()-1; i >= 0; i--) {
            char temp = prefix.charAt(i);
            if (Character.isDigit(temp)) {
                is.push(Integer.parseInt(temp + ""));
            } else {
                int operand_1 = is.pop();
                int operand_2 = is.pop();
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
