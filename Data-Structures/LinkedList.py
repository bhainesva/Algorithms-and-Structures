#!/bin/python2
class node:
    def __init__(self, value=None):
        self.value = value
        self.nextNode = None
        self.prevNode = None



class LinkedList:
    def __init__(self):
        self.head = node()
        self.tail = node()
        self.tail.prevNode = self.head
        self.head.nextNode = self.tail
        self.size = 0

    def __iter__(self):
        return ListItr(self.head.nextNode)


    def __repr__(self):
        out = ""
        for i in self:
            out += str(i) + ", "

        return out[:-2]

    def valueAt(self, index):
        itr = ListItr(self.head)
        for i in range(index):
            itr.next()
        return itr.current.value
        
    def find(self, value):
        itr = ListItr(self.head)
        while itr.current.value != value:
            try:
                itr.next()
            except:
                return ListItr(self.tail)
        return itr

    def remove(self, node):
        node.prevNode.nextNode = node.nextNode
        node.nextNode.prevNode = node.prevNode
            
    def indexOf(self, value):
        itr = ListItr(self.head)
        index = -1
        while itr.current.value != value:
            index += 1
            try:
                itr.next()
            except:
                return -1
        return index

    def add(self, data):
        newNode = node(data)
        newNode.nextNode = self.tail
        newNode.prevNode = self.tail.prevNode

        self.tail.prevNode = newNode
        newNode.prevNode.nextNode = newNode
    
        self.size += 1

class ListItr:
    def __init__(self, node):
        self.current = node

    def __iter__(self):
        return self

    def next(self):
        if self.current.nextNode == None:
            raise StopIteration()

        self.current = self.current.nextNode
        return self.current.prevNode.value


if __name__ == "__main__":
    ls = LinkedList()
    ls.add(1)
    ls.add(2)
    ls.add(3)
    ls.add(4)
    ls.add(5)
    ls.add(6)
    ls.add(7)
    ls.add(8)
    ls.add(9)

    print repr(ls)
    print "FIND 0:", ls.find(0).current.value
    print "FIND 3:", ls.find(3).current.value
    print "FIND 9:", ls.find(9).current.value
