package forJob.shopee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-07-19-3:52 下午
 */
public class Solution719 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }
        HashSet<Integer> set3 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int num:nums1){
            if(set2.contains(num) && !set3.contains(num)){
                list.add(num);
                set3.add(num);
            }
        }
        int n = list.size();
        int[] res = new int[n];
        return res;
    }

}
