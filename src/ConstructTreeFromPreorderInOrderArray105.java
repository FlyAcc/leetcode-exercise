import java.util.ArrayList;
import java.util.List;

public class ConstructTreeFromPreorderInOrderArray105 {
    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        ConstructTreeFromPreorderInOrderArray105 ct = new ConstructTreeFromPreorderInOrderArray105();
        TreeNode root = ct.buildTree(pre, in);
        System.out.println(morrisTraversal(root));
    }

    public static List<Integer> morrisTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = curr;
                curr = curr.left;
                // IMPORTANT! Avoid Infinite loop
                rightmost.right.left = null;
            }
        }
        return result;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildSubTree(preorder, inorder, 0, 0, preorder.length);
    }

    private TreeNode buildSubTree(int[] pre, int[] in, int p1, int p2, int length) {
        if (length == 0 || p1 >= pre.length) {
            return null;
        }

        TreeNode root = new TreeNode(pre[p1]);
        int subLength = 0;
        int pos = p2;
        while (pos < in.length && in[pos] != root.val) {
            pos++;
            subLength++;
        }
        root.left = buildSubTree(pre, in, p1 + 1, p2, subLength);
        root.right = buildSubTree(pre, in, p1 + subLength + 1, p2 + subLength + 1, length - subLength - 1);
        return root;
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
