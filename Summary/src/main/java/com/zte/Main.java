package com.zte;

/**
 * @author skyliuhc
 * @create 2021-09-05-5:07 下午
 */
public class Main {

    public long ans(int n, int[] arr) {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            for (int j = i; j < n; j++) {
                if ((temp & arr[j]) == 0) {
                    ans += n - j;
                    break;
                } else {
                    temp &= arr[j];
                }
            }
        }
        return ans;
    }
}
