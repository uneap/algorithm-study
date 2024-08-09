import static java.lang.Integer.highestOneBit;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미네랄 {
    // 막대를 던짐, 홀이면 오른 쪽부터, 짝이면 왼쪽부터 삭제
    // 막대를 던진 위치부터 bfs 를 통해 미네랄이 분리되었는지 확인
    // 분리된 미네랄 위치를 저장
    // x를 빼면서 위치시킴
    // 반복
    static String[][] lands;
    static int R,C;
    public static class Stone {
        int x;
        int y;
        int cluster;
        public Stone(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = parseInt(st.nextToken());
        C = parseInt(st.nextToken());
        lands = new String[R + 1][C];
        for(int i = R; i >= 1; i--) {
             String line = br.readLine();
             String[] lines = line.split("");
            for(int j = 0; j < C; j++) {
                lands[i][j] = lines[j];
            }
        }
        int count = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++) {
            int fightLand = parseInt(st.nextToken());
            List<Stone> floatLands = fight(fightLand, i);
            if(floatLands == null) {
                continue;
            }
            moveMineral(floatLands);
        }
        print();
    }
    public static void print() {
        for(int i = R; i > 0; i--) {
            for(int j = 0; j < C; j++) {
                System.out.print(lands[i][j]);
            }
            System.out.println();
        }
    }
    public static List<Stone> fight(int fightLand, int i) {
        int j;
        if(i % 2 == 0) {
            j = 0;
            while(j < C) {
                if(lands[fightLand][j].equals("x")) {
                    lands[fightLand][j] = ".";
                    return floatLand();
                }
                j++;
            }
        } else {
            j = C - 1;
            while(j >= 0) {
                if(lands[fightLand][j].equals("x")) {
                    lands[fightLand][j] = ".";
                    return floatLand();
                }
                j--;
            }
        }
        return null;
    }
    public static boolean isLand() {
        for(int i = 0; i < C; i++) {
            if(lands[1][i].equals("x")) {
                return false;
            }
        }
        return true;
    }
    public static List<Stone> floatLand() {
        boolean[][] visit = new boolean[R + 1][C];
        List<Stone> stones = null;
        int count = 0;
        for(int i = R; i >= 1; i--) {
            for(int j = 0; j < C; j++) {
                if(visit[i][j]) {
                    continue;
                }
                if(lands[i][j].equals("x")) {
                    count++;
                    if(count > 1) {
                        return stones;
                    }
                    stones = storeLocation(visit, new Stone(i,j));
                }
            }
        }
        if(count == 1 && isLand()) {
            return stones;
        }
        return null;
    }
    public static List<Stone> storeLocation(boolean[][] visit, Stone stone) {
        Queue<Stone> q = new LinkedList<>();
        List<Stone> stones = new ArrayList<>();
        int[] directX = {1,-1,0,0};
        int[] directY = {0,0,1,-1};
        q.add(stone);
        visit[stone.x][stone.y] = true;
        while(!q.isEmpty()) {
            Stone newStone = q.poll();
            for(int i = 0; i < 4; i++) {
                int dx = directX[i] + newStone.x;
                int dy = directY[i] + newStone.y;
                if(dx < 1 || dy < 0 || dx > R || dy >= C) {
                    continue;
                }
                if(visit[dx][dy]) {
                    continue;
                }
                if(lands[dx][dy].equals(".")) {
                    continue;
                }
                q.add(new Stone(dx, dy));
                visit[dx][dy] = true;
            }
        }
        for(int i = 1; i <= R; i++) {
            for(int j = 0; j < C; j++) {
                if(visit[i][j]) {
                    stones.add(new Stone(i, j));
                }
            }
        }
        return stones;
    }
    public static void moveMineral(List<Stone> floatLocations){
        for(Stone stone : floatLocations) {
            lands[stone.x][stone.y] = ".";
        }
        int move = 1;
        outerLoop:
        while(true) {
            for (Stone stone : floatLocations) {
                if (stone.x - move == 0 || lands[stone.x - move][stone.y].equals("x")) {
                    move--;
                    break outerLoop;
                }
            }
            move++;
        }

        for(Stone stone : floatLocations) {
            lands[stone.x - move][stone.y] = "x";
        }
    }
}
