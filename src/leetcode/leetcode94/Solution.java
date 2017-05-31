package leetcode.leetcode94;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DamonLiu on 16/9/23.
 */


class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        addSubtree(root.left,result);
        result.add(root.val);
        addSubtree(root.right,result);
        return result;
    }

    public void addSubtree(TreeNode node,List<Integer> list) {
        if(node==null){
            return;
        }
        addSubtree(node.left,list);
        list.add(node.val);
        addSubtree(node.right,list);
    }
}