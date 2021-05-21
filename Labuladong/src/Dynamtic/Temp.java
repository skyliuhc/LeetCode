package Labuladong.src.Dynamtic;

/**
 * @Author skyliuhc
 * @Description 动态规划的模板
 * @Date 2021-05-08-8:10 下午
 */
public class Temp {
    /*动态规划中最重要就是写出状态转移方程

    *一个通用的思维框架
    *明确状态 --> 定义dp数组/函数的含义 ->明确选择 -->明确base case
    */
    //    动态规划的第一个性质
    //可能存在重叠子问题----->可以用备忘录解决
    //备忘录中不是初始值，那么就返回备忘录中的值，否则就先算值，然后把这个值放到备忘录中
    //带备忘录的递归解法效率和迭代的动态规划差不多
    //动态规划类问题的两个解法，自顶向下的递归，自底向下的动态归还


    //背包问题
    int knapsack(int W,int N,int[] weight,int[] val){
        //可装载重量为W的背包 物品的个数为N
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i <=N; i++) {
            for (int w = 1; w <=W; w++) {
                //如果说当前背包装不下
                if(w-weight[i-1]<0){
                    //那我只能选择不装入背包
                    dp[i][w] = dp[i-1][w];
                }else{
                    //装入或者不装入背包，择优
                    dp[i][w] = Math.max(dp[i-1][w-weight[i-1]]+val[i-1],dp[i-1][w]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        Temp temp = new Temp();
        int N = 3, W = 4;
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[] {4, 2, 3};
        System.out.println(temp.knapsack(W, N, wt, val));
    }


}
