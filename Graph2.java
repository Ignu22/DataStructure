import java.util.*;

public class Graph2<m>{
    private Map<m, List<m>> map = new HashMap<>();
    
    private void addvertex(m data){
        map.put(data, new ArrayList<>());
    }
    
    public void Insert(m vertex, m edge, boolean Isbidirectional){
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
        for(m x : map.keySet()){
            System.out.print(x+": ");
            for(m y : map.get(x)){
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
    
    public static void main (String[] args) {
        Graph2<Integer> graph = new Graph2<>();
        graph.Insert(3,5,true);
        graph.Insert(3,4,true);
        graph.Insert(5,6,false);
        
        graph.display();
    }
}