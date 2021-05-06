package algorithm.recursion;

public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.add(3);
        root.add(10);
        root.add(1);
        root.add(6);
        root.add(4);
        root.add(7);
        root.add(14);
        root.add(13);
        BinarySearchTree bst = new BinarySearchTree();
        bst.printTree(root);
    }

    private void printTree(TreeNode node) {
        if (node == null) {
            return;
        }

        printTree(node.left);
        System.out.print(node.value + " ");
        printTree(node.right);
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        void add(int val) {
            // base case: if val is less than value, and left node is null,
            // we simply add to the left side
            // break: we add to left/right side of the tree, since a tree may have multiple layers
            if (val < value) {
                if (left == null) {
                    left = new TreeNode(val);
                } else {
                    left.add(val);
                }
            } else if (val > value) {
                if (right == null) {
                    right = new TreeNode(val);
                } else {
                    right.add(val);
                }
            }
        }
    }
}
