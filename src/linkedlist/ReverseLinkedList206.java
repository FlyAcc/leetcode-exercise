package linkedlist;

/**
 * tags: #recursion， #linkedlist
 */
public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ReverseLinkedList206 rll = new ReverseLinkedList206();
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;

        ListNode rn = rll.reverseList(node);
        System.out.println(rn);
    }

    /*
    将A->B变为A<-B, 由于B->C这一信息丢失了，因此我们没法进行下去，这是因为题目提供的ListNode只有next没有prev。
    为了解决这一个问题，我们使用一个prev变量保存每次操作后prev信息。
    对于A->B->C来说，prev为null、A、B、C
     */
    public ListNode reverseList_Iterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /*
    由于ListNode没有prev信息，因为我们无法直接从头开始，但是从后面开始的话是可行的。
    假如有这么一个list：A->B->C->D，从后面开始的话，A->B->C<-D，并不会对其他部分造成影响，
    因此我们可以采用递归的方式，从尾到头
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = reverseList(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return result;
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
