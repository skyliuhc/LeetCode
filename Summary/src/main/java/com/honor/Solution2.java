package com.honor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author skyliuhc
 * @create 2021-08-21-7:26 下午
 */
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(",");
        for (String s : split) {
            System.out.println(s);
        }
        int m = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(m);
        String[] strings = fullJustify(split, m);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static String[] fullJustify(String[] words, int maxWidth) {
        //定义0-maxWidth个空格字符串，方便之后直接调用
        final String[] space = new String[maxWidth + 1];
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < maxWidth + 1; i++) {
            space[i] = s.toString();
            s.append("*");
        }
        //新建List，用来存最后的结果。
        List<String> pWords = new ArrayList<String>();
        //遍历整个words，一行一行的排版
        for (int i = 0; i < words.length; i++) {
            int curlen = words[i].length(); //记录当前已读取单词的长度，当>=maxWidth时进行排版
            int startI = i;                //记录本次读取单词的起点
            while (i < words.length - 1 && curlen < maxWidth) {
                i++;
                curlen = curlen + words[i].length() + 1;  // 每多读一个单词都要加一个空格
            }
            if (curlen > maxWidth) {       //当前长度>maxWidth，说明已经多读取了一个单词
                curlen = curlen - words[i].length() - 1;
                i--;
            }
            //一行一行的排版
            pWords.add(processCurline(words, startI, i, curlen, maxWidth, space));
        }
        int size = pWords.size();
        String[] res = new String[size];
        for (int i = 0; i < res.length; i++) {
            res[i]=pWords.get(i);
        }
        return res;
    }

    public static String processCurline(String[] words, int si, int ei, int curlen, int maxWidth, String[] space) {
        StringBuffer sb = new StringBuffer();   //用来进行排版
        int map = ei - si;                   // 记录单词之间的有几个间隙
        int addSpace = maxWidth - curlen + map;   //记录这一行总共有多少个空格
        if (map == 0) {               //间隙为0，证明只有一个单词
            sb.append(words[ei]);
            sb.append(space[addSpace]);
            return sb.toString();
        }
        if (ei == words.length - 1) {            //证明要排版最后一行了，格式特殊
            for (int i = si; i < ei; i++) {
                sb.append(words[i]).append("*");
            }
            sb.append(words[ei]);             //最后一个单词不用加空格
            sb.append(space[addSpace - map]);   //如果还有多余空格，一起加上
            return sb.toString();
        }
        int allAddSpace = addSpace / map;     //所有的空格数 / 间隙 = 每个间隙必加的空格数
        int left = addSpace % map + si;     //多出来的空格要从si开始，依次加在间隙中
        for (int i = si; i < ei; i++) {
            sb.append(words[i]).append(space[allAddSpace]);
            if (i < left) sb.append("*");     // <left就要多加一个空格
        }
        sb.append(words[ei]);
        return sb.toString();
    }


}
