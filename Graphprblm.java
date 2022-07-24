import java.util.*;
public class Graphprblm{
    public static List<Integer> checksize(int[][] matrix){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> sizes= new ArrayList<>();
        for(int i =0; i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(visited[i][j]){
                    continue;
                }else{
                    traverse(i, j, matrix, visited, sizes);
                }
            }
        }
        return sizes;
    }
    public static void traverse(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes){
        int current =0;
        Stack<Integer[]> nodestoexplore = new Stack<>();
        nodestoexplore.add(new Integer[]{i,j});
        while(!nodestoexplore.empty()){
            Integer[] currentnode= nodestoexplore.pop();
            i = currentnode[0];
            i = currentnode[1];
            if(visited[i][j]){
                continue;
            }
            visited[i][j] = true;
            if(matrix[i][j]==0){
                continue;
            }
            current++;
            List<Integer[]> nearest = getnearestnode(i, j, matrix, visited);
            nodestoexplore.addAll(nearest);
        }
        if(current>0){
         sizes.add(current);
        }
    }
    private static List<Integer[]> getnearestnode(int i, int j, int[][] matrix, boolean[][] visited){
        List<Integer[]> nearest = new ArrayList<>();
        if(i>0 && !visited[i-1][j]){
            nearest.add(new Integer[]{i-1,j});
        }
        if(i<matrix.length-1 && !visited[i+1][j]){
            nearest.add(new Integer[]{i+1,j});
        }
        if(j>0 && !visited[i][j-1]){
            nearest.add(new Integer[]{i,j-1});
        }
        if(j<matrix[0].length-1 && !visited[i][j+1]){
            nearest.add(new Integer[]{i,j+1});
        }
        return nearest;
    }
    public static void main (String[] args) {
        int[][] matrix = {{1,0,0,1,1},
                          {0,1,1,1,0},
                          {0,0,0,0,1},
                          {1,0,0,0,1}};
        List<Integer> result = checksize(matrix);
        
        result.forEach(System.out::println);
        
    } 
}