package main

import "fmt"

type stack struct {
	nums []int
}

func main() {
	Stac := &stack{}
	push(Stac, 1)
	push(Stac, 2)
	push(Stac, 3)
	fmt.Println(pop(Stac))
	fmt.Println(pop(Stac))
	fmt.Println(pop(Stac))
}
func push(s *stack, n int) {
	s.nums = append(s.nums, n)
}
func pop(s *stack) int {
	i := s.nums[len(s.nums)-1]
	s.nums = s.nums[0 : len(s.nums)-1]
	return i
}
