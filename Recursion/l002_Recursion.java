public class l002_Recursion {

    public static int getMaxGold(int [][]gold,int m,int n,int r,int c){
        if( r<0 ||  r==gold.length || c==gold[0].length) return 0 ;
        int myAns=0 ;
        int a=getMaxGold(gold,m,n,r-1,c+1) ;
        int b=getMaxGold(gold,m,n,r,c+1) ;
        int d=getMaxGold(gold,m,n,r+1,c+1) ;
        myAns=Math.max(a,Math.max(b,d)) ;
        return myAns+gold[r][c]  ;
    }


    public static void main(String[] args){
        int[][] gold = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
        int m = 4, n = 4;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, getMaxGold(gold, m, n, i, 0));
        }
        System.out.println(ans);
    }
}
