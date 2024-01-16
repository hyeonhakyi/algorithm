import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> list = new ArrayList<>();
        
        for(String str: strArr){
            if(!str.contains("ad")){
                list.add(str);
            }
        }
        int idx = 0;
        String[] arr = new String[list.size()];
        for(String str : list){
            arr[idx++] = str;
        }
        return arr;
    }
}