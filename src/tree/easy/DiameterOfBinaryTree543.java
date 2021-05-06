package tree.easy;

/**
 * tags: #binary-tree, #recursion, #DFS
 */
public class DiameterOfBinaryTree543 {
    private int diameter;

    /*
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    显然最长路径是一个叶节点到另一个叶节点的距离，
    即longest path = node + the longest path of the node's left branch + the longest path of the node's right branch
    由于需要找的是叶节点，这里我们使用DFS（适用于目标远离根节点的情况）
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }

    private int longestPath(TreeNode node) {
        // base case
        if (node == null) return 0;

        // break the problem
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);
        // record the result
        diameter = Math.max(diameter, leftPath + rightPath);

        // combine the simpler result
        return Math.max(leftPath, rightPath) + 1;
    }

    static class TreeNode {
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
