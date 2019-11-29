//binary search tree
package main

type Tree struct {
	node *Node
}

type Node struct {
	value int
	left  *Node
	right *Node
}

func (n *Node) insert(value int) {
	if value <= n.value {
		if n.left == nil {
			n.left = &Node{value: value}
		} else {
			n.left.insert(value)
		}
	} else {
		if n.right == nil {
			n.right = &Node{value: value}
		} else {
			n.right.insert(value)
		}

	}
}

func (t *Tree) insert(value int) *Tree {
	if t.node == nil {
		t.node = &Node{value: value}
	} else {
		t.node.insert(value)
	}
	return t
}

func printNode(n *Node) {
	if n == nil {
		return
	}
	println(n.value)
	printNode(n.left)
	printNode(n.right)
}
func (n *Node) isIn(value int) bool {
	if n == nil {
		return false
	}
	if n.value == value {
		return true
	}
	if value <= n.value {
		return n.left.isIn(value)
	} else {
		return n.right.isIn(value)
	}
}
func main() {
	t := &Tree{}
	t.insert(30).insert(48).insert(50).insert(45)
	printNode(t.node)
	println(t.node.isIn(25))
	println(t.node.isIn(50))
}
