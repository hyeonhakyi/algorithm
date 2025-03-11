class Solution {
    public long solution(int w, int h) {
        long W = (long) w;
        long H = (long) h;
        
        return W * H - (W + H - gcd(w,h));
    }
    
    private int gcd(int x,int y){
        if(y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}