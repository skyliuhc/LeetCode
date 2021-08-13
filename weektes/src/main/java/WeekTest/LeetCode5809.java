package WeekTest;

import java.util.HashSet;

/**
 * @author skyliuhc
 * @create 2021-07-11-10:38 上午
 */
public class LeetCode5809 {
    int ans =0;
    HashSet<String> set = new HashSet<>();
    public int countPalindromicSubsequence(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        dfs(chars,0,n,0,sb);
        return ans;
    }

    private void dfs(char[] chars, int start, int n, int index, StringBuilder sb) {
        if(start == n){
            if(index==3 ){
                String s =sb.toString();
                if(check(s) &&  !set.contains(s)){
                    set.add(s);
                    ans++;
                };

            }
            return;
        }

        sb.append(chars[start]);
//        System.out.println("选择之前"+sb.toString());
        dfs(chars,start+1,n,index+1,sb);
        sb.deleteCharAt(sb.length()-1);
//        System.out.println("不选"+sb.toString());
        dfs(chars,start+1,n,index,sb);
    }

    private boolean check(String now) {
        int n = now.length();
        for (int i = 0; i < n/2; i++) {
            if(now.charAt(i)!=now.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode5809 s = new LeetCode5809();
        System.out.println(s.countPalindromicSubsequence("aabca"));

//        StringBuilder sb = new StringBuilder();
//        sb.append("1");
//        System.out.println(sb.toString());
//        sb.deleteCharAt(sb.length()-1);
//        System.out.println(sb.toString());
    }
}
