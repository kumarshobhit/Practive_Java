
import java.util.ArrayList;
public class l001Recursion {

    public static void printIncreasing(int a,int b) {
        if(a>b) return ;
        System.out.println(a) ;
        printIncreasing(a+1,b) ;
    }

    public static void printDecreasing(int a, int b) {
        if(a>b) return ;
        printDecreasing(a + 1, b);
        System.out.println(a) ;
    }

    public static void printIncreasingDecreasing(int a, int b) {
        if(a>b) return ;
        System.out.println(a) ;
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a) ;
    }

    public static void oddEven(int a,int b) {
        if(a>b) return ;
        if(a%2!=0) {
            System.out.println(a+" : odd") ;
        }
        else {
            System.out.println(a+" : even") ;
        }
        oddEven(a+1,b) ;
    }

    public static int  factorial(int n){
        if(n==1) return 1 ;
        return n*factorial(n-1) ;
    }

    public static int  power(int a,int b) {
        if(b==0) return 1 ;
        return a*power(a,b-1) ;
    }

    // O(logn)
    public static int  powerBtr(int a,int b) {
        if(b==0) return 1 ;
        int ans=powerBtr(a,b/2) ;
        if(b%2==0) return ans*ans ;
        return a*ans*ans ;
    }

    public static void printArray(int []arr,int ind) {
        if (ind == arr.length) {
            return;
        }
        System.out.println(arr[ind]);
        printArray(arr, ind + 1);
    }

    public static void printArrayReverse(int[] arr,int ind) {
        if(ind == arr.length){
            return ;
        }
        printArrayReverse(arr,ind+1) ;
        System.out.println(arr[ind]) ;
    }

    public static int maximum(int[] arr,int ind) {
        if (ind == arr.length) {
            return Integer.MIN_VALUE;
        }
        int ans = maximum(arr, ind + 1);
        return Math.max(ans, arr[ind]);
    }

    public static int minimum(int[] arr,int ind) {
        if (ind == arr.length) {
            return Integer.MAX_VALUE;
        }
        int ans=minimum(arr,ind+1) ;
        return Math.min(ans,arr[ind]) ;
    }

    public static boolean find(int[] arr, int data,int ind) {
        if (ind == arr.length) {
            return false;
        }
        if(arr[ind]==data) return true ;
       return find(arr,data,ind+1) ;
    }

    public static int firstIndex(int[] arr, int data,int ind) {
        if (ind == arr.length) {
            return -1;
        }
        if (arr[ind] == data)
            return ind;
        
        int ans = firstIndex(arr, data, ind + 1);
        if (ans > -1)
            return ans;
        return -1;

    }

    public static int lastIndex(int[] arr, int data,int ind) {
        if(ind == arr.length){
            return -1 ;
        }
        int ans= lastIndex(arr,data,ind+1) ;
        if(ans>-1) return ans ;
        if(arr[ind]==data) return ind ;
        return -1 ;

    }

    public static int [] allIndexes(int []arr,int data,int idx,int count){
        if(idx >= arr.length){
            return new int[count] ;
        }
        if(arr[idx] == data) count++ ;

        int []ans=allIndexes(arr,idx+1,data,count) ;
        if(arr[idx] == data){
            ans[count-1] = idx ;
            count-- ;
        }

        return ans ;
    }

    public static ArrayList<String> subsequence(String str,int idx){
         if(idx==str.length()){
            ArrayList<String> base=new ArrayList<>() ;
            base.add("") ;
            return base ;
        }
        ArrayList<String> rec=subsequence(str,idx+1)  ;
        ArrayList<String> myans=new ArrayList<>() ;
        // na wali call
        for(int i=0;i<rec.size();i++){
            myans.add(rec.get(i)) ;
        }
        char ch=str.charAt(idx) ;
        for(int i=0;i<rec.size();i++){
            myans.add(ch+rec.get(i)) ;
        }
        return myans ;
    }
    
    public static int countsubsequence(String str,int idx,String asf,ArrayList<String> ans){
        if(idx==str.length()) {
            ans.add(asf) ;
            return 1 ;
        }
        int count = 0 ;

        count+=countsubsequence(str,idx+1,asf,ans) ;
        count+=countsubsequence(str,idx+1,asf+str.charAt(idx),ans) ;
        return count ;

    }

    public static String[] nokiaKeys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static int nokiaKeyPad(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        return 0;
    }

    public static ArrayList<String> stairPath(int n) {
        if(n==0){
            ArrayList<String>baseAns=new ArrayList<> () ;
            baseAns.add("") ;
            return baseAns;
        }
        ArrayList<String> myAns=new ArrayList<String>();
        for(int jump=1;jump<=3 && n-jump>=0;jump++){
            ArrayList<String>recAns=stairPath(n-jump) ;
            for(String s:recAns) myAns.add(s+jump) ;
        }

        return myAns ;
    }

    public static int stairPath(int n,String psf,ArrayList<String>ans){
        if(n==0){
            ans.add(psf) ;
            return 1 ;
        }

        int cnt=0 ;
        for(int jump=1;jump<=3 && n-jump>=0;jump++){
            cnt+=stairPath(n-jump,psf+jump,ans) ;
        }
        return cnt ;
    }


    public static ArrayList<String> boardPath(int n) {
        if (n == 0) {
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        ArrayList<String> myAns = new ArrayList<String>();
        for (int dice = 1; dice <= 6 && n - dice >= 0; dice++) {
            ArrayList<String> recAns = stairPath(n - dice);
            for (String s : recAns)
                myAns.add(s + dice);
        }

        return myAns;
    }

    public static int boardPath(int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int cnt = 0;
        for (int dice = 1; dice <= 3 && n - dice >= 0; dice++) {
            cnt += stairPath(n - dice, psf + dice, ans);
        }
        return cnt;
    }


    public static int boardPath(int[] arr, int n, String psf, ArrayList<String> ans) {
        if(n==0){
            ans.add(psf) ;
            return 1 ;
        }

        int cnt = 0;
        for (int i= 1; i<= arr.length && n - arr[i]] >= 0; i++) {
            cnt += stairPath(n - arr[i], psf + ans[i], ans);
        }
        return cnt;
    }

    public static int mazePath_HVD(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans, int[][] dir,String[] dirS) {
        return 0 ;
     }

     public static int mazePath_HVD_multi(int sr, int sc, int er, int ec, String psf, ArrayList<String> ans, int[][] dir,String[] dirS) {
     
        return 0 ;
    }

    public static void mazePath() {
        int [][] dir = {{0,1},{1,0},{1,1}} ;
        String [] dirS = {"H","V","D"} ;

        ArrayList<String>ans = new ArrayList<>() ;
        System.out.println(maxPath_HVD())
    }


    public static void main (String[] args){
        // oddEven(1,6) ;
        // System.out.println(factorial(5)) ;
        // System.out.println(power(2,3)) ;
        // System.out.println((powerBtr(2,3))) ;
        // int arr[] ={1,2,3,4,5} ;
        // printArray(arr,0) ;
        // printArrayReverse(arr,0) ;
        // int temp[]={1,3,5,5,2,6,6,4,6} ;
        // System.out.println(lastIndex(temp,6,0)) ;
        // System.out.println(firstIndex(temp,6,0)) ;
        // System.out.println(maximum(temp,0)) ;
        // System.out.println(minimum(temp, 0));
        // ArrayList<String> ans=subsequence("abc",0) ;
        // ArrayList<String>ans=new ArrayList<>() ;
        // System.out.println(countsubsequence("abc",0,"",ans)) ;
        // System.out.println(ans) ;

        // System.out.println(stairPath(5)) ;
        // System.out.println(stairPath(5,"",new ArrayList<String>())) ;
    }

}


