package Binary;

public class LeetCode275 {

    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        while (l < r) {
            int mid = l+r+1>>1;
            if (citations[citations.length - mid] >= mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
