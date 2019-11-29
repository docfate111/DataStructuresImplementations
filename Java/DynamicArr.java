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
public class DynamicArr {
    public static int arr[];
    public DynamicArr(int size){
        this.arr=new int[size];
    }
    public String toString(){
        String out="";
        for(int i=0; i<this.arr.length; i++){
           out+=arr[i];
        }
        return out;
    }
    public void set(int index, int value){
        if(index>this.arr.length){
            System.out.println("Error index out of bounds!");
        }else{
        for(int i=0; i<this.arr.length; i++){
            if(i==index){
                this.arr[i]=value;
            }
        }
        }
    }
    public int get(int index){
        return this.arr[index];
    }
    public int size(){
        return this.arr.length;
    }
    public void clear(){
        for(int i=0; i<this.arr.length; i++){
            this.arr[i]=0;
        }
    }
    public void append(int value){
        int[] a=new int[this.arr.length+1];
        for(int i=0; i<this.arr.length; i++){
            a[i]=this.arr[i];
        }
        a[this.arr.length]=value;
        this.arr=a;
    }
    public void insert(int index, int value){
        int[] a=new int[this.arr.length+1];
        for(int i=0; i<index; i++){
            a[i]=this.arr[i];
        }
        a[index]=value;
        for(int i=index+1; i<this.arr.length+1; i++){
            a[i]=this.arr[i-1];
        }
        this.arr=a;
    }
    public boolean contains(int value){
         for(int i=0; i<this.arr.length; i++){
            if(this.arr[i]==value){
                return true;
            }
        }
        return false;
    }
    //remove first instance of value
    public void removeOne(int value){
        if(this.contains(value)){
            int[] a=new int[this.arr.length-1];
            int ind=0;
            boolean removed=false;
            for(int i=0; i<this.arr.length; i++){
                if(this.arr[i]==value && removed==false){
                    removed=true;
                }else{
                     a[ind]=this.arr[i];
                     ind++;
                }
            }
            this.arr=a;
        }else{
            System.out.println("Not in the array");
        }
    }
    //remove all instances of value
    public void removeAll(int value){
        if(this.contains(value)){
            int timesValueAppears=0;
            for(int i=0; i<this.arr.length; i++){
                if(this.arr[i]==value){
                    timesValueAppears+=1;
                }
            }
            int[] a=new int[this.arr.length-timesValueAppears];
            int ind=0;
            for(int i=0; i<this.arr.length; i++){
                if(this.arr[i]==value){
    
                }else{
                     a[ind]=this.arr[i];
                     ind++;
                }
            }
            this.arr=a;
        }else{
            System.out.println("Not in the array");
        }
    }
    public void removeAt(int index){
        int[] a=new int[this.arr.length-1];
            int ind=0;
            for(int i=0; i<this.arr.length; i++){
                if(i==index){
    
                }else{
                     a[ind]=this.arr[i];
                     ind++;
                }
            }
        this.arr=a;
        
    }
    public int indexOf(int value){
        for(int i=0; i<this.arr.length; i++){
            if(this.arr[i]==value){
                return i;
            }
        }
        System.out.println("Error not in array!");
        return -1;
    }
}
