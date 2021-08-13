package WeekTest;

/**
 * @author skyliuhc
 * @create 2021-07-18-10:33 上午
 */
public class LeetCode5161 {
    public int canBeTypedWords(String text, String b) {
        String[] words = text.split(" ");
        int res = 0;
        for (String s : words) {
            boolean flag = true;
            for (char c : b.toCharArray()) {
                if (s.contains(c+"")) {
                    flag=false;
                    break;
                }
            }
            if(flag) res++;

        }
        return res;
    }
}
