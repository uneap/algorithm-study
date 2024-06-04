import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class dfs_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        int count = parseInt(br.readLine());
        Map<Integer, Set<Integer>> computer = new HashMap<>();
        while(count > 0) {
            count --;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Set<Integer> linkedComputers = computer.getOrDefault(x, new HashSet<>());
            linkedComputers.add(y);
            computer.put(x, linkedComputers);
            linkedComputers = computer.getOrDefault(y, new HashSet<>());
            linkedComputers.add(x);
            computer.put(y, linkedComputers);
        }
        AtomicInteger answer = new AtomicInteger(0);
        virus(computer, answer, new boolean[num + 1]);
        System.out.println(answer.get());
    }
    public static void virus(Map<Integer, Set<Integer>> computers, AtomicInteger answer, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        visited[1] = true;
        while(!stack.isEmpty()) {
            int computer = stack.pop();
            Set<Integer> linkedComputers = computers.getOrDefault(computer, new HashSet<>());
            for(int linkedComputer : linkedComputers) {
                if(visited[linkedComputer]) {
                    continue;
                }
                answer.getAndIncrement();
                stack.add(linkedComputer);
                visited[linkedComputer] = true;
            }
        }
    }
}
