/*
    Solve - https://www.codechef.com/DSAPREP_10/problems/STKSORT
    (the above link is not working, so this question was changed by sir)


    Leetcode: - 155. Min Stack

    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    Implement the MinStack class:
        MinStack() initializes the stack object.
        void push(int val) pushes the element val onto the stack.
        void pop() removes the element on the top of the stack.
        int top() gets the top element of the stack.
        int getMin() retrieves the minimum element in the stack.

    You must implement a solution with O(1) time complexity for each function.


    Example 1:
        Input
            ["MinStack","push","push","push","getMin","pop","top","getMin"]
            [[],[-2],[0],[-3],[],[],[],[]]
        Output
            [null,null,null,null,-3,null,0,-2]
        Explanation
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin(); // return -3
            minStack.pop();
            minStack.top();    // return 0
            minStack.getMin(); // return -2

    Constraints:
        -231 <= val <= 231-1
        Methods pop, top, and getMin operations will always be called on non-empty stacks.
        At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */

import java.util.Stack;

class MinStack {
    private final Stack<Integer> st;
    private final Stack<Integer> minst;

    public MinStack() {
        st=new Stack<>();
        minst=new Stack<>();
    }

    public void push(int info) {
        st.push(info);
        if(minst.isEmpty() || info<=minst.peek()) minst.push(info);
    }

    public void pop() {
        int a = minst.peek();
        if (st.pop()==a) minst.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minst.peek();
    }
}