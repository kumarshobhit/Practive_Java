import java.util.ArrayDeque;

public class l003 {

    public int[] asteroidCollision(int[] a) {
        int n=a.length; 
        ArrayDeque<Integer> st=new ArrayDeque<Integer>() ;
        for(int ele:arr) {
            if(ele>0) {
                st.addFirst(ele);
                continue ;
            }

            while(st.size()>0 && st.peek() > 0 && st.peek() < -ele) st.pop() ;

            if(st.size()>0 && st.peek()== -ele) st.pop() ;
            else if(st.size()==0 || st.peek()<0) st.push(ele) ;
            else {
                //nothing to do
            }
        }
        int []arr=new int[st.size()] ;
        int idx=st.size()-1 ;
        while(st.size()>0) {
            arr[idx--]=st.pop() ;
        }
        return arr ;
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n=pushed.length ;
        ArrayDeque<Integer> st=new ArrayDeque<>() ;
        int idx=0 ;
        for(int ele:pushed) {
            st.addFirst(ele) ;
            while(st.size()>0 && st.peek()==popped[idx]) {
                st.pop() ;
                idx++ ;
        }
    }

    if(idx==n) return true ;
    return false ;

}

public int scoreOfParentheses(String s) {
    ArrayDeque<Character> st=new ArrayDeque<>() ;
    int n=s.length() ;
    int ans=0 ;
    int idx=0 ;
    while(idx<n) {
        char ch=s.charAt(idx) ;
        if(ch=='(') {
            st.addFirst(ch);
        } 
        else {
            int sum=0 ;
            while(st.size()>0 && st.peek()!='(') {
                char ch1=st.pop() ;
                sum+=(ch1-'0') ;
            }
            st.pop() ;
            if(sum==0) st.addFirst('1');
           else  if(sum==1) st.addFirst('2') ;
            else st.addFirst((char)(2*sum+'0')) ;
        }
    }
    while(st.size()>0) {
        ans+=(st.pop()-'0') ;
    }
    return ans ;
}

    public static void main(String[] args){
        
    }
}
