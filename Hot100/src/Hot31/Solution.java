package Hot31;

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
//        System.out.println("i:"+i);//i=1;
//        for (int num : nums) {
//            System.out.print(num);
//        }
        while (i>=0 && nums[i]>=nums[i+1]){
            //找不满足递减序列的第一个序号
            i--;
//            System.out.println("减了");
        }
        if (i>=0){
            int j = nums.length-1;
            while (j>=0 && nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        //如果没有的话就反转数组，此时i=-1
//        System.out.println("i:"+i);
        reverse(nums,i+1);
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums,int start){
        int left = start, right = nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums =new int[]{3,2,1};
        Solution s = new Solution();
        s.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
