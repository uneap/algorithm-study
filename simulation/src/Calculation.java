import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Calculation {
    static int[][] array = new int[100][100];
    static Map<Integer, Integer> numberAndCount;
    static int rSize = 3;
    static int cSize = 3;
    static int answer = 0;
    public static class Number implements Comparable<Number> {
        int number;
        public Number(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(Number n) {
            if (Objects.equals(numberAndCount.getOrDefault(number, 0), numberAndCount.getOrDefault(n.number, 0))) {
                return this.number - n.number;
            }
            return numberAndCount.getOrDefault(number, 0) - numberAndCount.getOrDefault(n.number, 0);
        }
    }
    public static void main(String[] args) throws IOException {
        int r, c, k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        k = parseInt(st.nextToken());
        r--;
        c--;
        for(int i = 0; i < 100; i++) {
            Arrays.fill(array[i], 0);
        }
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                array[i][j] = parseInt(st.nextToken());
            }
        }

        while(answer <= 100) {
            if(array[r][c] == k) {
                break;
            }
            answer++;
            if(rSize < cSize) {
                calculateC();
            } else {
                calculateR();
            }
        }
        if(answer <= 100) {
            System.out.print(answer);
        } else {
            System.out.print(-1);
        }
    }
    //List로 넣고, array에 넣는 형태
    public static void calculateR() {
        int columnSize = cSize;
        for(int i = 0; i < rSize; i++) {
            numberAndCount = new HashMap<>();
            List<Number> rows = new ArrayList<>();
            for(int j = 0; j < columnSize; j++) {
                if(array[i][j] == 0) {
                    continue;
                }
                if(!numberAndCount.containsKey(array[i][j])) {
                    rows.add(new Number(array[i][j]));
                }
                numberAndCount.put(array[i][j], numberAndCount.getOrDefault(array[i][j], 0) + 1);
            }
            Collections.sort(rows);
            List<Integer> sortedArray = getSortedArray(rows);
            int size = sortedArray.size() % 100;
            Arrays.fill(array[i], 0);
            for(int j = 0; j < size; j++) {
                array[i][j] = sortedArray.get(j);
                cSize = Math.max(cSize, size);
            }
        }
    }
    public static void calculateC() {
        int rowSize = rSize;
        for(int j = 0; j < cSize; j++) {
            numberAndCount = new HashMap<>();
            List<Number> columns = new ArrayList<>();
            for(int i = 0; i < rowSize; i++) {
                if(array[i][j] == 0) {
                    continue;
                }
                if(!numberAndCount.containsKey(array[i][j])) {
                    columns.add(new Number(array[i][j]));
                }
                numberAndCount.put(array[i][j], numberAndCount.getOrDefault(array[i][j], 0) + 1);
            }
            Collections.sort(columns);
            List<Integer> sortedArray = getSortedArray(columns);
            int size = sortedArray.size() % 100;
            initColumn(j);
            for(int i = 0; i < size; i++) {
                array[i][j] = sortedArray.get(i);
                rSize = Math.max(rSize, size);
            }
        }
    }
    public static void initColumn(int j) {
        for(int i = 0; i < cSize; i++) {
            array[i][j] = 0;
        }
    }
    public static List<Integer> getSortedArray(List<Number> numbers) {
        List<Integer> sortedArray = new ArrayList<>();
        for (Number num : numbers) {
            int number = num.number;
            sortedArray.add(number);
            int count = numberAndCount.get(number);
            sortedArray.add(count);
        }
        return sortedArray;
    }
}
