package DataStructures;

import DataStructures.LinkedList.Node;

public class h {
    

public void insertAtPosition(int data, int position) 
{ 
    Node newNode = new Node(data); 
    Node temp = head;
    if (position == 1) { 
        insertAtBeginning(data); 
        return;
    } 
    for(int i=0; i<position-1;i++){
        temp = temp.next;
    }
    temp.next = newNode.next;
    temp.next.prev = newNode;
    temp.next = 
    // 12345
} 
}
