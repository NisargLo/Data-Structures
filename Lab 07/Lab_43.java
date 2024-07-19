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

public class Lab_43 {
    public static void main(String[] args) {
        int[][] interval1 = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        int[][] interval2 = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        int[][] mergedInterval1 = merge(interval1);
        int[][] mergedInterval2 = merge(interval2);

        System.out.println("Merged Intervals 1 :-");
        printIntervals(mergedInterval1);

        System.out.println("\nMerged Intervals 2 :-");
        printIntervals(mergedInterval2);
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        bubbleSort(intervals);

        Int_Array_Stack stack = new Int_Array_Stack(intervals.length);
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] top = stack.peep(1);
            if (intervals[i][0] <= top[1]) {
                top[1] = Math.max(top[1], intervals[i][1]);
            }
            else {
                stack.push(intervals[i]);
            }
        }

        int[][] merged = new int[stack.size()][];
        for (int i = stack.size() - 1; i >= 0; i--) {
            merged[i] = stack.pop();
        }

        return merged;
    }

    private static void bubbleSort(int[][] intervals) {
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = temp;
                }
            }
        }
    }

    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
    }
}

class Int_Array_Stack {
    int[][] stack_array;
    private int top = -1;
    int size;

    protected Int_Array_Stack(int size) {
        this.size = size;
        this.stack_array = new int[this.size][];
    }

    protected void push(int[] x) {
        if (top >= size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack_array[top] = x;
    }

    protected int[] pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return null;
        }
        int[] poppedArray = stack_array[top];
        top--;
        return poppedArray;
    }

    // user enters 1 based index :-
    protected int[] peep(int index) {
        if (top + 1 - index < 0) {
            System.out.println("Stack Underflow");
            return null;
        }
        return stack_array[top + 1 - index];
    }

    protected boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}
