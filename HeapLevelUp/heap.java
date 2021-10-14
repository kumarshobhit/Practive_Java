import java.io.* ;
import java.util.* ;

public class heap {
    private ArrayList<Integer> arr ;

    public heap() {
        this.arr=new ArrayList<Integer>(); 
    }

    // O(n+nLog(n)) -> O(n)
    public heap(int []arr) {
        for(int ele:arr) {
            this.arr.add(ele) ;
        }

        for(int i=this.arr.size()-1;i>=0;i--) {
            downHeapify(i) ;
        }
    }

    private boolean compareTo(int x,int y) {
        return this.arr.get(x)>this.arr.get(y) ;
    }

    private void swap(int x,int y) {
        int v1=this.arr.get(x) ;
        int v2=this.arr.get(y) ;

        this.arr.set(x,v2) ;
        this.arr.set(y,v1) ;
    }

    // log(N)
    private void upHeapify(int ci) {
        int pi=(ci-1)/2 ;
        if(pi>=0 && compareTo(ci,pi) {
            swap(ci,pi) ;
            upHeapify(pi) ;
        }
    }

    private void downHeapify(int pi) {
        int lci=2*pi+1 ;
        int rci=2*pi+2 ;
        int maxIdx=pi ;

        if(lci<arr.size() && compareTo(lci,maxIdx)) 
        maxIdx=lci ;

        if (rci < arr.size() && compareTo(rci, maxIdx))
            maxIdx = rci;

        if(pi!=maxIdx) {
            swap(pi,maxIdx) ;
            downHeapify(maxIdx) ;
        }
    }

    public void add(int val) {
        // code 
        this.arr.add(val) ;
        // int pi=size/2 ;
        // downHeapify(pi) ;
        upheapify(this.arr.size()-1) ;
    }

    public int size() {
        return this.arr.size() ;
    }

    // log(N)
    public int remove() {
        int val= this.arr.get(0);
        swap(0,this.arr.size()-1) ;
        downHeapify(0) ;
        this.arr.remove(this.arr.size()-1) ;
        return val ;
    }

    public int peek() {
        return this.arr.get(0) ;
    }
}
