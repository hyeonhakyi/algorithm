import java.util.*;

class Node implements Comparable<Node>{
    int num;
    int x;
    int y;
    Node left;
    Node right;
    
    public Node(int num,int x,int y,Node left,Node right){
        this.num = num;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int compareTo(Node o){
        if(this.y == o.y){
            return this.x - o.x;
        }
        return o.y - this.y;
    }
}

class Solution {
    static int[][] answer;
    static int idx;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++){
            list.add(new Node(i + 1,nodeinfo[i][0],nodeinfo[i][1],null,null));
        }
        
        Collections.sort(list);
        
        Node root = list.get(0);
        for(int i = 1; i < nodeinfo.length; i++){
            insertNode(root,list.get(i));
        }
        
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        
        return answer;
    }//main end
    
    private static void insertNode(Node parents,Node child){
        if(parents.x > child.x){
            if(parents.left == null){
                parents.left = child;
            }else{
                insertNode(parents.left,child);
            }
        }else{
            if(parents.right == null){
                parents.right = child;
            }else{
                insertNode(parents.right,child);
            }
        }
    }//insertNode nend
    
    private static void preorder(Node root){
        if(root != null){
            answer[0][idx++] = root.num;
            preorder(root.left);
            preorder(root.right);
        }
    }//preorder end
    
    private static void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.num;
        }
    }//postorder end
}//class end