package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        PalindromeLinkedList234 pll = new PalindromeLinkedList234();
        System.out.println(pll.isPalindrome_List(node1));
        System.out.println(pll.isPalindrome(node1));
    }

    /**
     * 思路：由于回文的特点是前面一半和倒着写的后面一半相同，因为我们可以将linkedlist分成两半，
     * 并将后面一半reverse，然后判断这两个部分相不相同，reverse的做法可以见{@link ReverseLinkedList206}
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        /*
         使用slow和fast两个指针，其中fast每次移动两个节点，slow移动一个，这么一来，当fast到达末尾时，
         slow便到达了中间点。注意此时有两种情况：
         1. list长度为奇数，此时fast!=null, fast.next==null，而slow位于的中间点为前后两部分相交处，
         判断是否回文时，应该将slow往前移动一个节点。
         2. list长度为偶数，此时fast==null，slow正处于后半部分开头处，我们不做其他处理
         */
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;

        slow = reverse(slow);
        while (slow != null && head.val == slow.val) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public boolean isPalindrome_List(ListNode head) {
        if (head == null) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }

        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
