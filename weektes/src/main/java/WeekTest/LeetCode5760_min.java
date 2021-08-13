package WeekTest;

public class LeetCode5760_min {
    //我想的错误做法
    public int minSwaps(String s) {
        if(isValid(s)){
            int res=0;
            int num=0;
            for (int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i)!=s.charAt(i+1)){
                    num=0;
                }else{
                    num++;
                }

            }
            if(num>=2){
                num=num/2;
            }
            return num;
        }
        return  -1;
    }

    Boolean isValid(String s){
        int nums0=0;
        int nums1 =0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0'){
                nums0++;
            }else{
                nums1++;
            }
        }
        return Math.abs(nums0-nums1)<=1;
    }

    public static void main(String[] args) {
        LeetCode5760_min l1 = new LeetCode5760_min();
        String test ="100";
        System.out.println(l1.minSwaps(test));
    }
}
