import java.util.*;

public class Graph{
    private Map<Integer, List<Integer>> map = new HashMap<>();
    
    private void addvertex(Integer data){
        map.put(data, new ArrayList<>());
    }
    
    public void Insert(Integer vertex, Integer edge, boolean Isbidirectional){
        if(!map.containsKey(vertex)){
            addvertex(vertex);
        }
        if(!map.containsKey(edge)){
            addvertex(edge);
        }
        
        map.get(vertex).add(edge);
        if(Isbidirectional){
            map.get(edge).add(vertex);
        }
    }
    
    public void display(){
        for(Integer x : map.keySet()){
            System.out.print(x+": ");
            for(Integer y : map.get(x)){
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
    
    public static void main (String[] args) {
        Graph graph = new Graph();
        graph.Insert(3,5,true);
        graph.Insert(3,4,true);
        graph.Insert(5,6,false);
        
        graph.display();
    }
}