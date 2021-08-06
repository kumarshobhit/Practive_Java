import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l003_Recursion {

     public static int  infiPermutations(int []coins,int tar,String asf){
        if(tar==0){
            System.out.println(asf) ;
            return 1 ;
        }
        int count=0 ;
        for(int i=0;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=infiPermutations(coins,tar-coins[i],asf+coins[i]+"-"+i+" ") ;
            }
        }
        return count ;
    }
    
    public static int infiCombinations(int []coins,int tar,String asf,int idx){
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                count += infiCombinations(coins, tar - coins[i], asf + coins[i] + "-" + i + " ",i);
            }
        }

        return count;
    }


     public static int  singlePermutations(int []coins,int tar,String asf){
        if(tar==0){
            System.out.println(asf) ;
            return 1 ;
        }
        int count=0 ;
        for(int i=0;i<coins.length;i++){
            if(tar-coins[i]>=0){
                if(coins[i]<0) continue ;
                int val=coins[i] ;
                coins[i]= -coins[i] ;
                count+=singlePermutations(coins,tar-val,asf+coins[i]+"-"+i+" ") ;
                coins[i]= -coins[i] ;
            }
        }

        return count ;
    }

     public static int singleCombinations(int []coins,int tar,String asf,int idx){
        if (tar == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                if(i>idx && coins[i]==coins[i-1])
                count += singleCombinations(coins, tar - coins[i], asf + coins[i] + "-" + i + " ",i+1);
            }
        }

        return count;
    }

    public static int singleCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
        count += singleCombination_subseq(coins, tar - coins[idx], idx + 1, asf + coins[idx] + " ");
        count += singleCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int infiCombination_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiCombination_subseq(coins, tar - coins[idx], idx, asf + coins[idx] + " ");
        count += infiCombination_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int infiPermutation_subseq(int[] coins, int tar, int idx, String asf) {
        if (tar == 0 || idx >= coins.length) {
            if (tar == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += infiPermutation_subseq(coins, tar - coins[idx], 0, asf + coins[idx] + " ");
        count += infiPermutation_subseq(coins, tar, idx + 1, asf);

        return count;
    }

    public static int singlePermutation_subseq(int[] coins, int tar,int idx, String asf) {
        if(tar==0 || idx>=coins.length){
            if(tar==0){
                System.out.println(asf) ;
                return 1 ;
            }
            return 0 ;
        }
        int count=0 ;
        if(coins[idx]>0){
            int val=coins[idx] ;
            coins[idx]= -coins[idx] ;
            if (tar - coins[idx] >= 0) {
                count += singlePermutation_subseq(coins, tar - val, 0, asf + val + " ");
            }
            coins[idx]= -coins[idx] ;
        }
        count+=singlePermutation_subseq(coins, tar,idx+1,asf) ;
        return count ;
    }

    // Qustions
    // total no of boxes
    // box no
    // total no of queen
    // queen placed so far
    // answer so far
    public static int queenCombination1D(int tnb, int bno, int tnq, int qpsf, String asf) {
        if (qpsf > tnq) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int b = bno; b <= tnb; b++) {
            count += queenCombination1D(tnb, b + 1, tnq, qpsf + 1, asf + "b" + b + "q" + qpsf + " ");
        }
        return count;
    }

    public static int queenCombination1D_sub(int tnb, int bno, int tnq, int qpsf, String asf){
        if(bno>tnb || qpsf>tnq){
            if(qpsf>tnq){
                System.out.println(asf) ;
                return 1 ;
            }
            return 0 ;
        }
        int count = 0 ;
        count+=queenCombination1D_sub(tnb,bno+1,tnq,qpsf+1,asf + "b" + bno + "q" + " ") ;
        count+=queenCombination1D_sub(tnb, bno+1, tnq, qpsf, asf);
        return count ;
    }

    public static int queenPermutation1D(int tnb, int tnq, int qpsf, boolean[] visited, String asf) {
        if (qpsf > tnq) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for (int b = 1; b <= tnb; b++) {
            if (!visited[b]) {
                visited[b] = true;
                count += queenPermutation1D(tnb, tnq, qpsf + 1, visited, asf + "b" + b + "q" + " ");
                visited[b] = false;
            }
        }
        return count;
    }

    public static int queenPermutation1D_sub(int tnb, int bno, int tnq, int qpsf,boolean[]visited, String asf) {
        if (bno > tnb || qpsf > tnq) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if(!visited[bno]){
            visited[bno]=true ;
           count+=queenPermutation1D_sub(tnb,1,tnq,qpsf+1,visited,asf + "b" + bno + "q" + " ");
            visited[bno]=false ;
        }
        count+=queenPermutation1D_sub(tnb, bno + 1, tnq, qpsf, visited, asf);
        return count;
    }

    public static void queen() {
        int tnb = 16, tnq = 4;
        boolean[] vis = new boolean[tnb + 1];
        System.out.println(queenCombination1D_sub(tnb, 1, tnq, 1, ""));
        // System.out.println(queenPermutation1D(tnb, tnq, 1,vis, ""));

        // System.out.println(queenPermutation1D_sub(tnb, 1, tnq, 1, vis, ""));
    }

    // 2QueenSet.=============================================================================

    // Queen_Set.=========================================================================================

    // tnb : total no boxes, bno : box no, tnq : total No queen, qpsf : queen placed
    // so far
    public static int queenCombination2D(boolean[][] box, int bno, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = bno; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            count += queenCombination2D(box, b + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
        }
        return count;
    }

    public static int queenPermutation2D(boolean[][] box, int tnq, String asf) {
        if (tnq == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length, m = box[0].length;
        for (int b = 0; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            if (!box[r][c]) {
                box[r][c] = true;
                count += queenPermutation2D(box, tnq - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;
            }
        }
        return count;
    }

    // 2D subsequence method h.w

    public static int queenCombination2D_sub(boolean[][] box, int bno, int tnq, String asf) {
        int n=box.length,m=box[0].length ;
        if (tnq == 0|| bno >= n*m) {
            if (tnq == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        int r=bno/m ;
        int c=bno%m ;
        count+=queenCombination2D_sub(box,bno+1,tnq-1, asf + "(" + r + "," + c + ") ") ;
        count+=queenCombination2D_sub(box,bno+1,tnq, asf) ;
        return count;
    }

    public static int queenPermutation2D_sub(boolean[][] box,int bno, int tnq, String asf) {
        int n=box.length,m=box[0].length ;
        if (tnq == 0|| bno >= n*m) {
            if (tnq == 0) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        int r=bno/m ;
        int c=bno%m ;
        if(box[r][c]==false){
            box[r][c]=true ;
            count+=queenPermutation2D_sub(box,bno+1,tnq-1, asf + "(" + r + "," + c + ") ") ;
            box[r][c]=false ;
        }
        count+=queenPermutation2D_sub(box,bno+1,tnq, asf) ;
        return count;
    }


    public static void queen2D() {
        int tnq = 4;
        boolean[][] box = new boolean[4][4];
        // System.out.println(queenCombination2D(box, 0, tnq, ""));
        // System.out.println(queenPermutation2D(box, tnq, ""));
        // System.out.println(queenPermutation1D_sub(tnb, 1, tnq, 1, vis, ""));
        System.out.println(queenCombination2D_sub(box,0,tnq,"")) ;
    }


    public static void main(String[] args){
        // int []coins={2,3,5,7} ;
        // int tar=10 ;
        // String asf="" ;
        // System.out.println(infiPermutations(coins,tar,asf)) ;
        //  System.out.println(infiCombinations(coins,tar,asf,0)) ;
        // System.out.println(singlePermutations(coins,tar,asf,-1)) ;

        // int[] coins = { 2, 3, 5, 7 };
        // int tar = 10;
        // String asf = "";

        // int tnb=7 ;
        // int tnq=4 ;
        // boolean[] visited=new boolean[tnb+1] ;
        // System.out.println(queenCombination1D(tnb,1,tnq,1,"")) ;
        // System.out.println(queenPermutation1D(tnb, tnq,1,visited, ""));
        // System.out.println(queenCombination1D_sub(tnb,1, tnq,1, ""));
        // System.out.println(queenPermutation1D_sub(tnb,1,tnq, 1, visited, ""));
        queen2D() ;

    }

    // Questions
    // 39.
    public void combinationSum(int[] arr, int tar, int idx, List<List<Integer>> ans, List<Integer> smallAns) {

        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns); // deep copy
            ans.add(base); // shallow copy
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                combinationSum(arr, tar - arr[i], i, ans, smallAns);
                smallAns.remove(smallAns.size() - 1);
            }
        }

    }

    public List<List<Integer>> combinationSum(int[] arr, int tar) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combinationSum(arr, tar, 0, ans, smallAns);
        return ans;
    }

    // .40
     public static int infiCombinations(int []coins,int tar,ArrayList<Integer> asf,int idx,List<List<Integer>> list ){
        if (tar == 0) {
            list.add(new ArrayList<>(asf)) ;
            return 1;
        }
        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                if(i>idx && coins[i]==coins[i-1]) continue ;
                asf.add(coins[i]) ;
                count += infiCombinations(coins, tar - coins[i],asf,i+1,list);
                asf.remove(asf.size()-1) ;
            }
        }

        return count;
    }

    public List<List<Integer>> combinationSum2(int[] coins, int tar) {
        Arrays.sort(coins) ;
         List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>() ;
        infiCombinations(coins,tar,temp,0,ans) ;
        return ans ;
    }


// interview bit question https://www.interviewbit.com/problems/subset/
// generate all subsequence through ncr method
    public void combinationSum(ArrayList<Integer> arr, int idx, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> smallAns) {
        ans.add(new ArrayList<>(smallAns)) ;

        for (int i = idx; i < arr.size(); i++) {
                int ele=arr.get(i) ;
                smallAns.add(ele);
                combinationSum(arr, i+1, ans, smallAns);
                smallAns.remove(smallAns.size() - 1);
        }

    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
        Collections.sort(arr) ;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> smallAns = new ArrayList<>();
        combinationSum(arr, 0, ans, smallAns);
        return ans;
    }



}




    