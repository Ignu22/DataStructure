class DoublyLinkedlist{
    class node{
        int data;
        node next;
        node prev;

        node(int data){

            this.data=data;

        }
        
    }
    public node head;
    public node tail;

    public void add(int data){
        node newnode = new node(data);

        if(head == null){
            head = newnode;
        }else{
            tail.next=newnode;
            newnode.prev=tail;
        }
        tail = newnode;
    }
    public void display(){
        node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public void displayrev(){
        node temp = tail;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedlist list= new DoublyLinkedlist();
        list.add(23);
        list.add(55);
        list.add(67);
        list.add(34);

        list.display();
        list.displayrev();
    }
}