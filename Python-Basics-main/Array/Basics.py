import array

arr = array.array('i',[1,2,3,4])
ls = [1,2,3,4]
arr.insert(len(arr),5) #adding element at last index 

def printArray(arr):
    for i in arr:
        print(i)

def linearSearch(arr, key):
    for i in range(len(arr)):
        if arr[i]==key:
            return i
    return -1

def LinearSearch(ls, key):
    for i, value in enumerate(ls):
        if value == key:
            return i
    return -1

printArray(arr)
print("Element at first index:",arr[0])
print(linearSearch(arr, 5))
print(LinearSearch(ls, 5))
