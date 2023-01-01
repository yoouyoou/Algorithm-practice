package leetcode;

public class l_24 {

	public static void main(String[] args) {
		ListNode n4 = new ListNode(4, null);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);

		ListNode root = swapPairs(n1);
		
		while(root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;

        if(head.next == null) 
            return head;
        
        ListNode next = head.next;
        ListNode next2 = head.next.next;
        
        head.next.next = head;
        head.next = swapPairs(next2);
        
        return next;
	}
	
}

class ListNode{
	int val;
	ListNode next;
	
	ListNode() {}
	ListNode(int val){ this.val = val; }
	
	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}
