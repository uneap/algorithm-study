import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HotPlanet {
    public static class Rectangle {
        int minX;
        int minY;
        int maxX;
        int maxY;

        public Rectangle(int minX, int minY, int maxX, int maxY) {
            this.minX = minX;
            this.minY = minY;
            this.maxX = maxX;
            this.maxY = maxY;
        }

        public void renew(int x, int y) {
            this.minY = Math.min(y, minY);
            this.maxY = Math.max(y, maxY);
            this.minX = Math.min(x, minX);
            this.maxX = Math.max(x, maxX);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Rectangle rectangle = new Rectangle(R,C,0,0);
        char[][] places = new char[R][C];
        for(int i = 0; i < R; i++) {
            String place = br.readLine();
            for(int j = 0; j < C; j++) {
                places[i][j] = place.charAt(j);
            }
        }
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                startSink(places, i, j, rectangle);
            }
        }
        for(int i = rectangle.minX; i <= rectangle.maxX; i++) {
            for(int j = rectangle.minY; j <= rectangle.maxY; j++) {
                if(places[i][j] == '*') {
                    places[i][j] = '.';
                }
                System.out.print(places[i][j]);
            }
            System.out.println();
        }
    }

    public static int get4WaySink(char[][] places, int x, int y) {
        int count = 0;
        int[] directX = {0,0,1,-1};
        int[] directY = {1,-1,0,0};
        for (int i = 0; i < 4; i++) {
            int dx = x + directX[i];
            int dy = y + directY[i];
            if(dx >= 0 && dy >= 0 && dx < places.length && dy < places[0].length) {
                if(places[dx][dy] == '.') {
                    count++;
                }
            } else {
                count++;
            }
        }
        return count;
    }
    public static void startSink(char[][] places, int x, int y, Rectangle rectangle) {
        int count = 0;
        if(places[x][y] == 'X'){
        count = get4WaySink(places, x, y);
            if(count >= 3) {
                places[x][y] = '*';
            }
        }
        if(places[x][y] == 'X') {
            rectangle.renew(x, y);
        }
    }
}
