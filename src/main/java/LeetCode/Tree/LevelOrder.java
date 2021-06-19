package LeetCode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {

    }

    void BFS_level(TreeNode root){
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        while (!q.isEmpty()){
            List<Integer> thisLevel = new ArrayList<>();
            int size = q.size();
            while (size>0){
                TreeNode node = q.poll();
                thisLevel.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }
            result.add(thisLevel);
            level++;
        }
    }
}
