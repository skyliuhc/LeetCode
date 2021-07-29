package LeetCode1418;

import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> name = new HashSet<String>();
        Map<Integer,Map<String,Integer>> foodsCnt=new HashMap<Integer, Map<String,Integer>>();
        for (List<String> order : orders) {
            String foodname=order.get(2);
            name.add(foodname);
            int id = Integer.parseInt(order.get(1));
            Map<String,Integer> map = foodsCnt.getOrDefault(id,new HashMap<String,Integer>());
            map.put(foodname,map.getOrDefault(foodname,0)+1);
            foodsCnt.put(id, map);
        }
        int n =name.size();
        List<String> names = new ArrayList<String>();
        for (String s : name) {
            names.add(s);
        }
        Collections.sort(names);
        int m = foodsCnt.size();
        List<Integer> ids = new ArrayList<Integer>();
        for (int id : foodsCnt.keySet()) {
            ids.add(id);
        }
        Collections.sort(ids);
        // 填写点菜展示表
        List<List<String>> table = new ArrayList<List<String>>();
        List<String> header = new ArrayList<String>();
        header.add("Table");
        for (String s : names) {
            header.add(s);
        }
        table.add(header);
        for (int i = 0; i < m; ++i) {
            int id = ids.get(i);
            Map<String, Integer> cnt = foodsCnt.get(id);
            List<String> row = new ArrayList<String>();
            row.add(Integer.toString(id));
            for (int j = 0; j < n; ++j) {
                row.add(Integer.toString(cnt.getOrDefault(names.get(j), 0)));
            }
            table.add(row);
        }
        return table;
    }
}