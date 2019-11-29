#include<stdio.h>
#include<stdlib.h>
typedef struct test_struct
{
    int val;
    struct test_struct *next;
}ts;
ts *head = NULL;
ts *curr = NULL;
ts* create_list(int val){
    printf("\n creating list with headnode as [%d]\n",val);
    ts *ptr = (ts*)malloc(sizeof(ts));
    if(NULL == ptr){
        printf("\n Node creation failed \n");
        return NULL;
    }
    ptr->val = val;
    ptr->next = NULL;
    head = curr = ptr;
    return ptr;
}
ts* add_to_list(int val, int add_to_end){
    if(NULL == head){
        return (create_list(val));
    }
    if(add_to_end)
        printf("\n Adding node to end of list with value [%d]\n",val);
    else
        printf("\n Adding node to beginning of list with value [%d]\n",val);
    ts *ptr = (ts*)malloc(sizeof(ts));
    if(NULL == ptr){
        printf("\n Node creation failed \n");
        return NULL;
    }
    ptr->val = val;
    ptr->next = NULL;
    if(add_to_end){
        curr->next = ptr;
        curr = ptr;
    }
    else{
        ptr->next = head;
        head = ptr;
    }
    return ptr;
}
ts* search_in_list(int val, ts **prev){
    ts *ptr = head;
    ts *tmp = NULL;
    int found = 0;
    printf("\n Searching the list for value [%d] \n",val);
    while(ptr != NULL){
        if(ptr->val == val){
            found=1;
            break;
        }else{
            tmp = ptr;
            ptr = ptr->next;
        }
    }
    if(found==1){
        if(prev)
            *prev = tmp;
        return ptr;
    }else{
        return NULL;
    }
}
int delete_from_list(int val)
{
    ts *prev = NULL;
    ts *del = NULL;
    printf("\n Deleting value [%d] from list\n",val);
    del = search_in_list(val,&prev);
    if(del == NULL){
        return -1;
    }else{
        if(prev != NULL)
            prev->next = del->next;
        if(del == curr){
            curr = prev;
        }
        else if(del == head){
            head = del->next;
        }
    }
    free(del);
    del = NULL;
    return 0;
}
void print_list(void){
    ts *ptr = head;
    printf("\n -------Printing list Start------- \n");
    while(ptr != NULL){
        printf("\n [%d] \n",ptr->val);
        ptr = ptr->next;
    }
    printf("\n -------Printing list End------- \n");
    return;
}
int main(void)
{
    int i = 0, ret = 0;
    struct test_struct *ptr = NULL;

    print_list();

    for(i = 5; i<10; i++)
        add_to_list(i,1);

    print_list();

    for(i = 4; i>0; i--)
        add_to_list(i,0);

    print_list();

    for(i = 1; i<10; i += 4)
    {
        ptr = search_in_list(i, NULL);
        if(NULL == ptr)
        {
            printf("\n Search [val = %d] failed, no such element found\n",i);
        }
        else
        {
            printf("\n Search passed [val = %d]\n",ptr->val);
        }

        print_list();

        ret = delete_from_list(i);
        if(ret != 0)
        {
            printf("\n delete [val = %d] failed, no such element found\n",i);
        }
        else
        {
            printf("\n delete [val = %d]  passed \n",i);
        }

        print_list();
    }

    return 0;
}
