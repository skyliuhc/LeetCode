package Labuladong.src.WeekTest;

public class LeetCode5766 {

        public int stoneGameVIII(int[] stones){
            int n = stones.length;
            int[] p = new int[n+1];
            for (int i = 1; i <=n ; i++) {
                p[i]=p[i-1]+stones[i-1];//求前缀和
            }
            int res = p[n];
            for(int i=n-1;i>1;i--){
                res=Math.max(res,p[i]-res);
            }
            return res;
        }

}
