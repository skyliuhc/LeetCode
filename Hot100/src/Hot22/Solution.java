package Hot22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        //递归的出口
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if(open<max){
            cur.append('(');
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);//删除尾部
        }
        if (close<open){
            cur.append(')');
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        int left =1;
        int right =Integer.MAX_VALUE;
        int result =(left+right)>>>1;//防止溢出，用右移
        System.out.println(result);
    }
}
