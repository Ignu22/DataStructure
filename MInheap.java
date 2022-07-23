import java.util.*;
public class Minheap{
    List<Integer> heap = new ArrayList<>();
    
    public Minheap(){
        
    }
    public Minheap(List<Integer> array){
        buildheap(array);
    }
    public void buildheap(List<Integer> array){
        heap = array;
        for(int i = parent(heap.size()-1); i>=0;i--){
            shiftdown(i);
        }
    }
    public void shiftdown(int currentId){
        int endid = heap.size()-1;
        int leftid = leftchild(currentId);
        while(leftid<= endid){
            int rightid = rightchild(currentId);
            int idtoshift;
            if(rightid<=endid && heap.get(rightid)<heap.get(leftid)){
                idtoshift = rightid;
            }else{
                idtoshift=leftid;
            }
            if(heap.get(currentId)>heap.get(idtoshift)){
                Collections.swap(heap,currentId,idtoshift);
                currentId=idtoshift;
                leftid = leftchild(currentId);
            }else{
                return;
            }
        }
    }
    public void shiftup(int currentId){
        int parentid = parent(currentId);
        while(currentId>0 && heap.get(parentid)>heap.get(currentId)){
            Collections.swap(heap,currentId,parentid);
            currentId=parentid;
            parentid=parent(currentId);
        }
    }
    public int peek(){
        return heap.get(0);
    }
    public void remove(){
        Collections.swap(heap,0,heap.size()-1);
        heap.remove(heap.size()-1);
        shiftdown(0);
    }
    public void insert(int value){
        heap.add(value);
        shiftup(heap.size()-1);
    }
    private int parent(int i){
        return(i-1)/2;
    }
    private int leftchild(int i){
        return(i*2)+1;
    }
    private int rightchild(int i){
        return(i*2)+2;
    }
    public void display(){
        for(int i = 0; i< heap.size();i++){
            System.out.println(heap.get(i));
        }
    }
    public static void main (String[] args) {
        List<Integer> array = new ArrayList<>();
        Minheap heap = new Minheap(array);
        heap.insert(68);
        heap.insert(28);
        heap.insert(8);
        heap.insert(1);
        heap.insert(5);
        heap.insert(15);
        heap.display();
        System.out.println("....");
        heap.remove();
        heap.display();
    }
}