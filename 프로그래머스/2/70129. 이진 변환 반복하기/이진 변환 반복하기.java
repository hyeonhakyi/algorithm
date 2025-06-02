class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            char[] arr = s.toCharArray();
            
            for(int i = 0; i < s.length(); i++){
                if("1".equals(String.valueOf(arr[i]))){
                    continue;
                }else{
                    answer[1]++;
                }
            }
            
            s = Integer.toBinaryString(s.replaceAll("0","").length());
            answer[0]++;
        }
        
        return answer;
    }
}