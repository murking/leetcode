package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class p102 {
    public static void main(String[] args) {

    }
}
class Solution {
    private List<List<Integer>> levels = new ArrayList<List<Integer>>();

//    private void dfs(TreeNode node ,int level){
//        if (levels.size()==level){
//            levels.add(new ArrayList<Integer>());
//        }
//        levels.get(level).add(node.val);
//        if (node.left != null)
//            dfs(node.left,level+1);
//        if (node.right != null)
//            dfs(node.right,level+1);
//    }
    private void bfs(TreeNode node ){
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(node);
        int level = 0;
        while (!que.isEmpty()){
            levels.add(new ArrayList<Integer>());

            int len = que.size();
            for (int i = 0; i < len; i++) {
                TreeNode tem = que.remove();
                levels.get(level).add(tem.val);
                if (tem.left!= null)
                    que.add(tem.left);
                if (tem.right!=null)
                    que.add(tem.right);
            }
            level++;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<List<Integer>>();
        bfs(root);
        return levels;
    }
}
