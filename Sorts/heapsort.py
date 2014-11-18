#!/bin/python2
import heapq

def sort(ls):
    heapq.heapify(ls)
    result = []
    for i in range(len(ls)):
        result.append(heapq.heappop(ls))

    return result

ls = [1, 5, 2, 7, 2, 8, 9, 3, 0, 4, 5]
print ls
print sort(ls)
