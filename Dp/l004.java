import java.util.Arrays;

public class l004 {

    public static void display(int[] dp) {
        for (int ele : dp) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for (int[] d : dp) {
            display(d);
        }
        System.out.println();
    }

    public static int combination(int[] arr, int tar, int[][] dp,int n) {
        if (tar == 0)
            return dp[n][tar]=1;
        if (dp[n][tar] != -1)
            return dp[n][tar];
        int count = 0;
        for (int i=n;i>0;i--) {
            if (tar - arr[i-1] >= 0)
                count += combination(arr, tar - arr[i-1],dp,i);
        }
        return dp[n][tar] = count;
    }

    public static int combination_Tab(int[] arr, int Tar, int[] dp) {
            dp[0]=1 ;
            for (int ele : arr){
            for (int tar = 0; tar <= Tar; tar++)
                if (tar - ele >= 0)
                    dp[tar] += dp[tar - ele]; // permutation(arr, tar - ele, dp);
        }
        return dp[Tar];
    }


    public static int permutation(int[] arr, int tar,int []dp) {
        if(tar==0) return dp[tar]=1 ;
        if(dp[tar]!=-1) return dp[tar] ;
        int count=0 ;
        for(int ele:arr) if(tar-ele>=0) count+=permutation(arr,tar-ele,dp) ;
        return dp[tar]=count ;
    }


    public static int permutation_Tab(int[] arr, int Tar, int[] dp) {
        dp[0] = 1;
        for (int tar = 1; tar <= Tar; tar++) {
            for (int ele : arr)
                if (tar - ele >= 0)
                    dp[tar] += dp[tar - ele];
        }
        return dp[Tar];
    }

    public static void fill(int []dp) {
        Arrays.fill(dp,-1) ;
    }

    public static void fill2D(int[][] dp) {
        for(int []d:dp) {
            Arrays.fill(d, -1);
        }
    }


    public static void target() {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10;
        int[] dp = new int[tar + 1];
        // fill(dp) ;
        System.out.println(permutation_Tab(arr, tar, dp));
        display(dp) ;
    }

    public static int targetSum(int []arr,int n,int tar,int [][]dp) {
        if(n==0 || tar==0) {
            return  dp[n][tar]=(tar==0) ? 1:0 ;
        }
        if(dp[n][tar]!=-1) return dp[n][tar] ;
        boolean res=false ;
        if(tar-arr[n-1]>=0) 
            res = res || targetSum(arr,n-1,tar-arr[n-1],dp)==1 ;
            res = res || targetSum(arr, n - 1, tar, dp) == 1;
        return res ? 1:0 ;
    }


    public static int targetSum_Tab(int[] arr, int N, int Tar, int[][] dp) {
        for(int n=0;n<=N;n++) {
            for(int tar=0;tar<=Tar;tar++) {
                if (n == 0 || tar == 0) {
                     dp[n][tar] = (tar == 0) ? 1 : 0;
                     continue ;
                }
                boolean res = false;
                if (tar - arr[n - 1] >= 0)
                    res = res ||  dp[n-1][tar-arr[n-1]]==1 ;  //res || targetSum(arr, n - 1, tar - arr[n - 1], dp) == 1;
                res =  res || dp[n-1][tar]==1 ; //res || targetSum(arr, n - 1, tar, dp) == 1;
                dp[n][tar]= res ? 1 : 0;
            }
        }
        return dp[N][Tar] ;
    }

    // back engg
    public static int targetSumPath(int[] arr, int N, int[][] dp, int tar, String psf) {
        if (N == 0 || tar == 0) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - arr[N - 1] >= 0 && dp[N - 1][tar - arr[N - 1]]==1)
            count += targetSumPath(arr, N - 1, dp, tar - arr[N - 1], psf + arr[N - 1] + " ");
        if (dp[N - 1][tar]==1)
            count += targetSumPath(arr, N - 1, dp, tar, psf);

        return count;
    }

    public static void targetSum_backEngg() {
        int[] arr = { 2, 3, 5, 7 };
        int tar = 10, N = 4;
        int [][] dp = new int[N + 1][tar + 1];
        System.out.println(targetSum_Tab(arr, N, tar, dp));
        System.out.println(targetSumPath(arr, N, dp, tar, ""));
    }

    //https:// practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/
    public static int knapSack(int w, int wt[], int val[], int n, int[][] dp) {
        if (n == 0 || w == 0)
            return dp[n][w] = 0;

        if (dp[n][w] != -1)
            return dp[n][w];

        int ans = 0;
        if (w - wt[n - 1] >= 0)
            ans = Math.max(ans, knapSack(w - wt[n - 1], wt, val, n - 1, dp) + val[n - 1]);
        ans = Math.max(ans, knapSack(w, wt, val, n - 1, dp));
        return dp[n][w] = ans;
    }

    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return knapSack(W, wt, val, n, dp);
        // your code here
    }

   public static void main(String[] args) {
    // target() ;
    targetSum_backEngg();
   }

   // https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/#
//    public static int targetSum_Tab(int[] arr, int N, int Tar, int[][] dp) {
//        for (int n = 0; n <= N; n++) {
//            for (int tar = 0; tar <= Tar; tar++) {
//                if (n == 0 || tar == 0) {
//                    dp[n][tar] = (tar == 0) ? 1 : 0;
//                    continue;
//                }
//                boolean res = false;
//                if (tar - arr[n - 1] >= 0)
//                    res = res || dp[n - 1][tar - arr[n - 1]] == 1; // res || targetSum(arr, n - 1, tar - arr[n - 1], dp)
//                                                                   // == 1;
//                res = res || dp[n - 1][tar] == 1; // res || targetSum(arr, n - 1, tar, dp) == 1;
//                dp[n][tar] = res ? 1 : 0;
//            }
//        }
//        return dp[N][Tar];
//    }

   static Boolean isSubsetSum(int N, int arr[], int sum) {
       // code here
       int[][] dp = new int[N + 1][sum + 1];
       return targetSum_Tab(arr, N, sum, dp) == 1;
   }
}