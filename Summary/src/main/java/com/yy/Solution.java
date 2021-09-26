package com.yy;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-09-23-6:01 下午
 */
public class Solution {
}
class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode() {}

    public TreeNode(int _val) {
        val = _val;
    }

    public TreeNode(int _val, List<TreeNode> _children) {
        val = _val;
        children = _children;
    }
};