public class Linkedlist{

    class node{
        int data;
        node next;

        node(int data){
            this.data=data;
        }
    }

    public node head =null;
    public node tail =null;

    public void addnode(int data){
        node newnode = new node(data);

        if(head==null){
            head=newnode;
        }else{
            tail.next = newnode;
        }
        tail=newnode;
    }

    public void display(){
        if(head==null){
            System.out.println("empty");
            return;
        }

        node temp= head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;

        }
    }
    public void delete(int data){
        node temp =head, prev=null;
        if(temp!=null && temp.data== data){
            head=temp.next;
            return;
        }
        while(temp!=null && temp.data!=data){
            prev=temp;
            temp =temp.next;

        }
        if(temp==null){
            return;
        }
        if(temp==tail){
            tail=prev;
            tail.next=null;
            return;

        }

        prev.next=temp.next;
    }

    public void insert(int nxtTo, int data){
        node newnode =new node(data);
        node temp =head;

        while(temp!=null && temp.data!=nxtTo){
            temp=temp.next;

        }
        if(temp==null){
            return;
        }
        if(temp == tail){
            tail.next =newnode;
            tail = newnode;
            return;

        }
        newnode.next= temp.next;
        temp.next=newnode;
    }
    public void rmvdupli(){
        node current=head;
        while(current!=null){
            node next=current.next;
            while(next!=null&& next.data ==current.data){
                next=next.next;
            }
            current.next=next;

            if(next==tail && current.data == next.data){
                tail=current;
                tail.next=null;
            }
            current=next;
        }
    }

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.addnode(10);
        list.addnode(40);
        list.addnode(20);
        list.addnode(20);
        list.addnode(20);
        list.addnode(70);
        list.addnode(70);
        list.addnode(70);
       
        list.rmvdupli();
        list.display();
        
    }


}