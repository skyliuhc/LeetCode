package WeekTest;

import java.util.Arrays;

public class LeetCode5777 {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int first=nums.length-1;//第一大的元素的索引，如果不止一个，索引取最大的那个
        int second=getSecond(nums,first);;//第二大的元素的索引，如果不止一个，索引取最大的那个
        int max1=nums[first];//第一大的元素
        int max2=nums[second];//第二大的元素
        int count =0;
        //直到所有的元素都相同时，结束循环
        while (max1!=max2){
            //最大元素的个数
            int temp= first-second;
            count+=temp;
            max1=max2;
            second=getSecond(nums,second);
            max2=nums[second];
        }
        return count;
    }
    //用来找第二大元素的索引
    int getSecond(int[] nums,int target){
        for (int i = target; i >=0 ; i--) {
            if(nums[i]<nums[target]){
                return i;
            }
        }
        return target;
    }

}
