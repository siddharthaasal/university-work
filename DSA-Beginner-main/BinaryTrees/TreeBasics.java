package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeBasics{

    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;
    public static Node buildPreorder(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildPreorder(nodes);
        newNode.right = buildPreorder(nodes);
        return newNode;
    }

    public static void preorderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inorderTraversal(Node root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root){
        if(root==null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrderIterative(Node root){
        if (root == null) {
            return; // Tree is empty, nothing to traverse
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            System.out.print(curr.data+" ");
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }
    
    public static void preorderTraversalIterative(Node root){
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node curr = s.pop();
            System.out.print(curr.data+" ");
            if(curr.right!=null){
                s.push(curr.right);
            }
            if(curr.left!=null){
                s.push(curr.left);
            }
        }
    }

    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount+rightCount+1;
    }

     public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum+rightSum+root.data;
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root){  //O(n*n)
        if(root == null){
            return 0;
        }
        int leftDiameter = diameter(root.left);
        int leftHeight = height(root.left);
        int rightDiameter = diameter(root.right);
        int rightHeight = height(root.right);
        int selfDiameter = leftHeight+rightHeight+1;
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    static class Info{
        int diam;
        int ht;
        Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameterOptimized(Node root){
        if(root==null){
            return new Info(0,0);
        }
        Info leftInfo = diameterOptimized(root.left);
        Info rightInfo = diameterOptimized(root.right);
        int selfDiameter = leftInfo.ht+rightInfo.ht+1;
        int diameter = Math.max(selfDiameter, Math.max(leftInfo.diam, rightInfo.diam));
        int height = Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(diameter, height);
    }

    public static void main(String[] args) {

        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildPreorder(nodes);
        System.out.println("Preorder: ");
        preorderTraversal(root);
        System.out.println("\nInorder: ");
        inorderTraversal(root);
        System.out.println("\nPostorder: ");
        postorderTraversal(root);
        System.out.println("\nNumber of nodes: "+countNodes(root));
        System.out.println("Sum of nodes: "+sumOfNodes(root));
        System.out.println("Height of tree: "+height(root));
        System.out.println("Pre-order Iterative: ");
        preorderTraversalIterative(root);
        System.out.println("\nLevel Order Iterative: ");
        levelOrderIterative(root);
        System.out.println("\nDiameter of tree: "+diameter(root));
        //diameter in O(n)
        System.out.println("O(n) Diameter of tree: "+diameterOptimized(root).diam);
        //subtree of another tree
        //top view
        //left view
        //right view
    }
}