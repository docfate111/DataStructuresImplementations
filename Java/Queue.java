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
public class Queue {
    private static MyLinkedList l;
    public Queue(String input){
       this.l=new MyLinkedList(input);
    }
    public void enqueue(String input){
        l.append(input);
    }
    public String dequeue(){
        String s=l.getFirst();
        l.removeFirst();
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
