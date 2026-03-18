export class Queue<T> {
  private data: T[] = [];

  offer(value: T): void {
    this.data.push(value);
  }

  poll(): T {
    if (this.isEmpty()) throw new Error("queue is empty");
    return this.data.shift() as T;
  }

  peek(): T {
    if (this.isEmpty()) throw new Error("queue is empty");
    return this.data[0];
  }

  size(): number {
    return this.data.length;
  }

  isEmpty(): boolean {
    return this.data.length === 0;
  }
}
