import java.util.ArrayList;

public class l005_Recursion {

    public static void equalSet(int []arr,int idx,int sum,ArrayList<ArrayList<Integer>>ans) {

    }

    // public static void equalSet(int []arr,int idx) {
    //     ArrayList<ArrayList<Integer>> ans = new ArrayList<>() ;
    //     for(int i=0;i<2;i++){
    //         ans.add(new ArrayList<Integer>()) ;
    //     }
    //     int sum=0 ;
    //     for(int ele:arr) {
    //         sum+=ele ;
    //     }

    //     if((sum&1)!=0) return ;
    //     equalSet(arr,0,sum/2,ans) ;
    //     System.out.println(ans) ;

    // }

    public static void ksubsets(int []arr,int idx,int []subsetSum,ArrayList<ArrayList<Integer>>ans) {

    }

    public static void equalSet(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<Integer>());
        }
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }
        if (sum%k!= 0)
            return;

        ksubsets(arr, 0, sum / 2, ans);
        System.out.println(ans);

    }

    static int count=0 ;
    public static void kPartition(int num,int n,ArrayList<ArrayList<Integer>>ans) {
        if(num > n) {
           if(ans.get(ans.size()-1).size() == 0) {
               return ;
           }
           System.out.print(count+". ") ;
           for(ArrayList<Integer> a : ans) {
               System.out.print(a + " ") ;
           }
           System.out.println() ;
            return ;
        }
        
        for(ArrayList<Integer> a : ans) {
            a.add(num) ;
            kPartition(num+1,n,ans) ;
            a.remove(a.size()-1) ;
            if(a.size()==0) break ;
        }
    }

    public static void main(String[] args) {
        int []arr={10,20,30,40,50,60} ;
        equalSet(arr,0,sum/2,ans) ;
        System.out.println(ans) ;
    }
}
