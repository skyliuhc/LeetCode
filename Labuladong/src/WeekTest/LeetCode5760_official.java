package Labuladong.src.WeekTest;

public class LeetCode5760_official {
    public int minSwaps(String s) {
        int n = s.length();
        int res= Integer.MAX_VALUE;
        //符合题目要求的只有两种
        //情况1(1在前，1多)："1010"（偶数） "10101"（奇数）模式是i+1%2也就是说!=i%2
        //情况2(0在前，0多)："0101"（偶数） "01010"（奇数）
        //fori i%2产生 0%2=0 1%2=1
        //统计源字符中的'0'和'1'的个数
        int n1 = count(s,'1');
        int n0 = count(s,'0');
        //情况一
        if(n1==(n+1)/2 && n0==n/2){
            int diff1 =0;
            for (int i = 0; i < n; i++) {
                //判断和第一种情况模式不同的个数
                if(s.charAt(i)-'0' == i % 2){
                    diff1++;
                }
            }
            res=Math.min(res,diff1/2);
        }
        //情况二
        if(n0==(n+1)/2 && n1==n/2){
            int diff2 =0;
            for (int i = 0; i < n; i++) {
                //判断和第二种情况模式不同的个数
                if(s.charAt(i)-'0' != i % 2){
                    diff2++;
                }
            }
            res=Math.min(res,diff2/2);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    public  int count(String s,char c){
        char[] chars = s.toCharArray();
        int count =0;
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]==c){
                count++;
            }
        }
        return count;
    }

}
