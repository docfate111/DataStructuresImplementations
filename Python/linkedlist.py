class Node:
    def __init__(self, n):
        self.value=n
        self.next=None
    def __add__(self, n):
        return self.append(n)
    def __sub__(self, n):
        return self.remove(n)
    def append(self, n):
        head=self
        while(self.getNext()!=None):
            self=self.getNext()
        self.setNext(Node(n))
        return head
    def setValue(self, n):
        self.value=n
    def setNext(self, n=None):
        self.next=n
    def getValue(self):
        return self.value
    def getNext(self):
        return self.next
    def remove(self, n):
        if(not self.contains(n)):
            print("Not in the linked list")
            return self
        head=self
        if(self.getValue()==n):
            self=self.getNext()
            return head.getNext()
        while(self.getNext()!=None):
            parent=self
            self=self.getNext()
            if(self.getValue()==n):
                parent.setNext(self.getNext())
        return head
    def __str__(self):
        s=""
        while(self.getNext()!=None):
            s+=str(self.getValue())+" -> "
            self=self.getNext()
        s+=str(self.getValue())
        return s
    def prepend(self, n):
        head=Node(n)
        head.setNext(self)
        return head
    def clear(self):
        while(self!=None):
            self.setValue(0)
            self=self.getNext()
    def len(self):
        count=0
        while(self!=None):
            self=self.getNext()
            count+=1
        return count
    def contains(self, n):
        while(self!=None):
            if(self.getValue()==n):
                return True
            self=self.getNext()
        return False
    def isEmpty(self):
        while(self!=None):
            if(self.getValue()!=0):
                return False
            self=self.getNext()
        return True
    def insert(self, index, n):
        head=self
        count=0
        if(index==0):
            return self.prepend(n)
        while(self!=None):
            if(count==index-1):
                toInsert=Node(n)
                toInsert.setNext(self.getNext())
                self.setNext(toInsert)
            self=self.getNext()
            count+=1
        return head
    def getFirst(self):
        return self.getValue()
    def getLast(self):
        while(self!=None):
            parent=self
            self=self.getNext()
        return parent.getValue()
    def removeFirst(self):
        return self.getNext()
    def removeLast(self):
        head=self
        parent=self
        while(self.getNext()!=None):
            parent=self
            self=self.getNext()
        parent.setNext()
        return head
    #remove all instances of n
    def removeAll(self, n):
        if(not self.contains(n)):
            print("Not in the linked list")
            return self
        newh=Node(self.getValue())
        head=newh
        while(self.getNext()!=None):
            if(self.getValue()!=n):
                newh+=self.getValue()
            self=self.getNext()
        if(head.getFirst()==n):
            return head.getNext()
        return head
    def removeAt(self, index):
        if(index>=self.len()):
            print("Index out of bounds")
        head=self
        count=0
        if(self.getValue()==n):
            self=self.getNext()
            return head.getNext()
        while(self.getNext()!=None):
            parent=self
            self=self.getNext()
            count+=1
            if(count==index):
                parent.setNext(self.getNext())
        return head
    def indexOf(self, n):
        if(not self.contains(n)):
            print("Not in linked list")
            return -1
        count=0
        while(self!=None):
            if(self.getValue()==n):
                return count
            self=self.getNext()
            count+=1
        return -1
if __name__=='__main__':
    n=Node(3)
    n+=4
    n+=5
    n+=10
    #n=n.removeFirst()
    print(n, n.indexOf(4))