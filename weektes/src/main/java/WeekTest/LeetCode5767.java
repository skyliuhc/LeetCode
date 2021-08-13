package WeekTest;

public class LeetCode5767 {
    //检查是否区域内所有整数都被覆盖
    public boolean isCovered(int[][] ranges, int left, int right) {
        for(int i=left;i<=right;i++){
            boolean isFlage = false;
            for(int[] r:ranges){
                int x=r[0];
                int y=r[1];
                if(i>=x && i<=y){
                    isFlage = true;
                }
            }
            if(!isFlage){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(2>>1);
    }
}
