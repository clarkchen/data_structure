package algorithm

func QuickSort(nums []int) []int {
	arr := make([]int, len(nums))
	copy(arr, nums)

	var partition func(int, int) int
	partition = func(left, right int) int {
		pivot := arr[right]
		i := left
		for j := left; j < right; j++ {
			if arr[j] <= pivot {
				arr[i], arr[j] = arr[j], arr[i]
				i++
			}
		}
		arr[i], arr[right] = arr[right], arr[i]
		return i
	}

	var sort func(int, int)
	sort = func(left, right int) {
		if left >= right {
			return
		}
		p := partition(left, right)
		sort(left, p-1)
		sort(p+1, right)
	}

	sort(0, len(arr)-1)
	return arr
}

func BinarySearch(arr []int, target int) int {
	left, right := 0, len(arr)-1
	for left <= right {
		mid := left + (right-left)/2
		if arr[mid] == target {
			return mid
		}
		if arr[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}
	return -1
}
