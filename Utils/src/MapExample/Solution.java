package MapExample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","value1");
        map.put("2","value2");
        map.put("3","value3");
//使用KeySet
        System.out.println("通过Map.keySet遍历key和value：");
        for(String key : map.keySet()){
            System.out.println("key="+key+" and value ="+map.get(key));
        }

        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("key="+entry.getKey()+"and value="+entry.getValue());
        }

        System.out.println("通过Map.entrySet遍历key和value");
        //通过Map.entrySet遍历key和value 重点
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println("key= "+entry.getKey()+" and value= "+entry.getValue());
        }
//        key= 1 and value= value1
//        key= 2 and value= value2
//        key= 3 and value= value3
        System.out.println("通过Map.values()遍历所有的value，但不能遍历key");
        for (String v : map.values()) {
            System.out.println("value= " + v);
        }
    }

}
