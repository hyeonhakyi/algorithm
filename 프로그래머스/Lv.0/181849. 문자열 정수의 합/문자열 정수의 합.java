class Solution {
    public int solution(String num_str) {
        char[] arr = new char[num_str.length()];
        for(int i= 0; i < num_str.length(); i++){
            arr[i] = num_str.charAt(i);
        }
        int sum = 0;
        for(int i= 0; i < arr.length; i++){
            int num = arr[i] -'0';
            sum += num;
        }
        return sum;
    }
}