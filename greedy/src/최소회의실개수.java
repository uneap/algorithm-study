import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소회의실개수 {
    // 우선 시작시간 순으로 정렬 (회의실 개수 최소로 구해야 하므로)
    // 비교할 때는 끝시간이 가장 작은 경우와 먼저 비교해야하므로 pq는 끝시간을 오름차순 정렬
    public static class Time implements Comparable<Time>{
        int start;
        int end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        List<Time> times = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = parseInt(st.nextToken());
            int end = parseInt(st.nextToken());
            times.add(new Time(start, end));
        }
        Collections.sort(times);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(times.get(0).end);
        for(int i = 1; i < times.size(); i++){
            if(times.get(i).start >= pq.peek()) {
                pq.poll();
            }
            pq.offer(times.get(i).end);
        }
        System.out.print(pq.size());
    }
}
