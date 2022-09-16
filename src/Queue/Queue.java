package Queue;

public class Queue implements IQueue {

	/* That code refers to a Queue - classic data structure.
	 * Implemented by @aquilesRod
	 * Disciplin: Data Structures I
	 * Pernambuco Catholic University
	 */
	
	private Integer queueArray[];
	private int head, tail;

	public Queue(int capacity) {
		this.queueArray = new Integer [capacity];
		this.head = 0;
		this.tail = 0;
	}

	@Override
	public void enqueue(Integer value) {
		if (this.isFull()) {
			throw new IllegalStateException();
		}
		
		this.queueArray[this.tail] = value;
		
		if (this.tail == this.queueArray.length-1) {
			 this.tail = 0;
		} else {
			this.tail++;
		}
		
	}

	@Override
	public Integer dequeue() throws Exception {
		Integer aux;
		
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}
		
		aux = this.queueArray[this.head];
		this.queueArray[this.head] = null;
		
		if (this.head == this.queueArray.length-1) {
			this.head = 0;
		} else {
			this.head++;
		}
		return aux;
	}

	@Override
	public boolean isEmpty() {
		return (this.queueArray[this.head] == null && this.head == this.tail);
	}
	
	private boolean isFull() {
		return (this.queueArray[this.head] != null && this.head == this.tail);
	}

}
