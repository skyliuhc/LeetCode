package com.AcDream.Order;

/**
 * @author skyliuhc
 * @create 2021-10-12-10:01 下午
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(9);
        list.add(4);
        list.add(3);
        list.add(1);
//        System.out.println("排序之前：");
//        list.forEach(System.out::print);
//        Collections.sort(list);
//        System.out.println();
//        System.out.println("排序之后：");
//        list.forEach(System.out::print);
//        Collections.reverse(list);
//        System.out.println();
//        System.out.println("逆序之后：");
//        list.forEach(System.out::print);
//        Collections.reverse(list);

        int[] nums = {5,9,4,3,1};
        Arrays.sort(nums);
        Collections.sort(list,Collections.reverseOrder());
        list.forEach(System.out::print);

    }
}
