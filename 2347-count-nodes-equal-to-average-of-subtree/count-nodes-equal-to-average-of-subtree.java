/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SumCnt {
    int sum;
    int cnt;
    SumCnt(int sum, int cnt) {
        this.sum = sum;
        this.cnt = cnt;
    }
}

class Solution {
    private int res = 0;
    public int averageOfSubtree(TreeNode root) {
        solve(root);  
        return res;   
    }
    private SumCnt solve(TreeNode root) {
        if(root==null) return new SumCnt(0,0);

        SumCnt left = solve(root.left);
        SumCnt right = solve(root.right);
        int avg = (left.sum+right.sum+root.val)/(left.cnt+right.cnt+1);
        if(root.val == avg) res++;

        return new SumCnt(left.sum+right.sum+root.val, left.cnt+right.cnt+1);
    }
}