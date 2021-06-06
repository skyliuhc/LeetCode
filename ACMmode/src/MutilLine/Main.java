package MutilLine;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while(T>0){
            T--;
            //a和b用分别用来装测试用例的第二行和第三行
            int n =scan.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i <n ; i++) {
                a[i]=scan.nextInt();
            }
            for (int i = 0; i <n ; i++) {
                b[i]=scan.nextInt();
            }
            System.out.println(myFunc(a,b));
        }

    }
    //你的处理函数
    static int myFunc(int[] array1, int[] array2){
        return -1;
    }
}
