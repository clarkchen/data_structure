import { quickSort, binarySearch } from "./sort.js";
import { kmpSearch } from "./string.js";
import { dijkstra } from "./graph.js";

function assert(condition: boolean, msg: string) {
  if (!condition) throw new Error(msg);
}

const arr = quickSort([4, 1, 3, 2]);
assert(arr.join(",") === "1,2,3,4", "quickSort failed");
assert(binarySearch(arr, 3) === 2, "binarySearch failed");
assert(kmpSearch("ababcabcacbab", "abcac") === 5, "kmpSearch failed");

const g = [
  [{ to: 1, w: 2 }, { to: 2, w: 5 }],
  [{ to: 2, w: 1 }],
  []
];
const dist = dijkstra(3, g, 0);
assert(dist[2] === 3, "dijkstra failed");

console.log("TS self-test passed");
