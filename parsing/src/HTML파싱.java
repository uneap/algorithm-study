import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HTML파싱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(parseMain(br.readLine()));
    }
    public static String parseMain(String string) {
        string = string.replaceAll("<main>", "");
        string = string.replaceAll("</main>", "");
        return parseDiv(string);
    }
    public static String parseDiv(String string) {
        string = string.replaceAll("<div title=\"([a-zA-Z_\\s1-9]*)\">([a-zA-Z_\\s/<>1-9=.\"]*)</div>", "title : $1 $2\n");
        return parseP(string);
    }
    public static String parseP(String string) {
        return string.replaceAll("<p>(\\s+)(<[a-z]*>)([a-zA-Z\\s]+)(<[/a-z]*>)(\\s+)</p>", "$3\n");
    }

    public static String remainOneSpace(String string) {
        return string.replaceAll("\\s+", " ");
    }
}
