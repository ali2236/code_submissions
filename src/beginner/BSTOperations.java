package beginner;

import java.util.Scanner;

public class BSTOperations {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            String opration = scanner.next();
            long value = scanner.nextLong();
            if (opration.equals("i")) {
                bst.insert(value);
            } else {
                bst.delete(value);
            }
        }
    }
}

class BinarySearchTree {

    class Node {
        long position;
        long value;
        Node right, left;

        public Node(long position, long value) {
            this.position = position;
            this.value = value;
            right = left = null;
        }

    }

    Node Root;

    public BinarySearchTree() {
        this.Root = null;
    }

    void insert(long value) {
        Root = insertRec(Root, 1, value);
    }

    Node insertRec(Node root, long position, long value) {
        if (root == null) {
            root = new Node(position, value);
            System.out.println(root.position);
        } else if (root.value > value)
            root.left = insertRec(root.left, root.position * 2, value);
        else
            root.right = insertRec(root.right, 2 * root.position + 1, value);
        return root;
    }

    void delete(long value) {
        Root = deleteRec(Root, value);
    }

    private Node deleteRec(Node root, long value) {
        if (root == null) return root;
        else if (root.value > value) root.left = deleteRec(root.left, value);
        else if (root.value < value) root.right = deleteRec(root.right, value);
        else {
            System.out.println(root.position);
            if (root.left == null) {
                //if (Root.right!=null) Root.right.position = Root.position;
                return root.right;
            } else if (root.right == null) {
                //Root.left.position = Root.position;
                return root.left;
            } else {
                root.value = minimum(root.right).value;
                root.right = deleteRec(root.right, root.value);
            }
        }
        return root;
    }

    private Node minimum(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
}