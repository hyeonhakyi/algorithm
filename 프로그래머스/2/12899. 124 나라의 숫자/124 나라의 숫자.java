class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] numbers = {"4", "1", "2"};
        
        while(n > 0){
            int num = n % 3;
            n /= 3;
            
            if(num == 0){
                n -= 1;
            }
            
            answer.insert(0, numbers[num]);
        }
        
        return answer.toString();
    }
}