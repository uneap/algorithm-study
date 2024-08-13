import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class 수리공항승 {
    // 0.5 1 1.5 1.5 2 2.5  95.5 100 100.5 100.5 101 101.5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = parseInt(st.nextToken());
        int length = parseInt(st.nextToken());
        PriorityQueue<Double> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        Set<Double> tapes = new HashSet<>();
        for(int i = 0; i < num; i++) {
            double number = parseDouble(st.nextToken());
            double min = number - 0.5;
            double max = number + 0.5;
            tapes.add(number);
            tapes.add(min);
            tapes.add(max);
        }
        for(double tape : tapes) {
            pq.offer(tape);
        }
        int answer = 0;
        while(!pq.isEmpty()) {
            double number = pq.poll();
            double range = number + (double)length;
            while(!pq.isEmpty() && pq.peek() <= range) {
                pq.poll();
            }
            answer++;
        }
        System.out.println(answer);
    }
}
