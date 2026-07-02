import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            
            String command = arr[0];
            String userId = arr[1];
            
            if(command.equals("Enter")){
                map.put(userId,arr[2]);
                list.add(new String[]{userId,"Enter"});
            }else if(command.equals("Leave")){
                list.add(new String[]{userId,"Leave"});
            }else if(command.equals("Change")){
                map.put(userId,arr[2]);
            }
        }
        String[] answer = new String[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            String userId = list.get(i)[0];
            String command = list.get(i)[1];
            
            if(command.equals("Enter")){
                answer[i] = map.get(userId) + "님이 들어왔습니다.";
            }else{
                answer[i] = map.get(userId) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }//solution end
}//class end