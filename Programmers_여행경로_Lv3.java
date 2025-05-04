import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        
        boolean[] useTicket = new boolean[tickets.length];
        List<String> answerList = new ArrayList<>();
        
        dfs(0, "ICN", useTicket, "ICN", answerList, tickets);
        Collections.sort(answerList);
        
        String[] answer = answerList.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(int depth, String now, boolean[] useTicket, String path, List<String> answerList, String[][] tickets) {
        if (depth == tickets.length) {
            answerList.add(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!useTicket[i] && tickets[i][0].equals(now)) {
                useTicket[i] = true;
                dfs(depth + 1, tickets[i][1], useTicket, path + " " + tickets[i][1], answerList, tickets);
                useTicket[i] = false;
            }
        }
    }
}