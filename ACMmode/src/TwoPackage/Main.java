package TwoPackage;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //输入主串和子串
        Scanner input = new Scanner(System.in);
        String mainString = input.nextLine();
        String subString = input.nextLine();
        //判断方法调用
        boolean result = jugdeExist(mainString, subString);
        System.out.println(result);

    }

    //判断子串是否与主串的某段相等
    public static boolean jugdeExist(String mainString, String subString) {
        if (null == mainString) return false;
        String[] forArray = mainString.split(",");
        for (String Id : forArray) {
            if (Id.equals(subString))
                return true;
        }
        return false;
    }
}
