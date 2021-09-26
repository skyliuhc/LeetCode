package com.huawei.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-08-25-7:41 下午
 */
public class Main3 {
    //在一个任务调度系统中，需要调度执行一系列到任务，任务之间存在依赖关系，如果任务A依赖B，则任务A必须在任务B完成后才能开始启动执行
    //现在给出n个任务的依赖关系与执行时间,n<=10000，清计算这n个任务执行完成所需要的时间
    //假设计算资源充足，允许任意多的任务并行执行，如果任务存在循环依赖，则输出-1
  public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int nt = Integer.parseInt(in.readLine());//几个任务
      List<Pair> list = new ArrayList<>();
      HashMap<Integer,Integer> map = new HashMap<>();
      for (int i = 0; i < nt; i++) {
          String[] strs = in.readLine().split(" ");
          String[] split = strs[0].split(",");
          for (String s : split) {
              int dependency = Integer.parseInt(s);
              if(dependency !=-1){
                  list.add(new Pair(i,dependency));//i依赖于dependency
              }
          }
          int time = Integer.parseInt(strs[1]);//计算所需要的时间
          map.put(i,time);
      }
      int size = list.size();
      int[][] prerq = new int[size][2];//先决条件
      int i = 0;
      for (Pair p : list) {
          prerq[i][0]=p.l;
          prerq[i][1]=p.r;
          i++;
      }
      int time = 0;
      int[] order = finderOrder(nt,prerq);
      for (int item : order) {
          time+=map.get(item);
      }
      if (time==0){
          System.out.println(-1);
      }else{
          System.out.println(time);
      }
  }

    private static int[] finderOrder(int numTask, int[][] preq) {
       int[] inds = new int[numTask];
       List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numTask; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] pre : preq) {
            inds[pre[0]]++;
            adjList.get(pre[1]).add(pre[0]);
        }
        Queue<Integer> queue = new LinkedList<>();//找出入度为0的节点，将其加入到队列中
        for (int i = 0; i < numTask; i++) {
            if (inds[i]==0) queue.offer(i);
        }
        int[] res = new int[numTask];
        int i= 0;
        while(!queue.isEmpty()){
            int top = queue.poll();
            res[i++] = top;
            numTask--;
            for (int  curNode : adjList.get(top)) {
                if(--inds[curNode ]==0){
                    queue.offer(curNode);
                }
            }
        }
        if (numTask==0) return res;
        else return new int[0];
    }

}
class Pair{
    int l;
    int r;

    public Pair(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
