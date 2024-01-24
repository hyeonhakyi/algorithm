import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        String[][] arr = new String[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
        }
        Arrays.sort(arr, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                if(s1[0].equals(s2[0])){
                    return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
                }else{
                    return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
                }
            }
        });
        for(int i=0; i<n; i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}