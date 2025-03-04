import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a); 
        int round = 0;
        
        for(int e : enemy){
           maxHeap.add(e); // 현재 라운드의 적의 수를 저장
           n -= e; // 병사 이용
            
           // 병사가 부족하면 무적권 사용
           if(n < 0){
               if(k > 0){
                   n += maxHeap.poll(); // 가장 큰 무리 찬스권 사용
                   k--; // 찬스권 제거
               }else{
                   break;
               }
           }            
           round++; // 라운드 증가
        }
        
        
        return round;
    }
}