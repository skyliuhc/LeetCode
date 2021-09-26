package com.honor.my;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author skyliuhc
 * @create 2021-09-14-6:36 下午
 */
public class Main2 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       ArrayList<People> peoples = new ArrayList<>();
       int id = 0;
       while (sc.hasNextLine()){
           String[] line = sc.nextLine().split(":");
           for (String s : line) {
               System.out.println(s);
           }
           String name = line[0];
           String[] stepsStr = line[1].split(" ");
           People p = new People();
           p.name = name;
           p.id = id++;
           int n2 = 0;
           int n3 = 0;
           int n4 = 0;
           int n5 = 0;
           int n2Idx = 0 ;
           for (int i = 0; i < stepsStr.length; i++) {
               int num = Integer.parseInt(stepsStr[i]);
               p.steps+=num;
               if (num<5000){
                   n5++;
               }else if(num<10000){
                   n4++;
               }else {
                   n3++;
                   if (num>30000){
                       n2++;
                       n2Idx=i;
                   }
               }
           }
           if (n2>=4){
               for (int i = n2Idx - 1; i > 0; i--) {
                   int num = Integer.parseInt(stepsStr[i]);
                   if(num>30000){
                       if (n2Idx-i<=4){
                           break;
                       }
                       n2Idx=i;
                   }
               }
               p.priority=2;
           }else {
               if (n3>15) p.priority = 3;
               else if (n4>15) p.priority = 4;
               else if (n5>18) p.priority = 5;
           }
           peoples.add(p);
       }
       peoples.sort(new Comparator<People>() {
           @Override
           public int compare(People o1, People o2) {
               if (o1.priority==o2.priority){
                   if(o1.steps==o2.steps){
                       return o1.id-o2.id;
                   }else {
                       return o2.steps - o1.steps;
                   }
               }else {
                   return o1.priority-o2.priority;
               }
           }
       });
       for (People people : peoples) {
            String out = "";
            if (people.priority==5){
                out="bad";
            }else if (people.priority==4){
                out="good";
            }else {
                out="excellent";
            }
            System.out.println(people.name+":"+out+" "+people.steps);
        }
    }
}
class People{
    int id;
    int steps;
    int priority = Integer.MIN_VALUE;
    String name;
}
