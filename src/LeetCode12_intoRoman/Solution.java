package LeetCode12_intoRoman;

public class Solution {
    //方法一：模拟
//    根据罗马数字的唯一表示法，为了表示一个给定的整数 num，
//    我们寻找不超过num 的最大符号值，将 num 减去该符号值，
//    然后继续寻找不超过 num 的最大符号值，将该符号拼接在上一个找到的符号之后，
//    循环直至num 为 00。最后得到的字符串即为num 的罗马数字表示

    int[] values ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] symbols ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num){
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while(num>=value){
                num-=value;
                roman.append(symbol);
            }
            if (num==0){
                break;
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(3));
    }


}
