package Hot11;

public class Solution {
//    //暴力求解 超时
//    public int maxArea(int[] height) {
//        int n = height.length;
//        int maxArea = 0;
//        int minHeight;
//        for (int i = 0; i < n-1; i++) {
//            for (int j = i+1; j <n ; j++) {
//                // 首先得求i..j中最短的一块板子
//                minHeight=Math.min(height[i],height[j]);
//                maxArea=Math.max(maxArea,minHeight*(j-i));
//            }
//        }
//        return maxArea;
//    }

    public int maxArea(int[] height){
        int l =0, r=height.length-1;
        int ans = 0;
        while (l<r){
            int area =Math.min(height[l],height[r])*(r-l);
            ans = Math.max(ans,area);
            if (height[l]<=height[r]){
                ++l;
            }else{
                --r;
            }
        }
        return ans;
    }
}
