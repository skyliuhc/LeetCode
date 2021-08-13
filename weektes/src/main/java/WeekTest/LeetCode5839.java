package WeekTest;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author skyliuhc
 * @create 2021-08-08-11:45 上午
 */
public class LeetCode5839 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });//大根堆
        int res =0;
        for (int pile : piles) {
            q.offer(pile);
        }
        while (k-->0){
            Integer peek = q.peek();
            int value = peek.intValue();
            value=value/2;
            q.poll();
            q.offer(value);
        }
        while(!q.isEmpty()){
            res+=q.poll();
        }
        return  res;
    }
}
