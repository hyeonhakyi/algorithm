class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++){
            String st = arr[i];
            
            max = Math.max(Integer.parseInt(st),max);
            min = Math.min(Integer.parseInt(st),min);
        }
        answer.append(min).append(" ").append(max);
        
        return answer.toString();
    }
}