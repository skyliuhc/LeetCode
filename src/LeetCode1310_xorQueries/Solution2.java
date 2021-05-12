package LeetCode1310_xorQueries;

class Solution2 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] ^= arr[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = (queries[i][0] == 0 ? 0 : arr[queries[i][0] - 1]) ^ arr[queries[i][1]];
        }
        return result;
    }
}