pub fn kmp_search(text: &str, pattern: &str) -> isize {
    if pattern.is_empty() {
        return 0;
    }
    let t = text.as_bytes();
    let p = pattern.as_bytes();

    let mut lps = vec![0usize; p.len()];
    let mut i = 1usize;
    let mut len = 0usize;
    while i < p.len() {
        if p[i] == p[len] {
            len += 1;
            lps[i] = len;
            i += 1;
        } else if len > 0 {
            len = lps[len - 1];
        } else {
            lps[i] = 0;
            i += 1;
        }
    }

    let (mut ti, mut pj) = (0usize, 0usize);
    while ti < t.len() {
        if t[ti] == p[pj] {
            ti += 1;
            pj += 1;
            if pj == p.len() {
                return (ti - pj) as isize;
            }
        } else if pj > 0 {
            pj = lps[pj - 1];
        } else {
            ti += 1;
        }
    }

    -1
}
