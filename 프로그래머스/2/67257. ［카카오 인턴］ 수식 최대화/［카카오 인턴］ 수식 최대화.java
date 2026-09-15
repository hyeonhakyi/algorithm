import java.util.*;

class Solution {
    static char[][] operates = {{'+','*','-'},
                               {'+','-','*'},
                               {'-','+','*'},
                               {'-','*','+'},
                               {'*','-','+'},
                               {'*','+','-'}};
    public long solution(String expression) {
        long answer = 0;
        
        List<Long> numbers = new ArrayList<>();
        List<Character> operate = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char str = expression.charAt(i);
            
            if(str == '-' || str == '*' || str == '+'){
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operate.add(str);
            }else{
                sb.append(str);
            }
        }
        
        numbers.add(Long.parseLong(sb.toString()));
        
        for(char[] oper : operates){
            List<Long> num = new ArrayList<>(numbers);
            List<Character> op = new ArrayList<>(operate);
            
            for(char targetOp : oper){
                int i = 0;
                
                while(i < op.size()){
                    if(targetOp == op.get(i)){
                        long left = num.get(i);
                        long right = num.get(i + 1);
                        
                        long result = calculate(left,right,targetOp);
                        
                        num.set(i,result);
                        num.remove(i + 1);
                    
                        op.remove(i);
                    }else{
                        i++;
                    }
                }            
            }
            
            answer = Math.max(answer, Math.abs(num.get(0)));
        }
        
        return answer;
    }//solution end
    
    private static long calculate(long a,long b,char c){
        if(c == '-'){
            return a - b;
        }
        
        if(c == '+'){
            return a + b;
        }
        
        return a * b;
    }//calaulate end
}//class end