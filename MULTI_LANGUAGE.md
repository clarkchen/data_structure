# 多语言扩展说明（Java / TypeScript / Python / Golang / Rust）

当前仓库以 Java 为主（`src/main/java`）。
本次新增了统一的“线性结构”多语言示例，便于后续继续扩展到排序、树、图。

## 目录

- Java（已有）
  - `src/main/java/List/Linear/ArrayStack.java`
  - `src/main/java/List/Linear/ArrayQueue.java`
- TypeScript
  - `ts/src/stack.ts`
  - `ts/src/queue.ts`
- Python
  - `python/stack_queue.py`
- Golang
  - `golang/linear/stack_queue.go`
- Rust
  - `rust/src/lib.rs`

## 后续建议扩展顺序

1. 排序（快排、归并、堆排）
2. 查找（二分、哈希）
3. 树（AVL、红黑树、堆）
4. 图（Dijkstra、Floyd、Prim、Kruskal）

## 设计原则

- API 名称尽量统一（push/pop/peek、offer/poll/peek）
- 每种语言先有最小可用实现，再补性能优化与测试覆盖
- 示例先保证可读性，再做语言级高级写法
