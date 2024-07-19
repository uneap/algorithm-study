import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LocalTime startTime = timeMaker(st.nextToken());
        LocalTime endTime = timeMaker(st.nextToken());
        LocalTime streamingEndTime = timeMaker(st.nextToken());
        Map<String, List<LocalTime>> nameAndTime = new HashMap<>();
        int count = 0;
        String str = null;

        while((str = br.readLine()) != null) {
            String[] arr = str.split(" ");
            LocalTime time = timeMaker(arr[0]);
            String name = arr[1];
            List<LocalTime> times = nameAndTime.getOrDefault(name, new ArrayList<>());
            times.add(time);
            nameAndTime.put(name, times);
        }
        for(String name : nameAndTime.keySet()) {
            List<LocalTime> times = nameAndTime.get(name);
            boolean validStart = false;
            boolean validEnd = false;
            for(LocalTime time : times) {
                if(!validStart) {
                    validStart = validStart(time, startTime);
                }
                if(!validEnd) {
                    validEnd = validEnd(time, endTime, streamingEndTime);
                }
            }
            if(validStart && validEnd) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean validStart(LocalTime time, LocalTime start) {
        return time.isBefore(start) || start.equals(time);
    }
    public static boolean validEnd(LocalTime time, LocalTime endTime, LocalTime streamingEndTime) {
        return (time.equals(endTime) || time.isAfter(endTime)) && (time.equals(streamingEndTime) || time.isBefore(streamingEndTime));
    }
    public static LocalTime timeMaker(String s) {
        StringTokenizer st = new StringTokenizer(s, ":");
        return LocalTime.of(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
}
