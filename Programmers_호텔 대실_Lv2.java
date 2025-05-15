import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        List<List<String[]>> schedule = new ArrayList<>();
        
        for (int i = 0; i < book_time.length; i++) {
            book_time[i][1] = getEndTime(book_time[i][1]);
        }
        
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return s1[0].compareTo(s2[0]);
            }
        });
        
        for (int i = 0; i < book_time.length; i++) {
            boolean isAdd = false;
            for (int j = 0; j < schedule.size(); j++) {
                if (schedule.get(j).get(schedule.get(j).size() - 1)[1].compareTo(book_time[i][0]) <= 0) {
                    schedule.get(j).add(book_time[i]);
                    isAdd = true;
                    break;
                }
            }
            
            if (!isAdd) {
                schedule.add(new ArrayList<>());
                schedule.get(schedule.size() - 1).add(book_time[i]);
            }
        }
        
        int answer = schedule.size();
        return answer;
    }
    
    static String getEndTime(String time) {
        String[] splitTime = time.split(":");
        
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);
        
        hour += (minute + 10) / 60;
        minute = (minute + 10) % 60;
        
        String result = "";
        
        if (hour < 10) {
            result += "0" + hour;
        } else {
            result += hour;
        }
        
        result += ":";
        
        if (minute < 10) {
            result += "0" + minute;
        } else {
            result += minute;
        }
        
        return result;
    }
}