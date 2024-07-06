import static java.lang.Integer.parseInt;

import java.util.*;
import java.io.*;

public class egg {
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = parseInt(br.readLine());
        int[] duration = new int[n];
        int[] weight = new int[n];

        for(int i=0; i< n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            duration[i] = parseInt(st.nextToken());
            weight[i] = parseInt(st.nextToken());
        }

        bt(duration, weight, 0, 0);

        System.out.println(max);
    }

    static void bt(int[] duration, int[] weight,int hand, int count) {
        if(hand == duration.length || count == duration.length - 1) {
            max = Math.max(max, count);
            return;
        }
        if(duration[hand] <= 0) {
            bt(duration,weight,hand + 1, count);
            return;
        }
        int n = count;
        for(int i = 0; i < duration.length; i++) {
            if(i == hand || duration[i] <= 0){
                continue;
            }
            hitEgg(duration,weight, hand, i);
            if(duration[hand] <= 0) {
                count++;
            }
            if(duration[i] <= 0) {
                count++;
            }
            bt(duration,weight,hand + 1, count);
            recoveryEgg(duration,weight,hand, i);
            count = n;
        }
    }

    static void hitEgg(int[] duration, int[] weight, int handEgg, int targetEgg) {
        duration[targetEgg] -= weight[handEgg];
        duration[handEgg] -= weight[targetEgg];
    }

    static void recoveryEgg(int[] duration, int[] weight, int handEgg, int targetEgg) {
        duration[targetEgg] += weight[handEgg];
        duration[handEgg] += weight[targetEgg];
    }

}
