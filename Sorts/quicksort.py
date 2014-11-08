#!/bin/python2
def quicksort(ls, low, high):
    if low < high:
        fixed = partition(ls, low, high)
        quicksort(ls, low, fixed-1)
        quicksort(ls, fixed+1, high)

def partition(ls, left, right):
    pivot = right
    value = ls[pivot]
    pos = left
    for i in range(left, right):
        if ls[i] < value:
            ls[i], ls[pos] = ls[pos], ls[i]
            pos += 1
    ls[right], ls[pos] = ls[pos], ls[right]
    return pos

ls = [1, 4, 2, 5, 6, 7, 3, 8]
print ls
quicksort(ls, 1, len(ls)-1)
print ls
