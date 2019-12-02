/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   queue.h
 * Author: thwilliams
 *
 * Created on December 2, 2019, 12:06 PM
 */
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