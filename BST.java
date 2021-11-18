package challenge.bst;

class Node {
    int value;
    Node left, right;

    Node(int data) {
        value = data;
        left = right = null;
    }
}

public class BST {

    private static int maxLevel = -1; // maximum level seen so far
    private static int res = -1; // value of deepest node so far

    public static void main(String[] args) {

        int[] input = {12, 11, 90, 82, 7, 9};

        // convert input to a BST
        Node root = createBST(input);

        //  return value of deepest node
        int deepestNodeValue = deepestNode(root);
        System.out.println("deepest: " + deepestNodeValue); // returns -1 if tree is empty

        //  return its depth
        int depth = height(root) - 1; // returns -1 if tree is empty
        System.out.println("depth: " + depth);
    }


    private static Node createBST(int[] input) {
        Node node = null;
        for (int value : input) {
            node = insert(node, value);
        }
        return node;
    }

    private static Node insert(Node node, int val) {
        if (node == null)
            return new Node(val);
        else if (node.value < val)
            node.right = insert(node.right, val);
        else if (node.value > val)
            node.left = insert(node.left, val);

        return node;
    }

    private static int deepestNode(Node root) {
        find(root, 0);
        return res;
    }

    private static void find(Node root, int level) {
        if (root != null) {
            find(root.left, ++level);

            if (level > maxLevel) {
                res = root.value;
                maxLevel = level;
            }

            find(root.right, level);
        }
    }

    private static int height(Node root) {
        if (root == null) return 0;

        int leftHt = height(root.left);
        int rightHt = height(root.right);
        return Math.max(leftHt, rightHt) + 1;
    }

}
 