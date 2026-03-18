import unittest

from graph_extra import DSU, prim, spfa
from sort_search import quick_sort, binary_search
from string_algo import kmp_search


class TestPythonAlgorithms(unittest.TestCase):
    def test_sort_search(self):
        arr = quick_sort([4, 1, 3, 2])
        self.assertEqual(arr, [1, 2, 3, 4])
        self.assertEqual(binary_search(arr, 3), 2)
        self.assertEqual(binary_search(arr, 9), -1)

    def test_kmp(self):
        self.assertEqual(kmp_search("ababcabcacbab", "abcac"), 5)
        self.assertEqual(kmp_search("hello", "world"), -1)

    def test_graph_extra(self):
        g = [
            [(1, 2), (2, 5)],
            [(0, 2), (2, 1)],
            [(0, 5), (1, 1)],
        ]
        w, c = prim(3, g, 0)
        self.assertEqual((w, c), (3, 3))
        dist = spfa(3, g, 0)
        self.assertEqual(dist[2], 3)

    def test_dsu(self):
        d = DSU(4)
        self.assertTrue(d.union(0, 1))
        self.assertFalse(d.union(0, 1))


if __name__ == "__main__":
    unittest.main()
