package WeekTest;

public class LeetCode5743 {
    //增长的内存泄露
    public int[] memLeak(int memory1, int memory2) {
        int time =1;
        while (Math.max(memory1,memory2)>=time){
            if (memory1>=memory2){
                memory1-=time;
            }else {
                memory2-=time;
            }
            time++;
        }
        return new int[]{time,memory1,memory2};
    }
    //之前想用递归，并不是很好
//    int[] dps(int m,int n,int time){
//        if(time>Math.max(m,n)){
//            return new int[]{time,m,n};
//        }else {
//            if (m>=n && m-time>=0){
//                return dps(m-time,n,time+1);
//            }else if (m<n && n-time>=0){
//                return dps(m,n-time,time+1);
//            }else {
//                return new int[]{time,m,n};
//            }
//        }
//    }

    public static void main(String[] args) {
        LeetCode5743 l1 = new LeetCode5743();
        int[] ints = l1.memLeak(2,2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
