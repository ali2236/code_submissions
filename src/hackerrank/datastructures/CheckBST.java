package hackerrank.datastructures;

public class CheckBST {


    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(Node root, Integer min, Integer max) {
        if (root == null) return true;

        if(root.data <= min || root.data >= max) return false;

        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }



}

class Node {
    int data;
    Node left;
    Node right;
}
