import java.io.*;
import java.util.*;

public class l001 {

static class Edge {
    int src, nbr, wt;
    Edge(int src, int nbr, int wt) {
        this.src = src;
        this.nbr = nbr;
        this.wt = wt;
    }
}

public static  void addEdge(ArrayList<Edge>[]graph,int u,int v,int w) {
    graph[u].add(new Edge(u,v,w));
    graph[v].add(new Edge(v,u,w));
}

public static  int findEdge(ArrayList<Edge>[] graph, int u, int v) {
    ArrayList<Edge> list = graph[u];
    for (int i = 0; i < list.size(); i++) {
        Edge e = list.get(i);
        if (e.nbr == v)
            return i;
    }

    return -1;
}

public static  void removeEdge(ArrayList<Edge>[] graph, int u, int v) {
    int i1 = findEdge(graph, u, v);
    int i2 = findEdge(graph, v, u);

    graph[u].remove(i1);
    graph[v].remove(i2);
}

public static void removeVtx(ArrayList<Edge>[] graph, int u) {
    ArrayList<Edge> list = graph[u];
    for (int i = list.size() - 1; i >= 0; i--) {
        Edge e = list.get(i);
        removeEdge(graph, e.src, e.nbr);
    }
}
// question 1 
public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
    if (src == dest)
        return true;
    if(vis[src]) return false ;
    vis[src] = true;
    boolean res = false;
    for (Edge e : graph[src]) {
        res = res || hasPath(graph, e.nbr, dest, vis) == true;
    }
    vis[src] = false;
    return res;
}

public static int printAllPaths(ArrayList<Edge>[]graph,int src,int dest,boolean []vis,String psf) {
    if(src==dest) {
        System.out.println(psf+dest) ;
        return 1 ;
    }

    int count=0 ;
    vis[src] = true;
    for(Edge e:graph[src]) {
        if(!vis[e.nbr]) {
            count+=printAllPaths(graph,e.nbr,dest,vis,psf+src) ;
        }
    }

    vis[src]=false ;
    return count ;

}

public static void preorder (ArrayList<Edge>[]graph,int src,boolean []vis,String psf,int wsf) {
    System.out.println(src+" -> "+ psf +"@"+wsf);
    vis[src] = true;
    for (Edge e : graph[src]) {
        if (!vis[e.nbr]) {
            preorder(graph,e.nbr,vis,psf+e.nbr,wsf+e.wt);
        }
    }
    vis[src] = false;
}

public static void postorder(ArrayList<Edge>[] graph, int src,boolean[] vis,String psf,int wsf) {
    vis[src] = true;
    for (Edge e : graph[src]) {
        if (!vis[e.nbr]) {
            postorder(graph, e.nbr, vis, psf + e.nbr, wsf + e.wt);
        }
    }
    System.out.println(src + " -> " + psf + "@" + wsf);
    vis[src] = false;
}

 static class pathPair {
    String psf="" ;
    int wsf=(int)1e9 ;
}

public static pathPair heaviestPath(ArrayList<Edge>[] graph, int src,int dest,boolean[] vis) {
    if(src==dest) {
        pathPair baseAns=new pathPair() ;
        baseAns.psf+=src ;
        baseAns.wsf=0 ;
        return baseAns ;
    }
    vis[src] = true;
    pathPair myAns = new pathPair();
    for (Edge e : graph[src]) {
        if (!vis[e.nbr]) {
            pathPair recAns=heaviestPath(graph,e.nbr,dest,vis) ;
            if(recAns.wsf != -1 &&  recAns.wsf+e.wt>myAns.wsf) {
                myAns.wsf=recAns.wsf+e.wt ;
                myAns.psf=src+recAns.psf ;
            }
        }
    }
    vis[src] = false;
    return myAns ;
}

public static pathPair lightestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
    if (src == dest) {
        pathPair baseAns = new pathPair();
        baseAns.psf += src;
        baseAns.wsf = 0 ;
        return baseAns;
    }
    vis[src] = true;
    pathPair myAns = new pathPair();
    for (Edge e : graph[src]) {
        if (!vis[e.nbr]) {
            pathPair recAns = lightestPath(graph, e.nbr, dest, vis);
            if (recAns.wsf != (int)1e9 && recAns.wsf + e.wt < myAns.wsf) {
                myAns.wsf = recAns.wsf + e.wt;
                myAns.psf = src + recAns.psf;
            }
        }
    }
    vis[src] = false;
    return myAns;
}

static class ceilAndFloorPair {
    int ceil= (int)1e9 ;
    int floor= -(int)1e9 ;
}

public static void ceilAndFloor(ArrayList<Edge>[]graph,int src,int data,boolean[]vis,int wsf,ceilAndFloorPair pair) {
    
    if(wsf>data) {
        pair.ceil=Math.min(data,wsf) ;
    }
    if (wsf < data) {
        pair.floor = Math.max(data, wsf);
    }
    vis[src]=true ;

    for(Edge e : graph[src]) {
        if(!vis[e.nbr]) {
            ceilAndFloor(graph,e.nbr,data,vis,wsf+e.wt,pair) ;
        }
    }

    vis[src]=false ;
}

// O(E)
public static void dfs_GCC(ArrayList<Edge>[] graph, int src,boolean []vis) {
    vis[src]=true ;
    for(Edge e:graph[src]) {
        if(!vis[e.nbr]) dfs_GCC(graph,e.nbr,vis) ;
    }
}

// O(E+V)
public static void GCC(ArrayList<Edge>[] graph) {
    int N=graph.length,componentCount=0 ;
    boolean []vis=new boolean[N] ;

    for(int i=0;i<N;i++ ) {
        if(!vis[i]) {
            dfs_GCC(graph,i,vis) ;
            componentCount++;
        }
    }
    System.out.println(componentCount) ;
}

    public static void main(String[] args) {
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);

        // int src = scn.nextInt();
        // int dest = scn.nextInt();

        // System.out.println(hasPath(graph, src, dest, new boolean[vtcs]));

        // preorder(graph,0,new boolean[N],"0",0) ;
        // postorder(graph, 0, new boolean[N], "0", 0);

        // pathPair ans=heaviestPath(graph,0,6,new boolean [N]) ;
        pathPair ans = lightestPath(graph, 0, 6, new boolean[N]);
        System.out.println(ans.psf+" "+ans.wsf) ;
    }  
}
