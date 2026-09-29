class Solution {
    
    int[] parent;
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        parent = new int[n + 1];
        
        // Initially every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if (find(u) == find(v)) {
                // Already connected -> cycle
                return edge;
            }
            
            union(u, v);
        }
        
        return new int[0];
    }
    
    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}