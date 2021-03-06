package Binary;

public class LeetCode74 {
    //搜索旋转排序数组

    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while (l<r){
            int mid =(l+r)>>>1;
            if(nums[mid]<=nums[nums.length-1]){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(nums[l]!=target){
            return -1;
        }
        return l;
    }
}
