import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import org.w3c.dom.xpath.XPathResult;

public class 할아버지는유명해 {
    // 1 2 3 점수 더해서 hashMap에 저장
    // 그 중에서 점수 오름차 순으로 정렬
    // 오름차순으로 출력
    public static class Athlete implements Comparable<Athlete>{
        int score;
        Set<Integer> number;
        public Athlete(int score, Set<Integer> number) {
            this.score = score;
            this.number = number;
        }

        @Override
        public int compareTo(Athlete o) {
            return o.score - this.score;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());
            if(N == 0 && M == 0) {
                break;
            }
            Map<Integer, Integer> numberAndScore = new HashMap<>();
            for(int i = 0; i < N; i ++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    int number = parseInt(st.nextToken());
                    numberAndScore.put(number, numberAndScore.getOrDefault(number, 0) + 1);
                }
            }
            PriorityQueue<Athlete> pq = new PriorityQueue<>();
            Map<Integer, Set<Integer>> scoreAndNumber = new HashMap<>();
            for(int number : numberAndScore.keySet()) {
                Set<Integer> numbers = scoreAndNumber.getOrDefault(numberAndScore.get(number), new HashSet<>());
                numbers.add(number);
                scoreAndNumber.put(numberAndScore.get(number), numbers);
            }
            for(int score : scoreAndNumber.keySet()) {
                pq.offer(new Athlete(score, scoreAndNumber.get(score)));
            }
            pq.poll();
            if(!pq.isEmpty()) {
                print(pq.poll().number);
            }
        }
    }
    public static void print(Set<Integer> numbers) {
        List<Integer> numbersList = new ArrayList<>(numbers);
        Collections.sort(numbersList);
        for(int number : numbersList) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
