import java.util.*;

class Node{
    int x;
    int y;
    int idx;
    Node left;
    Node right;
    public Node(int x,int y,int idx){
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

class Solution {
    static List<Integer> preorderList;
    static List<Integer> postorderList;
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i + 1);
        };
        
        Arrays.sort(nodes,(a,b) ->{
            if(a.y == b.y){
                return Integer.compare(a.x,b.x);
            }
            return Integer.compare(b.y,a.y);
        });
        
        Node root = nodes[0];
        
        for(int i = 1; i < n; i++){
            insert(root,nodes[i]);
        }
        
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();
        
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][n];
        for(int i = 0; i < n; i++){
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }
        
        return answer;
    }//solution end
    
    private static void insert(Node parent,Node child){
        if(child.x < parent.x){
            if(parent.left == null){
                parent.left = child;
            }else{
                insert(parent.left,child);
            }
        }else{
            if(parent.right == null){
                parent.right = child;
            }else{
                insert(parent.right,child);
            }
        }
    }//insert end
    
    private static void preorder(Node node){
        if(node == null) return;
        
        preorderList.add(node.idx);
        preorder(node.left);
        preorder(node.right);
    }//preorder end
    
    private static void postorder(Node node){
        if(node == null) return;
        
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.idx);
    }//postorder end
}//class end