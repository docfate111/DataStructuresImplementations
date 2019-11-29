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
        //System.out.print(d.size());
    }
    
}
