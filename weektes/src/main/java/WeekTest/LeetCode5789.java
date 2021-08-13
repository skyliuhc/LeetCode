package WeekTest;

public class LeetCode5789 {
    public int numberOfRounds(String startTime, String finishTime) {
        int sh = Integer.parseInt(startTime.substring(0, 2));
        int sm = Integer.parseInt(startTime.substring(3, 5));
        int fh = Integer.parseInt(finishTime.substring(0, 2));
        int fm = Integer.parseInt(finishTime.substring(3, 5));
        int res = 0;
        if (fh*60 +fm>=sh*60*sm) {

           res=get(sh,sm,fh,fm);
        }else{
            res+=get(sh,sm,24,0)+get(0,0,fh,fm);
        }
        return res;
    }
    public int get(int sh, int sm, int fh, int fm){
        int res =0;
        if (sm % 15 != 0) {//没有赶上游戏开始
            sm = (sm / 15 + 1) * 15;
        }
        res = (fm - sm+(fh-sh)*60) / 15;
        return res;
    }

}
