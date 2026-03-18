package algorithm

import "testing"

func TestSortSearch(t *testing.T) {
	arr := QuickSort([]int{4, 1, 3, 2})
	expect := []int{1, 2, 3, 4}
	for i := range expect {
		if arr[i] != expect[i] {
			t.Fatalf("sort mismatch at %d", i)
		}
	}
	if BinarySearch(arr, 3) != 2 {
		t.Fatal("binary search expected index 2")
	}
	if BinarySearch(arr, 9) != -1 {
		t.Fatal("binary search expected -1")
	}
}
