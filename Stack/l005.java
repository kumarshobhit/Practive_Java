import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class l005 {

    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        ArrayDeque<Character>st=new ArrayDeque<>() ;
        char []arr=s.toCharArray();
        for(int i=0;i<n;i++) {
            char ch=s.charAt(i);
            if(ch==')') {
                if(st.size()!=0) st.removeFirst() ;
                else arr[i]='#' ;
            }
            else {
                 st.add(ch);
            }
        }
        while(st.size()!=0) {
            arr[st.removeFirst()]='#' ;
        }

        StringBuilder sb=new StringBuilder() ;
        for(int i=0;i<n;i++) {
            if(arr[i]!='#') sb.append(arr[i]) ;
        }

        return sb.toString() ;

    }

    public int[] exclusiveTime(int n, List<String> logs) {
        class logPair{
            int id,timeStamp,sleepTime ;
            boolean isStart=false ;

            logPair(String str ) {
                String []arr=str.split(":") ;
                this.id=Integer.parseInt(arr[0]) ;
                this.timeStamp=Integer.parseInt(arr[1]) ;
                this.isStart=arr[1].equals("start") ;
                this.sleepTime=0 ;
            }
        }

        LinkedList<logPair> st = new LinkedList<>();
        int []ans=new int [n] ;

        for(String s:logs) {
            logPair log = new logPair(s) ;

            if(log.isStart) st.addFirst(log) ;
            else {
                logPair rp=st.removeFirst() ;
                ans[rp.id]+=log.timeStamp-rp.timeStamp+1 ;
                ans[rp.id]-=rp.sleepTime ;
                if(st.size()!=0) {
                    st.getFirst().sleepTime+= log.timeStamp - rp.timeStamp + 1;
                }
            }
        }

        return ans ;

    }



    public int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length ;
        double[][] disTimeData=new double[n][2] ;

        for(int i=0;i<n;i++) {
            disTimeData[i][0]=position[i]*1.0 ;
            disTimeData[i][1]=((target-position[i])*1.0)/speed[i] ;
        }

        // lamda operator does not work in primitive data types
        Arrays.sort(disTimeData,(a,b)-> {
            return (int)(a[0]-b[0]) ;
        }) ;

        int ans=1 ;
        double prevTime=disTimeData[n-1][1] ;
        for(int i=n-2;i>=0;i--) {
            if(disTimeData[i][1]>prevTime) {
                prevTime=disTimeData[i][1] ;
                ans++ ;
            }
        }
        return ans ;
    }

    public static void main(String[] args) {
        Integer[]arr={1,2,3,4,5} ;
        Integer[]pq={3,4,5,1,2} ;

        fun(arr,pq) ;
    }
}


// custom sorting
public static void fun(Integer []arr,Integer []pq) {
        class pair implements Comparable<pair>{
            int ele,pri ;
            pair(int ele,int pri) {
                this.ele=ele ;
                this.pri=pri ;
            }

            public int compareTo(pair o) {
                return o.pri-this.pri ;
            }
        }
        ArrayList<pair> ans =new ArrayList<>() ;
        int n=arr.length ;
        for(int i=0;i<n;i++) {
            pair temp=new pair(arr[i],pq[i]) ;
            ans.add(temp) ;
        }
        Collections.sort(ans) ;
        for(int i=0;i<n;i++) System.out.print(ans.get(i).ele+" ") ;
        System.out.println() ;
    }
