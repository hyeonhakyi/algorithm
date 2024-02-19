import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        StringTokenizer st1 = new StringTokenizer(n,"0");
        StringTokenizer st2 = new StringTokenizer(n, "1");

        System.out.println(Math.min(st1.countTokens(),st2.countTokens()));
    }
}
