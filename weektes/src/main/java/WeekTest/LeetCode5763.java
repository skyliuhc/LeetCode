package WeekTest;

public class LeetCode5763 {
    //自己写的代码能过
//    public boolean checkZeroOnes(String s) {
//        if (s.length()==1){
//            return s.charAt(0)=='1'?true:false;
//        }
//        char[] chars = s.toCharArray();
//        int n1 = 0;
//        int n0 = 0;
//        ArrayList<Integer> list1 = new ArrayList<>();
//        ArrayList<Integer> list0 = new ArrayList<>();
//        System.out.println("执行到我这里");
//        for (int i = 0; i < chars.length - 1; i++) {
//            if (chars[i] == '1' && chars[i + 1] == '1') {
//                n1++;
//                System.out.println("n1:"+n1);
//            } else if (chars[i] == '1' && chars[i + 1] == '0') {
//                n1++;
//                list1.add(n1);
//                System.out.println("n1:" + n1);
//                n1 = 0;
//            }
//            if (chars[i] == '0' && chars[i + 1] == '0') {
//                n0++;
//                System.out.println("n0:"+n0);
//            } else if (chars[i] == '0' && chars[i + 1] == '1') {
//                n0++;
//                System.out.println("n0:"+n0);
//                list0.add(n0);
//                n0 = 0;
//            }
//        }
//        if (chars[chars.length-1]=='0'){
//            n0++;
//            list0.add(n0);
//        }else{
//            n1++;
//            list1.add(n1);
//        }
//        int max1 = 0;
//        int max0 = 0;
//        for (int i = 0; i < list1.size(); i++) {
//            max1 = Math.max(max1, list1.get(i));
//        }
//
//        for (int i = 0; i < list0.size(); i++) {
//            max0 = Math.max(max0, list0.get(i));
//        }
//
//        return max1 > max0 ? true : false;
//    }
    public boolean checkZeroOnes(String s){
        int len1 = 0, len0 = 0;
        int max1 = 0, max0 = 0;
        //max1 代表'1'子串的最大长度
        //max0 代表'0'子串的最大长度
        for (char c : s.toCharArray()) {
            if (c=='0') {
                len0++;
                len1=0;
            }else{
                len1++;
                len0=0;
            }
            max1=Math.max(len1,max1);
            max0=Math.max(len0,max0);
        }
        return max1>max0;
    }
    //    "011000111"
    public static void main(String[] args) {
        LeetCode5763 leetCode5763 = new LeetCode5763();
        System.out.println(leetCode5763.checkZeroOnes("11111111111111111111111111111111111111111111111111"));
    }
}
