
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.lang.StringBuilder;

class Solution {
    public String solution(String X, String Y) {
        
        List<Character> couple = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                couple.add(c);
                map.put(c, map.get(c) - 1);
            }
        }
        
        if (couple.isEmpty()) return "-1";
        if (containsOnlyZero(couple)) return "0";
        
        Collections.sort(couple, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        
        for (char c: couple) {
            sb.append(c);
        }
        
        String answer = sb.toString();
        return answer;
    }
    
    public boolean containsOnlyZero(List<Character> couple) {
        for (char c: couple) {
            if (c != '0') return false;
        }
        return true;
    }
}