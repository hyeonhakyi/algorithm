import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i= 0; i <arr.length; i++){
            int num = arr[i];
            for(int j = 0; j < num; j++){
                list.add(num);
            }
        }
        int[] X = new int[list.size()];
        for(int d = 0; d < list.size(); d++){
            X[d] = list.get(d);
        }
        return X;
    }
}