package com.offer2.HashMap;

import java.util.*;

/**
 * @author skyliuhc
 * @create 2021-08-18-2:24 上午
 */
public class offer2_30 {
    class RandomizedSet {

        Map<Integer, Integer> dict;
        List<Integer> list;
        Random rand = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            dict = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (dict.containsKey(val)) {
                return false;
            }

            dict.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!dict.containsKey(val)) return false;
            //这一步是为了保证其他元素的索引是正确的，不受删除元素的影响
            // move the last element to the place idx of the element to delete
            int lastElement = list.get(list.size() - 1);
            int idx = dict.get(val);
            list.set(idx, lastElement);
            dict.put(lastElement, idx);
            // delete the last element
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
        //nextInt(int n)函数表示随机生成[0,n)
    }
}
