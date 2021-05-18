package nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> triples = threeSumTarget(nums,i+1,target-nums[i]);
            for (List<Integer> triple : triples){
                triple.add(nums[i]);
                res.add(triple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
    List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int low = start;//左指针改成start开始
        int high = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (low < high) {
            int sum = nums[low] + nums[high];
            int left = nums[low], right = nums[high];
            if (sum < target) {
                while (low < high && nums[low] == left) low++;
            } else if (sum > target) {
                while (low < high && nums[high] == right) high--;
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(left);
                list.add(right);
                res.add(list);
                while (low < high && nums[low] == left) low++;
                while (low < high && nums[high] == right) high--;
            }
        }
        return res;
    }

    List<List<Integer>> threeSumTarget(int[] nums, int start,int target){
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums,i+1,target-nums[i]);
            for(List<Integer> tuple:tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i<n-1 && nums[i]==nums[i+1]) i++;
        }
        return res;
    }



}
