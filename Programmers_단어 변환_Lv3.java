class Solution {
    
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        dfs(0, begin, target, words, visited);
        
        return answer;
    }
    
    static void dfs(int depth, String word, String target, String[] words, boolean[] visited) {
        if (word.equals(target)) {
            answer = depth;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canChange(word, words[i])) {
                visited[i] = true;
                dfs(depth + 1, words[i], target, words, visited);
                visited[i] = false;
            }
        }
    }
    
    static boolean canChange(String begin, String target) {
        int length = begin.length();
        int diff = 0;
        
        for (int i = 0; i < length; i++) {
            if (begin.charAt(i) != target.charAt(i))
                diff++;
        }
        
        return diff == 1 ? true : false;
    }
}