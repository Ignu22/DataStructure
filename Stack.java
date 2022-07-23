import java.util.Scanner;
public class Stack{
   static class Node{
       int data;
       Node next;
       
       public Node(int data){
           this.data=data;
       }
   }
   public Node top;
   
   public void push(int data){
       Node newnode= new Node(data);
       
       if(top == null){
           top = newnode;
       }else{
           newnode.next = top;
           top = newnode;
       }
   }
   public void pop(){
       if(top == null){
           System.out.println("Stack underflow");
           return;
       }
       top = top.next;
   }
   
   public void display(){
       Node current = top;
       
       while(current!=null){
           System.out.println(current.data);
           current=current.next;
       }
   }
   public static void main (String[] args) {
       Scanner sc = new Scanner(System.in);
       Stack stack = new Stack();
       System.out.print("Enter no. of elements to add in stack :");
       int num = sc.nextInt();
       for(int i=0;i<=num;i++){
           i=sc.nextInt();
           stack.push(i);
       }
       System.out.println("Stack is");
       stack.display();
   }
}