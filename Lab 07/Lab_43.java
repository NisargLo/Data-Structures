/*
    Merge Overlapping Intervals

    Given a set of time intervals in any order, our task is to merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals

    Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
        Output: {{1, 4}, {6, 8}, {9, 10}}
        Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4].
        Therefore we will merge these two and return [1,4],[6,8],[9,10]

    Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
        Output: {{1, 9}}

    Reference : https://www.geeksforgeeks.org/merging-intervals/
 */

import java.util.*;

public class Lab_43{
    public static void main(String[] args) {
        int[][] interval1 = {{1, 3}, {2,4}, {6,8}, {9,10}};
        int[][] interval2 = {{6,8}, {1,9}, {2,4}, {4,7}};
        int[][] mergedInterval1 = merge(interval1);
        int[][] mergedInterval2 = merge(interval2);
        System.out.println("Merged Intervals 1 :-");
        for (int[] interval : mergedInterval1) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
        System.out.println("\nMerged Intervals 2 :-");
        for (int[] interval : mergedInterval2) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] top = stack.peek();
            if (current[0] <= top[1]) {
                top[1] = Math.max(top[1], current[1]);
            }
            else {
                stack.push(current);
            }
        }
        int[][] merged = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            merged[i] = stack.pop();
        }
        return merged;
    }
}