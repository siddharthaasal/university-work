package Queue;

//using an array
class Queue {
	static private int front, rear, capacity;
	static private int queue[];

	Queue(int c)
	{
		front = rear = 0;
		capacity = c;
		queue = new int[capacity];
	}


	static void queueEnqueue(int data)
	{
		if (capacity == rear) {
			System.out.printf("\nQueue is full\n");
			return;
		}
		else {
			queue[rear] = data;
			rear++;
		}
		return;
	}

    static void queueDequeue() {
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
        } else {
          queue[front] = -1;
		  front++;

        }
    }

	static void queueDisplay()
	{
		int i;
		if (front == rear) {
			System.out.printf("\nQueue is Empty\n");
			return;
		}
		for (i = front; i < rear; i++) {
			System.out.printf("%d ", queue[i]);
		}
		return;
	}

    	public static void main(String[] args)
	{
	
		Queue q = new Queue(4);

        System.out.print("\ninitially: ");
		queueDisplay();

		queueEnqueue(1);
		queueEnqueue(2);
		queueEnqueue(3);
		queueEnqueue(4);

        System.out.println("after adding: ");
		queueDisplay();

        
		queueDequeue();
		queueDequeue();
		
        System.out.println("\nafter removing: ");
		queueDisplay();

	}
}
