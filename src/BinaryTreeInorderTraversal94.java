import java.util.ArrayList;
import java.util.List;

/**
 * tags: #Tree, #Traversal
 */
public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, n2, n3);
        BinaryTreeInorderTraversal94 it = new BinaryTreeInorderTraversal94();
        System.out.println(it.inorderTraversal(root));
        System.out.println(it.morrisTraversal(root));
    }

    /*
    Morris Traversal的思路是把树展开为链（顺序为Inorder）
     */
    public List<Integer> morrisTraversal(TreeNode root) {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
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
