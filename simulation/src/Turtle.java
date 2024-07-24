import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 움직일 수 있는 건 상하 좌우인데 방향을 바꿈.
//최대 직사각형 만들기
// 0 -1, 1 0, -1 0, 0 1
// 1 -1 1 0 -1 0 0 1
//   .
// . . .
// .
public class Turtle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        while(n-- > 0) {
            String direction = br.readLine();
            System.out.println(move(direction));
        }
    }

    public static int maxRectangleSize(int minDx, int maxDx, int minDy, int maxDy) {
        return (Math.abs(maxDx - minDx)) * (Math.abs(maxDy - minDy));
    }

    // 0,0
    // 북 앞 0,-1
    // 북 뒤 0, 1
    // L 앞 -1, 0
    // L 뒤 1, 0
    // LL 앞 0, 1
    // LL 뒤 0 ,-1
    // LLL 앞 1, 0
    // LLL 뒤 -1, 0 반복
    // R 앞 1, 0
    // R 뒤 -1, 0
    // RR 앞 0, 1
    // RR 뒤 0 ,-1
    // LL 앞 위와 동일
    // LL 뒤
    // LLRR 0
    // LRR R1
    // LLRRR R1
    // LLLR L2
    public static int move(String direction) {
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;
        int[] leftFrontX = {0,-1,0,1};
        int[] leftFrontY = {-1,0,1,0};
        int[] leftBackX = {0,1,0,-1};
        int[] leftBackY = {1,0,-1,0};
        int[] rightFrontX = {0,1,0,-1};
        int[] rightFrontY = {-1,0,1,0};
        int[] rightBackX = {0,-1,0,1};
        int[] rightBackY = {1,0,-1,0};
        int lRotation = 0;
        int rRotation = 0;
        int x = 0;
        int y = 0;
        for(int i = 0; i < direction.length(); i++) {
            if(direction.charAt(i) == 'F') {
                if(lRotation > rRotation) {
                    x += leftFrontX[lRotation - rRotation];
                    y += leftFrontY[lRotation - rRotation];
                } else  {
                    x += rightFrontX[rRotation - lRotation];
                    y += rightFrontY[rRotation - lRotation];
                }
            }
            if(direction.charAt(i) == 'B') {
                if(lRotation > rRotation) {
                    x += leftBackX[lRotation - rRotation];
                    y += leftBackY[lRotation - rRotation];
                } else  {
                    x += rightBackX[rRotation - lRotation];
                    y += rightBackY[rRotation - lRotation];
                }
            }
            if(direction.charAt(i) == 'L') {
                lRotation++;
                lRotation %= 4;
            }
            if(direction.charAt(i) == 'R') {
                rRotation++;
                rRotation %= 4;
            }
            minX = Math.min(x, minX);
            maxX = Math.max(x, maxX);
            minY = Math.min(y, minY);
            maxY = Math.max(y, maxY);
        }
        return maxRectangleSize(minX, maxX, minY, maxY);
    }
}