import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 좋은구간 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        int[] set = new int[num];
        Set<Integer> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            set[i] = parseInt(st.nextToken());
            s.add(set[i]);
        }
        Arrays.sort(set);
        int n = parseInt(br.readLine());
        boolean goodInterval;
        Set<Integer> starts = new HashSet<>();
        starts.add(n);
        Set<Integer> end = new HashSet<>();
        for(int i = 1; i < set[set.length - 1]; i++) {
            if(n == i) {
                continue;
            }
            if(n < i) {
               goodInterval = isGoodInterval(s, n, i);
               if(goodInterval) {
                   end.add(i); // 11 12
               }
            } else {
                goodInterval = isGoodInterval(s, i, n);
                if(goodInterval) {
                    starts.add(i); // 9 10
                }
            }
        }
        System.out.println(end.size() * starts.size() + starts.size() - 1);
    }

    public static boolean isGoodInterval(Set<Integer> s, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(s.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
