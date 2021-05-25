package Binary;

public class LeetCode69_mySqrt {
        public int mySqrt(int x) {
            int l =0;
            int r =x;
            while(l<r){
                int mid =(l+r+1)>>1;
                if(mid<=x/mid){
                    l=mid;
                }else{
                    r=mid-1;
                }
            }
            return r;
        }
}
