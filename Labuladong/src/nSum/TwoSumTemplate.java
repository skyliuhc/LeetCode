package nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumTemplate {

    List<List<Integer>> twoSumTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0;
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


}
