package stack.easy;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> minStack = new Stack<>();
    private final Stack<Integer> stack = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        int lastMin = minStack.isEmpty() ? val : minStack.peek();
        minStack.push(Math.min(val, lastMin));
        stack.push(val);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
