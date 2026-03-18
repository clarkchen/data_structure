pub fn dijkstra(n: usize, g: &[Vec<(usize, i32)>], src: usize) -> Vec<i32> {
    let inf = i32::MAX / 4;
    let mut dist = vec![inf; n];
    let mut used = vec![false; n];
    dist[src] = 0;

    for _ in 0..n {
        let mut u: Option<usize> = None;
        for v in 0..n {
            if !used[v] && (u.is_none() || dist[v] < dist[u.unwrap()]) {
                u = Some(v);
            }
        }
        let u = match u {
            None => break,
            Some(x) if dist[x] == inf => break,
            Some(x) => x,
        };

        used[u] = true;
        for &(to, w) in &g[u] {
            if dist[to] > dist[u] + w {
                dist[to] = dist[u] + w;
            }
        }
    }

    dist
}

pub fn topological_sort(n: usize, g: &[Vec<usize>]) -> Vec<usize> {
    let mut indeg = vec![0usize; n];
    for u in 0..n {
        for &v in &g[u] {
            indeg[v] += 1;
        }
    }

    let mut q = Vec::new();
    for (i, &d) in indeg.iter().enumerate() {
        if d == 0 {
            q.push(i);
        }
    }

    let mut order = Vec::new();
    let mut i = 0usize;
    while i < q.len() {
        let u = q[i];
        i += 1;
        order.push(u);
        for &v in &g[u] {
            indeg[v] -= 1;
            if indeg[v] == 0 {
                q.push(v);
            }
        }
    }

    if order.len() == n { order } else { vec![] }
}

pub fn floyd_warshall(mat: &[Vec<i32>]) -> Vec<Vec<i32>> {
    let n = mat.len();
    let mut dist = mat.to_vec();
    for k in 0..n {
        for i in 0..n {
            for j in 0..n {
                if dist[i][k] + dist[k][j] < dist[i][j] {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    dist
}

pub fn kruskal(n: usize, edges: &mut Vec<(usize, usize, i32)>) -> (i32, usize) {
    let mut parent: Vec<usize> = (0..n).collect();

    fn find(parent: &mut [usize], x: usize) -> usize {
        if parent[x] != x {
            let root = find(parent, parent[x]);
            parent[x] = root;
        }
        parent[x]
    }

    edges.sort_by_key(|e| e.2);

    let mut weight = 0;
    let mut count = 0;
    for &(u, v, w) in edges.iter() {
        let ru = find(&mut parent, u);
        let rv = find(&mut parent, v);
        if ru != rv {
            parent[ru] = rv;
            weight += w;
            count += 1;
            if count == n - 1 {
                break;
            }
        }
    }
    (weight, count)
}
