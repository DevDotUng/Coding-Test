import java.io.*;
import java.util.*;

public class Main {

    static int n, m, invisibleArea = 64;
    static int[] dirs;
    static int[][] office;
    static List<CCTV> cctvs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        office = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int type = Integer.parseInt(input[j]);
                if (type == 6) office[i][j] = type;
                if (type > 0 && type < 6) cctvs.add(new CCTV(i, j, type, 0));
            }
        }

        dirs = new int[cctvs.size()];

        dfs(0);

        System.out.println(invisibleArea);
    }

    static void dfs(int depth) {
        if (depth == dirs.length) {
            for (int i = 0; i < dirs.length; i++) {
                cctvs.get(i).dir = dirs[i];
            }

            for (CCTV cctv: cctvs) {
                office[cctv.x][cctv.y] = -1;

                if (cctv.type == 1) {

                    if (cctv.dir == 0)
                    // 위
                    for (int i = cctv.x; i >= 0; i--) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    if (cctv.dir == 1)
                    // 아래
                    for (int i = cctv.x; i < n; i++) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    if (cctv.dir == 2)
                    // 왼쪽
                    for (int i = cctv.y; i >= 0; i--) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }
                    if (cctv.dir == 3)
                    // 오른쪽
                    for (int i = cctv.y; i < m; i++) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }

                } else if (cctv.type == 2) {

                    if (cctv.dir == 0 || cctv.dir == 2)
                    // 위
                    for (int i = cctv.x; i >= 0; i--) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    if (cctv.dir == 0 || cctv.dir == 2)
                    // 아래
                    for (int i = cctv.x; i < n; i++) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    if (cctv.dir == 1 || cctv.dir == 3)
                    // 왼쪽
                    for (int i = cctv.y; i >= 0; i--) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }
                    if (cctv.dir == 1 || cctv.dir == 3)
                    // 오른쪽
                    for (int i = cctv.y; i < m; i++) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }

                } else if (cctv.type == 3) {

                    if (cctv.dir == 0 || cctv.dir == 3)
                    // 위
                    for (int i = cctv.x; i >= 0; i--) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    if (cctv.dir == 1 || cctv.dir == 2)
                    // 아래
                    for (int i = cctv.x; i < n; i++) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    if (cctv.dir == 2 || cctv.dir == 3)
                    // 왼쪽
                    for (int i = cctv.y; i >= 0; i--) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }
                    if (cctv.dir == 0 || cctv.dir == 1)
                    // 오른쪽
                    for (int i = cctv.y; i < m; i++) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }

                } else if (cctv.type == 4) {

                    if (cctv.dir != 2)
                    // 위
                    for (int i = cctv.x; i >= 0; i--) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    if (cctv.dir != 0)
                    // 아래
                    for (int i = cctv.x; i < n; i++) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    if (cctv.dir != 1)
                    // 왼쪽
                    for (int i = cctv.y; i >= 0; i--) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }
                    if (cctv.dir != 3)
                    // 오른쪽
                    for (int i = cctv.y; i < m; i++) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }

                } else if (cctv.type == 5) {
                    // 위
                    for (int i = cctv.x; i >= 0; i--) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    // 아래
                    for (int i = cctv.x; i < n; i++) {
                        if (office[i][cctv.y] <= 0) office[i][cctv.y] = -1;
                        else break;
                    }
                    // 왼쪽
                    for (int i = cctv.y; i >= 0; i--) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }
                    // 오른쪽
                    for (int i = cctv.y; i < m; i++) {
                        if (office[cctv.x][i] <= 0) office[cctv.x][i] = -1;
                        else break;
                    }
                }
            }

            invisibleArea = Math.min(getInvisibleArea(), invisibleArea);

            officeInit();

            return;
        }

        for (int i = 0; i < 4; i++) {
            dirs[depth] = i;
            dfs(depth + 1);
        }
    }

    static int getInvisibleArea() {
        int invisibleAreaTmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == 0) invisibleAreaTmp++;
            }
        }
        return invisibleAreaTmp;
    }

    static void officeInit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == -1) office[i][j] = 0;
            }
        }
    }
}

class CCTV {
    int x;
    int y;
    int type;
    int dir;

    CCTV(int x, int y, int type, int dir) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.dir = dir;
    }
}