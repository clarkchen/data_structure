type WEdge = { u: number; v: number; w: number };

export function floydWarshall(mat: number[][]): number[][] {
  const n = mat.length;
  const dist = mat.map((r) => [...r]);
  for (let k = 0; k < n; k++) {
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (dist[i][k] + dist[k][j] < dist[i][j]) {
          dist[i][j] = dist[i][k] + dist[k][j];
        }
      }
    }
  }
  return dist;
}

export function kruskal(n: number, edges: WEdge[]): { weight: number; count: number } {
  const parent = Array.from({ length: n }, (_, i) => i);
  const find = (x: number): number => (parent[x] === x ? x : (parent[x] = find(parent[x])));
  const unite = (a: number, b: number): boolean => {
    const ra = find(a), rb = find(b);
    if (ra === rb) return false;
    parent[ra] = rb;
    return true;
  };

  let weight = 0;
  let count = 0;
  edges.sort((a, b) => a.w - b.w);
  for (const e of edges) {
    if (unite(e.u, e.v)) {
      weight += e.w;
      count++;
      if (count === n - 1) break;
    }
  }
  return { weight, count };
}
