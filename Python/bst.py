class Node:
    def __init__(self, n=None):
        self.val=n
        self.left=None
        self.right=None
    def getVal(self):
        return self.val
    def setVal(self, n):
        self.val=n
    def getRight(self):
        return self.right
    def getLeft(self):
        return self.left
    def setLeft(self, n=None):
        if(isinstance(n, int)):
            self.left=Node(n)
        else:
            self.left=n
    def setRight(self, n=None):
        if(isinstance(n, int)):
            self.right=Node(n)
        else:
            self.right=n
class BST:
    def __init__(self, n=None):
        if(isinstance(n, int)):
            self.root=Node(n)
        else:
            self.root=n
    def preorderPrint(self):
        self.preorder(self.getRoot())
    def preorder(self, start):
        if start: #not none
            print(start.getVal())
        if(start.getLeft()):
            self.preorder(start.getLeft())
        if(start.getRight()):
            self.preorder(start.getRight())
    def postrderPrint(self):
        self.postorder(self.getRoot())
    def postorder(self, start):
        if start: #not none
            print(start.getVal())
        if(start.getLeft()):
            self.postorder(start.getLeft())
        if(start.getRight()):
            self.postorder(start.getRight())
    def __str__(self):
        #level order traversal
        s=""
        q=[self.root]
        while(q):
            s+=str(q[-1].getVal())+" "
            node=q.pop()
            if(node.getLeft()!=None):
                q=[node.getLeft()]+q
            if(node.getRight()!=None):
                q=[node.getRight()]+q
        return s
    def getRoot(self):
        return self.root
    def size(self):
        q=[self.root]
        count=0
        while(q):
            node=q.pop()
            count+=1
            if(node.getLeft()!=None):
                q=[node.getLeft()]+q
            if(node.getRight()!=None):
                q=[node.getRight()]+q
        return count
    def addNode(self, n):
        head=self.root
        if(self.root==None):
            self.root.setVal(n)
        else:
            curr=self.root
            parent=curr
            while(True):
                parent=curr
                if(n<curr.getVal()):
                    curr=curr.getLeft()
                    if(curr==None):
                        parent.setLeft(n)
                        return head
                elif(n==curr.getVal()):
                    return head
                else:
                    curr=curr.getRight()
                    if(curr==None):
                        parent.setRight(n)
                        return head
    def removeNode(self, n):
        head=self
        curr=self.getRoot()
        parent=curr
        #1. find element to remove if it exists
        #2. replace the node we are removing with its successor if one exists
        if(self.contains(n)):
            if(curr.getVal()==n):
                curr=curr.getLeft()
            return self.remove(curr, parent, head, n, '')
    def remove(self, curr, parent, head, n, dir):
        if(n==curr.getVal()):
            #1. node to remove has no children
            if(curr.getRight()==None and curr.getLeft()==None):
                if(dir=='l'):
                    parent.setLeft(None)
                if(dir=='r'):
                    parent.setRight(None)
                return head
            #2. node to remove has only right
            elif(curr.getRight()!=None and curr.getLeft()==None):
                if(dir=='l'):
                    parent.setLeft(curr.getRight())
                if(dir=='r'):
                    parent.setRight(curr.getRight())
                return head
            #3. node to remove has only left
            elif(curr.getRight()==None and curr.getLeft()!=None):
                if(dir=='l'):
                    parent.setLeft(curr.getLeft())
                if(dir=='r'):
                    parent.setRight(curr.getLeft())
                return head
            #4. node to remove has both
            else:
                if(dir=='l'):
                    parent.setLeft(None)
                if(dir=='r'):
                    parent.setRight(None)
                return head
        elif(n<curr.getVal()):
            return self.remove(curr.getLeft(), curr, head, n,'l')
        elif(n>curr.getVal()):
            return self.remove(curr.getRight(), curr, head, n, 'r')
    def contains(self, n):
        return self.find(self.getRoot(), n)
    def find(self, node, n):
        curr=node
        #4 possibilites:
        #we hit a null node
        if(curr==None):
            print("Value doesn't exist!")
            return False
        #we found it 
        if(n==curr.getVal()):
            return True
        elif(n<curr.getVal()):
            return self.find(curr.getLeft(), n)
        elif(n>curr.getVal()):
            return self.find(curr.getRight(), n)
def isValid(tree):
    return isValidTree(tree.getRoot(), None, '')
def isValidTree(curr, parent, side):
    #go left and right until the end 
    #depth first search until 
    if(curr==None):
        return True
    if(parent!=None):
        if(parent.getVal()>curr.getVal() and side=='l'):
            return False
        if(parent.getVal()<curr.getVal() and side=='r'):
            return False
    x=isValidTree(curr.getRight(), curr, 'l')
    y=isValidTree(curr.getLeft(), curr, 'r')
    return x and y
#1)Find the first common parent of two nodes in the a tree.    
if __name__=='__main__':
    tree=BST(7)
    tree.addNode(20)
    tree.addNode(5)
    tree.addNode(15)
    tree.addNode(10)
    tree=tree.removeNode(7)
    #assert tree.contains(10)==True
    print(tree)
    assert isValid(tree)==True