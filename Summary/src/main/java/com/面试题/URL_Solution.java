package com.面试题;

/**
 * @author skyliuhc
 * @create 2021-09-21-9:33 上午
 */
public class URL_Solution {
    public static String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int index = chars.length-1;
        for(int i=length-1;i>=0;i--){
            if(chars[i]==' '){
                chars[index--] = '0';
                chars[index--] = '2';
                chars[index--] = '%';
            }else{
                chars[index--] = chars[i];
            }
        }
        System.out.print(">>");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.print("<<");
        System.out.println();
        System.out.println(index);
        System.out.println(chars.length-index-1);
        return new String(chars,index+1,chars.length-index-1);
    }

    public static void main(String[] args) {
        String  s = "Mr John Smith    ";
        int n =  13;
        System.out.println(replaceSpaces(s,n));
    }
}
