

static List<Integer>[] tree;
// node -> list of queries involving this node
static List<Integer>[] indexes;
static boolean[] vis;
static int[] depth;
static int[] parent;

static int[] uf;

static int[][] queries;
static int[] ans;
static boolean[] foundLCA;

// Tarjan's offline LCA algorithm - find least common ancestor of u and all v 
private static void tarjanOLCA(int u) {
    vis[u] = true;
    makeSet(u);
    for (int v : tree[u]) {
        if (!vis[v]) {
            depth[v] = depth[u] + 1;
            tarjanOLCA(v);
            union(u, v);
            parent[find(u)] = u;
        }
    }

    for (int idx : indexes[u]) {
        // System.err.printf("node %d contributes %d to query %d%n", u + 1, depth[u], idx + 1);
        ans[idx] += depth[u];

        int v = queries[idx][0] ^ queries[idx][1] ^ u;
        if (vis[v] && !foundLCA[idx]) {
            int lca = parent[find(v)];
            // System.err.printf("lca %d contributes %d to query %d%n", lca + 1, depth[lca], idx + 1);
            ans[idx] -= 2 * depth[lca];
            foundLCA[idx] = true;
        }
    }
}

private static int find(int x) {
    return uf[x] = (uf[x] == x) ? x : find(uf[x]);
}

private static void union(int x, int y) {
    int xr = find(x);
    int yr = find(y);
    if (xr == yr) return;
    uf[xr] = yr;
}

private static void makeSet(int x) {
    parent[x] = x;
}