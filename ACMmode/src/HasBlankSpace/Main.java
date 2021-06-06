package HasBlankSpace;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextLine()){
            String[] s =sc.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                list.add(Integer.parseInt(s[i]));
            }
            Integer array[]=new Integer[list.size()];
            list.toArray(array);
            int[] ints = Arrays.stream(array).mapToInt(Integer::intValue).toArray();
            //solve();

        }
        String[] test = "123 456 789".split(" ");
        for (int i = 0; i < test.length; i++) {
            System.out.println(Integer.parseInt(test[i]));
        }
    }
}
