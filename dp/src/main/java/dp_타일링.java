import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        long tile[] = new long[n + 1];
        tile[1] = 1;
        tile[2] = 3;
        for(int i = 3; i <= n; i++) {
            tile[i] = (tile[i - 1] + tile[i - 2] * 2) % 10007 ;
        }
        System.out.println(tile[n]);
    }

}