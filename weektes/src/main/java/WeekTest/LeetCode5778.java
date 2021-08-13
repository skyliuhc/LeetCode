package WeekTest;

public class LeetCode5778 {
    //两种操作
    //操作一，删除头，加到尾
    //操作二：将某个字符反转
    public int minFlips(String s) {
        int len = s.length();
        s = s+s;
        int d0 = 0;// 转换成以0开头的字符串所需要的反转次数
        int d1 = 0;// 转换成以1开头的字符串所需要的反转次数
        StringBuffer h0 = new StringBuffer();
        StringBuffer h1 = new StringBuffer();
        for(int i = 0; i < len; i++){
            h0.append("01");
            h1.append("10");
        }
        String head0 = h0.toString();
        String head1 = h1.toString();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < 2*len; i++){
            if(s.charAt(i) != head0.charAt(i)){d0++;}// 与head0不同，则d0++
            if(s.charAt(i) != head1.charAt(i)){d1++;}// 与head1不同，则d1++
            if(i >= len){
                if(s.charAt(i-len) != head0.charAt(i-len)){d0--;}
                // 最前面的元素出窗口，如果出窗口的元素与head0对应的元素不同，则d0--
                //（不同的元素需要反转一次，但是不同的元素已经出窗口了，所以反转次数少一次）
                if(s.charAt(i-len) != head1.charAt(i-len)){d1--;}
                ans = Math.min(ans, Math.min(d0, d1));
            }
        }
        return ans;
    }
}
