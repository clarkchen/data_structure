package stringalgo

func KMPSearch(text, pattern string) int {
	if len(pattern) == 0 {
		return 0
	}

	lps := make([]int, len(pattern))
	for i, l := 1, 0; i < len(pattern); {
		if pattern[i] == pattern[l] {
			l++
			lps[i] = l
			i++
		} else if l > 0 {
			l = lps[l-1]
		} else {
			lps[i] = 0
			i++
		}
	}

	for i, j := 0, 0; i < len(text); {
		if text[i] == pattern[j] {
			i++
			j++
			if j == len(pattern) {
				return i - j
			}
		} else if j > 0 {
			j = lps[j-1]
		} else {
			i++
		}
	}

	return -1
}
