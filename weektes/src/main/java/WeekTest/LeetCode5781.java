package WeekTest;

public class LeetCode5781 {
    public String removeOccurrences(String s, String part) {
        int l = part.length();
        while(s.contains(part)){
            int i = s.indexOf(part);
            s=s.substring(0,i)+s.substring(i+l);
        }
        return  s;
    }
}
