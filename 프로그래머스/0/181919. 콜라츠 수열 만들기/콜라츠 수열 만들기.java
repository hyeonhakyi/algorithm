import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        while(n>1){
            if(n%2==0){
                n/=2;
            }else if(n%2 !=0){
                n = 3*n+1;
            }
            list.add(n);
        }
        int[] arr = new int[list.size()];
        for(int i=0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}