package com.acwing.offer_week1;

/**
 * @author skyliuhc
 * @create 2021-08-10-3:41 下午
 */
public class offer16_replaceSpace {
    public String replaceSpaces(StringBuffer str) {
        if(str==null) return null;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==' '){
                res.append("%20");
            }else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
