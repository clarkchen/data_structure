export class BinarySearchTree {
  private root: Node | null = null;

  insert(value: number): void {
    this.root = this.insertNode(this.root, value);
  }

  inorder(): number[] {
    const res: number[] = [];
    const dfs = (node: Node | null) => {
      if (!node) return;
      dfs(node.left);
      res.push(node.value);
      dfs(node.right);
    };
    dfs(this.root);
    return res;
  }

  private insertNode(node: Node | null, value: number): Node {
    if (!node) return new Node(value);
    if (value < node.value) node.left = this.insertNode(node.left, value);
    else node.right = this.insertNode(node.right, value);
    return node;
  }
}

class Node {
  value: number;
  left: Node | null = null;
  right: Node | null = null;

  constructor(value: number) {
    this.value = value;
  }
}

export class MinHeap {
  private data: number[] = [];

  push(v: number): void {
    this.data.push(v);
    this.siftUp(this.data.length - 1);
  }

  pop(): number {
    if (this.data.length === 0) throw new Error("heap is empty");
    const top = this.data[0];
    const last = this.data.pop()!;
    if (this.data.length > 0) {
      this.data[0] = last;
      this.siftDown(0);
    }
    return top;
  }

  private siftUp(i: number) {
    while (i > 0) {
      const p = (i - 1) >> 1;
      if (this.data[p] <= this.data[i]) break;
      [this.data[p], this.data[i]] = [this.data[i], this.data[p]];
      i = p;
    }
  }

  private siftDown(i: number) {
    const n = this.data.length;
    while (true) {
      let s = i;
      const l = i * 2 + 1;
      const r = i * 2 + 2;
      if (l < n && this.data[l] < this.data[s]) s = l;
      if (r < n && this.data[r] < this.data[s]) s = r;
      if (s === i) break;
      [this.data[s], this.data[i]] = [this.data[i], this.data[s]];
      i = s;
    }
  }
}
