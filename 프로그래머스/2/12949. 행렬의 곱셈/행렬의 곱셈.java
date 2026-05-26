class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;        // arr1의 행 개수
        int col = arr2[0].length;     // arr2의 열 개수
        int mid = arr1[0].length;     // arr1의 열 개수이자 arr2의 행 개수

        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < mid; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}