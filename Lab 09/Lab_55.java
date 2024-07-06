/*
    Solve - https://www.codechef.com/problems/CHFQUEUE

    CHFQUEUE

    Chef is managing a queue where each person has a specific priority.
    The queue is represented by an array where each element represents the priority of a person standing in the queue.
    Chef wants to count the number of subarrays where the minimum priority is greater than a given threshold K.

    Input:
        The first line contains two integers N (the number of people in the queue) and K (the threshold).
        The second line contains N integers where the ith integer represents the priority of the ith person in the queue.

    Output:
        Output a single integer which is the number of subarrays where the minimum priority is greater than K.

    Constraints:
        1 ≤ N ≤ 10^5
        1 ≤ K ≤ 10^9
        1 ≤ priority of each person ≤ 10^9

    Example:
        Input:
            5 3
            2 6 4 3 5
        Output:
            7

    Explanation:
        The subarrays where the minimum priority is greater than 3 are:
            [6]
            [6, 4]
            [6, 4, 3]
            [6, 4, 3, 5]
            [4]
            [4, 3]
            [4, 3, 5]
        There are 7 such subarrays in total.
 */

public class Lab_55 {
    public static void main(String[] args) {

    }
}
