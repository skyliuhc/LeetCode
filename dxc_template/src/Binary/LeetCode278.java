package Binary;

public class LeetCode278 {
    //    第一个错误的版本
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;//注意这里的写法，有时候会溢出所以尽量不要写(l+r)>>1
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    //题目给出了借口，不同自己实现
    private boolean isBadVersion(int mid) {
        return true;
    }
}
