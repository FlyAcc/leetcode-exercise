package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * tags: #set, #linkedlist, #differnt-length, #TortoiseAndHare
 */
public class LinkedListIntersection160 {
    public static void main(String[] args) {

    }

    /*
    该题难点在于两个linkedlist（相交点前）的长度不一样，也就是我们无法通过一次遍历求出相交点。
    假设list1在相交点前的长度为A，list2相交点前的长度为B，相交点后的长度均为C（若无相交点，则C=0），
    由于(A+C)+(B+C)=(B+C)+(A+C)，因此我们可以通过两次遍历的方式求出相交点。
    具体做法是：遍历list1（list2），当到达最后一个节点时，转为遍历list2（list1）。进一步的，即使
    没有相交点，这种做法最终也会返回null（到达末尾）。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    /*
    这种做法基于这么个思路：假如list1与list2有交点，那么将list1的末尾和list2的开头相连就能得到一个
    cycle，然后我们可以用龟兔赛跑算法求证有没有这么一个cycle，有的话就可以证明有交点。
    证明有交点后，我们需要找到交点，注意到交点就是cycle的起始点，因此我们可以使用求cycle起始点的算法，
    具体为：https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/
     */
    public ListNode getIntersectionNode_TNH(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // find last node of list A (c3)
        ListNode endA = headA;
        while (endA.next != null) {
            endA = endA.next;
        }
        // join c3 to b1 making a c1...c3-b1...b3-c1 loop (if b3 indeed points to c1)
        endA.next = headB;

        ListNode start = null; // if there's no cycle this will stay null
        // Floyd's cycle finder
        ListNode slow = headA, fast = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // found a cycle
                // reset to beginning to find cycle start point (c1)
                start = headA;
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                break;
            }
        }
        // unjoin c3-b1
        endA.next = null;
        return start;
    }

    public ListNode getIntersectionNode_Set(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> aSet = new HashSet<>();
        while (headA != null) {
            aSet.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (aSet.contains(headB)) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
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
