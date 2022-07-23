public class Queue{
    
   static class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
        }
   }
        
        public Node front;
        public Node rear;
        
        void enqueue(int data){
            Node newnode = new Node(data);
            if(rear == null){
                front = rear = newnode;
                return;
            }
                rear.next=newnode;
                rear = newnode;
            
        }
        void dequeue(){
            if(front == null){
                System.out.println("Empty queue");
            }
            front = front.next;
            
            if(front == null){
                rear = null;
            }
        }
      public  void display(){
            Node current = front;
            if(front == null){
                System.out.println("Empty");
                return;
            }
            while(current!=null){
                System.out.print(current.data+" ");
                current=current.next;
            }
            System.out.println();
        }
        public static void main (String[] args) {
            Queue q = new Queue();
            q.enqueue(20);
            q.enqueue(30);
            q.enqueue(50);
            q.enqueue(90);
            
            q.dequeue();
            
            q.display();
            
        }
    
}