/*
    From HackerRank

    Check if tree is BST
    - left is < root && right is > root
    - no duplicates
*/

public class CheckBST {
    public static class Node {
        public int data;
        public Node left;
        public Node right;
    }
    public static boolean check(Node root, int min, int max) {
        return root == null || min < root.data && root.data < max && (check(root.left, min, root.data) && check(root.right, root.data, max));
    }
    public static boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

    }
}