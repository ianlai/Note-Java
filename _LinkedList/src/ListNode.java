public class ListNode{
	int val;
	ListNode next;
	ListNode(int x){ val=x;}
	
	public static void print(ListNode node){
		ListNode n = node;
		while(n!=null){
			System.out.print(n.val + " -> ");
			n = n.next;
		}
		return;
	}
	
	public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2){
		if(l1==null && l2==null) return null;
        if(l1==null && l2!=null) return l2;
        if(l1!=null && l2==null) return l1;
		ListNode r = new ListNode(0); //dummy
		ListNode t = r; 
		while(true){
			if(l1!=null && l2!=null){           
				if(l1.val < l2.val){  //add l1
					t.next = l1;
					l1 = l1.next;
				}else{                //add l2
					t.next = l2;
					l2 = l2.next;
				}
			}else if(l1==null && l2!=null){      //l1 finished
				t.next = l2;
				r = r.next;  //deduct first node
				return r;
			}else if(l1!=null && l2==null){      //l2 finished
				t.next = l1;
				r = r.next;  //deduct first node
				return r;
			}else{                               //both finished
				r = r.next;  //deduct first node
				return r;	
			}
			t = t.next;
		}
	}
		
//		if(l1==null && l2==null) return null;
//        if(l1==null && l2!=null) return l2;
//        if(l1!=null && l2==null) return l1;
//        ListNode h1 = l1;
//        ListNode h2 = l2;
//        
//        while(l1.next!=null && l2.next!=null){
//             if(l1.next.val > l2.val){
//                 ListNode temp1 = l1.next;
//                 l1.next = l2;
//                 while(l2.next.val > temp1.val){
//                     l2 = l2.next;
//                 }
//                 ListNode temp2 = l2.next;
//                 l2.next = temp1;
//             }
//             l1 = l1.next;
//        }
//        if(l1.next==null && l2.next!=null){ //l1 finished
//            l1.next = l2;
//        }
//        if(l1.next!=null && l2.next==null){ //l2 finished
//            l2.next = l1;
//            return h2;
//        }
//        if(l1.next==null && l2.next==null){
//            if(l1.val > l2.val){
//                l2.next = l1;
//                return h2;
//            }
//            else{
//                l1.next = l2;
//            }
//        }
//        return h1;

}
