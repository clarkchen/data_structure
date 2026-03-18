from typing import List


def quick_sort(nums: List[int]) -> List[int]:
    arr = nums[:]

    def partition(left: int, right: int) -> int:
        pivot = arr[right]
        i = left
        for j in range(left, right):
            if arr[j] <= pivot:
                arr[i], arr[j] = arr[j], arr[i]
                i += 1
        arr[i], arr[right] = arr[right], arr[i]
        return i

    def sort(left: int, right: int) -> None:
        if left >= right:
            return
        p = partition(left, right)
        sort(left, p - 1)
        sort(p + 1, right)

    sort(0, len(arr) - 1)
    return arr


def binary_search(arr: List[int], target: int) -> int:
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = left + (right - left) // 2
        if arr[mid] == target:
            return mid
        if arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1
