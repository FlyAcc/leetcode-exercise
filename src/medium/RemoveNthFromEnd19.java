package medium;

/**
 * tags: #recursion, #two-pointer
 */
public class RemoveNthFromEnd19 {
    public static void main(String[] args) {
        ListNode fifth = new ListNode(5, null);
        ListNode fourth = new ListNode(4, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(2, third);
        ListNode head = new ListNode(1, second);
        RemoveNthFromEnd19 r = new RemoveNthFromEnd19();
        ListNode temp = r.removeNthFromEnd(head, 5);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    /*
    目标是移除从末端数起第n个节点，由于不知道链表有多长，因此无法直接找到待移除的节点。
    这里的做法是使用双指针，使两个指针的间距为n个节点，然后同时向前移动俩指针，当在前面的指针
    到达末端时，后面的指针此时指向的就是待移除的节点，这是因为两个指针的间距始终为n个节点。
     */
    public ListNode removeNthFromEnd_OnePass(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode first = start;
        ListNode second = start;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return start.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = removeNthFromEndHelper(head, n);
        ListNode second = head.next;
        return count == n ? second : head;
    }

    private int removeNthFromEndHelper(ListNode head, int n) {
        if (head == null) {
            return 0;
        }

        if (head.next == null) {
            return 1;
        }

        int current = removeNthFromEndHelper(head.next, n);
        if (current != 0) {
            if (++current == n + 1) {
                head.next = head.next.next;
            }
        }

        return current;
    }

    private static class ListNode {
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
