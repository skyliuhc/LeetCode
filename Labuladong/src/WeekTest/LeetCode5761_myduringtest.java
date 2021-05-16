package WeekTest;

import java.util.Arrays;

public class LeetCode5761_myduringtest {

    class FindSumPairs {
        int[] arr1;
        int[] arr2;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.arr1 = nums1;
            this.arr2 = nums2;

        }

        public void add(int index, int val) {


        }

        public int count(int tot) {
            int n1 = arr1.length;
            int n2 = arr2.length;
            int[] temp2=new int[n2];

            for (int i = 0; i <n2 ; i++) {
                    temp2[i]=arr2[i];
            }

            Arrays.sort(arr1);
            Arrays.sort(temp2);
            int count = 0;

            for (int i = n1 - 1; i >= 0; i--) {
                for (int j = n2 - 1; j >= 0; j--) {
                    if (arr1[i] + temp2[j] == tot) {
                        count++;
                    } else if (arr1[i] + temp2[j] < tot) {
                        break;
                    }
                }

            }
            return count;
        }
    }
}
