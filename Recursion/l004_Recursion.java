public class l004_Recursion {

    // combinations
    public static boolean isSafeToPlaceQueen(boolean [][]box,int sr,int sc){ 
        int [][]dir={{0,-1},{-1,-1},{-1,0},{-1,1}} ;
        int n=box.length ;
        int m=box[0].length ;
        for(int d=0;d<dir.length;d++){
          for(int rad=1;rad<=Math.min(n,m);rad++)  {
              int r = sr + rad * dir[d][0];
              int c = sc + rad * dir[d][1];

              if(r>=0 && c>=0 && r<n && c<m){
                  if (box[r][c] == true)
                      return false;
              }
              else {
                  break ;
              }

          }
        }
        return true ;
    }

    public static int Nqueens(boolean[][] box, int bno, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if(isSafeToPlaceQueen(box,r,c)){
                box[r][c]=true ;
                count += Nqueens(box, b + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                box[r][c]=false ;
            }
        }
        return count;
    }

    //permutations
    public static boolean isSafeToPlaceQueen2(boolean[][] box, int sr, int sc) {
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 },{1,0},{1,1},{0,1},{1,-1}};
        int n = box.length;
        int m = box[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad <= Math.min(n, m); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (box[r][c] == true)
                        return false;
                } else {
                    break;
                }

            }
        }
        return true;
    }

    public static int Nqueens2(boolean[][] box, int bno, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!box[r][c] && isSafeToPlaceQueen2(box, r, c)) {
                box[r][c] = true;
                count += Nqueens2(box, 0, tnq - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;
            }
        }
        return count;
    }

     static boolean [] row,col,diag,adiag ;
     // isSafe optimization
    public static int Nqueen3(int n,int m,int bno,int tnq,String asf){
        if(tnq==0){
            System.out.println(asf);
            return 1 ;
        }

        int count = 0;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if(!row[r] && !col[c] && !diag[r+c] && !adiag[r-c+n-1]){
                row[r]=col[c]=diag[r+c]=adiag[r-c+n-1]=true ;
                count+=Nqueen3(n,m,b+1,tnq-1,asf + "(" + r + "," + c + ") ") ;
                row[r]=col[c]=diag[r+c]=adiag[r-c+n-1]=false ; 
            }
        }
        return count;

    }

    public static int Nqueen3_onePath(int n, int m, int bno, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + n - 1]) {
                row[r] = col[c] = diag[r + c] = adiag[r - c + n - 1] = true;
                count += Nqueen3_onePath(n, m, b + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                if(count==1) return  count ;
                row[r] = col[c] = diag[r + c] = adiag[r - c + n - 1] = false;
            }
        }
        return count;

    }


    public static int Nqueen3_Perm(int n, int m, int bno, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + n - 1]) {
                row[r] = col[c] = diag[r + c] = adiag[r - c + n - 1] = true;
                count += Nqueen3_Perm(n, m,0, tnq - 1, asf + "(" + r + "," + c + ") ");
                row[r] = col[c] = diag[r + c] = adiag[r - c + n - 1] = false;
            }
        }
        return count;

    }

    // Combination_optimized
    public static int nQueen_05(int n, int m, int floor, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;

        for (int room = 0; room < m; room++) {
            int r = floor, c = room;
            if (!col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen_05(n, m, floor + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        return count;
    }

    // permutation_optimized
    public static int nQueen_06(int n, int m, int floor, int tnq, String asf) {
        if (tnq == 0 || floor >= n) {
            if (tnq == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        for (int room = 0; room < m; room++) {
            int r = floor, c = room;
            if (!row[r] && !col[c] && !diag[r + c] && !adiag[r - c + m - 1]) {
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += nQueen_06(n, m, 0, tnq - 1, asf + "(" + r + "," + c + ") ");
                row[r] = col[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }

        count += nQueen_06(n, m, floor + 1, tnq, asf);
        return count;
    }
    

    public static void nqueen() {
        int n = 4, m=4, tnq = 4;
        // boolean[][] box = new boolean[n][n];
        // System.out.println(Nqueens(box, 0, tnq, ""));
        // System.out.println(Nqueens2(box, 0, tnq, ""));
        row=new boolean[n+1] ;
        col=new boolean[m+1] ;
        diag=new boolean[n+m-1] ;
        adiag=new boolean[n+m-1] ;
        // System.out.println(Nqueen3(n,m,0,tnq,"")) ; 
        // System.out.println(Nqueen3_onePath(n,m,0,tnq,"")) ;
        System.out.println(Nqueen3_Perm(n, m, 0, tnq, "")) ;
    }

    public static void main(String[] args) {
        nqueen();

    }

    // leetcode questions 
    // 40
    // 216
    // 51
    // 52
    // 322
    // 77 tle
    // 377 tle


}


