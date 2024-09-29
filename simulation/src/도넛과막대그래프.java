//도넛모양은 나가는 간선 2개 이상 어쩌구 - 막대 모양 - 8자 모양
// 막대모양은 나가는거 없는 애 한개 개수
// 8자모양은 나오는 간선, 들어오는 간선 2개씩 있는 거 개수
// 나가는 간선 2개 이상, 들어오는 거 없는 애가 생성된 애
import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int vertex = 0;
        for(int i = 0; i < edges.length; i++) {
            vertex = Math.max(vertex, Math.max(edges[i][0], edges[i][1]));
        }
        Set[] inNode = new HashSet[vertex + 1];
        Set[] outNode = new HashSet[vertex + 1];
        for(int i = 0; i <= vertex; i++) {
            inNode[i] = new HashSet<>();
            outNode[i] = new HashSet<>();
        }
        search(inNode, outNode, edges);
        for(int i = 1; i <= vertex; i++) {
            if(outNode[i].size() >= 2 && inNode[i].size() == 0) {
                answer[0] = i;
            }
            if(inNode[i].size() >= 1 && outNode[i].size() == 0) {
                answer[2]++;
            }
            if(inNode[i].size() >= 2 && outNode[i].size() == 2) {
                answer[3]++;
            }
        }
        answer[1] = outNode[answer[0]].size() - answer[2] - answer[3];
        return answer;
    }
    public void search(Set[] inNode, Set[] outNode, int[][] edges) {
        for(int i = 0; i < edges.length; i++) {
            outNode[edges[i][0]].add(edges[i][1]);
            inNode[edges[i][1]].add(edges[i][0]);
        }
    }

}