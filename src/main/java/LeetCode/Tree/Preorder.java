package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class Preorder {
    public static void main(String[] args) {

    }

     public static void inOrderDFS(TreeNode root){

        if (root.left != null) {
            inOrderDFS(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            inOrderDFS(root.right);
        }
     }
}

class TreeNode {
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