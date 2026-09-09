import java.util.*;

class Solution {
    public String solution(String p) {
        return convert(p);
    }//solution end
    
    private String convert(String w) {

        // 1. 빈 문자열이면 빈 문자열 반환
        if (w.length() == 0) {
            return "";
        }

        // 2. 균형잡힌 문자열 u와 나머지 v로 분리
        int balance = 0;
        int index = 0;

        for (int i = 0; i < w.length(); i++) {

            if (w.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            // 처음으로 균형이 맞는 지점
            if (balance == 0) {
                index = i;
                break;
            }
        }

        String u = w.substring(0, index + 1);
        String v = w.substring(index + 1);


        // 3. u가 올바른 괄호 문자열이면
        if (isCorrect(u)) {

            // u + v를 변환한 결과
            return u + convert(v);
        }


        // 4. u가 올바른 괄호 문자열이 아니라면
        StringBuilder sb = new StringBuilder();

        // 4-1
        sb.append("(");

        // 4-2
        sb.append(convert(v));

        // 4-3
        sb.append(")");

        // 4-4
        // u의 첫 번째, 마지막 문자 제거
        // 나머지 괄호 방향 뒤집기
        for (int i = 1; i < u.length() - 1; i++) {

            if (u.charAt(i) == '(') {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }

        return sb.toString();
    }//convert end
    
    private static boolean isCorrect(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '('){
                count++;
            }else{
                count--;
            }
            
            if(count < 0){
                return false;
            }
        }
        return true;
    }//isCollect
}//class end