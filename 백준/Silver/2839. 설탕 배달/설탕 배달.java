import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;

        while(true){
            if(num%5 ==0){
                System.out.println(num/5+cnt);
                break;
            }else if(num <0){
                System.out.println(-1);
                break;
            }
            num = num-3;
            cnt++;
        }
    }
}