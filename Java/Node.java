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
public class Node {
    private Node left;
    private Node right;
    private int value;
    public Node(int a){
        this.value=a;
    }
    public String toString(){
        return Integer.toString(this.value);
    }
    public Node(String a){
        this.value=Integer.parseInt(a);
    }
    public Node(Node a, Node b, int c){
        this.value=c;
        this.left=a;
        this.right=b;
    }
    public void setLeft(Node a){
        this.left=a;
    }
    public void setRight(Node a){
        this.right=a;
    }
    public Node getLeft(){
        return this.left;
    }
    public Node getRight(){
        return this.right;
    }
    public int value(){
        return this.value;
    }
}
