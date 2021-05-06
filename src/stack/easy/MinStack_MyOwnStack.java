package stack.easy;

public class MinStack_MyOwnStack {
    private Node top;

    /**
     * initialize your data structure here.
     */
    public MinStack_MyOwnStack() {
    }

    public static void main(String[] args) {
        MinStack_MyOwnStack stack = new MinStack_MyOwnStack();
        stack.push(-1);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

    public void push(int val) {
        if (top == null) {
            top = new Node(val);
            top.min = val;
        } else {
            Node oldTop = top;
            top = new Node(val);
            oldTop.next = top;
            top.prev = oldTop;
            top.min = Math.min(oldTop.min, val);
        }
    }

    public void pop() {
        if (top != null) {
            top = top.prev;
            if (top != null) {
                top.next = null;
            }
        }
    }

    public int top() {
        return top.value;
    }

    public int getMin() {
        return top.min;
    }

    private static class Node {
        private final int value;
        private Node prev;
        private Node next;
        private int min = Integer.MAX_VALUE;

        public Node(int value) {
            this.value = value;
        }
    }
}
