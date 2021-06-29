package challenge.may;

public class Solution0514 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        Solution0514 s = new Solution0514();
        s.flatten_Simpler(node1, null);
        System.out.println(node1);
    }

    private TreeNode flatten_Simpler(TreeNode root, TreeNode pre) {
        if (root == null) return pre;
        pre = flatten_Simpler(root.right, pre);
        pre = flatten_Simpler(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        if (root.left == null) {
            return;
        }
        TreeNode originRight = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode right = root.right;
        while (right.right != null) {
            right = right.right;
        }
        right.right = originRight;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
