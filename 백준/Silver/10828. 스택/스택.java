import java.util.*;

public class Main {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder br = new StringBuilder();
        int num = sc.nextInt();
        stack = new int[num];

        for(int i=0; i<num; i++){
            String str = sc.next();

            switch (str){
                case "push":
                    push(sc.nextInt());
                    break;

                case "pop":
                    br.append(pop()).append('\n');
                    break;

                case "size":
                    br.append(size()).append('\n');
                    break;

                case "empty":
                    br.append(empty()).append('\n');
                    break;

                case "top":
                    br.append(top()).append('\n');
                    break;
            }
        }
        System.out.println(br);
    }

    public static void push(int item){
        stack[size++] = item;
    }

    public static int pop(){
        if(size == 0){
            return -1;
        }else{
            int res = stack[size-1];
            stack[size-1] = 0;
            size--;
            return res;
        }
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if(size==0){
            return 1;
        }else{
            return 0;
        }
    }

    public static int top(){
        if(size==0){
            return -1;
        }else{
            return stack[size-1];
        }
    }
}