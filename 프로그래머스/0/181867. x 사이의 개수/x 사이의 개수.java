import java.util.*;
class Solution {
    public int[] solution(String myString) {
        String[] arr = myString.split("x");
        
        int[] arr1 = new int[arr.length];
        
        if (myString.charAt(myString.length()-1) == 'x') {
            arr1 = new int[arr.length+1];
        }
        for(int i=0; i < arr.length; i++){
            arr1[i] = arr[i].length();
        }
        return arr1;
    }
}