package DoublePoint_SlideWindow_stack_queue;

public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int  j=0,i=n-1;j<n;j++){
            while(i-1>j && numbers[i-1]+numbers[j]>=target) i--;
            //这里是确保numbers[i]+numbers[j]是第一个大于等于target的数
            if(numbers[i]+numbers[j]==target){
                return new int[]{j+1,i+1};
            }
        }
        return new int[]{-1,-1};
    }
}
