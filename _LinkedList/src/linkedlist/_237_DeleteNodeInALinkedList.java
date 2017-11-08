package linkedlist;

public class _237_DeleteNodeInALinkedList {

	public static void main(String[] args) {
		_237_DeleteNodeInALinkedList obj = new _237_DeleteNodeInALinkedList();
		ListNode l1 = ListNode.createListDefault();
		l1.print();
		
		ListNode delNode = l1.next.next.next; //4
		obj.deleteNode(delNode);
		l1.print();
	}

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}