package forJob.vivo;

import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int res =0;
        while(sc.hasNext()){
            String bianhao = sc.next();
            if(bianhao.contains("7")){
                res+=1;
            }else{
                int value = Integer.parseInt(bianhao);
                if(value!=0 && value%7==0){
                    res+=1;
                }
            }
        }
        System.out.println(res);
    }
}
