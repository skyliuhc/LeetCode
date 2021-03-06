package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author skyliuhc
 * @Description
 * @Date 2021-05-09-10:15 上午
 */
public class LeetCode752 {

    public int openLock(String[] deadends, String target) {
        //记录需要跳过的死亡密码
        Set<String> deads =new HashSet<>();
        for(String s:deadends){
            deads.add(s);
        }
        Set<String> visited =new HashSet<>();
        Queue<String> q = new LinkedList<>();
        //从起点开始启动广度优先搜索
        int step =0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()){
            int sz=q.size();
            for (int i = 0; i < sz; i++) {
                String cur=q.poll();
                if(deads.contains(cur))
                    continue;
                if(cur.equals(target))
                    return step;
                for (int j = 0; j < 4; j++) {
                    String up=plusOne(cur,j);
                    if(!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    String down =minusOne(cur,j);
                    if(!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }

            }
            step++;
        }
        return -1;
    }
    //将s[j]向上波动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }



}
