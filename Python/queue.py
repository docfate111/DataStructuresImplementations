class Queue:
    def __init__(self, n):
        self.l=[n]
    def enQ(self, n):
        #enqueue but short
        self.l.append(n)
    def dQ(self):
        #dequeque but shorthand
        temp=self.l[0]
        self.l=self.l[1:]
        return temp
    def peek(self):
        return self.l[0]
    def __str__(self):
        return str(self.l)
    def size(self):
        return len(self.l)
    def isEmpty(self):
        return self.size()==0
if __name__=='__main__':
    q=Queue(3)
    q.enQ(5)
    q.enQ(60)
    q.dQ()
    q.dQ()
    print(q.dQ())
    print(q.isEmpty())