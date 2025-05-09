import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        
        Stack<String[]> planStack = new Stack<>();
        Stack<String[]> overdueStack = new Stack<>();
        List<String> answerList = new ArrayList<>();
        
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] s1, String[] s2) {
                return s1[1].compareTo(s2[1]);
            }
        });
        
        for (int i = plans.length - 1; i >= 0; i--) {
            planStack.push(plans[i]);
        }
        
        String time = planStack.peek()[1];
        while (true) {
            
            if (planStack.empty() && overdueStack.empty()) {
                break;
            }
            
            String[] playing;
            String[] nextPlan;
            String type;
            if (planStack.empty()) {
                playing = overdueStack.pop();
                type = "overdue";
                answerList.add(playing[0]);
                continue;
            } else if (overdueStack.empty()) {
                playing = planStack.pop();
                type = "plan";
                if (planStack.empty()) {
                    answerList.add(playing[0]);
                    continue;
                }
                nextPlan = planStack.peek();
            } else {
                if (time.compareTo(planStack.peek()[1]) < 0) {
                    playing = overdueStack.pop();
                    type = "overdue";
                } else {
                    playing = planStack.pop();
                    type = "plan";
                    if (planStack.empty()) {
                        answerList.add(playing[0]);
                        continue;
                    }
                }
                nextPlan = planStack.peek();
            }
            
            String end;
            if (type.equals("plan")) {
                end = getEnd(playing[1], playing[2]);
            } else {
                end = getEnd(time, playing[2]);
            }
            
            if (end.compareTo(nextPlan[1]) > 0) {
                if (type.equals("plan")) {
                    playing[2] = getRestTime(nextPlan[1], playing[1], playing[2]);
                } else {
                    playing[2] = getRestTime(nextPlan[1], time, playing[2]);
                }
                
                time = nextPlan[1];
                overdueStack.push(playing);
            } else {
                time = end;
                answerList.add(playing[0]);
            }
        }
        
        String[] answer = new String[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    static String getEnd(String start, String playTime) {
        String[] time = start.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int playTimeInt = Integer.parseInt(playTime);
        
        hour += (playTimeInt + minute) / 60;
        minute = (playTimeInt + minute) % 60;
        
        String hourString;
        String minuteString;
        
        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = Integer.toString(hour);
        }
        
        if (minute < 10) {
            minuteString = "0" + minute;
        } else {
            minuteString = Integer.toString(minute);
        }
        
        return hourString + ":" + minuteString;
    }
    
    static String getRestTime(String time1, String time2, String playTime) {
        String[] spliteTime1 = time1.split(":");
        String[] spliteTime2 = time2.split(":");
        int playTimeInt = Integer.parseInt(playTime);
        
        int hour1 = Integer.parseInt(spliteTime1[0]);
        int minute1 = Integer.parseInt(spliteTime1[1]);
        
        int hour2 = Integer.parseInt(spliteTime2[0]);
        int minute2 = Integer.parseInt(spliteTime2[1]);
        
        return Integer.toString(playTimeInt - (hour1 * 60 + minute1) + (hour2 * 60 + minute2));
    }
}