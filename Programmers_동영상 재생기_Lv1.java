class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video_len_int = timeToInteger(video_len);
        int pos_int = timeToInteger(pos);
        int op_start_int = timeToInteger(op_start);
        int op_end_int = timeToInteger(op_end);
        
        int current = pos_int;
        
        for (String c: commands) {
            if (current >= op_start_int && current <= op_end_int) current = op_end_int;
            if (c.equals("prev")) current = prev(current);
            else current = next(current, video_len_int);
        }
        
        if (current >= op_start_int && current <= op_end_int) current = op_end_int;
        
        String minute = current / 60 < 10 ? "0" + Integer.toString(current / 60) : Integer.toString(current / 60);
        String second = current % 60 < 10 ? "0" + Integer.toString(current % 60) : Integer.toString(current % 60);
        
        String answer = minute + ":" + second;
        return answer;
    }
    
    int timeToInteger(String time) {
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    int prev(int time) {
        if (time < 10) return 0;
        else return time - 10;
    }
    
    int next(int time, int video_len) {
        if (time > video_len - 10) return video_len;
        else return time + 10;
    }
}