package WeekTest;

import java.util.HashMap;

public class LeetCode5761_offical {

    //  注意看nums1和nums2的数据范围,nums2的范围很大，考虑将其放入HashMap中
    // x+y=total;
    // y=total-x;
    // 定义数组
    class FindSumPairs {
        int[] arr1;
        int[] arr2;
        HashMap<Integer,Integer> map;
        public FindSumPairs(int[] nums1, int[] nums2) {
            this.arr1 = nums1;
            this.arr2 = nums2;
            map=new HashMap<>();
            for (int i = 0; i < arr2.length; i++) {
                if(map.containsKey(arr2[i])){
                    map.put(arr2[i],map.get(arr2[i])+1);
                }else{
                    map.put(arr2[i],1);
                }
            }
        }

        public void add(int index, int val) {
            //先删除
            map.put(arr2[index],map.get(arr2[index])-1);
            this.arr2[index]+=val;
            if (map.containsKey(arr2[index])){
                map.put(arr2[index],map.get(arr2[index])+1);
            }
            else{
                map.put(arr2[index],1);
            }
        }

        public int count(int tot) {
            int n1=arr1.length;
            int result =0;

            for (int i = 0; i < n1; i++) {
                int target =tot-arr1[i];
                if (map.containsKey(target)){
                    result+=map.get(target);
                }
            }
            return result;
        }
    }
}
