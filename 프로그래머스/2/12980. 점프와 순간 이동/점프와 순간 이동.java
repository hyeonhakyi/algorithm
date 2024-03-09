import java.util.*;

public class Solution {
    public int solution(int n) {
        int bettery = 0;
        int currentPos = 0;

        while(currentPos < n){
            if((n - currentPos)%2 == 0){
                currentPos += (n - currentPos)/2;
            }else {
                currentPos += 1;
                bettery++;
            }
        }
        return bettery;
    }
}