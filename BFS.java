// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * We are using a queue data structure - the idea is to add the root node and then pop it out to calculate the
 * children node of the parent node. We are using the size variable to calulate the number of nodes at each level
 * We use a loop with this size variable to traverse over the nodes at each level and add the children node of
 * each parent node in the queue.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                li.add(curr.val);
                
                if(curr.left != null)
                    {
                        q.add(curr.left);
                    }
                if(curr.right != null)
                    {
                        q.add(curr.right);
                    }        
            }
            result.add(li);
        }
        return result;
    }
}

/*
 * Approach 2 - BFS using DFS
 * The idea is to use a level variable to keep a track of the recursion level. In the result list, we check the following:
 * If the size of the list and the level is same, then the list for that level does not exist and we should 
 * create a list for that level.
 * If the level and the size does not match, we need to simply get the list at that level and add the element 
 * to that list.
 */

 /*
  * class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        
        dfs(root,0);
        return result;
    }
        
        private void dfs(TreeNode root, int level)
        {
            if(root == null)
                {
                    return;
                }
            if(result.size() == level)
            {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            
            dfs(root.left,level+1);
            dfs(root.right,level+1);
        }
}
  */

