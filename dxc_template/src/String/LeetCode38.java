package String;

public class LeetCode38 {

    public String countAndSay(int n) {
        String s ="1";

        for(int i=0;i<n-1;i++){
            StringBuilder t = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int k = j;
                while (k<s.length()&&s.charAt(k)==s.charAt(j)){
                    k++;
                }
                //表达，多少个s[j]
                t.append(k-j).append(s.charAt(j));
                j=k-1;
            }
            s=t.toString();
        }
        return s;
    }

}
