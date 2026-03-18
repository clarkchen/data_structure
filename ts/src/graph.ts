type Edge = { to: number; w: number };

export function dijkstra(n: number, g: Edge[][], src: number): number[] {
  const dist = new Array<number>(n).fill(Number.POSITIVE_INFINITY);
  const used = new Array<boolean>(n).fill(false);
  dist[src] = 0;

  for (let i = 0; i < n; i++) {
    let u = -1;
    for (let v = 0; v < n; v++) {
      if (!used[v] && (u === -1 || dist[v] < dist[u])) u = v;
    }
    if (u === -1 || dist[u] === Number.POSITIVE_INFINITY) break;
    used[u] = true;

    for (const e of g[u]) {
      if (dist[e.to] > dist[u] + e.w) dist[e.to] = dist[u] + e.w;
    }
  }

  return dist;
}

export function topologicalSort(n: number, g: number[][]): number[] {
  const indeg = new Array<number>(n).fill(0);
  for (let u = 0; u < n; u++) for (const v of g[u]) indeg[v]++;

  const q: number[] = [];
  for (let i = 0; i < n; i++) if (indeg[i] === 0) q.push(i);

  const order: number[] = [];
  for (let i = 0; i < q.length; i++) {
    const u = q[i];
    order.push(u);
    for (const v of g[u]) {
      if (--indeg[v] === 0) q.push(v);
    }
  }

  return order.length === n ? order : [];
}
