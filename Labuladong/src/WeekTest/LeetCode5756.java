package Labuladong.src.WeekTest;

import java.util.*;

public class LeetCode5756 {




    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length, range = 1 << n;
        int[] dp = new int[range];
        //若i的二进制表示中1的个数为num, 1的位置为k1,k2,...,knum, dp[i]表示nums1的前num个数和nums2第k1,k2,...,knum个数的最小异或值之和
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //固定nums1，然后改变nums2[]来找最小的
        for (int mask = 0; mask < range; mask++) {
            for (int i = 0; i < n; i++) {//遍历i的各个二进制位
                if (((mask >> i) & 1) == 1)//i的第j位为1
                    dp[mask] = Math.min(dp[mask], dp[mask ^ (1 << i)] + (nums1[Integer.bitCount(mask) - 1] ^ nums2[i]));
                //尝试选取nums1[num]和nums2[j]进行异或更新dp[i]
            }
        }
        return dp[range - 1];//答案为dp[111...1](n个1)
    }

    public static void main(String[] args) {
        int  test =1;
        test<<=5;
        System.out.println(test);
    }




//    public int minimumXORSum(int[] nums1, int[] nums2) {
//        //第一步先删除有相同的元素
//        List<Integer> l1 = new ArrayList<>();
//        List<Integer> l2 = new ArrayList<>();
//        int n = nums1.length;
//        HashMap<Integer, Integer> map1 = new HashMap<>();
//        HashMap<Integer, Integer> map2 = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
//            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
//        }
//        for (int i = 0; i < n; i++) {
//            if (map1.containsKey(nums2[i])) {
//                map1.put(nums1[i], map1.get(nums1[i]) - 1);
//                map2.put(nums2[i], map2.get(nums2[i]) - 1);
//            }
//        }
//        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//            for (int i = 0; i < entry.getValue(); i++) {
//                l1.add(entry.getKey());
//            }
//        }
//        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
//            for (int i = 0; i < entry.getValue(); i++) {
//                l2.add(entry.getKey());
//            }
//        }
//        int[] t1 = new int[l1.size()];
//        int[] t2 = new int[l2.size()];
//        for (int i = 0; i < l1.size(); i++) {
//            t1[i] = l1.get(i);
//            t2[i] = l2.get(i);
//        }
//        return force(t1, t2);
//    }
//
//    private int force(int[] t1, int[] t2) {
//
//        return 0;
//    }
//
//    private int getSum(int[] t1, int[] t2) {
//        int sum = 0;
//        if (t1.length != t2.length) {
//            return -1;
//        }
//        for (int i = 0; i < t1.length; i++) {
//            sum += t1[i] ^ t2[i];
//        }
//        return sum;
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[j] = nums[i];
//        nums[i] = temp;
//    }


}
