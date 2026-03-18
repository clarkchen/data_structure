# 数据结构与算法 - Java 实现

> 《大话数据结构》Java 版本源代码，优化无止境，掌握基础才能起飞 🚀

## 📋 目录

- [环境配置](#环境配置)
- [快速开始](#快速开始)
- [项目结构](#项目结构)
- [算法列表](#算法列表)
- [多语言扩展](#多语言扩展)

## 环境配置

| 工具 | 版本 |
|------|------|
| JDK | 17+ |
| Maven | 3.6+ |
| IDE | IntelliJ IDEA / Eclipse / VS Code |

## 快速开始

### 1. 克隆项目

```bash
git clone https://github.com/clarkchen/data_structure.git
cd data_structure
```

### 2. 编译项目

```bash
cd java
mvn clean compile
```

### 3. 运行测试

```bash
cd java
mvn test
```

### 4. 打包

```bash
cd java
mvn package
```

## 项目结构

```
java/
├── pom.xml
└── src/
    ├── main/java/
    │   ├── Graph/          # 图论算法
    │   ├── List/           # 链表
    │   ├── Search/         # 查找算法
    │   ├── Sort/           # 排序算法
    │   ├── String/         # 字符串算法
    │   └── Trees/          # 树结构
    └── test/java/          # 单元测试
```

## 算法列表

### 🔗 线性结构 (List)

| 算法 | 文件 |
|------|------|
| 单链表 | `List/MyList/SingleList.java` |
| 双链表 | `List/MyList/DoubleList.java` |
| 栈（数组实现） | `List/Linear/ArrayStack.java` |
| 队列（循环数组实现） | `List/Linear/ArrayQueue.java` |

### 🔢 排序 (Sort)

| 类别 | 算法 | 文件 |
|------|------|------|
| 交换排序 | 冒泡排序 | `Sort/exchange/BubbleSort.java` |
| 交换排序 | 快速排序 | `Sort/exchange/QuickSort.java` |
| 插入排序 | 直接插入排序 | `Sort/insert/InsertSort.java` |
| 插入排序 | 希尔排序 | `Sort/insert/ShellSort.java` |
| 选择排序 | 简单选择排序 | `Sort/select/SelectSort.java` |
| 选择排序 | 堆排序 | `Sort/select/HeapSort.java` |
| 其他 | 归并排序 | `Sort/other/MergeSort.java` |
| 其他 | 基数排序 | `Sort/other/RadixSort.java` |

### 🔍 查找 (Search)

| 算法 | 文件 |
|------|------|
| 二分查找 | `Search/BinarySearch/BinarySearch.java` |
| 哈希表 | `Search/Hash/HashList.java` |

### 🌳 树 (Trees)

| 算法 | 文件 |
|------|------|
| 二叉树遍历 | `Trees/traverse/Tree.java` |
| AVL 平衡树 | `Trees/AVL/AVLTree.java` |
| 红黑树 | `Trees/ReadBalckTree/RBTree.java` |
| 哈夫曼树 | `Trees/Huffman/HuffmanTreePriority.java` |
| 线索二叉树 | `Trees/ThreadTree/threadTree.java` |

### 📊 图 (Graph)

| 算法 | 文件 | 说明 |
|------|------|------|
| Dijkstra | `Graph/Dijkstra/DijkstraShortPath.java` | 单源最短路径 |
| Floyd | `Graph/Floyd/FolydShortPath.java` | 多源最短路径 |
| SPFA | `Graph/SPFA/SPFA.java` | 最短路径快速算法 |
| Prim | `Graph/PrimTree/Prim.java` | 最小生成树 |
| Kruskal | `Graph/Kruskal/Kruskal.java` | 最小生成树 |
| 拓扑排序 | `Graph/Topological/TopologicalSort.java` | 有向无环图排序 |
| 关键路径 | `Graph/Topological/KeyPath.java` | AOE 网关键路径 |

### 📝 字符串 (String)

| 算法 | 文件 |
|------|------|
| KMP 模式匹配 | `String/KMP.java` |

## 多语言扩展

当前已统一为五种语言：Java / TypeScript / Python / Golang / Rust。

- Java 主实现：`java/src/main/java`（入口说明：`java/README.md`）
- 多语言总览：`MULTI_LANGUAGE.md`

## 许可证

MIT License

## 参考资料

- 《大话数据结构》 - 程杰
- 《算法导论》 - Thomas H. Cormen
