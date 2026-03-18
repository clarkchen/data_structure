package graph

import "testing"

func TestGraphExtra(t *testing.T) {
	g := make([][][2]int, 3)
	g[0] = [][2]int{{1, 2}, {2, 5}}
	g[1] = [][2]int{{0, 2}, {2, 1}}
	g[2] = [][2]int{{0, 5}, {1, 1}}

	w, c := Prim(3, g, 0)
	if w != 3 || c != 3 {
		t.Fatalf("prim expect (3,3), got (%d,%d)", w, c)
	}

	dist := SPFA(3, g, 0)
	if dist[2] != 3 {
		t.Fatalf("spfa expect dist[2]=3, got %d", dist[2])
	}
}

func TestDSU(t *testing.T) {
	d := NewDSU(4)
	if !d.Union(0, 1) {
		t.Fatal("first union should be true")
	}
	if d.Union(0, 1) {
		t.Fatal("second union should be false")
	}
}
