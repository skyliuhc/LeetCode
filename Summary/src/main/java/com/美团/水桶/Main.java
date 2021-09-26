package com.美团.水桶;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author skyliuhc
 * @create 2021-09-25-4:47 下午
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int T = n;
        String[] a = br.readLine().split(" ");
        int i=0;
        while (T-- > 0) {
            q.offer(Integer.parseInt(a[i++]));
        }
        while (m-- > 0) {
            int poll = q.poll();
            poll += 1;
            q.offer(poll);
        }
        System.out.println(q.peek());
        br.close();
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        int T = n;
//        while (T-->0){
//            q.offer(sc.nextInt());
//        }
//        while (m-->0){
//            int poll = q.poll();
//            poll+=1;
//            q.offer(poll);
//        }
//        System.out.println(q.peek());
//    }

}
