import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dp_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int sugar[] = new int[n + 1];
        Arrays.fill(sugar, 0);
        sugar[0] = 0;
        sugar[1] = -1;
        sugar[2] = -1;
        for(int i = 3; i <= n; i++) {
            if(i - 5 >= 0 && sugar[i - 5] != -1) {
                sugar[i] = sugar[i - 5] + 1;
            } else if(i - 3 >= 0 && sugar[i - 3] != -1) {
                sugar[i] = sugar[i - 3] + 1;
            } else {
                sugar[i] = -1;
            }
        }
        System.out.println(sugar[n]);
    }

}