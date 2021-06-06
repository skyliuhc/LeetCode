package NotKnown;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Long mod = 1000000007l;
        while(input.hasNext()){
            Long n = input.nextLong();
            Long l = input.nextLong();
            if(n==0&&l==0){
                break;
            }
            System.out.println(solve(n,l)%mod);
        }
    }

    private static int solve(Long n, Long l) {
        return 0;
    }
}
