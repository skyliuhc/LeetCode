package String;

public class LeetCode6 {
    //找规律的题
    public String convert(String s, int n) {
        if (n==1){
            return  s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(i==0||i==n-1){
                for (int j = i; j <s.length() ; j+=2*(n-1)) {
                    sb.append(s.charAt(j));
                }
            }else {
                for (int j = i,k=2*(n-1)-i; j <s.length()||k<s.length() ; j+=2*(n-1),k+=2*(n-1)) {
                    if(j<s.length()) sb.append(s.charAt(j));
                    if(k<s.length()) sb.append(s.charAt(k));
                }
            }
        }
        return sb.toString();
    }

}
