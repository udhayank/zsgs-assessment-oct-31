import java.util.Arrays;

public class NextGreaterNode {

	public static void main(String[] args) {
		
		int[] arr = {2,7,4,3,5};
		Node head = Node.createLinkedList(arr);
		
		System.out.println(Arrays.toString(new NextGreaterNode().nextGreaterNode(head)));

	}
	
	public int[] nextGreaterNode(Node head) {
		
		int n = findLength(head);
		System.out.println(n);
		int[] res = new int[n];
		
		int index = 0;
		
		while (head.next != null) {
			
			int jump = 0;
			int nextGreater = 0;
			boolean isFound = false;
			
			Node temp = head.next;
			while (temp != null) {
				
				// counting the number of nodes passed -> jump number of elements in the res array has to be updated
				jump++; 
				if (temp.data > head.data) {
					nextGreater = temp.data;
					isFound = true;
					break;
				}
				temp = temp.next;
				
			}
			
			if (!isFound) {
				
				res[index] = 0;
				index++;
				head = head.next;
				
			} else {
				
				for (int i=0; i<jump; i++) {
					res[index] = nextGreater;
					index++;
					head = head.next;
				}
				
			}
			
		}
		
		return res;
		
	}
	
	private int findLength(Node head) {
		
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
		
	}
	
	
}

class Node {
	
	int data;
	Node next;
	
	Node (int data){
		this.data = data;		
	}
	
	
	public static Node createLinkedList(int[] arr) {
	// construct linked list using given array and return head Node
		
		Node head = new Node(arr[0]);
		Node temp = head;
		
		for (int i=1; i<arr.length; i++) {
			temp.next = new Node(arr[i]);
			temp = temp.next;
		}
		
		return head;
		
	}
	
}
