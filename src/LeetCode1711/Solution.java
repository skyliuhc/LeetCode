package LeetCode1711;

import java.util.HashMap;

/**
 * @author skyliuhc
 * @create 2021-07-07-12:13 上午
 */
public class Solution {
    public int countPairs(int[] d) {
        int mod = 1000000000+7;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans =0;
        int maxN=0;
        for (int v : d) {
            maxN = Math.max(maxN,v);
        }
        maxN<<=1;
        for (int i = 0; i < d.length; i++) {
            int key =d[i];
            for (int j = 1; j <=maxN; j<<=1) {
                ans+=map.getOrDefault(j-key,0);
                ans%=mod;
            }
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int a =1;
        a<<=1;
        System.out.println(a);
    }
}
