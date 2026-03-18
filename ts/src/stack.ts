export class Stack<T> {
  private data: T[] = [];

  push(value: T): void {
    this.data.push(value);
  }

  pop(): T {
    if (this.isEmpty()) throw new Error("stack is empty");
    return this.data.pop() as T;
  }

  peek(): T {
    if (this.isEmpty()) throw new Error("stack is empty");
    return this.data[this.data.length - 1];
  }

  size(): number {
    return this.data.length;
  }

  isEmpty(): boolean {
    return this.data.length === 0;
  }
}
