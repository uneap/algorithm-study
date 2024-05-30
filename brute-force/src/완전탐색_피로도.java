import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 완전탐색_피로도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = parseInt(st.nextToken());
        int b = parseInt(st.nextToken());
        int c = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int work = 0;
        int hour = 0;
        int p = 0;
        while(true) {
            if(hour == 24){
                break;
            }
            if(p + a > m) {
                p -= c;
            } else {
                work += b;
                p += a;
            }
            hour ++;
            if(p < 0) {
                p = 0;
            }
        }
        System.out.println(work);
    }
}
