package String;

public class LeetCode165 {

    public int compareVersion(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() || j < s2.length()) {
            int x = i;
            int y = j;
            //用两个指针来搜索子字符串
            while (x < s1.length() && s1.charAt(x) != '.') x++;
            while (y < s2.length() && s2.charAt(y) != '.') y++;
            int a = i == x ? 0 : Integer.parseInt(s1.substring(i, x));
            //超过长度就补0
            int b = j == y ? 0 : Integer.parseInt(s2.substring(j, y));
            if (a > b) return 1;
            if (a < b) return -1;
            i = x + 1;
            j = y + 1;
        }
        return 0;
    }
}
