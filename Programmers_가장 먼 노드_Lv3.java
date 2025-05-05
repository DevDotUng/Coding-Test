import java.util.*;

class Solution {
    
    static List<Node> list;
    static boolean[] visited;
    static boolean[][] node;
    
    public int solution(int n, int[][] edge) {
        
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        node = new boolean[n + 1][n + 1];
        
        for (int i = 0; i < edge.length; i++) {
            node[edge[i][0]][edge[i][1]] = true;
            node[edge[i][1]][edge[i][0]] = true;
        }
        
        bfs(n);
        
        Collections.sort(list, (n1, n2) -> (n1.count - n2.count));
        
        int count = list.get(list.size() - 1).count;
        int answer = 0;
        
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).count == count) answer++;
            else break;
        }
        
        return answer;
    }
    
    static void bfs(int a) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            list.add(n);
            
            for (int i = 1; i <= a; i++) {
                if (node[n.edge][i] && !visited[i]) {
                    queue.offer(new Node(i, n.count + 1));
                    visited[i] = true;
                }
            }
        }
    }
}

class Node {
    int edge;
    int count;
    
    Node(int edge, int count) {
        this.edge = edge;
        this.count = count;
    }
}