import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위굴리기 {
    //    0 2
//    3 4
//    5 6
//    7 8
//    주사위에 숫자가 채워지는 위치
//    좌표를 움직이는 위치를 따로 저장
//    주사위와 좌표 값 새롭게 씀
//    출력할 때마다 가장 위 좌표 값 출력, 만일 좌표에서 벗어난 범위일 경우 출력x
    static int[][] matrix;
    static int[][] dice;
    static int x, y, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        x = parseInt(st.nextToken());
        y = parseInt(st.nextToken());
        int count = parseInt(st.nextToken());
        matrix = new int[N][M];
        dice = new int[4][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                matrix[i][j] = parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < dice.length; i++) {
            Arrays.fill(dice[i], 0);
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++) {
            int direct = parseInt(st.nextToken());
            if (moveMatrix(direct)) {
                printTop();
            }
        }
    }

    public static boolean moveMatrix(int direct) {
        int[] directX = {0,0,0,-1,1};
        int[] directY = {0,1,-1,0,0};
        int dx = directX[direct] + x;
        int dy = directY[direct] + y;
        if(dx < 0 || dy < 0 || dx >= N || dy >= M) {
            return false;
        }
        moveDice(direct);
        x = dx;
        y = dy;
        if(matrix[dx][dy] == 0) {
            matrix[dx][dy] = dice[3][1];
        } else {
            dice[3][1] = matrix[dx][dy];
            matrix[dx][dy] = 0;
        }
        return true;
    }
    public static void moveDice(int direct) {
        switch (direct) {
//                동
            case 1:
                moveEast();
                break;
//                서
            case 2:
                moveWest();
                break;
//                남
            case 3:
                moveSouth();
                break;
//                북
            case 4:
                moveNorth();
                break;
            default:
                break;
        }
    }
    public static void moveNorth(){
        int temp = dice[0][1];
        dice[0][1] = dice[1][1];
        dice[1][1] = dice[2][1];
        dice[2][1] = dice[3][1];
        dice[3][1] = temp;
    }

    public static void moveSouth() {
        int temp = dice[3][1];
        dice[3][1] = dice[2][1];
        dice[2][1] = dice[1][1];
        dice[1][1] = dice[0][1];
        dice[0][1] = temp;
    }

    public static void moveWest() {
        int temp = dice[1][0];
        int temp2 = dice[3][1];
        dice[1][0] = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = temp2;
        dice[3][1] = temp;
    }
    public static void moveEast() {
        int temp = dice[1][2];
        int temp2 = dice[3][1];
        dice[3][1] = temp;
        dice[1][2] = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = temp2;
    }
    public static void printTop() {
        System.out.println(dice[1][1]);
    }
}