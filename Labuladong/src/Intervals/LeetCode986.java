package Intervals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode986 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        LinkedList<int[]> list = new LinkedList<>();
        while (i < firstList.length && j < secondList.length) {
            int a1 = firstList[i][0];
            int a2 = firstList[i][1];
            int b1 = secondList[j][0];
            int b2 = secondList[j][1];
            if(a2>=b1&&b2>=a1){
                int left=Math.max(a1,b1);
                int right=Math.min(a2,b2);
                list.add(new int[]{left,right});
            }
            if (b2>=a2){
                i++;
            }else{
                j++;
            }
        }
        int size = list.size();
        int[][] res = new int[size][];
        for (int k = 0; k < size; k++) {
            res[k] = list.poll();//用poll会快一点
        }
        return res;
        //下面比poll稍微慢一点
//        return list.toArray(new int[size][2]);
    }

}
