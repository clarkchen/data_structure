pub mod graph;
pub mod graph_extra;
pub mod string;
pub mod tree;

pub struct Stack<T> {
    data: Vec<T>,
}

impl<T> Stack<T> {
    pub fn new() -> Self {
        Self { data: Vec::new() }
    }

    pub fn push(&mut self, v: T) {
        self.data.push(v);
    }

    pub fn pop(&mut self) -> Option<T> {
        self.data.pop()
    }

    pub fn peek(&self) -> Option<&T> {
        self.data.last()
    }

    pub fn len(&self) -> usize {
        self.data.len()
    }

    pub fn is_empty(&self) -> bool {
        self.data.is_empty()
    }
}

pub struct Queue<T> {
    data: std::collections::VecDeque<T>,
}

impl<T> Queue<T> {
    pub fn new() -> Self {
        Self {
            data: std::collections::VecDeque::new(),
        }
    }

    pub fn offer(&mut self, v: T) {
        self.data.push_back(v);
    }

    pub fn poll(&mut self) -> Option<T> {
        self.data.pop_front()
    }

    pub fn peek(&self) -> Option<&T> {
        self.data.front()
    }

    pub fn len(&self) -> usize {
        self.data.len()
    }

    pub fn is_empty(&self) -> bool {
        self.data.is_empty()
    }
}

pub fn quick_sort(nums: &[i32]) -> Vec<i32> {
    let mut arr = nums.to_vec();
    if !arr.is_empty() {
        sort_impl(&mut arr, 0, (arr.len() - 1) as isize);
    }
    arr
}

fn sort_impl(arr: &mut [i32], left: isize, right: isize) {
    if left >= right {
        return;
    }
    let p = partition(arr, left, right);
    sort_impl(arr, left, p - 1);
    sort_impl(arr, p + 1, right);
}

fn partition(arr: &mut [i32], left: isize, right: isize) -> isize {
    let pivot = arr[right as usize];
    let mut i = left;
    for j in left..right {
        if arr[j as usize] <= pivot {
            arr.swap(i as usize, j as usize);
            i += 1;
        }
    }
    arr.swap(i as usize, right as usize);
    i
}

pub fn binary_search(arr: &[i32], target: i32) -> isize {
    let mut left: isize = 0;
    let mut right: isize = arr.len() as isize - 1;

    while left <= right {
        let mid = left + (right - left) / 2;
        let val = arr[mid as usize];
        if val == target {
            return mid;
        }
        if val < target {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    -1
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn stack_should_be_lifo() {
        let mut s = Stack::new();
        s.push(1);
        s.push(2);
        assert_eq!(s.peek(), Some(&2));
        assert_eq!(s.pop(), Some(2));
        assert_eq!(s.pop(), Some(1));
    }

    #[test]
    fn queue_should_be_fifo() {
        let mut q = Queue::new();
        q.offer(1);
        q.offer(2);
        assert_eq!(q.peek(), Some(&1));
        assert_eq!(q.poll(), Some(1));
        assert_eq!(q.poll(), Some(2));
    }

    #[test]
    fn sort_and_search_should_work() {
        let sorted = quick_sort(&[4, 2, 7, 1, 3]);
        assert_eq!(sorted, vec![1, 2, 3, 4, 7]);
        assert_eq!(binary_search(&sorted, 4), 3);
        assert_eq!(binary_search(&sorted, 9), -1);
    }

    #[test]
    fn kmp_should_work() {
        assert_eq!(crate::string::kmp_search("ababcabcacbab", "abcac"), 5);
        assert_eq!(crate::string::kmp_search("hello", "world"), -1);
    }

    #[test]
    fn tree_and_heap_should_work() {
        let mut root = None;
        crate::tree::bst_insert(&mut root, 3);
        crate::tree::bst_insert(&mut root, 1);
        crate::tree::bst_insert(&mut root, 2);
        let mut out = Vec::new();
        crate::tree::inorder(&root, &mut out);
        assert_eq!(out, vec![1, 2, 3]);

        let mut h = crate::tree::MinHeap::new();
        h.push(4);
        h.push(1);
        h.push(3);
        assert_eq!(h.pop(), Some(1));
    }

    #[test]
    fn graph_extra_should_work() {
        let g = vec![vec![(1, 2), (2, 5)], vec![(0, 2), (2, 1)], vec![(0, 5), (1, 1)]];
        let (w, c) = crate::graph_extra::prim(3, &g, 0);
        assert_eq!(c, 3);
        assert_eq!(w, 3);

        let dist = crate::graph_extra::spfa(3, &g, 0);
        assert_eq!(dist[2], 3);

        let mut dsu = crate::graph_extra::Dsu::new(3);
        assert!(dsu.union(0, 1));
        assert!(!dsu.union(0, 1));
    }
}

