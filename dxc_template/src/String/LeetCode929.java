package String;

import java.util.HashSet;

public class LeetCode929 {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
//            int at = findstr(email, '@');
            int at = email.indexOf('@');//自带的api
            String name = "";
            for (char c : email.substring(0,at).toCharArray()) {
                if (c == '+') {
                    break;
                } else if (c != '.') {
                    name += c;
                }
            }
            String domain = email.substring(at + 1);
            set.add(name + "@" + domain);
        }
        return set.size();
    }

    int findstr(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }
}
