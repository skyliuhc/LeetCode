import java.util.HashMap;

public class LeetCode525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int res =0;
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(count,-1);
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(num==1){
                count++;
            }else{
                count--;
            }
            if(map.containsKey(count)){
                int prevIndex = map.get(count);
                res=Math.max(res,i-prevIndex);
            }else{
                map.put(count,i);
            }
        }
        return res;
    }
}
