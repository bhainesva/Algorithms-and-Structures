#!/bin/python2

class Stack():
    def __init__(self):
        self.store = []

    def push(self, item):
        self.store.append(item)

    def pop(self):
        if len(self.store) == 0:
            raise IndexError("Pop from empty stack")
        tmp = self.store[-1]
        self.store = self.store[:-1]
        return tmp

if __name__ == "__main__":
    ls = Stack()
    ls.push(1)
    ls.push(2)
    ls.push(3)
    ls.push(4)
    print ls.pop()
    print ls.pop()
    print ls.pop()
    print ls.pop()
    print ls.pop()

