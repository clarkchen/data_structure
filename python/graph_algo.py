from typing import List, Tuple


def dijkstra(n: int, graph: List[List[Tuple[int, int]]], src: int) -> List[int]:
    inf = 10**18
    dist = [inf] * n
    used = [False] * n
    dist[src] = 0

    for _ in range(n):
        u = -1
        for v in range(n):
            if not used[v] and (u == -1 or dist[v] < dist[u]):
                u = v
        if u == -1 or dist[u] == inf:
            break
        used[u] = True

        for to, w in graph[u]:
            if dist[to] > dist[u] + w:
                dist[to] = dist[u] + w

    return dist


def topological_sort(n: int, graph: List[List[int]]) -> List[int]:
    indeg = [0] * n
    for u in range(n):
        for v in graph[u]:
            indeg[v] += 1

    q = [i for i in range(n) if indeg[i] == 0]
    order = []
    i = 0
    while i < len(q):
        u = q[i]
        i += 1
        order.append(u)
        for v in graph[u]:
            indeg[v] -= 1
            if indeg[v] == 0:
                q.append(v)

    return order if len(order) == n else []
