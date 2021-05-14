package LeetCode12_intoRoman;

public class Solution {
    int[] values ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] symbols ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String inToRoman(int num){
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
        System.out.println(s.inToRoman(3));
    }


}
