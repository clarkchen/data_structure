type Edge = { to: number; w: number };

type WEdge = { u: number; v: number; w: number };

export class DSU {
  private parent: number[];

  constructor(n: number) {
    this.parent = Array.from({ length: n }, (_, i) => i);
  }

  find(x: number): number {
    if (this.parent[x] !== x) this.parent[x] = this.find(this.parent[x]);
    return this.parent[x];
  }

  union(a: number, b: number): boolean {
    const ra = this.find(a);
    const rb = this.find(b);
    if (ra === rb) return false;
    this.parent[ra] = rb;
    return true;
  }
}

export function prim(n: number, g: Edge[][], start = 0): { weight: number; count: number } {
  const inf = Number.POSITIVE_INFINITY;
  const dist = new Array<number>(n).fill(inf);
  const used = new Array<boolean>(n).fill(false);
  dist[start] = 0;

  let weight = 0;
  let count = 0;

  for (let i = 0; i < n; i++) {
    let u = -1;
    for (let v = 0; v < n; v++) {
      if (!used[v] && (u === -1 || dist[v] < dist[u])) u = v;
    }
    if (u === -1 || dist[u] === inf) break;
    used[u] = true;
    weight += dist[u];
    count++;

    for (const e of g[u]) {
      if (!used[e.to] && e.w < dist[e.to]) dist[e.to] = e.w;
    }
  }

  return { weight, count };
}

export function spfa(n: number, g: Edge[][], src: number): number[] {
  const inf = Number.POSITIVE_INFINITY;
  const dist = new Array<number>(n).fill(inf);
  const inQ = new Array<boolean>(n).fill(false);
  const q: number[] = [];

  dist[src] = 0;
  q.push(src);
  inQ[src] = true;

  for (let i = 0; i < q.length; i++) {
    const u = q[i];
    inQ[u] = false;

    for (const e of g[u]) {
      if (dist[u] + e.w < dist[e.to]) {
        dist[e.to] = dist[u] + e.w;
        if (!inQ[e.to]) {
          q.push(e.to);
          inQ[e.to] = true;
        }
      }
    }
  }

  return dist;
}

export function kruskalWithDsu(n: number, edges: WEdge[]): { weight: number; count: number } {
  const dsu = new DSU(n);
  let weight = 0;
  let count = 0;

  edges.sort((a, b) => a.w - b.w);
  for (const e of edges) {
    if (dsu.union(e.u, e.v)) {
      weight += e.w;
      count++;
      if (count === n - 1) break;
    }
  }

  return { weight, count };
}
