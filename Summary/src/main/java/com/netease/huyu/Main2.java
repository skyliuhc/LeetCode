package com.netease.huyu;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-09-17-8:40 下午
 */
public class Main2 {
    public static void main(String[] args)  {
        String[] table = {"AB", "ABC", "FG"};
        Arrays.sort(table, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()!=o2.length()){
                    return o2.length()-o1.length();
                }else {
                    return o1.compareTo(o2);
                }

            }
        });
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i]);
        }

    }


    public int[][] search_substr (String source, String[] table) {
        // write code here
        int n = table.length;

        int strn = source.length();
        Arrays.sort(table, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()!=o2.length()){
                    return o2.length()-o1.length();
                }else {
                    return o1.compareTo(o2);
                }

            }
        });
        Trie trie = new Trie();
        List<String> list = new ArrayList<>();
        for (String s : table) {
            if (!trie.search(s)){
                trie.insert(s);
                list.add(s);
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            String tt = list.get(i);
            ans[i][0]=source.indexOf(tt);
            int count = 0;
            for (int j = 0; j < strn+1-n; j++) {
                if (source.substring(i,tt.length()+i).equals(tt)){
                    count++;
                }
            }
            ans[i][1] = count;
        }
        return  ans;
    }



}
class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
