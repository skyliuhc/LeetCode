package com.zte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-08-24-11:11 上午
 */
public class Solution {
    //二叉树的最大上升子序列
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode() {
        }

        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public  int maxLength(TreeNode root){
        List<List<Integer>> res= binaryTreePaths(root);
        int max = Integer.MIN_VALUE;
        int pathNum = res.size();
        for (int i = 0; i < pathNum; i++) {
            int n = res.get(i).size();
            List<Integer> tlist = res.get(i);
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[i] =  tlist.get(i);
            }
            max= Math.max(lengthOfLIS(nums),max);
        }
        return max;
    }

    List<List<Integer>> res = new ArrayList<>();    // 存储结果
    LinkedList<Integer> path = new LinkedList<>();  // 存储单个路径

    public List<List<Integer>> binaryTreePaths(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树的遍历框架
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        path.add(root.val);
        // 到叶子节点就返回
        if (root.left == null && root.right == null) {
            // 添加到结果中
            res.add(path);
        }
        traverse(root.left);
        traverse(root.right);
        path.removeLast();
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res =0;
        for(int i=0;i<dp.length;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
