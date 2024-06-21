import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp_타일링1 {
    // 1 2x1
    // 2 1x2*2 2x1*2
    // 2x3 1x2*22x1 2x1*3 2x1*3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int tile[] = new int[n + 2];
        tile[1] = 1;
        tile[2] = 2;
        for(int i = 3; i <= n; i++) {
            tile[i] = tile[i - 1]% 10007 + tile[i - 2] % 10007 ;
        }
        System.out.println(tile[n]%10007);
    }

}