import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 원의 범위 체크
// dfs로 원 이동
public class 원이동 {
    static int startNumber,endNumber;
    public static class Circle implements Comparable<Circle> {
        int minX;
        int maxX;
        int number;
        public Circle(int minX, int maxX, int number) {
            this.maxX = maxX;
            this.minX = minX;
            this.number = number;
        }
        @Override
        public int compareTo(Circle circle) {
            return this.minX - circle.minX;
        }

        public boolean include(Circle circle) {
            return this.minX <= circle.minX && this.maxX >= circle.maxX;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = parseInt(br.readLine());
        List<Circle> circles = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = parseInt(st.nextToken());
            int x = parseInt(st.nextToken());
            int length = parseInt(st.nextToken());
            circles.add(new Circle(x - length, x + length, number));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        startNumber = parseInt(st.nextToken());
        endNumber = parseInt(st.nextToken());
        Collections.sort(circles);
        circles.add(0, new Circle(Integer.MIN_VALUE, Integer.MAX_VALUE, 0));
        boolean[] visit = new boolean[count + 1];
        List<Integer> answers = new ArrayList<>();
        answers.add(startNumber);
        visit[startNumber] = true;
        dfs(circleMatrix, visit, answers, startNumber);
    }

    public static void dfs(Map<Integer, List<Integer>> circleMatrix, boolean[] visit, List<Integer> answers, Integer index) {
        if(index == endNumber) {
            System.out.println(answers.size());
            for(int i = 0; i < answers.size(); i++) {
                System.out.print(answers.get(i) + " ");
            }
            System.exit(0);
        }
        if(index == circleMatrix.size()) {
            return;
        }
        for(int num : circleMatrix.get(index)) {
            if(visit[num]){
                continue;
            }
            visit[num] = true;
            answers.add(num);
            dfs(circleMatrix, visit, answers, num);
        }
    }
}
