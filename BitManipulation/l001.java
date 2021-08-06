public class l001 {

    // 0->1,1->1
    public static void offToOn(int n,int k){
        int mask = (1<<k) ;
        n|=mask ;
        System.out.println(n) ;
    }
    // 0->0,1->0
    public static void onToOff(int n,int k){
      int mask=(1<<k)  ; 
      n&=(~mask) ;
      System.out.println(n) ;
    }

    public static int countSetBits(int n) {
        int ans=0 ;
        int mask=1 ;
        for(int i=0;i<31;i++){
            if()
            mask=(mask<<1) ;
        }
        return ans ;
    }

    public static int countSetBits_2(int n){
        int ans=0 ;
        int a=1 ;
        // logn n approach
        while(n>0){
            if((n&1)!=0) ans++ ;
            a=a<<1 ;
            n=n>>>1 ; // note we have to use triple right shift operator
        }
        return ans ;
    }
    public static void main(String [] args){
        int n=5 ;
        int k=2 ;
        System.out.println(n) ;
        // offToOn(n,k) ;
        k=3 ;
        // onToOff(n,k) ;
        System.out.println(countSetBits(5)) ;
    }
}