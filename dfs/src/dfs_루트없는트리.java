import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class dfs_루트없는트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        int count = num;
        while (num > 1) {
            num --;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Set<Integer> linkedNodes = nodes.getOrDefault(x, new HashSet<>());
            linkedNodes.add(y);
            nodes.put(x, linkedNodes);
            linkedNodes = nodes.getOrDefault(y, new HashSet<>());
            linkedNodes.add(x);
            nodes.put(y, linkedNodes);
        }
        int[] answers = new int[count + 1];
        dfs(nodes, new boolean[count + 1], answers);
        for(int i = 2; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
    }
    public static void dfs(Map<Integer, Set<Integer>> nodes, boolean[] visited, int[] answers) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        visited[1] = true;
        while(!stack.isEmpty()) {
            int x = stack.pop();
            for(Integer node : nodes.get(x)) {
                if(visited[node]) {
                    continue;
                }
                answers[node] = x;
                visited[node] = true;
                stack.push(node);
            }
        }

    }
}
