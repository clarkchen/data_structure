pub struct Dsu {
    parent: Vec<usize>,
}

impl Dsu {
    pub fn new(n: usize) -> Self {
        Self {
            parent: (0..n).collect(),
        }
    }

    pub fn find(&mut self, x: usize) -> usize {
        if self.parent[x] != x {
            let root = self.find(self.parent[x]);
            self.parent[x] = root;
        }
        self.parent[x]
    }

    pub fn union(&mut self, a: usize, b: usize) -> bool {
        let ra = self.find(a);
        let rb = self.find(b);
        if ra == rb {
            return false;
        }
        self.parent[ra] = rb;
        true
    }
}

pub fn prim(n: usize, g: &[Vec<(usize, i32)>], start: usize) -> (i32, usize) {
    let inf = i32::MAX / 4;
    let mut dist = vec![inf; n];
    let mut used = vec![false; n];
    dist[start] = 0;

    let mut weight = 0;
    let mut count = 0;

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
        weight += dist[u];
        count += 1;

        for &(to, w) in &g[u] {
            if !used[to] && w < dist[to] {
                dist[to] = w;
            }
        }
    }

    (weight, count)
}

pub fn spfa(n: usize, g: &[Vec<(usize, i32)>], src: usize) -> Vec<i32> {
    let inf = i32::MAX / 4;
    let mut dist = vec![inf; n];
    let mut in_q = vec![false; n];
    let mut q = Vec::new();

    dist[src] = 0;
    q.push(src);
    in_q[src] = true;

    let mut i = 0usize;
    while i < q.len() {
        let u = q[i];
        i += 1;
        in_q[u] = false;

        for &(to, w) in &g[u] {
            if dist[u] + w < dist[to] {
                dist[to] = dist[u] + w;
                if !in_q[to] {
                    q.push(to);
                    in_q[to] = true;
                }
            }
        }
    }

    dist
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn prim_spfa_dsu_basic() {
        let g = vec![vec![(1, 2), (2, 5)], vec![(0, 2), (2, 1)], vec![(0, 5), (1, 1)]];
        let (w, c) = prim(3, &g, 0);
        assert_eq!((w, c), (3, 3));

        let dist = spfa(3, &g, 0);
        assert_eq!(dist[2], 3);

        let mut dsu = Dsu::new(3);
        assert!(dsu.union(0, 1));
        assert!(!dsu.union(0, 1));
    }
}
