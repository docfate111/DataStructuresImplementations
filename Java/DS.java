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
public class DS {
     public static void main(String args[]){
         BST b=new BST(5);
         b.addNode(7);
         b.addNode(20);
         b.addNode(15);
         b.inOrderTraverseTree();
         b.addNode(10);
         b.addNode(1);
         System.out.println();
         b.inOrderTraverseTree();
        b.remove(20);
        System.out.println();
         b.inOrderTraverseTree();
        /* Queue q=new Queue("l");
         q.enqueue("i");
         q.enqueue("n");
         q.enqueue("e");
         System.out.println(q.toString());
          System.out.println(q.dequeue());
          System.out.println(q.toString());
        Stack s=new Stack("s");
        s.push("t");
        s.push("a");
        s.push("x");
        System.out.println(s.toString());
        System.out.println(s.pop());
        System.out.println(s.toString());
         MyLinkedList l=new MyLinkedList("a");
         l.prepend("b");
         l.append("c");
         l.append("k");
         System.out.println(l.toString()+"\n"+l.indexOf("k"));
          MyLinkedList nl=l.removeAll("k");
         System.out.println(nl.toString());
         MyLinkedList nl=l.removeOne("c");
         System.out.println(nl.toString());
         l.removeLast();
         l.removeLast();
          l.removeFirst();
         System.out.println(l.getFirst()+l.getLast());
         System.out.println(l.isEmpty());
        System.out.println(l.size());
        DoublyLinkedList d=new DoublyLinkedList();
        d.prepend("first node");
        d.append("3");
        //d.append("2");
        System.out.println(d.toString());
         d.append("3");
         System.out.println(d.toString());
        DynamicArr d=new DynamicArr(3);
        System.out.println(d.size());
        d.set(0, 5);
        d.set(1, 3);
        d.set(2, 2);
        d.insert(1, 2);
         System.out.println(d.toString());
        d.removeAt(2);
         System.out.println(d.toString());
        d.removeAt(1);
        System.out.println(d.toString()+" "+ d.indexOf(2));
        System.out.print(d.size());*/
       
    }
    
}
