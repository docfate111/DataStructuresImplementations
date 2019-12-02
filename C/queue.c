#include <stdio.h>
#include <stdlib.h>
void init(int *head, int *tail){
    *head = *tail = 0;
}
void enQ(int *q,int *tail, int element){
    q[(*tail)++] = element;
}
int dQ(int *q,int *head){
    return q[(*head)++];
}
void printQ(int *q,int head,int tail){
    int i = tail - 1;
    while(i >= head)
        printf("%d ",q[i--]);
}
int main(){
    int head, tail;
    int queue[5];
    init(&head,&tail);
    enQ(queue,&tail, 3);
    enQ(queue,&tail, 4);
    enQ(queue,&tail, 7);
    //dQ(queue, &head);
    printQ(queue,head,tail);
    return 0;
}