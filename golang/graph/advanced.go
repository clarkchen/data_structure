package graph

func FloydWarshall(mat [][]int) [][]int {
	n := len(mat)
	dist := make([][]int, n)
	for i := 0; i < n; i++ {
		dist[i] = make([]int, n)
		copy(dist[i], mat[i])
	}
	for k := 0; k < n; k++ {
		for i := 0; i < n; i++ {
			for j := 0; j < n; j++ {
				if dist[i][k]+dist[k][j] < dist[i][j] {
					dist[i][j] = dist[i][k] + dist[k][j]
				}
			}
		}
	}
	return dist
}

type WEdge struct {
	U, V, W int
}

func Kruskal(n int, edges []WEdge) (int, int) {
	parent := make([]int, n)
	for i := 0; i < n; i++ {
		parent[i] = i
	}
	var find func(int) int
	find = func(x int) int {
		if parent[x] != x {
			parent[x] = find(parent[x])
		}
		return parent[x]
	}
	unite := func(a, b int) bool {
		ra, rb := find(a), find(b)
		if ra == rb {
			return false
		}
		parent[ra] = rb
		return true
	}
	for i := 0; i < len(edges); i++ {
		for j := i + 1; j < len(edges); j++ {
			if edges[j].W < edges[i].W {
				edges[i], edges[j] = edges[j], edges[i]
			}
		}
	}
	weight, count := 0, 0
	for _, e := range edges {
		if unite(e.U, e.V) {
			weight += e.W
			count++
			if count == n-1 {
				break
			}
		}
	}
	return weight, count
}
