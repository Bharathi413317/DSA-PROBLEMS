import java.util.*;

class Pair {
    int node;
    long weight;

    Pair(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Pair1 {
    int ve;
    int we;

    Pair1(int ve, int we) {
        this.ve = ve;
        this.we = we;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;

        ArrayList<List<Pair1>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];

            adj.get(u).add(new Pair1(v, w));
            adj.get(v).add(new Pair1(u, w));
        }

        TreeSet<Pair> ts = new TreeSet<>((a, b) -> {
            if (a.weight != b.weight)
                return Long.compare(a.weight, b.weight);
            return Integer.compare(a.node, b.node);
        });

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        dist[0] = 0;
        ways[0] = 1;

        ts.add(new Pair(0, 0));

        while (!ts.isEmpty()) {
            Pair p = ts.pollFirst();

            int nod = p.node;
            long wt = p.weight;

            // if (wt > dist[nod]) {
            //     continue;
            // }

            for (Pair1 pr : adj.get(nod)) {
                int nodu = pr.ve;
                long newDist = wt + pr.we;

                if (newDist < dist[nodu]) {
                    ts.remove(new Pair(nodu, dist[nodu]));

                    dist[nodu] = newDist;
                    ways[nodu] = ways[nod];

                    ts.add(new Pair(nodu, newDist));
                } else if (newDist == dist[nodu]) {
                    ways[nodu] = (int) (
                        ((long) ways[nodu] + ways[nod]) % mod
                    );
                }
            }
        }

        return ways[n - 1];
    }
}