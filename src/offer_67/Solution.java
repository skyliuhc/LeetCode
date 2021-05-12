package offer_67;

/**
 * @author skyliuhc
 * @create 2021/5/6
 */
public class Solution {

    public int strToInt(String str){
        char[] c = str.trim().toCharArray();
        if(c.length==0) return 0;
        int res=0,boundry=Integer.MAX_VALUE/10;
        int i=1,sign=1;
        if(c[0]=='-') sign=-1;
        else if(c[0]!='+') i=0;//如果没有符号
        for (int j = i; j <c.length; j++) {
            if (c[j]<'0'||c[j]>'9') break;
            if(res>boundry||res==boundry&&c[j]>'7'){
                return sign==1 ? Integer.MAX_VALUE :Integer.MIN_VALUE;
            }
            res=res*10+(c[j]-'0');
        }
        return sign*res;
    }


}
