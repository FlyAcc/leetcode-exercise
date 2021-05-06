package tree.traversal.depth;

public class DepthFirstTraversal {
    // Root of Binary Tree
    Node root;

    DepthFirstTraversal() {
        root = null;
    }

    // Driver method
    public static void main(String[] args) {
        DepthFirstTraversal tree = new DepthFirstTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }

    /*
    postOrder: left->right->root
     */
    void printPostorder(Node node) {
        if (node == null)
            return;

        // left
        printPostorder(node.left);

        // right
        printPostorder(node.right);

        // root
        System.out.print(node.key + " ");
    }


    /*
    inorder: left->root->right
     */
    void printInorder(Node node) {
        if (node == null)
            return;

        // left
        printInorder(node.left);

        // root
        System.out.print(node.key + " ");

        // right
        printInorder(node.right);
    }

    /*
    preOrder: root->left->right
     */
    void printPreorder(Node node) {
        if (node == null)
            return;

        // root
        System.out.print(node.key + " ");

        // left
        printPreorder(node.left);

        // right
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        printPostorder(root);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder() {
        printPreorder(root);
    }

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}
