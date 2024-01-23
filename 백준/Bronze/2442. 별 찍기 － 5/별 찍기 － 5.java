import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        //int count = 1;
        for(int i=0; i<num1;i++){
            for(int j =1; j<num1-i; j++){
                System.out.print(" ");
            }
            for(int j= 1; j<=(2*i)+1; j++){
                //System.out.print((count++)+"\t");
                System.out.print("*");
            }
//            for(int k = num1-i-1; k >0; k--){
//                System.out.print(" ");
//            }
            System.out.println();
        }
    }
}