package challenge.may;

public class Solution0516 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        TreeNode node6 = new TreeNode();
        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node4.right = node5;
        node5.left = node6;
        Solution0516 s = new Solution0516();
        System.out.println(s.minCameraCover(node1));
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return minCameraCover2(root);
    }

    private int minCameraCover2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int camCount = minCameraCover2(root.left) + minCameraCover2(root.right);
        if (root.left != null && root.left.val == 0) {
            root.val = 1;
            return camCount + 1;
        }

        if (root.right != null && root.right.val == 0) {
            root.val = 1;
            return camCount + 1;
        }

        return camCount;
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
