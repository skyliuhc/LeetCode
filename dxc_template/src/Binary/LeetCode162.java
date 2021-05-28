package Binary;

public class LeetCode162 {
    // 寻找峰值
    public int findPeakElement(int[] nums) {
        int l =0, r = nums.length-1;
        while(l<r){
            int mid =l+(r-l)/2;
            if(nums[mid]>nums[mid+1]){
                //注意这个check函数
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
