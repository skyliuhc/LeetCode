package Hot20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    public boolean isValid(String s) {
        int n= s.length();
        //base case 因为要成双成对的出现所以
        if (n%2==1){
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if (s.isEmpty()||stack.peek()!=map.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
