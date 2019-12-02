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
public class Entry {
    private int key;
    private String value;
    public Entry(int key, String value){
        this.key=key;
        this.value=value;
    }
    public String getValue(){
        return this.value;
    }
    public int getKey(){
        return this.key;
    }
}
