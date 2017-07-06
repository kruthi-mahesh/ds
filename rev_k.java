import java.util.*;
class rev_k{
	Node head;
	class Node{
		int data;
		Node next;
		Node(int item){
			data = item;
		}
	}
	static void print(Node head){
		System.out.println("print called ");
		Node c = head;
		while(c != null){
			System.out.println(c.data);
			c= c.next;
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
	static Node rev_k(Node head,int k){
		int ct =0;
		Node cur =head;
		Node pre=null,next=null;
		if(head == null || head.next == null)
			return head;
		while(ct<k && cur!=null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			ct++;
		}
		if(next != null)
			head.next = rev_k(next,k);		
		return pre;
	}

	void rev_k(int k){
		this.head = rev_k(head,k);

	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int item;
		rev_k l = new rev_k();
		while( 1==1){
			System.out.println("0.print\n1.push\n2.del\n3.rev_k");
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
				int k = in.nextInt();
				l.rev_k(k);
				System.out.println("After rev");
				l.print();
			}
		}
	}

}