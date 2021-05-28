package Binary;

public class LeetCode153 {
//    寻找旋转排序数组中的最小值
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid =(l+r)>>1;
            if(nums[mid]<=nums[nums.length-1]){
                //check函数
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[l];
    }
}
