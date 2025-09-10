import java.util.*;

class Solution {
    static boolean[][] pillar,beam;
    static int N;
    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        
        pillar = new boolean[n + 3][n + 3];
        beam = new boolean[n + 3][n + 3];
                
        for(int[] i : build_frame){
            int x = i[0];
            int y = i[1];
            int a = i[2]; // 0: 기둥, 1: 보
            int b = i[3]; // 0: 삭제, 1: 설치
            
            if(b == 1){
                if(a == 0){
                    pillar[x][y] = true;
                    if(!isAllAvailable()) pillar[x][y] = false;
                }else{
                    beam[x][y] = true;
                    if(!isAllAvailable()) beam[x][y] = false;
                }
            }else{
                if(a == 0){
                    pillar[x][y] = false;
                    if(!isAllAvailable()) pillar[x][y] = true;
                }else{
                    beam[x][y] = false;
                    if(!isAllAvailable()) beam[x][y] = true;
                }
            }
        }
        
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                if(pillar[i][j]) list.add(new int[]{i,j,0});
                if(beam[i][j]) list.add(new int[]{i,j,1});
            }
        }
        
        list.sort((o1,o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });
        
        int[][] answer = new int[list.size()][3];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }//main end
    
    static boolean isAllAvailable(){
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){
                if(pillar[i][j] && !canPlacePiller(i,j)) return false;
                if(beam[i][j] && !canPlaceBeam(i,j)) return false;
            }
        }
        return true;
    }//isAllAvailable end
    
    static boolean canPlacePiller(int x,int y){
        if(y == 0) return true;
        if(y >= 0 && pillar[x][y-1]) return true;
        if(beam[x][y]) return true;
        if(x > 0 && beam[x - 1][y]) return true;
        return false;
    }//canPlacePiller end
    
    static boolean canPlaceBeam(int x,int y){
        if(y > 0 && pillar[x][y - 1]) return true;
        if(y > 0 && pillar[x + 1][y - 1]) return true;
        if(x > 0 && beam[x - 1][y] && beam[x + 1][y]) return true;
        return false;
    }//canPlaceBeam end
}