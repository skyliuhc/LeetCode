package Binary;

public class LeetCode287 {

    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int i : nums) {
                if (i >= 1 && i <= mid) {
                    //统计苹果的个数
                    cnt++;
                }
            }
            if (cnt > mid - 1 + 1) {
                //如果苹果的数量是大于抽屉的数量时，就说嘛结果是在左半边
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
