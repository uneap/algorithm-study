import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class heap_min {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = parseInt(br.readLine());
        while(n > 0) {
            n --;
            int number = parseInt(br.readLine());
            if(number == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                }else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(number);
            }
        }
    }
}