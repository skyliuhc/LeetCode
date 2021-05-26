package Binary;

public class LeetCode34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        //base case
        if(nums.length<1){
            return new int[]{-1,-1};
        }
        int n = nums.length;
        int l =0, r =n-1;
        while (l<r){
            int mid=l+r>>1;
            if(nums[mid]>=target){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        if(nums[r]!=target){
            return new int[]{-1,-1};
        }
        int start =r;
        l=0;r=n-1;
        while (l<r){
            int mid=l+r+1>>1;
            if(nums[mid]<=target){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return new int[]{start,r};
    }
}
