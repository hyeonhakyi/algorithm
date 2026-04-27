import java.util.*;

class Solution {
    static boolean[][] piller;
    static boolean[][] beam;
    static int size;
    public int[][] solution(int n, int[][] build_frame) {
        size = n;
        
        piller = new boolean[n + 2][n + 2];
        beam = new boolean[n + 2][n + 2];
        
        for(int[] commend : build_frame){
            int x = commend[0];
            int y = commend[1];
            int type = commend[2];
            int remove = commend[3];
            
            if(remove == 1){
                if(type == 0){
                    piller[x][y] = true;
                    
                    if(!isVaild()){
                        piller[x][y] = false;
                    }
                }else{
                    beam[x][y] = true;
                    
                    if(!isVaild()){
                        beam[x][y] = false;
                    }
                }
            }else{
                if(type == 0){
                    piller[x][y] = false;
                    
                    if(!isVaild()){
                        piller[x][y] = true;
                    }
                }else{
                    beam[x][y] = false;
                    
                    if(!isVaild()){
                        beam[x][y] = true;
                    }
                }
            }        
        }
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i <= size; i++){
            for(int j = 0; j <= size; j++){
                if(piller[i][j]){
                    list.add(new int[]{i,j,0});
                }
                
                if(beam[i][j]){
                    list.add(new int[]{i,j,1});
                }                
            }
        }
        
        list.sort((a, b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            if(a[1] != b[1]){
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });
        
        int[][] answer = new int[list.size()][3];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }//solution end
    
    private static boolean isVaild(){
        for(int i = 0; i <= size; i++){
            for(int j = 0; j <= size; j++){
                if(piller[i][j] && !canPiller(i,j)){
                    return false;
                }
                
                if(beam[i][j] && !canBeam(i,j)){
                    return false;
                }
            }
        }
        return true;
    }//isValud end
    
    private static boolean canPiller(int x,int y){
        if(y == 0) return true;
        if(piller[x][y - 1]) return true;
        if(x > 0 && beam[x - 1][y]) return true;
        if(beam[x][y]) return true;
        return false;
    }//canPiller end
    
    private static boolean canBeam(int x,int y){
        if(y > 0 && piller[x][y - 1]) return true;
        if(y > 0 && piller[x + 1][y - 1]) return true;
        if(x > 0 && beam[x + 1][y] && beam[x - 1][y]) return true;
        
        return false;
    }
}//class end