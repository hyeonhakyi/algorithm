import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

            // i칸 왼쪽 회전
            String rotate =
                s.substring(i) + s.substring(0, i);

            // 회전한 문자열 전체가 올바르면 +1
            if (check(rotate)) {
                answer++;
            }
        }

        return answer;
    }//solution end


    private static boolean check(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            // 여는 괄호
            if (c == '(' || c == '[' || c == '{') {

                stack.push(c);

            } else {

                // 닫는 괄호인데 앞에 여는 괄호가 없음
                if (stack.isEmpty()) {
                    return false;
                }

                // 짝이 맞지 않는 경우
                if (c == ')' && stack.peek() != '(') {
                    return false;
                }

                if (c == ']' && stack.peek() != '[') {
                    return false;
                }

                if (c == '}' && stack.peek() != '{') {
                    return false;
                }

                // 짝이 맞으면 제거
                stack.pop();
            }
        }

        // 여는 괄호가 남아있으면 올바르지 않음
        return stack.isEmpty();
    }//check end
}