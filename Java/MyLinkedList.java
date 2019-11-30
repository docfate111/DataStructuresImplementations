/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;
/**
 * @author thwilliams
 */
public class MyLinkedList {
    NodeL head;
    MyLinkedList(String a) {
       NodeL newHead=new NodeL(a);
       newHead.next=null;
       this.head=newHead;
    }
    public String toString(){
        NodeL curr=this.head;
        String output="";
        int count=0;
        while(curr.next!=null){
            output+=Integer.toString(count)+": "+curr.data+"\n";
            curr=curr.next;
            count+=1;
        }
         output+=Integer.toString(count)+": "+curr.data+"\n";
        return output;
    }
    public void prepend(String input){
        NodeL newHead=new NodeL(input);
        newHead.next=this.head;
        this.head=newHead;
    }
    public void append(String input){
        NodeL curr=this.head;
        while(curr.next!=null){
            curr=curr.next;
        }
        NodeL newEnd=new NodeL(input);
        newEnd.next=null;
        curr.next=newEnd;
    }
    public void clear(){
        NodeL curr=this.head;
        while(curr.next!=null){
            curr.data="";
            curr=curr.next;
        }
        curr.data="";
    }
    //length of linked list
    public int size(){
     NodeL curr=this.head;
     int count=0;
        while(curr.next!=null){
           count+=1;
            curr=curr.next;
        }
        return count+1;
    }
    public boolean isEmpty(){
        NodeL curr=this.head;
        while(curr.next!=null){
            if(curr.data!=""){
                return false;
            }
            curr=curr.next;
        }
        if(curr.data!=""){
            return false;
        }
        return true;
    }
    public void insert(int index, String input){
        if(index>this.size()+1){
            System.out.println("Error out of range");
        }else{
            NodeL toInsert=new NodeL(input);
            if(index==0){
                toInsert.next=this.head;
                this.head=toInsert;
            }else{
                NodeL curr=this.head;
                int count=0;
                while(curr.next!=null){
                    if(count==(index-1)){
                        //insert inside list
                        toInsert.next=curr.next;
                        curr.next=toInsert;
                    }
                    count+=1;
                    curr=curr.next;
                }
            }
        }
    }
    public String getFirst(){
        return this.head.data;
    }
    public String getLast(){
        NodeL curr=this.head;
        while(curr.next!=null){
            curr=curr.next;
        }
        return curr.data;
    }
    public void removeFirst(){
        this.head=this.head.next;
    }
    public void removeLast(){
        NodeL curr=this.head;
        int count=1;
        while(curr.next!=null){
            if(count==(this.size()-1)){
                 curr.next=null;
                 break;
            }
            count+=1;
            curr=curr.next;
        }
    }
    public MyLinkedList removeAll(String input){
         MyLinkedList newHead=new MyLinkedList(this.head.data);
            if(!this.contains(input)){
                System.out.println(input+" not in the linked list!");
                return newHead;
            }else{
                if(this.head.data==input){
                    newHead.head=this.head.next;
                    return newHead;
                }else{
                    NodeL curr=this.head.next;
                    while(curr.next!=null){
                        if(input.equals(curr.data)){
                            //skip over next element
                            curr=curr.next;
                        }else{
                            newHead.append(curr.data);
                            curr=curr.next;
                        }
                    }
                if(curr!=null && !input.equals(curr.data)){
                    newHead.append(curr.data);
                }
                return newHead;
            }
     }
    }
   public MyLinkedList removeAt(int index){
       MyLinkedList newHead=new MyLinkedList(this.head.data);
       if(index>this.size()+1){
            System.out.println("Error out of range");
            return newHead;
        }else{
            if(index==0){
                newHead.head=this.head.next;
                return newHead;
            }else{
                NodeL curr=this.head;
                int count=0;
                while(curr.next!=null){
                    if(count==(index-1)){
                        //skip over next element
                        curr=curr.next;
                    }else{
                        newHead.append(curr.data);
                    }
                    count+=1;
                    curr=curr.next;
                }
                newHead.append(curr.data);
                return newHead;
            }
        }
   }
   public MyLinkedList removeOne(String input){
            MyLinkedList newHead=new MyLinkedList(this.head.data);
            if(!this.contains(input)){
                System.out.println(input+" not in the linked list!");
                return newHead;
            }else{
                if(this.head.data==input){
                    newHead.head=this.head.next;
                    return newHead;
                }else{
                    NodeL curr=this.head.next;
                    boolean removed=false;
                    while(curr.next!=null){
                        if(input.equals(curr.data) && removed==false){
                            //skip over next element
                            curr=curr.next;
                            removed=true;
                        }else{
                            newHead.append(curr.data);
                            curr=curr.next;
                        }
                    }
                if(curr!=null && !input.equals(curr.data)){
                    newHead.append(curr.data);
                }
                return newHead;
            }
        }
   }
   public int indexOf(String input){
        NodeL curr=this.head;
        int count=0;
        while(curr.next!=null){
            if(curr.data==input){
                return count;
            }
            curr=curr.next;
            count++;
        }
        if(curr.data==input){
            return count;
        }
        //not in linked list
        return -1;
   }
   public boolean contains(String input){
        NodeL curr=this.head;
        while(curr.next!=null){
            if(curr.data==input){
                return true;
            }
            curr=curr.next;
        }
        if(curr.data==input){
            return true;
        }
        return false;
   }
}
