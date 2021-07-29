package Labuladong.src.Dynamtic;

/**
 * @author skyliuhc
 * @create 2021-07-06-8:18 上午
 */
public class LeetCode45_jump {
    //当前可移动距离尽可能得多走，如果没到终点，步数再加一
    //整体最优:一步尽可能多走
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0; //下次的最右起跳点
        int maxPosition = 0;//目前能跳到最远到地方
        int steps = 0; //跳跃次数
        for (int i = 0; i < n-1; i++) {
            maxPosition= Math.max(maxPosition,i+nums[i]);
            if (i==end){//最后一次移动下标不等于当前覆盖最大距离下标，就说明能到达
                //第一步覆盖范围[0,end] 只要是这个范围都是一步跳
                end = maxPosition;//目前能跳到的最远位置，变成了下次起跳位置的右边界
                steps++;//进行下一次跳跃
            }
        }
        return steps;
    }
}
