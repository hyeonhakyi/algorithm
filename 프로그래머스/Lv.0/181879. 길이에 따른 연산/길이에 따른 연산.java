class Solution {
    public int solution(int[] num_list) {
        int sum = 0;
        if(num_list.length >=11){
            for(int i=0; i<num_list.length;i++){
                sum += num_list[i];
            }
            return sum;
        }
        int sum1 = 1;
        if(num_list.length <=10){
            for(int i=0; i<num_list.length; i++){
                sum1 *= num_list[i];
            }
        }
        return sum1;
    }
}