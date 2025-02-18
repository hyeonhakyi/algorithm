import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = br.readLine();
            if(s.equals("end")){
                break;
            }

            char[] arr = s.toCharArray();

            boolean containsVowels = false; //모음 체크
            boolean treeTimesInARow = false; //모음 이나 자음 3개 체크
            int voweLsInARowCount = 0; // 연속으로 나온 모음
            int consonantsInARowCount = 0; // 연속으로 나온 자음
            boolean doubleInARowCheck = false; // 같은 글자 반복

            for(int i = 0; i < arr.length; i++){
                if(check(arr[i])){
                    containsVowels = true;
                    voweLsInARowCount++;
                    consonantsInARowCount = 0;
                }else{
                    consonantsInARowCount++;
                    voweLsInARowCount = 0;
                }

                if(voweLsInARowCount >= 3 || consonantsInARowCount >= 3){
                    treeTimesInARow = true;
                    break;
                }

                if(i >= 1){
                    if(arr[i - 1] == arr[i]){
                        if(arr[i] == 'e'){
                            continue;
                        }else if(arr[i] == 'o'){
                            continue;
                        }
                        doubleInARowCheck = true;
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<");
            for(int j = 0; j < arr.length; j++){
                sb.append(arr[j]);
            }
            sb.append("> is ");
            if(doubleInARowCheck || treeTimesInARow || !containsVowels){
                sb.append("not ");
            }
            sb.append("acceptable.");
            System.out.println(sb);
        }
    }//main end


    static boolean check(char a){
        if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a== 'u'){
            return true;
        }
        return false;
    }//check end
}//class end
