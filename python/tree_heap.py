import heapq
from dataclasses import dataclass
from typing import Optional, List


@dataclass
class Node:
    value: int
    left: Optional["Node"] = None
    right: Optional["Node"] = None


class BinarySearchTree:
    def __init__(self):
        self.root: Optional[Node] = None

    def insert(self, value: int):
        self.root = self._insert(self.root, value)

    def _insert(self, node: Optional[Node], value: int) -> Node:
        if node is None:
            return Node(value)
        if value < node.value:
            node.left = self._insert(node.left, value)
        else:
            node.right = self._insert(node.right, value)
        return node

    def inorder(self) -> List[int]:
        res: List[int] = []

        def dfs(node: Optional[Node]):
            if not node:
                return
            dfs(node.left)
            res.append(node.value)
            dfs(node.right)

        dfs(self.root)
        return res


class MinHeap:
    def __init__(self):
        self._h = []

    def push(self, v: int):
        heapq.heappush(self._h, v)

    def pop(self) -> int:
        return heapq.heappop(self._h)

    def peek(self) -> int:
        return self._h[0]

    def is_empty(self) -> bool:
        return len(self._h) == 0
