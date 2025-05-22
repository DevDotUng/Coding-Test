import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> valueStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (valueStack.isEmpty()) {
                valueStack.push(numbers[i]);
                indexStack.push(i);
                continue;
            }
            
            while (true) {
                if (valueStack.isEmpty()) {
                    valueStack.push(numbers[i]);
                    indexStack.push(i);
                    break;
                }
                
                if (valueStack.peek() < numbers[i]) {
                    answer[indexStack.pop()] = numbers[i];
                    valueStack.pop();
                } else {
                    valueStack.push(numbers[i]);
                    indexStack.push(i);
                    break;
                }
            }
        }
        
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}