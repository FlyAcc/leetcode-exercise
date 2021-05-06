package tree.easy;

/**
 * tags: #binary-tree, #recursion
 */
public class MergeTrees617 {
    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(5);
        TreeNode left = new TreeNode(3, left1, null);
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, right);
        TreeNode d = new TreeNode(4);
        TreeNode b = new TreeNode(1, null, d);
        TreeNode e = new TreeNode(7);
        TreeNode c = new TreeNode(3, null, e);
        TreeNode a = new TreeNode(2, b, c);
        MergeTrees617 mt = new MergeTrees617();
        mt.printTree(mt.mergeTrees(root, a));
    }

    public TreeNode mergeTrees_Recursion(TreeNode root1, TreeNode root2) {
        // base case: if one of the nodes is null, then the result of merge is another node
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        // break the problem one step simpler: merge left or right sub tree
        // assume that my function will solve the simpler problem, and then don't care about how it solves
        // finally we try to solve the complex problem base on the simple ones (combine the simple sub problems'
        // result in most case)
        root1.val += root2.val;
        root1.left = mergeTrees_Recursion(root1.left, root2.left);
        root2.right = mergeTrees_Recursion(root1.right, root2.right);
        return root1;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode left1 = root1 != null ? root1.left : null;
        TreeNode left2 = root2 != null ? root2.left : null;
        TreeNode left = mergeTrees(left1, left2);
        TreeNode right1 = root1 != null ? root1.right : null;
        TreeNode right2 = root2 != null ? root2.right : null;
        TreeNode right = mergeTrees(right1, right2);
        int val;
        if (root1 == null) {
            val = root2.val;
        } else if (root2 == null) {
            val = root1.val;
        } else {
            val = root1.val + root2.val;
        }
        TreeNode root = new TreeNode(val);
        root.left = left;
        root.right = right;
        return root;
    }

    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    public static class TreeNode {
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
