class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.length = 0

    def __str__(self):
        temp_node = self.head
        result = ""
        while temp_node is not None:
            result += str(temp_node.value)
            if temp_node.next is not None:
                result += " -> "
            temp_node = temp_node.next
        return result

    def append(self, value):
        new_node = Node(value)
        self.length += 1
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node

    def prepend(self, value):
        new_node = Node(value)
        self.length += 1
        if self.head is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node

    def insert(self, value, index):
        new_node = Node(value)
        if index<0 or index>self.length:
            return False
        elif self.head is None:
            self.head = new_node
            self.tail = new_node
        elif index==0:
            new_node.next = self.head
            self.head = new_node
        else:
            temp_node = self.head
            for _ in range(index-1):
                temp_node = temp_node.next
            new_node.next = temp_node.next
            temp_node.next = new_node
        self.length += 1
        return True
    
    def traversal(self):
        current_node = self.head
        while current_node is not None:
            print(current_node.value, end=' ')
            current_node = current_node.next
    
    def search(self, target):
        current_node = self.head
        index = 0 
        while current_node:
            if current_node.value == target:
                return index
            current_node = current_node.next
            index += 1
        return -1
    
    def get(self, index):
        current_node = self.head
        if index<0 or index>self.length:
            return None
        for _ in range(index):
            current_node = current_node.next
        return current_node
    
    def setValue(self, index, value):
        temp = self.get(index)
        if temp:
            temp.value = value
            return True
        return False
    
    def popFirst(self):
        if self.length == 0:
            return None
        
        popped_node = self.head
        if self.length == 1:
            self.head = None
            self.tail = None
        else:
            self.head = self.head.next
            popped_node.next = None

        self.length -= 1
        return popped_node
    
    def popLast(self):
        if self.length == 0:
            return None
        popped_node = self.tail
        if self.length == 1:
            self.head = self.tail = None
        else:
            temp = self.head
            while temp.next is not self.tail:
                temp = temp.next
            temp.next = None
            self.tail = temp
        self.length -= 1
        return popped_node
    
    def remove(self, index):
        if index < -1 or index >= self.length:
            return None
        if index == 0:
            return self.popFirst()
        if index == -1 or index == self.length-1:
            return self.popLast()
        prev_node = self.get(index-1)
        popped_node = prev_node.next
        prev_node.next = popped_node.next
        popped_node.next = None
        self.length -= 1
        return popped_node
    
    def deleteAll(self):   #O(1)
        self.head = None
        self.tail = None
        self.length = 0

            

        
        
new_linked_list = LinkedList()
new_linked_list.insert(10,0)
new_linked_list.append(20)
new_linked_list.append(40)
new_linked_list.prepend(0)
new_linked_list.insert(30,3)
print(new_linked_list)
new_linked_list.traversal()
print()
print("Element at",new_linked_list.search(80))
print(new_linked_list.get(3).value)
print(new_linked_list.setValue(3,33))
