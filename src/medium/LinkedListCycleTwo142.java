package medium;

public class LinkedListCycleTwo142 {
    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(4);
        fourth.next = second;
        third.next = fourth;
        second.next = third;
        first.next = second;
        LinkedListCycleTwo142 llc = new LinkedListCycleTwo142();
        System.out.println(llc.detectCycle(first).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        slow = head;
        while (slow != fast && fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
