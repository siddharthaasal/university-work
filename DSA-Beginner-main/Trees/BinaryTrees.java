package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees {
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

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;

        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelorder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode==null){
                System.out.println("");
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return leftCount + rightCount + 1;
    }

        public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int diameterSlow(Node root){
        //O(n^2)
        if(root == null){
            return 0;
        }
        int leftDiameter = diameterSlow(root.left);
        int leftHeight = height(root.right);
        int rightDiameter = diameterSlow(root.left);
        int rightHeight = height(root.right);
        int treeDiameter = Math.max(leftHeight+rightHeight+1, Math.max(leftDiameter,rightDiameter));
        return treeDiameter;
    }
    
    public static class Info{
        int diameter;
        int height;
        public Info(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }
    public static Info diameterFast(Node root){
        //O(n)
        if(root == null){
            return new Info(0, 0);
        }

        Info leftInfo = diameterFast(root.left);
        Info rightInfo = diameterFast(root.right);

        int  finalDiameter = Math.max(leftInfo.height+rightInfo.height+1, 
                                        Math.max(leftInfo.diameter, rightInfo.diameter));
        int finalHeight = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new Info(finalDiameter, finalHeight);
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root: " + root.data);
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println("");
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println("");
        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println("");
        System.out.println("Levelorder Traversal: ");
        levelorder(root);
        System.out.println("Height: "+ height(root));
        System.out.println("Total nodes: " + countNodes(root));
        System.out.println("Sum of Nodes: "+ sum(root));
        System.out.println("Diameter (slower approach): "+diameterSlow(root));
        System.out.println("Diameter (faster approach): "+diameterFast(root).diameter);

    }
}