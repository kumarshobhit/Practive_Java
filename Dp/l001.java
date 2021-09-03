public class l001 {
    public static void display(int []dp) {
        for(int ele:dp) {
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for (int []d:dp) {
            display(d);
        }
        System.out.println();
    }

    public static int fibo_memo(int n,int []dp) {
        if(n<=1) return dp[n]=n ;
        if(dp[n]!=0) return dp[n] ;

        int ans=fibo_memo(n-1,dp)+fibo_memo(n-2,dp);
        return dp[n]=ans ;
    }

    public static int fibo_tabu(int N, int[] dp) {
        for(int n=0;n<=N;n++) {
            if (n <= 1) {
                 dp[n] = n;
                 continue ;
            }
            int ans = dp[n-1]+dp[n-2];
             dp[n] = ans;
        }
        return dp[N];
    }

    public static int fibo_opt(int N) {
        int f=0;
        int s=1 ;
        for(int n=2;n<=N;n++) {
            int t=f+s ;
            f=s ; 
            s=t ;
        }
        return s ;
    }

    public static void fibo(int n) {
        int []dp=new int[n+1];
        // fibo_memo(n,dp);
        // fibo_tabu(n,dp);
        int ans=fibo_opt(n);
        System.out.println(ans);
        // display(dp);
    }

    public static int mazePath_memo(int sr,int sc,int er,int ec,int [][]dp,int [][]dir) {
        if(er==sr && ec==sc) {
            return 1 ;
        }
        if(dp[sr][sc]!=0) return dp[sr][sc] ;
        int ans=0 ;
         for (int[] d : dir) {
            int r = sr + d[0], c = sc + d[1];
            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                ans += mazePath_memo(r, c, er, ec, dp, dir);
            }
        }

        return dp[sr][sc]=ans ;
    }

    public static int mazePath_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {

        for(int sr=ER;sr>=SR;sr--) {
            for(int sc=EC;sc>=SC;sc--) {
                if (ER == sr && EC == sc) {
                    dp[sr][sc] =  1;
                    continue ;
                }
                int ans = 0;
                for (int[] d : dir) {
                    int r = sr + d[0], c = sc + d[1];
                    if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                        ans += dp[r][c]; //mazePath_memo(r, c, er, ec, dp, dir);
                    }
                }

                 dp[sr][sc]=ans ;
            }
        }

        return dp[SR][SC] ;
    }


    public static int mazePathJump_tabu(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {

        for (int sr = ER; sr >= SR; sr--) {
            for (int sc = EC; sc >= SC; sc--) {
                if (ER==sr && EC==sc) {
                    dp[sr][sc] = 1;
                    continue;
                }
                int ans = 0;
                for (int[] d : dir) {
                    int r = sr + d[0], c = sc + d[1];
                    while (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                        ans += dp[r][c]; // mazePath_memo(r, c, er, ec, dp, dir);
                        r+=d[0] ;
                        c+=d[1] ;
                    }
                }

                dp[sr][sc] = ans;
            }
        }

        return dp[SR][SC];
    }


    // public static int  mazePath_memo(int er,int ec,int [][]dp,int [][]dir) {
    //     if(er==0 && ec==0) {
    //         return dp[er][ec]=1 ;
    //     }
    //     if(dp[er][ec]!=0) return dp[er][ec] ;
    //     int count=0 ;
    //     for(int []d:dir) {
    //         int r=er+d[0],c=ec+d[1] ;
    //         if(r>=0 && c>=0 && r<dp.length && c<dp.length){
    //             count+=mazePath_memo(r,c,dp,dir);
    //         }
    //     }

    //     return dp[er][ec]=count ;
    // }

    public static void maze(int R,int C) {
        int [][]dp=new int [R+1][C+1] ;
        int[][] dir = { { 1, 0 }, { 0, 1 }, { 1, 1 } };
        System.out.println(mazePathJump_tabu(0,0, R,C, dp, dir));
        display2D(dp);
    }

    public static void main (String[] args) {
        // fibo(10);
        maze(3,3) ;
    }
}
