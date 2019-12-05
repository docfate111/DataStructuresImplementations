#include <stdio.h>
#include <stdlib.h>
#define TRUE 1
#define FALSE 0
#define LEN(L) sizeof(L)/sizeof(L[0])
typedef struct Node{
    int data;
    struct Node* next;
} node;
node* newNode(int a){
    node* new=(node*)malloc(sizeof(node));
    new->data=a;
    new->next=NULL;
    return new;
}
node* append(node* root, int a){
    node* curr=root;
    node* n=newNode(a);
    while(root->next!=NULL){
        root=root->next;
    }
    root->next=n;
    return curr;
}
void printList(node* root){
    while(root->next!=NULL){
        printf("%d -> ", root->data);
        root=root->next;
    }
    printf("%d", root->data);
}
int lenList(node* root){
    int count=0;
     while(root!=NULL){
        count++;
        root=root->next;
    }
    return count;
}
node* removeNode(node* root, int a){
    node* curr=root;
    if(root->data==a){
        return root->next;
    }
    while(root->next!=NULL){
        if(root->next->data==a){
            if(root->next->next==NULL){
                root->next=NULL;
                return curr;
            }
            root->next=root->next->next;
        }
        root=root->next;
    }
    return curr;
}
int isIn(int arr[], int len, int num){
    for(int i=0; i<len; i++){
        if(num==arr[i]){
            return TRUE;
        }
    }
    return FALSE;
}
/*2.1 Write code to remove duplicates from an unsorted linked list.*/
node* removeDuplicates(node* root){
    node* head=root;
    int seen[10];
    for(int i=0; i<10; i++){
        seen[i]=-1;
    }
    int count=0;
    node* past=root;
    while(root!=NULL){
        if(isIn(seen, 10, root->data)){
            past->next=root->next;
        }else{
            seen[count++]=root->data;
        }
        past=root;
        root=root->next;
    }
    return head;
}
//2.2 Implement an algorithm to find the nth to last element of a singly linked list.
int nth2last(node* root, int n){
    //index we are looking for
    int index=lenList(root)-n;
    int count=0;
    while(index!=count){
        root=root->next;
        count++;
    }
    return root->data;
}
/*2.3 Implement an algorithm to delete a node in the middle of a single linked list, given
only access to that node.
Input: the node ‘c’ from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a->b->d->e*/
void removeN(node* root, int a){
    if(root->data==a){
        root=root->next;
        return;
    }
    while(root->next!=NULL){
        if(root->next->data==a){
            if(root->next->next==NULL){
                root->next=NULL;
                return;
            }
            root->next=root->next->next;
        }
        root=root->next;
    }
}
/*2.4 You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
the list. Write a function that adds the two numbers and returns the sum as a linked
list.
EXAMPLE
Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
Output: 8 -> 0 -> 8*/
node* addLists(node* s, node* t){
    int sum=s->data+t->data;
    node* sumn=newNode(sum%10);
    int carry=sum/10;
    while(s->next!=NULL && t->next!=NULL){
        s=s->next;
        t=t->next;
        sum=s->data+t->data+carry;
        carry=sum/10;
        sumn=append(sumn, sum%10);
    }
    return sumn;
}
/*2.5 Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an
earlier node, so as to make a loop in the linked list.
EXAMPLE
input: A -> B -> C -> D -> E -> C [the same C as earlier]
output: C*/
int isInP(node* arr[], int len, node* num){
    for(int i=0; i<len; i++){
        if(num==arr[i]){
            return TRUE;
        }
    }
    return FALSE;
}
void stopLoop(node* root){
    node* seen[10];
    int count=0;
    node* past=root;
    while(root!=NULL){
        if(isInP(seen, 10, root->next)){
            printf("%d ", root->next->data);
            return;
        }else{
            seen[count++]=root->next;
        }
        past=root;
        root=root->next;
    }
}
/*int main(){
    //a=removeNode(a, 2);
    //a=removeDuplicates(a);
    /*node* a=newNode(3);
    a=append(a, 1);
    a=append(a, 5);
    node* b=newNode(5);
    b=append(b, 9);
    b=append(b, 2);*/
    //printList(addLists(a, b));
    //removeNode(a, 5);
    //printf("\n%d", nth2last(a, 3));
    node* l=newNode('A');
    l=append(l, 'B');
    l=append(l, 'C');
    node* s=l->next->next;
    l=append(l, 'D');
    l=append(l, 'E');
    l=append(l, 'C');
    l->next->next->next->next->next->next=s;
    stopLoop(l);
    //printList(s);
    return 0;
}*/