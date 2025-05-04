class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        int answer = count;
        return answer;
    }
    
    void dfs(int[] numbers, int depth, int target, int result) {
        if (depth == numbers.length) {
            if (result == target) {
                count++;
            }
            return;
        }
        
        dfs(numbers, depth + 1, target, result + numbers[depth]);
        dfs(numbers, depth + 1, target, result - numbers[depth]);
    }
}