public class l003 {

    public static class ListNode {
        int val = 0 ;
        ListNode next=null ;

        ListNode(int val) {
            this.val = val ;
        }
    }

    public static int getLength(ListNode head) {
        if (head == null)
            return 0;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        return len;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode c = head, p = null;
        while (c != null) {
            ListNode f = c.next;
            c.next = p;
            p = c;
            c = f;
        }
        head = p;
        return p;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1) ;
        ListNode p=reverse(l1),q=reverse(l2),prev=dummy ;
        int c=0 ;
        while(p!=null ||  q!=null || c!=0) {
            int sum=c+(p!=null ? p.val:0)+(q!=null ? q.val:0) ;
            int qu=sum/10 ;
            int r=sum%10 ;
            prev.next=new ListNode(r) ;
            prev=prev.next ;
            c=qu ;
            if(p!=null) p=p.next ;
            if(q!=null) q=q.next ;
        }
        return reverse(dummy.next) ;  
    }

    public static ListNode multiplyDigit(ListNode list,int d) {
        ListNode dummy=new ListNode(-1),curr=list,prev=dummy ;
        int carry=0 ;
        while(curr!=null || carry!=0) {
            int sum=carry+(curr!=null ? curr.val : 0) * d ;
            int q=sum/10 ;
            int r=sum%10 ;
            carry=q ;
            prev.next=new ListNode(r) ;
            prev=prev.next ;
           if(curr!=null) curr=curr.next ;

        }
        return dummy.next ;

    }

    public static void addList(ListNode prev,ListNode list) {
        int carry=0 ;
        while(list !=null && carry!=0) {
            int sum=carry+(list!=null ? list.val: 0) + (prev!=null ? prev.val : 0) ;
            int digit=sum%10 ;
            carry=sum/10 ;
            if(prev.next!=null) {
                prev.next.val=digit ;
            }
            else {
                prev.next=new ListNode(digit) ;
            }
            prev=prev.next ;
            if(list!=null) list=list.next ;
        }
    }

    public static ListNode multiplyTwoLL(ListNode l1,ListNode l2) {
        l1=reverse(l1) ;
        l2=reverse(l2) ; 
        ListNode ans=new ListNode (-1),prev=ans ;
        while(l2!=null) {
            ListNode multipliedList=multiplyDigit(l1, l2.val) ;
            addList(prev,multipliedList) ;
            prev=prev.next ;
            l2=l2.next ;
        }

        return reverse(ans.next) ;
    }


    // Quick Sort 
    public static ListNode[] getSegregateNodes(ListNode head,int pivotIdx) {
        if(head==null || head.next==null) return new  ListNode[]{null,head,null};
     
         ListNode smaller=new ListNode(-1) ;
        ListNode greater=new ListNode(-1) ;
        ListNode sm=smaller,gr=greater;
        ListNode p=head ;
        ListNode pivot=head ;
        
        while(pivotIdx-->0){
            pivot=pivot.next ;
        }
        while(p!=null) {
            if(p!=pivot && p.val<=pivot.val) {
                sm.next=p ;
                sm=p ;
            }
            else if(p!=pivot && p.val>pivot.val) {
                gr.next=p ;
                gr=p ;
            }
            p=p.next ;
        }
        sm.next=gr.next=pivot.next=null ;
       
        return new ListNode[] {smaller.next, pivot, greater.next}
    }
    // {head,tail}
    public static ListNode[] quickSort(ListNode head) {
        if(head.next==null || head==null) 
        return new ListNode[]{head,head} ;

        int len=getLength(head) ;
        ListNode[]segregateNodes=getSegregateNodes(head,len/2) ;
        ListNode[]left=quickSort(segregateNodes[0]) ;
        ListNode[]right=quickSort(segregateNodes[2]) ;

        return mergeLists(left,segregateNodes[1],right) ;
    }

    public static ListNode[] mergeLists(ListNode[] left,ListNode pivot, ListNode[] right) {
        ListNode fh=null,ft=null ;
        if(left[0]!=null && right[0]!=null){
            fh=left[0] ;
            fh.next=pivot ;
            pivot.next=right[0] ;
            ft=right[1] ;
        }
        else if(left[0]==null && right[0]==null) {
            fh=ft=pivot ;
        }
        else if(left[0]==null) {
            fh=pivot ;
            pivot.next=right[0] ;
            ft=right[1] ;
        }
        else {
            fh=left[0] ;
            left[1].next=pivot ;
            ft=pivot ;
        }
        return new ListNode[]{fh,ft} ;
    }
    
    public static void main(String[] args){

    }

// questions 
// leetcode 445
// leetcode 2
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//          ListNode dummy=new ListNode(-1) ;
//         ListNode p=l1,q=l2,prev=dummy ;
//         int c=0 ;
//         ListNode th=null ;
//         while(p!=null ||  q!=null || c!=0) {
//             int sum=c+(p!=null ? p.val:0)+(q!=null ? q.val:0) ;
//             int qu=sum/10 ;
//             int r=sum%10 ;
//             prev.next=new ListNode(r) ;
//             prev=prev.next ;
//             c=qu ;
//             if(p!=null) p=p.next ;
//             if(q!=null) q=q.next ;
//         }
//         return dummy.next ; 
//     }
// }
}