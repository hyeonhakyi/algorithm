import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        //int count = 1;
        for(int i=0; i<num1;i++){
            for(int k= 0; k<i; k++){
                //System.out.print((count++)+"\t");
                System.out.print(" ");
            }
            for(int j =0; j<(2*num1-1)-(2*i); j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = 1; i < num1; i++){
            for(int k=1; k<num1-i; k++){
                System.out.print(" ");
            }
            for(int j=0; j < (2*i+1); j++) {
                //System.out.print((count++) + "\t");
                System.out.print("*");
            }
            System.out.println();
        }
    }
}