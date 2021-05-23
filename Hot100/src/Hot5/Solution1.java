package Hot5;

public class Solution1 {


    public String longestPalindrome(String s){
        if(s==null || s.length()<1){
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len_odd = expandCenter(s,i,i);
            int len_even = expandCenter(s,i,i+1);
            int len = Math.max(len_odd,len_even);
            if (len>end-start){
                start=i-(len-1)/2;
                end = i +len/2;
            }
        }
        return s.substring(start,end+1);
    }
    /**
     *
     * @param s 输入的字符串
     * @param left  起始的左边界
     * @param right 起始的右边界
     * @return 回文串的长度
     */
    private  int expandCenter(String s, int left, int right){
            // left =right 的时候，此时回文中心是一个字符，回文串的长度是奇数
            // right = left +1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
            //跳出循环的时候恰好满足 s.charAt(left) != s.charAt(right)
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        //不包括right 和left所指向的两个
        return right-left-1;
    }


}
