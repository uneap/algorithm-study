import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LineUp {
    // 1 2 3 4 5 6 7
    // 6 1 1 1 2 0 0
    // 6 2 3 4 7 5 1
    // 6 7 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tall = new int[num];
        List<Integer> people = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            tall[i] = parseInt(st.nextToken());
        }
        for(int i = num - 1; i >= 0; i--) {
            people.add(tall[i], i + 1);
        }
        for(int i = 0 ; i < num; i++) {
            System.out.print(people.get(i) + " ");
        }
    }
}