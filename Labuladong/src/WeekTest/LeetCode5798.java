package Labuladong.src.WeekTest;

import java.util.*;

public class LeetCode5798 {
    public int[][] rotateGrid(int[][] g, int k) {
        int n = g.length,m = g[0].length;
        int[][] res =new int[n][m];//一定是new一个新的数组或者是拷贝一下，直接将地址指向g是不对的
        for (int a = n,b=m,i=0; a >0 && b>0 ; a-=2,b-=2,i++) {
            int x=i,y=i;
            List<int[]> q= new ArrayList<>();//一圈数字，虽然可以找规律算出长度，但没必要
            for (int j = 0; j < b-1; j++) q.add(new int[]{x, ++y});//其实这里是++y或者y++都无所谓，只要对应关系是对的就行了
            for (int j = 0; j < a-1; j++) q.add(new int[]{++x, y});
            for (int j = 0; j < b-1; j++) q.add(new int[]{x, --y});
            for (int j = 0; j < a-1; j++) q.add(new int[]{--x, y});
            for (int j = 0; j < q.size(); j++) {
                // System.out.println(q.get(j)[0]+" "+q.get(j)[1]);
                int t=(j+k)%q.size();
                int[] qt = q.get(t);
                int[] qj = q.get(j);
                res[qj[0]][qj[1]] = g[qt[0]][qt[1]];
            }
        }
        return res;
    }
}
