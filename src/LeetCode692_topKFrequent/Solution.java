package LeetCode692_topKFrequent;

import java.util.*;

public class Solution {


    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        int maxTime =Integer.MIN_VALUE;
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            list.add(entry.getKey());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if(map.get(word2)==map.get(word1)){
                    return word1.compareTo(word2);
                }else{
                    return map.get(word2)-map.get(word1);
                }
            }
        });
    return list.subList(0,k);
    }
}
