package WeekTest;

public class LeetCode5212 {
    //第四题hard
    //向下取整数对和
    //常规解法超时
//    public int sumOfFlooredPairs(int[] nums) {
//        int mod =1000000000+7;
//        int n = nums.length;
//        int res=0;
//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j < n; j++) {
//                res+=Math.floor(nums[i]/nums[j])%mod;
//            }
//        }
//        return res;
//    }

    //前缀和+枚举
    public int sumOfFlooredPairs(int[] nums) {
        int N = 100010;
        int MOD = 1000000007;
        int[] s = new int[N];   //记录每个数出现多少次
        for (int x : nums) //记录每个数出现多少次
            s[x] ++ ;
        for (int i = 1; i < N; i++)  //前缀和
            s[i] += s[i - 1];
        int res = 0;    //记录答案
        for (int i = 1; i < N; i++) //枚举每一个数
            for (int j = 1; j * i < N; j ++ ) { //j代表倍数，枚举i的所有倍数区间
                int l = j * i, r = Math.min(N - 1, (j + 1) * i - 1);    //表示i的j倍到i的j+1倍（不包括i的j+1倍）的区间范围的左边界和右边界
                int sum = (s[r] - s[l - 1]) * j % MOD;     //区间个数乘以j就是这个区间的和
                res = (res + sum * (s[i] - s[i - 1])) % MOD;//区间和还要乘以这个数的数量
            }
        return res;
    }


    public static void main(String[] args) {
        int v = 1000000000+7;
        System.out.println(v);
    }

}
