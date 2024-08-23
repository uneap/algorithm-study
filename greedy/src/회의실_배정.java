import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실_배정 {
    // end가 작은 순으로 정렬
    // 가장 작은 값과 비교하면서, 해당 범위 넘어갈 경우, start값과 end값으로 갱신
    // 1 4 -> this
    //3 5
    //0 6
    //5 7
    //3 8
    //5 9
    //6 10
    //8 11
    //8 12
    //2 13
    //12 14
    public static class Time implements Comparable<Time>{
        int start;
        int end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return this.end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        List<Time> times = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times.add(new Time(parseInt(st.nextToken()), parseInt(st.nextToken())));
        }
        int count = 1;
        Collections.sort(times);
        Time time = times.get(0);
        for(int i = 1; i < num; i++) {
            if(times.get(i).start >= time.end) {
                time = times.get(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
