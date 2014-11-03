#!/bin/python2
def sort(ls):
    first = 0
    minInd = 0
    while(first < len(ls)):
        minVal = ls[first]
        swap = False
        for i in range(first, len(ls)):
            if ls[i] < minVal:
                minVal = ls[i]
                minInd = i
                swap = True
        if swap:
            ls[first], ls[minInd] = ls[minInd], ls[first]
        first+=1
    return ls

def sort2(ls):
    for first in range(len(ls)-1):
        minVal = ls[first]
        minIndex = first
        swap = False
        for i in range(first+1, len(ls)):
            if (ls[i] < ls[first]):
                minVal = ls[i]
                minIndex = i
                swap = True
        if swap:
            ls[minIndex], ls[first] = ls[first], ls[minIndex]
    return ls

# This difference between this and the above is that
# this one doesn't have to use a swap bool thing but
# it does swap things with themselves.
# Actually that's probably optimized out, this is the better
# version I think.
def sort3(ls):
    for first in range(len(ls)-1):
        minVal = ls[first]
        minIndex = first
        for i in range(first, len(ls)):
            if (ls[i] < ls[first]):
                minVal = ls[i]
                minIndex = i
        ls[minIndex], ls[first] = ls[first], ls[minIndex]
    return ls

ls = [1, 4, 5, 2, 2, 3, 6, 7, 3, 4, 8, 9]
print ls
print sort(ls)
print sort2(ls)
print sort3(ls)

