package String;

public class LeetCode273 {


    static String[] small = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"
            , "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] decade = {"", "","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] big = {"Billion", "Million", "Thousand", ""};

    public String numberToWords(int num) {
        if (num == 0) {
            return small[0];
        }
        String res = "";
        for (int i = 1000000000, j = 0; i > 0; i /= 1000, j++) {
            if (num >= i) {
                res += get_part(num / i) + big[j] + " ";
                num %= i;
            }
        }
        res.trim();
        return res;
    }

    private String get_part(int num) {
        String res = "";
        if (num >= 100) {
            res += small[num / 100] + "Hundred";
            num %= 100;
        }
        if (num == 0) {
            return res;
        }
        if (num > 20) {
            res += decade[num / 10] + " ";
            num %= 10;
        }
        if (num == 0) {
            return res;
        }
        res += small[num] + " ";
        return res;
    }

    public static void main(String[] args) {
        System.out.println(big.length);
    }

}
