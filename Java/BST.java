/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
/**
 *
 * @author thwilliams
 */
public class BST {
    private Node root;
    private int nodeCount;
    public BST(int r){
        Node root=new Node(r);
        this.root=root;
    }
    public BST(){
        this.root=null;
    }
    public void inOrderTraverseTree(){
        inOrderTraverseTree(this.root);
    }
    public void inOrderTraverseTree(Node focusNode) {
	        if (focusNode != null) {
	            // Traverse the left node
	            inOrderTraverseTree(focusNode.getLeft());
	            // Visit the currently focused on node
	            System.out.println(focusNode);
	            // Traverse the right node
	            inOrderTraverseTree(focusNode.getRight());
	        }
	    }
    public void preorderTraverseTree(){
         preorderTraverseTree(this.root);
    }
    public void preorderTraverseTree(Node focusNode){
	        if (focusNode != null) {
	            System.out.println(focusNode);
	            preorderTraverseTree(focusNode.getLeft());
	            preorderTraverseTree(focusNode.getRight());
	        }
	    }
    public void postOrderTraverseTree(){
        postOrderTraverseTree(this.root);
    }
    public void postOrderTraverseTree(Node focusNode) {
	        if (focusNode != null) {
	            postOrderTraverseTree(focusNode.getLeft());
	            postOrderTraverseTree(focusNode.getRight());
	            System.out.println(focusNode);
	        }
	    }
    public boolean contains(int n){
        Queue a=new Queue(this.root);
        Node k;
        while(!a.NisEmpty()){
            k=a.Ndequeue();
           if(k!=null){
               if(k.value()==n){
                   return true;
               } 
            }
            if(k.getLeft()!=null){
                a.enqueue(k.getLeft());
            }
            if(k.getRight()!=null){
                a.enqueue(k.getRight());
            }
        }
        return false;
    }
    public void addNode(int n){
        Node a=new Node(n);
        if(this.root==null){
            this.root=a;
        }else{
            Node curr=this.root;
            //to hold parent later
            Node parent;
            while(true){
                parent=curr;
                if(n<curr.value()){
                    curr=curr.getLeft();
                    if(curr==null){
                        parent.setLeft(a);
                        return;
                    }
                }else{
                    curr=curr.getRight();
                    if(curr==null){
                        parent.setRight(a);
                        return;
                    }
                }
            }
        }
    }
    public boolean remove(int d){
        Node curr=this.root;
        Node parent=this.root;
        boolean isLeft=true;
        while(curr.value()!=d){
            parent=curr;
            if(d<curr.value()){
                isLeft=true;
                curr=curr.getLeft();
                //go left
            }else{
                isLeft=false;
                curr=curr.getRight();
                //go right
            }
            if(curr==null){
            //element not inside the tree
            return false;
            }
        }  
        //no left and no right child
        if(curr.getLeft()==null && curr.getRight()==null){
            if(curr.value()==this.root.value()){
                this.root=null;
            }else if(isLeft){
                //if the node we are removing is left remove it
                parent.setLeft(null);
            }else{
                //if the node we are removing is right remove it
                parent.setRight(null);
            }
            //only is a left child
        }else if(curr.getRight()==null){
            //no right child
            //if we are removing root then get the left child
            if(curr.value()==this.root.value()){
               this.root=this.root.getLeft();
            }else if(isLeft){
                parent.setLeft(curr.getLeft());
            }else{
                parent.setRight(curr.getRight());
            }
        }else if(curr.getLeft()==null){
             //no left child, only a right child
            //if we are removing root then get the right child
            if(curr.value()==this.root.value()){
               this.root=curr.getRight();
            }else if(isLeft){
                parent.setLeft(curr.getRight());
            }else{
                parent.setRight(curr.getLeft());
            }
        }else{
             //there is both a left or right node
             Node replacement=getReplacement(curr);
              if(curr.value()==this.root.value()){
                    this.root=replacement;
             }else if(isLeft){
                    parent.setLeft(replacement);
            }else{
                     parent.setRight(replacement);
            }
            replacement.setLeft(curr.getLeft());
        }
        return true;
    }
    public Node getReplacement(Node a){
        Node parent=a;
        Node replacement=a;
        //always replace with right
        Node curr=a.getRight();
        while(curr!=null){
            parent=replacement;
            replacement=curr;
            curr=curr.getLeft();
        }
        if(replacement.value()!=a.getRight().value()){
            parent.setLeft(replacement.getRight());
            replacement.setRight(a.getRight());
        }
        return replacement;
    }
   public Node leftmost(Node a){
        Node curr=a;
        while(curr.getLeft()!=null){
            curr=curr.getLeft();
        }
        return curr;
    }
    public boolean isEmpty(){
        return this.nodeCount==0;
    }
    public int size(){
        return this.nodeCount;
    }
    
    
}
