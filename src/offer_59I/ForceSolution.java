package offer_59I;

/**
 * @author skyliuhc
 * @create 2021/5/5
 */
public class ForceSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0){
            return new int[0];
        }
        int[] res = new int[nums.length-k+1];
        for (int i = 0; i <=nums.length-k; i++) {
            res[i]=findMax(nums,i,k+i);
        }
        return res;
    }

    private int findMax(int[] nums, int low, int hight) {
        int max =nums[low];
        for (int i = low; i < hight; i++) {
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return  max;
    }


}
