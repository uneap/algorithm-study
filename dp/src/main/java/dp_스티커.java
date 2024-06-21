import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        while (n >= 0) {
            n--;
            int y = parseInt(br.readLine());
            int sticker[][] = new int[2][y+1];
            for(int i= 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j <= y; j++) {
                    sticker[i][j] = parseInt(st.nextToken());
                }
            }
            for(int i= 2; i <= y; i++) {
                sticker[0][i] = Math.max(sticker[0][i] + sticker[1][i - 2], sticker[0][i] + sticker[1][i - 1]);
                sticker[1][i] = Math.max(sticker[1][i] + sticker[0][i - 2], sticker[1][i] + sticker[0][i - 1]);
            }
            System.out.println(Math.max(sticker[1][y], sticker[0][y]));

        }
    }
}