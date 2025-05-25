import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> termsMap = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < terms.length; i++) {
            termsMap.put(terms[i].split(" ")[0], Integer.parseInt(terms[i].split(" ")[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i].split(" ")[0];
            String term = privacies[i].split(" ")[1];
            
            String deadline = getDeadline(privacy, termsMap.get(term));
            
            if (deadline.compareTo(today) < 0) {
                answerList.add(i + 1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    String getDeadline(String privacy, int term) {
        String[] splitString = privacy.split("\\.");
        
        int year = Integer.parseInt(splitString[0]);
        int month = Integer.parseInt(splitString[1]);
        int day = Integer.parseInt(splitString[2]);
        
        int days = year * 12 * 28 + month * 28 + day;
        
        days += term * 28 - 1;
        year = days / 336;
        month = (days % 336) / 28;
        day = (days % 336) % 28;
        
        if (month == 0) {
            year -= 1;
            month = 12;
        }
        
        if (day == 0) {
            month -= 1;
            day = 28;
        }
        
        if (month == 0) {
            year -= 1;
            month = 12;
        }
        
        String yearString = Integer.toString(year);
        String monthString = month < 10 ? "0" + month : Integer.toString(month);
        String dayString = day < 10 ? "0" + day : Integer.toString(day);
        
        return yearString + "." + monthString + "." + dayString;
    }
}