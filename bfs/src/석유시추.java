//bfs
// bfs로 위치 지정할 때 영역을 지정
// 모든 열을 체크할 때 해당 영역을 지나가면 석유 덩어리로 지정
import java.util.*;
class Solution {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] land) {
        int answer = 0;
        int area = 1;
        Map<Integer, Integer> landSize = new HashMap<>();
        boolean[][] visit = new boolean[land.length][land[0].length];
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                if(land[i][j] != 0 && !visit[i][j]){
                    land[i][j] = area;
                    bfs(land, visit, area, new Point(i, j));
                    area++;
                }
            }
        }
        checkSize(landSize, land);
        return getMaxOilSize(landSize, land);
    }
    public int getMaxOilSize(Map<Integer, Integer> landSize, int[][] land) {
        int answer = 0;
        for(int i = 0; i < land[0].length; i++) {
            Set<Integer> oilArea = new HashSet<>();
            for(int j = 0; j < land.length; j++) {
                if(land[j][i] != 0){
                    oilArea.add(land[j][i]);
                }
            }
            int oilSize = 0;
            for(int area : oilArea) {
                oilSize += landSize.get(area);
            }
            answer = Math.max(answer, oilSize);
        }
        return answer;
    }
    public void checkSize(Map<Integer, Integer> landSize, int[][] land) {
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                if(land[i][j] != 0){
                    landSize.put(land[i][j], landSize.getOrDefault(land[i][j], 0) + 1);
                }
            }
        }
    }
    public void bfs(int[][] land,boolean[][] visit, int area, Point point) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        visit[point.x][point.y] = true;
        int[] directX = {0,0,1,-1};
        int[] directY = {1,-1,0,0};
        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int dx = directX[i] + p.x;
                int dy = directY[i] + p.y;
                if(dx >= land.length || dy >= land[0].length || dx < 0 || dy < 0 || visit[dx][dy] || land[dx][dy] == 0) {
                    continue;
                }
                q.offer(new Point(dx,dy));
                visit[dx][dy] = true;
                land[dx][dy] = area;
            }
        }
    }
}