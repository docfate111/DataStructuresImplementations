#include <stdio.h>
#include <stdlib.h>
typedef struct node{
	int data; //4 bytes
	struct node* next; //pointer to next chunk in the linked list
}node;
node *createList(int n){ //returning starting address
	//n number of nodes to be created
	int i=0;
	node *head=NULL; node *temp=NULL; node *p=NULL;
	for(i=0; i<n; i++){
		//create individual nodes
		temp=(node*)malloc(sizeof(node)); //creates struct node
		printf("\nEnter the data for node number %d:", i +1);
		scanf("%d", &(temp->data));
		temp->next=NULL;
	if(head==NULL){//if empty set temp as first node
		head=temp;
	}else{//sets nodes equal to address of next node
		p=head;
		while(p->next != NULL){
			p=p->next;
		}
		p->next=temp;
	}
	}
	return head;
	}
void displayList(node *head){
	node *p=head;
	while(p != NULL){
		printf("%d -> ", p->data);
		p=p->next; //continues to next null until end when pointer
		//is null
	}
}
node* search(node *h, int lookfor){
	node *p=h;
	int n=1;
	int found=0;
	while(p!=NULL){
		if(p->data==lookfor){
			printf("Element %d", n);
			found++;
			break;
		}
		p=p->next;
		n++;
	}
	if(found==0){
		printf("Not found");
		return NULL;
	}else{return p;}
	}
int main(){
	int n=0;
	node *head=NULL;
	printf("\nHow many nodes? ");
	scanf("%d", &n);
	head=createList(n);
	displayList(head);
	search(head, 3);
	return 0;}

