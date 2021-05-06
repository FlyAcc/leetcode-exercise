package linkedlist;

/**
 * tags: #linkedlist, #iteration
 */
public class MergeTwoLists21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode node = new MergeTwoLists21().mergeTwoLists(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /*
    我的做法
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = null;
        ListNode currentNode = null;
        ListNode _l1 = l1;
        ListNode _l2 = l2;
        // 一个linked list为null时就没必要再继续循环了，可以直接把不为空的list直接attach到merged list
        // 因为每个linked list本身也是排序好的
        while (_l1 != null || _l2 != null) {
            int min;
            if (_l1 == null || (_l2 != null && _l2.val < _l1.val)) {
                min = _l2.val;
                _l2 = _l2.next;
            } else {
                min = _l1.val;
                _l1 = _l1.next;
            }

            ListNode temp = currentNode;
            currentNode = new ListNode(min);
            if (temp != null) {
                temp.next = currentNode;
            } else {
                merged = currentNode;
            }
        }

        return merged;
    }

    /*
    这种做法得到的结构：preHead->head->second->third->...->last
    因此我们最后返回的是preHead.next
     */
    public ListNode mergeTwoLists_NoIteration(ListNode l1, ListNode l2) {
        // 使用preHead把linked list的头记录下来，当然由于实际的merged list是last
        // last是merged list的最后一个节点
        ListNode preHead = new ListNode();
        ListNode last = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                last.next = l2;
                l2 = l2.next;
            } else {
                last.next = l1;
                l1 = l1.next;
            }
            last = last.next;
        }

        // 一个list node为null时，只需简单把另一个list node attach到last上
        if (l1 == null) {
            last.next = l2;
        } else {
            last.next = l1;
        }

        return preHead.next;
    }

    /*
    使用递归的基本思路：merged linked list的下一个节点即该节点的下一个节点与另一个list的合并结果
    通过把list细分为一个个节点，判断出最小值的点，再进行递归合并
     */
    public ListNode mergeTwoLists_Iteration(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
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
