import java.util.*;

class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        quard(arr,0,0,arr.length);
        
        return answer;
    }
    
    public boolean zip(int[][]arr, int x,int y,int len){
        int point = arr[x][y];
        
        for(int i = x; i < x + len; i++){
            for(int j = y; j < y + len; j++){
                if(arr[i][j] != point){
                    return false;
                }
            }
        }
        return true;
    }
    
    public void quard(int[][] arr,int x,int y,int len){
        if(zip(arr,x,y,len)){
            if(arr[x][y] == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
        }else{
            quard(arr,x,y,len/2);
            quard(arr,x,y+len/2,len/2);
            quard(arr,x+len/2,y,len/2);
            quard(arr,x+len/2,y+len/2,len/2);
        }
    }
}