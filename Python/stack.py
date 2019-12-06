class Stack:
    def __init__(self, n=None):
        self.l=[n]
    def push(self, n):
        self.l.append(n)
    def pop(self):
        if(len(self.l)==0):
            print("Stack is empty")
            return 0
        temp=self.l[-1]
        self.l=self.l[:-1]
        return temp
    def peek(self):
        return self.l[-1]
    def __str__(self):
        return str(self.l)
    def size(self):
        return len(self.l)
    def clear(self):
        self.l=[]
    def isEmpty(self):
        return self.size()==0
    def setL(self, l):
        self.l=l
        return self
def listToStack(l):
    return Stack().setL(l)
if __name__=='__main__':
    stax=listToStack([1, 2, 3])
    stax.push(4)
    print(stax)