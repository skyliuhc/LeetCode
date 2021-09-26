package MapExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-09-17-12:15 上午
 */
public class main {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};

        Arrays.sort(nums);
        int target = 0;
        int n = nums.length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target){
                continue;//反正这已经是最大的情况了，这都不行，那肯定不行了
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;//因为排序，所以后面的数肯定大嘛
                }
                if(nums[i]+nums[j]+nums[n-2]+nums[n-1]<target){
                    continue;
                }
                int left = j+1;
                int right = n-1;
                while(left<right){
                    int temp = nums[i]+nums[j]+nums[left]+nums[right];
                    if(temp==target){
                        int[] ans = new int[4];
                        ans[0]=nums[i];
                        ans[1]=nums[j];
                        ans[2]=nums[left];
                        ans[3]=nums[right];
                        res.add(ans);
                        left++;
                        while (left<right && nums[left]==nums[left-1]){
                            left++;
                        }
                        right--;
                        while (left<right && nums[right]==nums[right+1]){
                            right--;
                        }
                    }else if (temp<target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }

        }
        for (int i = 0; i < res.size(); i++) {
            int[] t = res.get(i);
            for (int j = 0; j < t.length; j++) {
                System.out.print(t[j]+" ");
            }
            System.out.println();
        }
    }
}
