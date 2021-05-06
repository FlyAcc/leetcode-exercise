package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * tags: #HashSet, #TortoiseAndHare
 */
public class LinkedListCycle141 {
    public static void main(String[] args) {
        LinkedListCycle141 llc = new LinkedListCycle141();
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        head.next = second;
//        second.next = head;
        ListNode third = new ListNode(0);
        second.next = third;
        ListNode last = new ListNode(-4);
        third.next = last;
        last.next = second;
        System.out.println(llc.hasCycle(head));
        System.out.println(llc.hasCycle_TortoiseHare(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (!set.contains(temp)) {
                set.add(temp);
                temp = temp.next;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle_TortoiseHare(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public boolean hasCycle_TortoiseHare1(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
