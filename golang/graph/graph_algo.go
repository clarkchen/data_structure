package graph

func Dijkstra(n int, g [][][2]int, src int) []int {
	const inf = int(1e18)
	dist := make([]int, n)
	used := make([]bool, n)
	for i := 0; i < n; i++ {
		dist[i] = inf
	}
	dist[src] = 0

	for i := 0; i < n; i++ {
		u := -1
		for v := 0; v < n; v++ {
			if !used[v] && (u == -1 || dist[v] < dist[u]) {
				u = v
			}
		}
		if u == -1 || dist[u] == inf {
			break
		}
		used[u] = true

		for _, e := range g[u] {
			to, w := e[0], e[1]
			if dist[to] > dist[u]+w {
				dist[to] = dist[u] + w
			}
		}
	}
	return dist
}

func TopologicalSort(n int, g [][]int) []int {
	indeg := make([]int, n)
	for u := 0; u < n; u++ {
		for _, v := range g[u] {
			indeg[v]++
		}
	}
	q := []int{}
	for i := 0; i < n; i++ {
		if indeg[i] == 0 {
			q = append(q, i)
		}
	}
	order := []int{}
	for i := 0; i < len(q); i++ {
		u := q[i]
		order = append(order, u)
		for _, v := range g[u] {
			indeg[v]--
			if indeg[v] == 0 {
				q = append(q, v)
			}
		}
	}
	if len(order) != n {
		return []int{}
	}
	return order
}
