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
public class Stack {
    //based off linked list implementation
    private static MyLinkedList l;
    public Stack(String input){
       this.l=new MyLinkedList(input);
    }
    public void push(String input){
        l.append(input);
    }
    public String pop(){
        String s=l.getLast();
        l.removeLast();
        return s;
    }
    public String toString(){
        //when printed out the stack grows downwards and shrinks upwards
        return l.toString();
    }
    public String peek(){
        return l.getLast();
    }
    public int size(){
        return l.size();
    }
    public boolean isEmpty(){
        return l.isEmpty();
    }
}
