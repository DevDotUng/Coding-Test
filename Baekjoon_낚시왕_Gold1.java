import java.io.*;
import java.util.*;

public class Main {

    static int r, c, m;
    static int[] dr = {0, -1, 1, 0, 0}, dc = {0, 0, 0, 1, -1};
    static List<Shark> sharks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int answer = 0;

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[2]);

        sharks = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            sharks.add(new Shark(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4])));
        }

        sharkSort();

        for (int i = 1; i <= c; i++) {
            for (int j = 0; j < sharks.size(); j++) {
                if (sharks.get(j).c == i) {
                    answer += sharks.remove(j).z;
                    break;
                }
            }

            for (int j = 0; j < sharks.size(); j++) {

                if (sharks.get(j).d == 1 || sharks.get(j).d == 2) {
                    for (int k = 0; k < sharks.get(j).s % ((r - 1) * 2); k++) {
                        int nextR = sharks.get(j).r + dr[sharks.get(j).d];
                        int nextC = sharks.get(j).c + dc[sharks.get(j).d];
    
                        if (nextR >= 1 && nextR <= r && nextC >= 1 && nextC <= c) {
                            sharks.get(j).r = nextR;
                            sharks.get(j).c = nextC;
                        } else {
                            if(sharks.get(j).d == 1) sharks.get(j).d = 2;
                            else sharks.get(j).d = 1;
    
                            nextR = sharks.get(j).r + dr[sharks.get(j).d];
                            nextC = sharks.get(j).c + dc[sharks.get(j).d];
    
                            sharks.get(j).r = nextR;
                            sharks.get(j).c = nextC;
                        }
                    }
                } else {
                    for (int k = 0; k < sharks.get(j).s % ((c - 1) * 2); k++) {
                        int nextR = sharks.get(j).r + dr[sharks.get(j).d];
                        int nextC = sharks.get(j).c + dc[sharks.get(j).d];
    
                        if (nextR >= 1 && nextR <= r && nextC >= 1 && nextC <= c) {
                            sharks.get(j).r = nextR;
                            sharks.get(j).c = nextC;
                        } else {
                            if(sharks.get(j).d == 3) sharks.get(j).d = 4;
                            else sharks.get(j).d = 3;
    
                            nextR = sharks.get(j).r + dr[sharks.get(j).d];
                            nextC = sharks.get(j).c + dc[sharks.get(j).d];
    
                            sharks.get(j).r = nextR;
                            sharks.get(j).c = nextC;
                        }
                    }
                }
            }

            sharkSort();

            if (sharks.size() >= 2) {
                Shark preShark = sharks.get(sharks.size() - 1);
                for (int j = sharks.size() - 2; j >= 0; j--) {
                    if (preShark.r == sharks.get(j).r && preShark.c == sharks.get(j).c) {
                        sharks.remove(j);
                    } else {
                        preShark = sharks.get(j);
                    }
                }
            }
        }

        System.out.println(answer);
    } 

    static void sharkSort() {
        Collections.sort(sharks, (s1, s2) -> (s1.c == s2.c ? s1.r == s2.r ? s1.z - s2.z : s1.r - s2.r : s1.c - s2.c));
    }
}

class Shark {
    int r;
    int c;
    int s;
    int d;
    int z;

    Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}