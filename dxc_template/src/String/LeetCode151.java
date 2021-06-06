package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode151 {
    public String reverseWords(String s) {
//        输入：s = "the sky is blue"
//        输出："blue is sky the"
        // 除去开头和末尾的空白字符
        s = s.trim();//返回字符串的副本，忽略前导空白和尾部空白
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));//根据给定正则表达式的匹配拆分此字符串
        //并且数组转集合
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
