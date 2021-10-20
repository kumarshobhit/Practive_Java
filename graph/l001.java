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


public void dfs(char[][] grid, int[][] dir, int sr, int sc) {
    grid[sr][sc] = '0';
    for (int d = 0; d < 4; d++) {
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];

        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1')
            dfs(grid, dir, r, c);
    }

}

public int numIslands(char[][] grid) {
    int n = grid.length, m = grid[0].length, componentCount = 0;

    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == '1') {
                dfs(grid, dir, i, j);
                componentCount++;
            }
        }
    }
    return componentCount;
}

public int dfs(int[][] grid, int[][] dir, int sr, int sc) {

    grid[sr][sc] = 0;
    int size = 0;
    for (int d = 0; d < 4; d++) {
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];

        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1)
            size += dfs(grid, dir, r, c);
    }

    return size + 1;

}

public int maxAreaOfIsland(int[][] grid) {
    int n = grid.length, m = grid[0].length, maxSize = 0;

    int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                int s = dfs(grid, dir, i, j);
                maxSize = Math.max(maxSize, s);
            }
        }
    }
    return maxSize;
}

public static void hamintonianPathCycle(ArrayList<Edge>[] graph, int osrc, int src, int EdgeCount, boolean[] vis,
        String ans) {
    if (EdgeCount == graph.length - 1) {
        int idx = findEdge(graph, src, osrc);
        if (idx != -1) {
            System.out.println(ans + src + "*");
        } else {
            System.out.println(ans + src + ".");
        }
        return;
    }

    vis[src] = true;
    for (Edge e : graph[src]) {
        if (!vis[e.nbr]) {
            hamintonianPathCycle(graph, osrc, e.nbr, EdgeCount + 1, vis, ans + src);
        }

    }

    vis[src] = false;

}

public static void hamintonianPathCycle(ArrayList<Edge>[] graph, int src) {
    int N = graph.length;
    boolean[] vis = new boolean[N];
    hamintonianPathCycle(graph, src, src, 0, vis, "");
}

public static void BFS(ArrayList<Edge>[] graph, int src, int dest) {
    LinkedList<Integer> que = new LinkedList<>();
    int N = graph.length;
    boolean[] vis = new boolean[N];

    que.addLast(src);
    int level = 0;

    boolean isCyclePresent = false;
    int shortestPath = -1;

    while (que.size() != 0) {
        int size = que.size();
        while (size-- > 0) {
            int rvtx = que.removeFirst();

            // for cycle
            if (vis[rvtx]) {
                isCyclePresent = true;
                continue;
            }

            if (rvtx == dest) {
                shortestPath = level;
            }

            vis[rvtx] = true;
            for (Edge e : graph[rvtx]) {
                if (!vis[e.nbr]) {
                    que.addLast(e.nbr);
                }
            }
        }
        level++;
    }
}

    public static boolean cycleDetection(ArrayList<Edge>[] graph, int src, boolean[] vis) {

    LinkedList<Integer> que = new LinkedList<>();
    que.addLast(src);

    while (que.size() != 0) {
        int size = que.size();
        while (size-- > 0) {
            Integer rvtx = que.removeFirst();
            if (vis[rvtx])
                return true;

            vis[rvtx] = true;
            for (Edge e : graph[rvtx]) {
                if (!vis[e.nbr])
                    que.addLast(e.nbr);
            }
        }
    }

    return false;
}

public static void cycleDetection(ArrayList<Edge>[] graph) {
    int vtces = graph.length;
    boolean[] vis = new boolean[vtces];
    boolean res = false;
    for (int i = 0; i < vtces; i++) {
        if (!vis[i])
            res = res || cycleDetection(graph, i, vis);
    }

    System.out.println(res);
}

// print all paths
    static class BFS_Pair  {
        int vtx=0 ;
        String psf="" ;
        int wsf=0 ;

        BFS_Pair(int vtx,String psf,int wsf) {
            this.vtx=vtx ;
            this.psf=psf ;
            this.wsf=wsf ;
        }

    }

    public static void printBFSPath(ArrayList<Edge>[] graph,int src) {
        int vtces=graph.length ;
        boolean []vis=new boolean[vtces] ;
        LinkedList<BFS_Pair>que=new LinkedList<>() ;
        que.addLast(new BFS_Pair(src,src+"",0)) ;

        while(que.size()!=0) {
            int size=que.size() ;
            while(size--> 0) {
                BFS_Pair rp=que.removeFirst() ;
                if(vis[rp.vtx]) continue ;
                System.out.println(rp.vtx+" -> "+rp.psf+" @ "+rp.wsf) ;
                vis[rp.vtx]=true ;

                for(Edge e:graph[rp.vtx]) {
                    if(!vis[e.nbr]) {
                        que.addLast(new BFS Pair(e.nbr,rp.psf+e.nbr,rp.wsf+e.wt)) ;
                    }
                }
            }
        }
    }


    public static int spreadInfection(ArrayList<Edge>[] graph, int infectedPerson, int NoOfDays) {
        LinkedList<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        que.addLast(infectedPerson);

        int infectedCount = 0, day = 1;
        while (que.size() != 0) {
            int size = que.size();

            if (day > NoOfDays)
                break;

            while (size-- > 0) {
                int ip = que.removeFirst(); // infectedPerson
                if (vis[ip])
                    continue;

                vis[ip] = true;
                infectedCount++;

                for (Edge e : graph[ip]) {
                    if (!vis[e.nbr])
                        que.addLast(e.nbr);
                }

            }

            day++;

        }

        return infectedCount;
    }


    // bipartite graph 
    public static void bipartite(ArrayList<Edge>[]graph,int src,int []vis) {

        LinkedList<Integer> que=new LinkedList<>() ;
        que.addLast(src) ;
        boolean cycle=false,isBiPartite=true ;
        int color=0 ; // 0:red, 1:green

        while(que.size()!=0) {
            int size=que.size() ;
            while(size-->0) {
                int rvtx=que.removeFirst() ;
                if(vis[rtx]!= -1) {
                    cycle=true ;
                    if(vis[rtx] != color) {
                        // conflict 
                        isBiPartite=false ;
                    }
                    continue ; // not any kind of conflict
                }
                vis[rtx]=color ;

                for(Edge e:graph[rvtx]) {
                    if(vis[rvtx]!=-1)  que.addLast(e.nbr);
                }
            }
            color=(color+1)%2 ;
        }

        if(cycle) {
            if(isBiPartite) System.out.println("even length cycle") ;
            else System.out.println("odd length cycle") ;
        }
        else {
            System.out.println("A-cycle and bipartite") ;
        }
    }

    public static void bipartite(ArrayList<Edge>graph) {
        int N=graph.length ;
        int []vis=new int[N] ;
        Arrays.fill(vis,-1) ;
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
