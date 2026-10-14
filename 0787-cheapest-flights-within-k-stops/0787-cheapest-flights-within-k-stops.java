class Pair{
    int node;
    int weight;
    int stops;
    Pair(int node,int weight,int stops){
        this.node=node;
        this.weight=weight;
        this.stops=stops;
    }
}
class Pair1{
    int node;
    int weight;
    Pair1(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    int ans=Integer.MIN_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int l=flights.length;
        int m=flights[0].length;
        int []dist=new int [n];
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        List<List<Pair1>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }for(int i=0;i<l;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            adj.get(u).add(new Pair1(v,w));
        }
        TreeSet<Pair> ts = new TreeSet<>((a, b) -> {
    if (a.stops != b.stops) {
        return Integer.compare(a.stops, b.stops);
    }
    return Integer.compare(a.weight, b.weight);
});
      ts.add(new Pair(src,0,0));
      while(!ts.isEmpty()){
          Pair p=ts.pollFirst();
          int weight=p.weight;
          int node=p.node;
          int rk=p.stops;
          if(rk > k)
          {
            continue;
          }
          for(Pair1 pr:adj.get(node)){
               int nd=pr.node;
               int w=pr.weight;
               if(dist[nd]>w+weight && rk <= k) {
                   if(dist[node]!=Integer.MAX_VALUE){
                    ts.remove(new Pair(nd,dist[node],rk));
                   }
                    dist[nd]=w+weight;
                    ts.add(new Pair(nd,dist[nd],rk+1));
               }

          }
      }
      if(dist[dst] == Integer.MAX_VALUE)
      {
        return -1;
      }
      return dist[dst];


    }
}