package main

import "fmt"

type Queue struct {
	list []int
}

func printQ(q *Queue) {
	for i := 0; i < len(q.list); i++ {
		fmt.Println(q.list[i])
	}
}
func (q *Queue) Enqueque(i int) {
	q.list = append(q.list, i)
}

func (q *Queue) Dequeque() int {
	if len(q.list) == 0 {
		return -1
	}
	item := q.list[0]
	q.list = q.list[1:]
	return item
}

func main() {
	q := &Queue{}
	q.Enqueque(1)
	q.Enqueque(3)
	q.Enqueque(5)
	printQ(q)
	q.Dequeque()
	q.Dequeque()
	printQ(q)
	q.Dequeque()
}
