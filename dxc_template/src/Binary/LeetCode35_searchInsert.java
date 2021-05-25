package Binary;

public class LeetCode35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        //base case
        if(nums.length==0||nums[nums.length-1]<target){
            return nums.length;
        }
        int l =0;
        int r =nums.length-1;
        while(l<r){
            int mid =l+r>>1;
            if(nums[mid]>=target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }
}
