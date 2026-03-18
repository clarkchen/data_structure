package tree

import "container/heap"

type Node struct {
	Val         int
	Left, Right *Node
}

type BST struct {
	Root *Node
}

func (b *BST) Insert(v int) {
	b.Root = insertNode(b.Root, v)
}

func insertNode(n *Node, v int) *Node {
	if n == nil {
		return &Node{Val: v}
	}
	if v < n.Val {
		n.Left = insertNode(n.Left, v)
	} else {
		n.Right = insertNode(n.Right, v)
	}
	return n
}

func (b *BST) Inorder() []int {
	res := []int{}
	var dfs func(*Node)
	dfs = func(n *Node) {
		if n == nil {
			return
		}
		dfs(n.Left)
		res = append(res, n.Val)
		dfs(n.Right)
	}
	dfs(b.Root)
	return res
}

type IntMinHeap []int

func (h IntMinHeap) Len() int           { return len(h) }
func (h IntMinHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntMinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *IntMinHeap) Push(x any)        { *h = append(*h, x.(int)) }
func (h *IntMinHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[:n-1]
	return x
}

func HeapPush(h *IntMinHeap, v int) {
	heap.Push(h, v)
}

func HeapPop(h *IntMinHeap) int {
	return heap.Pop(h).(int)
}
