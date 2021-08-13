package WeekTest;

import java.util.ArrayList;
import java.util.List;

public class LeetCode5772 {

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        // 比赛的时候写的
//        int first=getNum(firstWord);
//        int second=getNum(secondWord);
//        int target=getNum(targetWord);
//        if(target==first+second){
//            return true;
//        }
//        return false;
        return get(firstWord)+get(secondWord)==get(targetWord);
    }


    //简洁写法
    int get(String str){
        int res =0;
        for (Character c:str.toCharArray()){
            res=res*10+c-'a';
        }
        return res;
    }
    private int getNum(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i)-'a');
//            System.out.println(firstWord.charAt(i)-'a');
        }
        int res =0;
        int n =list.size();
        for (int i = 0; i < list.size(); i++) {
            n--;
            res+=list.get(i)*Math.pow(10,n);
//            n--;
//            System.out.println("n"+Math.pow(10,n));
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode5772 l1 = new LeetCode5772();
        System.out.println(l1.isSumEqual("aaa", "a", "aab"));

    }

}
