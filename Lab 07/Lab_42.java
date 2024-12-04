/*
    Solve : https://www.codechef.com/problems/SUDBOOKS

    Sudhanshu is maintaining a library of books, each uniquely identified by an integer ID.
    He wants to keep track of the books that are borrowed and returned over a period of time.
    Given a sequence of operations where each operation can be either borrowing a book or returning a book, you need to determine the number of books currently borrowed at the end of the sequence.

    Input:
        The first line contains an integer N, the number of operations.
        Each of the next N lines contains an operation in the format:
        "B x" indicating a book with ID x is borrowed.
        "R x" indicating a book with ID x is returned.

    Output:
        Output a single integer, the number of books currently borrowed after all operations have been processed.

    Constraints:
        1 ≤ 𝑁 ≤ 100,000
        1 ≤ x ≤ 10^6

    Example:
        Input:
            6
            B 101
            B 102
            R 101
            B 103
            B 101
            R 102
        Output:
            2

    Explanation:
        After the sequence of operations:
            Book 101 is borrowed and then returned, so it is not currently borrowed.
            Book 102 is borrowed and then returned, so it is not currently borrowed.
            Book 103 is borrowed and not returned, so it is currently borrowed.
        Therefore, there are 2 books currently borrowed.
 */

import java.util.*;

public class Lab_42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Set<Integer> borrowedBooks = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String operation = sc.next();
            int bookId = sc.nextInt();
            if (operation.equals("B")) {
                borrowedBooks.add(bookId);
            } else if (operation.equals("R")) {
                borrowedBooks.remove(bookId);
            }
        }
        sc.close();
        System.out.println(borrowedBooks.size());
    }
}