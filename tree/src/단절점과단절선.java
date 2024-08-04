import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 단절점과단절선 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> tree = new HashMap<>();
        int num = parseInt(br.readLine());
        for(int i = 0; i < num - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = parseInt(st.nextToken());
            List<Integer> nodes = tree.getOrDefault(root, new ArrayList<>());
            nodes.add(parseInt(st.nextToken()));
            tree.put(root, nodes);
        }
    }
}
