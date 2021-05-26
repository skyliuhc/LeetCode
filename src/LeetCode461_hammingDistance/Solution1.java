package LeetCode461_hammingDistance;

public class Solution1 {

    class Solution {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
}
