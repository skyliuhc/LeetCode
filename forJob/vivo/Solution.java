package forJob.vivo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            int res =0;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                if(map.containsKey(arr[i])){
                    if(i-map.get(arr[i])>=1){
                        System.out.println("YES");
                        break;
                    }
                }else {
                    map.put(arr[i],i);
                }
            }
            System.out.println("NO");
        }
    }

}
