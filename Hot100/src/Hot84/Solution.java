package Hot84;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0){
            return 0;
        }
        int[] lessFromLeft = new int[heights.length];
        //比 lessFromLeft[i] 存的是比heights[i]大的最小的索引
        int[] lessFromRight = new int[heights.length];
        //比 lessFromRight[i] 存的是比heights[i]大的最大的索引
        lessFromRight[heights.length-1] = heights.length;
        lessFromLeft[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            int p =i-1;
            while (p>= 0&& heights[p]>=heights[i]){
                p=lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for (int i = heights.length-2; i >=0; i--) {
            int p =i+1;
            while (p<heights.length&& heights[p]>=heights[i]){
                p=lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea=Math.max(maxArea,heights[i]*(lessFromRight[i]-lessFromLeft[i]-1));
        }
        return maxArea;
    }


}
