package Labuladong.src.WeekTest;

public class LeetCode5765 {
    //当时的思路是dp，没有看题目数据量的习惯，超时
    //下面是大雪菜的思路，
    public boolean canReach(String str, int a, int b) {
        // a就是minJump, b= maxJump,对变量改为较小的名字，可以方便写代码，尤其是在时间紧并且没有自动补全的情况下
        int n = str.length();
        int[] f = new int[n + 1];//f[i]=val表示存在val种路线跳到第i个点,
        int[] s = new int[n + 1];//s是f[i]的前缀和
        f[1] = 1;//可以到达第一个点，开始的位置嘛
        s[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (str.charAt(i - 1) == '0' && i - a >= 1) {
                // 能跳
                int l = Math.max(1, i - b);
                int r = i - a;
                if (s[r] > s[l - 1])
                    f[i] = 1;
            }
            s[i] = s[i - 1] + f[i];//代码翻译成java似乎有点问题，问题出在这里，这里需要跟着循环更新。
        }
        return f[n] > 0 ? true : false;
    }


    public static void main(String[] args) {
        LeetCode5765 leetCode5765 = new LeetCode5765();
//        "00111010" 3 5
        String test = "011010";
        System.out.println("str.length:"+test.length());
        System.out.println(test.charAt(1));
        System.out.println(leetCode5765.canReach("011010", 2, 3));
    }

    //这个解法可以看懂，并且可以运行
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int len = s.length();
            boolean[] dp = new boolean[len];
            dp[0] = true;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '0') {
                    for (int j = i - minJump; j >= 0 && j >= i - maxJump; j--) {
                        if (dp[j] == true) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
            return dp[len - 1];
        }
    }

}
