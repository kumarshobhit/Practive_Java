public class l003 {

    public static class ListNode {
        int data = 0 ;
        ListNode next=null ;

        ListNode(int data) {
            this.data = data ;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1) ;
        ListNode p=reverse(l1),q=reverse(l2),prev=dummy ;
        int c=0 ;
        ListNode th=null ;
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
    
    public static void main(String[] args){

    }

// questions 
// leetcode 445
// leetcode 2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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