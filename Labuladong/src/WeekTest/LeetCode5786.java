package Labuladong.src.WeekTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeetCode5786 {

    //一下是我在比赛的过程中的想的代码，最终超时了
//    public int maximumRemovals(String s, String p, int[] removable) {
//        int k=0;
//        int[] state = new int[s.length()];
//        Arrays.fill(state,1);
//        for (int i = 0; i < removable.length ;i++) {
//            int deleteIndex = removable[i];
//            state[deleteIndex]=0;
//            List<Character> list = new ArrayList<>();
//            for (int j = 0; j < s.length(); j++) {
//                if(state[j]==1){
//                    list.add(s.charAt(j));
//                }
//            }
//
//            String temp="";
//            for (int j = 0; j < list.size(); j++) {
//                temp+=list.get(j);
//            }
//            System.out.println(temp);
//            if(check(temp,p)){
//                k++;
////                System.out.println(k);
//            }else{
//                break;
//            }
//        }
//        return k;
//    }


    boolean check(String s1, String s2) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == s2.length() && i <= s1.length()) {
            return true;
        } else {
            return false;
        }

    }
    //        for (int i = 0; i < s2.length(); i++) {
//                String t= String.valueOf(s2.charAt(i));
//                if(s1.indexOf(t)==-1){
//                    return false;
//                }
//                s1=s1.substring(s1.indexOf(t));
//        }
//        return true;

    public static void main(String[] args) {
        LeetCode5786 leet = new LeetCode5786();
        Scanner sc = new Scanner(System.in);
        String s1 = "abcbddddd";
        String s2 = "abcd";
        int[] test = new int[]{3, 2, 1, 4, 5, 6};
        String s3 = "accb";
//        System.out.println(s1.indexOf(s3));
//        System.out.println();
        System.out.println(leet.maximumRemovals(s1, s2, test));
    }

    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0;
        int r = removable.length+1;
        while (l < r) {
            int mid = l+(r-l)/2;
            if (check(s, p, mid, removable)) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return l-1;
    }

    private boolean check(String s, String p, int k, int[] removable) {
        //判断p是否是s的子串
        int m = s.length();
        int n = p.length();
        int i = 0;
        int j = 0;
        boolean[] state = new boolean[m];
        for (int x = 0; x < k; x++) {
            state[removable[x]] = true;
        }
        //删除的被标记为true
        while (i < m && j < n) {
            if (s.charAt(i) == p.charAt(j) && !state[i]) {
                j++;
            }
            i++;
        }
        return j == n;
    }


}
