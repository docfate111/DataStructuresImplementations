package main

import "fmt"

type node struct {
	val  int
	name string
	next *node
}

func main() {
	one := &node{1, "info", nil}
	two := &node{2, "more", nil}
	one = addNodeEnd(one, two)
	printList(one)
}
func printList(regs *node) {
	for p := regs; p != nil; p = p.next {
		fmt.Println(p.name+" = ", p.val)
	}
}

func addNodeEnd(node, regs *node) *node {
	if regs == nil {
		return regs
	}
	for p := regs; p != nil; p = p.next {
		if p.next == nil {
			p.next = node
			return regs
		}
	}
	return regs
}

func searchList(s string, regs *node) *node {
	if regs == nil {
		return nil
	}
	for p := regs; p != nil; p = p.next {
		if p.name == s {
			return p
		}
	}
	return nil
}
