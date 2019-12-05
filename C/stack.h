#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 100
typedef struct node{
	int val; //4 bytes
	char* name;
	struct node* next; //pointer to next chunk in the linked list
}node;
typedef struct stack{
	int* pos;
	int stack[MAX];
	int n;
}stack;
void stack_init(stack* a){
	a->pos=a->stack;
	a->n=0;
}
void push(stack* a, int v){
	*a->pos=v;
	a->pos++;
	a->n++;
}
int pop(stack* s){
	if(s->n<=0){
		printf("Can't pop. Bottom of stack reached.\n");
	}
	s->pos--;
	s->n--;
	return *s->pos;
}
node *createList(int n, char c){ //returning starting address
	//n number of nodes to be created
	int i=0;
	node *head=NULL; node *temp=NULL; node *p=NULL;
	for(i=0; i<n; i++){
		//create individual nodes
		temp=(node*)malloc(sizeof(node)); //creates struct node
		temp->val=0;
		if(c=='r'){
			temp->name=registers[i];
		}else{
			temp->name="";
		}
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
void printList(node *head){
	node *p=head;
	while(p != NULL){
		printf("%s=%d\n", p->name, p->val);
		p=p->next; //continues to next null until end when pointer
		//is null
	}
}
node* search(node *h, char* lookfor, char verbose){
	node *p=h;
	int n=1;
	int found=0;
	while(p!=NULL){
		if(strcmp(lookfor, p->name)==0){
			if(verbose=='v'){
				printf("%d", p->val);
			}
			found++;
			break;
		}
		p=p->next;
		n++;
	}
	if(found==0){
		if(verbose=='v')
			printf("Not found");
		return p;
	}else{
		return p;
		}
	}

