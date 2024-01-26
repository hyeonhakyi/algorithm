import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i = 0; i <num; i++){
            System.out.println(solved(sc.next()));
        }
    }

    public static String solved(String str){
        Stack<Character> st = new Stack<>();

        for(int i=0; i <str.length(); i++){
            char c = str.charAt(i);

            if(c == '('){
                st.push(c);
            }else if(st.empty()){
                return "NO";
            }else{
                st.pop();
            }
        }
        if(st.empty()){
            return "YES";
        }else{
            return "NO";
        }
    }
}