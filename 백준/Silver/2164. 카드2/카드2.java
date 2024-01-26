import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> list = new LinkedList<>();

        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        while(list.size() != 1){
            list.poll();
            list.offer(list.poll());
        }
        System.out.println(list.poll());
    }
}