package WeekTest;

public class LeetCode5759_dxc {
    //采用二进制枚举子集
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int res =0;
        //2^n
        for (int i = 0; i < 1<<n; i++) {
            int s=0;
            for (int j = 0; j < n; j++) {
                if((i>>j&1)==1){
                    s^=nums[j];
                }
            }
            res+=s;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i<<2);
    }

}
