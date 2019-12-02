/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author thwilliams
 */
public class HashTable{
    private List<Entry> entries;
    HashTable(){
        this.entries=new ArrayList<>();
    }
    HashTable(int k, String v){
        Entry a = new Entry(k, v);
        this.entries=new ArrayList<>();
        this.entries.add(a);
    }
    public void add(int k, String v){
        Entry a = new Entry(k, v);
        this.entries.add(a);
    }
    public void remove(int k, String v){
      for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext(); ) {
        Entry value = iterator.next();
        if (value.getKey()==k && value.getValue()==v) {
            iterator.remove();
        }
    }
    }
    public void remove(int k){
      for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext(); ) {
        Entry value = iterator.next();
        if (value.getKey()==k) {
            iterator.remove();
        }
    }
    }
    public String getKeys(){
        String output="";
        for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext(); ) {
            Entry value = iterator.next();
            output+=Integer.toString(value.getKey())+", ";
        }   
        return output.substring(0, output.length()-2);
    }
    public String getValues(){
          String output="";
        for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext(); ) {
            Entry value = iterator.next();
            output+=value.getValue()+", ";
        }   
        return output.substring(0, output.length()-2);
    }
    public void remove(String v){
      for (Iterator<Entry> iterator = this.entries.iterator(); iterator.hasNext(); ) {
        Entry value = iterator.next();
        if (value.getValue()==v) {
            iterator.remove();
        }
    }
    }
    public void clear(){
        this.entries=new ArrayList<>();
    }
    public String getValue(int k){
        for(Entry item: this.entries){
            if(item.getKey()==k){
                return item.getValue();
            }
        }
        return "Not found";
    }
    public String toString(){
        String output="";
        for(Entry item: this.entries){
            output+=item.getKey()+" => "+item.getValue()+"\n";
        }
        return output;
    }
    public boolean containsKey(int key){
        for(Entry item: this.entries){
           if(item.getKey()==key){
               return true;
           }
        }
        return false;
    }
    public boolean containsValue(String value){
        for(Entry item: this.entries){
           if(item.getValue().equals(value)){
               return true;
           }
        }
        return false;
    }
    
}
