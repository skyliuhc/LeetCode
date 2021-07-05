package LeetCode451;

/**
 * @author skyliuhc
 * @create 2021-07-03-12:43 上午
 */
public class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int[] c = new int[256];
        for (int i = 0; i < s.length(); i++) {
            c[chars[i]]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >0 ;i-- ) {
            int max =0;
            int maxIndex=0;
            for (int j = 0; j < 256; j++) {
                if(c[j]>max) {
                    max =  c[j];
                    maxIndex = j;
                }
            }
            for (int k = 0; k < max; k++) {
                sb.append((char)maxIndex);
            }
            c[maxIndex] = 0;
            // i=i-max+1;
            i-=max-1;

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a = 'A';
        System.out.println(a);
    }
}
