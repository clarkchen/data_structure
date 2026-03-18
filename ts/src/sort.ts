export function quickSort(arr: number[]): number[] {
  const nums = [...arr];

  function partition(left: number, right: number): number {
    const pivot = nums[right];
    let i = left;
    for (let j = left; j < right; j++) {
      if (nums[j] <= pivot) {
        [nums[i], nums[j]] = [nums[j], nums[i]];
        i++;
      }
    }
    [nums[i], nums[right]] = [nums[right], nums[i]];
    return i;
  }

  function sort(left: number, right: number): void {
    if (left >= right) return;
    const p = partition(left, right);
    sort(left, p - 1);
    sort(p + 1, right);
  }

  sort(0, nums.length - 1);
  return nums;
}
