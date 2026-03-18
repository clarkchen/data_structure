package graph

type DSU struct {
	parent []int
}

func NewDSU(n int) *DSU {
	p := make([]int, n)
	for i := 0; i < n; i++ {
		p[i] = i
	}
	return &DSU{parent: p}
}

func (d *DSU) Find(x int) int {
	if d.parent[x] != x {
		d.parent[x] = d.Find(d.parent[x])
	}
	return d.parent[x]
}

func (d *DSU) Union(a, b int) bool {
	ra, rb := d.Find(a), d.Find(b)
	if ra == rb {
		return false
	}
	d.parent[ra] = rb
	return true
}

func Prim(n int, g [][][2]int, start int) (int, int) {
	const inf = int(1e18)
	dist := make([]int, n)
	used := make([]bool, n)
	for i := 0; i < n; i++ {
		dist[i] = inf
	}
	dist[start] = 0

	weight, count := 0, 0
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
		weight += dist[u]
		count++
		for _, e := range g[u] {
			to, w := e[0], e[1]
			if !used[to] && w < dist[to] {
				dist[to] = w
			}
		}
	}
	return weight, count
}

func SPFA(n int, g [][][2]int, src int) []int {
	const inf = int(1e18)
	dist := make([]int, n)
	inQ := make([]bool, n)
	for i := 0; i < n; i++ {
		dist[i] = inf
	}
	dist[src] = 0

	q := []int{src}
	inQ[src] = true

	for i := 0; i < len(q); i++ {
		u := q[i]
		inQ[u] = false
		for _, e := range g[u] {
			to, w := e[0], e[1]
			if dist[u]+w < dist[to] {
				dist[to] = dist[u] + w
				if !inQ[to] {
					q = append(q, to)
					inQ[to] = true
				}
			}
		}
	}
	return dist
}
