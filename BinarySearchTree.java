public class BinarySearchTree{
    static class Node{
        int data;
        Node left, right;
        
        public Node(int item){
            data = item;
        }
    }
    Node root;
    
    public void insert(int data){
        Node current = root;
        if(current == null){
            root = new Node(data);
            return;
        }
        while(true){
            if(data < current.data){
                if(current.left ==  null){
                    current.left = new Node(data);
                    break;
                }else{
                    current = current.left;
                }
            }else {
                if(current.right ==  null){
                    current.right = new Node(data);
                    break;
                }else{
                    current = current.right;
                }
            }
        }
    }
    
    public boolean contains(int data){
        Node current = root;
        while(current!= null){
            if(data< current.data){
                current= current.left;
            }else if(data > current.data){
                current = current.right;
            }else{
                return true;
            }
        }
        return false;
    }
    
    public void remove(int data){
       removehelper(data,root,null); 
    }
    
    public void removehelper(int data, Node current, Node parent){
        
        while(current!= null){
            if(data < current.data){
                parent = current;
                current= current.left;
            }else if(data > current.data){
                parent = current;
                current = current.right;
            }else{
                if(current.left!= null && current.right!= null){
                    current.data =getminvalue(current.right);
                    removehelper(current.data,current.right,current);
                }else{
                    if(parent == null){
                        if(current.right == null){
                            root = current.left;
                        }else{
                            root = current.right;
                        }
                    }else{
                        if(parent.left == current){
                            if(current.right == null){
                                parent.left = current.left;
                            }else {
                                parent.left = current.right;
                            }
                        }else{
                           if(current.right == null){
                                parent.right = current.left;
                            }else {
                                parent.right = current.right;
                            } 
                        }
                    }
                }
                break;
            }
        }
    }
    
    public int getminvalue(Node current){
        if(current.left==null){
            return current.data;
        }else{
            return getminvalue(current.left);
        }
    }
    
    public void inorder(){
        inorderhelper(root);
    }
    public void inorderhelper(Node node){
        if(node!= null){
            inorderhelper(node.left);
            System.out.print(node.data+" ");
            inorderhelper(node.right);
        }
    }
    public void preorder(){
        preorderhelper(root);
    }
    public void preorderhelper(Node node){
        if(node!= null){
            System.out.print(node.data+" ");
            preorderhelper(node.left);
            preorderhelper(node.right);
        }
    }
    public void postorder(){
       postorderhelper(root);
    }
    public void postorderhelper(Node node){
        if(node!= null){
            postorderhelper(node.left);
            postorderhelper(node.right);
            System.out.print(node.data+" ");
        }
    }
    
    public int findclosest(int target){
        Node current = root;
        int closest = current.data;
        while(current!= null){
            if(Math.abs(target-closest)> Math.abs(target - current.data)){
                closest = current.data;
            }
            if(target < current.data){
                current = current.left;
            }else if(target > current.data){
                current = current.right;
            }else{
                break;
            }
        }
        return closest;
    }
    
    public static void main (String[] args) {
        BinarySearchTree tree= new BinarySearchTree();
        tree.insert(10);
        tree.insert(7);
        tree.insert(11);
        tree.insert(4);
        tree.insert(9);
       
        tree.inorder();
        System.out.println();
        tree.preorder();
        System.out.println();
        tree.postorder();
        System.out.println();
        System.out.println(tree.findclosest(5));
       
    }
}