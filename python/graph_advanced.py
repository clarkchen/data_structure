from typing import List, Tuple


def floyd_warshall(mat: List[List[int]]) -> List[List[int]]:
    n = len(mat)
    dist = [row[:] for row in mat]
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
    return dist


def kruskal(n: int, edges: List[Tuple[int, int, int]]) -> Tuple[int, int]:
    parent = list(range(n))

    def find(x: int) -> int:
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    def unite(a: int, b: int) -> bool:
        ra, rb = find(a), find(b)
        if ra == rb:
            return False
        parent[ra] = rb
        return True

    weight = 0
    count = 0
    for u, v, w in sorted(edges, key=lambda x: x[2]):
        if unite(u, v):
            weight += w
            count += 1
            if count == n - 1:
                break

    return weight, count
