// Time Complexity :O(V+E)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * Create an indegree array and an adjacency list representing the graph. Then, pick the node which has
 * no dependency and add it to the queue. Now, process the node and take it out and then refer to the 
 * adjacency list to check which nodes are dependent on it and reduce the indegree by 1. Check if the indegree
 * is equal to 0, if yes, add it to the queue.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0 || prerequisites == null)
            return true;
        
        //Creating the indegree array and Adjacency List
        int[] indegree = new int[numCourses];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int edge[]:prerequisites)
        {
            indegree[edge[0]]++;
            if(!map.containsKey(edge[1]))
            {
                map.put(edge[1],new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        //Checking which nodes to add to the queue
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i<numCourses;i++)
        {
            if(indegree[i] == 0)
            {
                q.add((i));
                count++;
            }
        }
        
        //Processing the queue
        while(!q.isEmpty())
        {
            int curr = q.poll();
            List<Integer> li = map.get(curr);
            if(li != null)
            {
                for (int edge : li){
                    indegree[edge]--;
                    if(indegree[edge] == 0)
                    {
                        q.add(edge);
                        count++;
                    
                    if(count == numCourses)
                    {
                        return true;
                    }
                    }
                }
            }
        }
        return false;
        
    }
}
