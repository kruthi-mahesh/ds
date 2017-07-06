import java.util.*;
class mergeSort{
	Node head;
	class Node{
		int data;
		Node next;
		Node(int item){
			data = item;
		}
	}
	void print(){
		if(head == null){
			System.out.println("Empty list");
			return;
		}

		Node t = head;
		System.out.println("Current list is: ");
		while(t!=null){
			System.out.println(t.data);
			t = t.next;
		}
	}
	void push(int data){
		Node t =head;
		if(head == null){
			head = new Node(data);
			return;
		}
		while(t.next !=null)
			t= t.next;
		t.next = new Node(data);

	}
	void del(int data){
		Node cur = head;
		Node pre = null;
		if(head == null){
			System.out.println("Cant delete from Empty list");
			return;
		}
	
		if(head.data == data){
			head = head.next;
			return;
		}
		while(cur != null && cur.data != data){
			pre = cur;
			cur = cur.next;
		}
		if(cur == null){
			System.out.println("Not found");
			return;
		} 
		pre.next = cur.next;	
	}
	Node  getmiddle(Node head){
		Node slow = head;
		Node fast = head.next;
		while(fast != null && fast.next!=null){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	void print(Node head){
		Node c = head;
		while(c != null){
			System.out.println(c.data);
			c= c.next;
		}
	}
	Node mergesort(Node head){
		if(head == null || head.next == null)
			return head;
		Node mid = getmiddle(head);
		Node second_half = mid.next;
		mid.next = null;
		Node left = mergesort(head);
		Node right = mergesort(second_half);
		return (merge(left,right));

	}
	void sort(){
		head = mergesort(head);
	}
	static Node merge(Node left,Node right){
		if(left ==  null)
			return right;
		if(right == null)
			return left;
		if(left.data <= right.data){
			left.next = merge(left.next,right);
			return left;
		}
		else{
			right.next = merge(left,right.next);
			return right;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int item;
		mergeSort l = new mergeSort();
		while( 1==1){
			System.out.println("0.print\n1.push\n2.del\n3.mergeSort");
			int ch = in.nextInt();
			switch(ch){
				case 0: 
				l.print();
				break;

				case 1:
				item = in.nextInt();
				l.push(item);
				break;

				case 2:
				item = in.nextInt();
				l.del(item);
				break;
				case 3:
				l.sort();
				System.out.println("After sorting");
				l.print();
			}
		}
	}

}