/*
	Problem: https://www.codechef.com/problems/JAG
	
	You are given an undirected graph with N nodes (numbered 1 through N).
	For each valid i, the i-th node has a weight W[i].
	Also, for each pair of nodes i and j, there is an edge connecting these nodes if j − i ≠ W[j] − W[i].
	Find the number of connected components in this graph.

	Input Format
		The first line of the input contains a single integer T denoting the number of test cases.
		The description of T test cases follows.
		The first line of each test case contains a single integer N.
		The second line contains N space-separated integers W[1], W[2], …, W[N].

	Output Format
		For each test case, print a single line containing one integer --- the number of connected components in the graph.

	Constraints
		1 ≤ T ≤ 10^4
		1 ≤ N ≤ 10^5
		|W[i]| ≤ 10^9 for each valid i
		the sum of N over all test cases does not exceed 2 * 10^5.

	Subtasks
		Subtask #1 (30 points):
			N ≤ 10^3
			the sum of N over all test cases does not exceed 2 * 10^3

		Subtask #2 (70 points): original constraints

	Sample 1:
		Input
			2
			2
			1 2
			2
			2 1
		Output
			2
			1

	Explanation:
		Example case 1: For i=1 and j=2, we have 2−1 = 2−1, therefore there are no edges in the graph and there are two connected components.
		Example case 2: For i=1 and j=2, we have 2−1 != 1−2, therefore there is an edge between 1 and 2, the graph is connected, so there is only one connected component.
 */

import java.util.*;
import java.lang.*;

public class Lab_87 {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-- > 0){
			int n = sc.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			HashSet<Long> hashSet = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				hashSet.add(arr[i-1]-i);
			}
			System.out.println(hashSet.size()==1?n:1);
		}
	}
}