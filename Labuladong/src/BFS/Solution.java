package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author skyliuhc
 * @Description BFS
 * @Date 2021-05-08-10:04 下午
 */
public class Solution {
    //关于BFS
    //主要采用的是队列这种数据结构
    //BFS 找到的路径一定是最短的，但代价就是空间复杂度比 DFS 大很多
    //应用的场景

    //二叉树的最小高度

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


    public static void main(String[] args) {

        System.out.println("nothing boys");
    }

}
