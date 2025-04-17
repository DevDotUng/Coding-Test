import java.io.*;
import java.util.*;

public class Main {

    static int P, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        List<List<Player>> rooms = new ArrayList<>();
        List<Integer> roomLevels = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        P = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        String id = input[1];
        int level = Integer.parseInt(input[0]);
        rooms.add(new ArrayList<>());
        rooms.get(0).add(new Player(id, level));
        roomLevels.add(level);

        for (int i = 0; i < P - 1; i++) {
            input = br.readLine().split(" ");
            id = input[1];
            level = Integer.parseInt(input[0]);

            boolean isAdd = false;
            for (int j = 0; j < rooms.size(); j++) {
                int roomLevel = roomLevels.get(j);
                if (level <= roomLevel + 10 && level >= roomLevel - 10 && rooms.get(j).size() < M) {
                    rooms.get(j).add(new Player(id, level));
                    isAdd = true;
                    break;
                }
            }

            if (!isAdd) {
                rooms.add(new ArrayList<>());
                rooms.get(rooms.size() - 1).add(new Player(id, level));
                roomLevels.add(level);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (List<Player> room: rooms) {
            if (room.size() == M) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            Collections.sort(room, (r1, r2) -> (r1.id.compareTo(r2.id)));
            for (int i = 0; i < room.size(); i++)
                sb.append(room.get(i).level).append(" ").append(room.get(i).id).append("\n");
        }

        System.out.print(sb);
    }
}

class Player {
    String id;
    int level;

    Player(String id, int level) {
        this.id = id;
        this.level = level;
    }
}