package Binary;

public class LeetCode33 {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        //第一次二分求最小值
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= nums[nums.length - 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //确定下一次二分的左边界和右边界
        if (target <= nums[nums.length - 1]) {
            r = nums.length - 1;
        } else {
            l = 0;
            r--;
        }
        while (l<r){
            int mid = l+r >>1;
            if(nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        //如果找到了这个数，返回索引
        if(nums[l]==target){
            return l;
        }
        return -1;
    }
}
