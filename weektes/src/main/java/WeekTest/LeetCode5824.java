package WeekTest;

/**
 * @author skyliuhc
 * @create 2021-07-25-10:41 上午
 */
public class LeetCode5824 {
    public String maximumNumber(String num, int[] change) {
        int n = num.length();
        char[] chars = num.toCharArray();
        boolean isChange = true;
        for (int i = 0; i < n; i++) {
            if (!isChange){
                break;
            }
            char before = chars[i];
            char after = (char) (change[chars[i]-'0']+'0');
            if(after>=before){
                chars[i]=after;
                isChange=true;
            }else{
                isChange=false;
            }
        }
        return new String(chars);
    }
    public String maximumNumberOffical(String num, int[] change) {
        int n = num.length();
        char[] c = num.toCharArray();
        for(int i=0;i<n;i++){
            int after = change[c[i]-'0'];
            int before = c[i]-'0';
            if(after>before){
                while(i<n && change[c[i]-'0']>=c[i]-'0'){
                    c[i]=(char)(change[c[i]-'0']+'0');
                    ++i;
                }
                break;
            }
        }
        return new String(c);
    }
}
