from typing import List, Tuple


class DSU:
    def __init__(self, n: int):
        self.parent = list(range(n))

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, a: int, b: int) -> bool:
        ra, rb = self.find(a), self.find(b)
        if ra == rb:
            return False
        self.parent[ra] = rb
        return True


def prim(n: int, graph: List[List[Tuple[int, int]]], start: int = 0) -> Tuple[int, int]:
    inf = 10**18
    dist = [inf] * n
    used = [False] * n
    dist[start] = 0

    weight = 0
    count = 0
    for _ in range(n):
        u = -1
        for v in range(n):
            if not used[v] and (u == -1 or dist[v] < dist[u]):
                u = v
        if u == -1 or dist[u] == inf:
            break
        used[u] = True
        weight += dist[u]
        count += 1

        for to, w in graph[u]:
            if not used[to] and w < dist[to]:
                dist[to] = w

    return weight, count


def spfa(n: int, graph: List[List[Tuple[int, int]]], src: int) -> List[int]:
    inf = 10**18
    dist = [inf] * n
    in_q = [False] * n
    q = []

    dist[src] = 0
    q.append(src)
    in_q[src] = True

    i = 0
    while i < len(q):
        u = q[i]
        i += 1
        in_q[u] = False

        for to, w in graph[u]:
            if dist[u] + w < dist[to]:
                dist[to] = dist[u] + w
                if not in_q[to]:
                    q.append(to)
                    in_q[to] = True

    return dist
