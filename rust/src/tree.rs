pub struct BstNode {
    pub val: i32,
    pub left: Option<Box<BstNode>>,
    pub right: Option<Box<BstNode>>,
}

impl BstNode {
    pub fn new(val: i32) -> Self {
        Self {
            val,
            left: None,
            right: None,
        }
    }
}

pub fn bst_insert(root: &mut Option<Box<BstNode>>, val: i32) {
    match root {
        None => *root = Some(Box::new(BstNode::new(val))),
        Some(node) => {
            if val < node.val {
                bst_insert(&mut node.left, val);
            } else {
                bst_insert(&mut node.right, val);
            }
        }
    }
}

pub fn inorder(root: &Option<Box<BstNode>>, out: &mut Vec<i32>) {
    if let Some(node) = root {
        inorder(&node.left, out);
        out.push(node.val);
        inorder(&node.right, out);
    }
}

pub struct MinHeap {
    data: Vec<i32>,
}

impl MinHeap {
    pub fn new() -> Self {
        Self { data: Vec::new() }
    }

    pub fn push(&mut self, x: i32) {
        self.data.push(x);
        let mut i = self.data.len() - 1;
        while i > 0 {
            let p = (i - 1) / 2;
            if self.data[p] <= self.data[i] {
                break;
            }
            self.data.swap(i, p);
            i = p;
        }
    }

    pub fn pop(&mut self) -> Option<i32> {
        if self.data.is_empty() {
            return None;
        }
        let top = self.data[0];
        let last = self.data.pop().unwrap();
        if !self.data.is_empty() {
            self.data[0] = last;
            self.sift_down(0);
        }
        Some(top)
    }

    fn sift_down(&mut self, mut i: usize) {
        let n = self.data.len();
        loop {
            let mut s = i;
            let l = i * 2 + 1;
            let r = i * 2 + 2;
            if l < n && self.data[l] < self.data[s] {
                s = l;
            }
            if r < n && self.data[r] < self.data[s] {
                s = r;
            }
            if s == i {
                break;
            }
            self.data.swap(i, s);
            i = s;
        }
    }
}
