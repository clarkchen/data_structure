# 多语言扩展说明（Java / TypeScript / Python / Golang / Rust）

当前仓库以 Java 为主（`src/main/java`）。
目前已新增：
- 线性结构（栈 / 队列）
- 排序与查找（快速排序 / 二分查找）
- 字符串（KMP）
- 树（BST / 堆）
- 图（Dijkstra / 拓扑排序 / Floyd / Kruskal）

已覆盖 Java / TypeScript / Python / Golang / Rust 的基础实现。

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

1. 进阶树结构（AVL、红黑树）
2. 进阶图算法（Floyd、Prim、Kruskal、SPFA）
3. 每种语言补测试与 benchmark
4. 增加统一的题目示例与复杂度说明

## 设计原则

- API 名称尽量统一（push/pop/peek、offer/poll/peek）
- 每种语言先有最小可用实现，再补性能优化与测试覆盖
- 示例先保证可读性，再做语言级高级写法
