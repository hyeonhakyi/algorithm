import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> q = new Stack<>();

        for(int i = 0; i < n; i++){
            int m = sc.nextInt();

            if(m == 0){
                q.pop();
            }else{
                q.push(m);
            }
        }
        int sum = 0;
        for(int i = 0; i < q.size(); i++){
            sum += q.get(i);
        }
        System.out.println(sum);
    }
}