public class l001 {
    public static class ListNode {
        int data = 0 ;
        ListNode next=null ;

        ListNode(int data) {
            this.data = data ;
        }
    }

    public static ListNode midNode(ListNode head) {
        if(head == null || head.next==null) return head ;
        ListNode s=head,f=head ;
        while(f.next!=null && f.next.next!=null) {
            f=f.next.next ;
            s=s.next ;
        }
        return s ;
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


    public static boolean isPalindrome(ListNode head) {
    ListNode first=midNode(head) ;
    ListNode second=first.next ;
    first.next=null ;
    second=reverse(second) ;
    ListNode p=head,q=second ;
    while(p!=null && q!=null) {
        if(p.data!=q.data) return false ;
        p=p.next ;
        q=q.next ;
    }
    second=reverse(second);
    first.next=second ;

    return true ;
    }

    public static void fold(ListNode head) {
        if(head== null || head.next == null) return ;
        ListNode first = midNode(head);
        ListNode second = first.next;
        first.next = null;
        second = reverse(second);
        ListNode c1 = head, c2 = second;
        while (c2 != null) {
            ListNode f1 = c1.next, f2 = c2.next;
            c1.next = c2;
            c2.next = f1;
            c1 = f1;
            c2 = f2;
        }
    }

    public static void unfold(ListNode head) {
        if(head==null || head.next==null) return ;
        ListNode d1=new ListNode(-1) ;
        ListNode d2=new ListNode(-1) ;
        ListNode p=head,q=head.next,c=head.next.next ;
        d1.next=p ;
        d2.next=q ;
        while(c!=null) {
            p.next=c; p=c ;
            q.next=c.next ;
            if(c.next!=null) {
                 q=c.next ;
                 c=c.next.next ;
            }
            else c=c.next ;
        }
        p.next=q.next=null ;
        p.next=reverse(d2.next) ;
        head=d1.next ;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 != null ? l1 : l2;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }
        curr.next = l1 != null ? l1 : l2;
        head = head.next;
        return head;
    }


    public static void main(String[] args){

    }



    // leetocde 876.
    // public ListNode middleNode(ListNode head) {
    //     if (head == null || head.next == null)
    //         return head;
    //     ListNode s = head, f = head;
    //     while (f != null && f.next != null) {
    //         f = f.next.next;
    //         s = s.next;
    //     }
    //     return s;
    // }

    // leetcode 206.
    // public ListNode reverseList(ListNode head) {
    //      if(head==null || head.next==null) return head ;
    //   ListNode c=head,p=null ;
    //   while(c!=null) {
    //       ListNode f=c.next ;
    //       c.next=p ;
    //       p=c ;
    //       c=f ;
    //   }
    //   head=p ;
    //   return p ;
    // }

    // 234.
    //  public boolean isPalindrome(ListNode head) {
    // ListNode first=midNode(head) ;
    // ListNode second=first.next ;
    // first.next=null ;
    // second=reverse(second) ;
    // ListNode p=head,q=second ;
    // while(p!=null&&q!=null)
    // {
    //     if (p.data != q.data)
    //         return false;
    //     p = p.next;
    //     q = q.next;
    // }
    // second=reverse(second);
    // first.next=second ;
    // return true ;
    // }

    // 143.
    // 19.
    // 328.
    // public ListNode oddEvenList(ListNode head) {
    //     if (head == null || head.next == null)
    //         return head;
    //     int t = 1;
    //     ListNode odd = new ListNode(-1);
    //     ListNode even = new ListNode(-1);
    //     ListNode p = odd, q = even;
    //     ListNode c = head;
    //     while (c != null) {
    //         if (t % 2 == 0) {
    //             q.next = c;
    //             q = c;
    //         } else {
    //             p.next = c;
    //             p = c;
    //         }
    //         t++;
    //         c = c.next;
    //     }
    //     p.next = q.next = null;
    //     p.next = even.next;
    //     return odd.next;
    // }
}
