package Trees;

public class Klevel {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void kLevel(Node root, int currLevel, int reqLevel){
        if(root == null){
            return;
        }
        if(currLevel == reqLevel){
            System.out.print(root.data + " ");
            return;
        }

        kLevel(root.left, currLevel+1, reqLevel);
        kLevel(root.right, currLevel+1, reqLevel);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        kLevel(root, 1, 2);
    }
}
