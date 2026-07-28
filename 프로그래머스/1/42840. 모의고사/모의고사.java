import java.util.*;

class Solution {
    static int[] first = new int[]{1,2,3,4,5};
    static int[] second = new int[]{2,1,2,3,2,4,2,5};
    static int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        List<Integer> list = find(answers);
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }//solution end
    
    private static List<Integer> find(int[] answers){
        List<Integer> list = new ArrayList<>();
        int fir = 0;
        int sec = 0;
        int th = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(first[i % first.length] == answers[i]){
                fir++;
            }
            
            if(second[i % second.length] == answers[i]){
                sec++;
            }
            
            if(third[i % third.length] == answers[i]){
                th++;
            }
        }
        
        int max = Math.max(fir,Math.max(sec,th));
        
        if(fir == max){
            list.add(1);
        }
        
        if(sec == max){
            list.add(2);
        }
        
        if(th == max){
            list.add(3);
        }
        
        return list;
    }//find end
}//class end