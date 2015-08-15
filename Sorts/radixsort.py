#!/bin/python2
import math
# Radix sort using base 10

def maxLen(ls):
    mx = max([abs(x) for x in ls])
    ln = int(math.floor(math.log10(mx) + 1))
    return ln

def sort(ls):
    for i in range(maxLen(ls)):
        buckets = [[] for x in range(10)]
        for num in ls:
            digit = (abs(num) / 10**i) % 10
            buckets[digit].append(num)
        ls = []
        for n in range(10):
            for x in buckets[n]:
                ls.append(x)
    neg = []
    pos = []
    for x in ls:
        if (abs(x) != x):
            neg.insert(0, x)
        else:
            pos.append(x)
    ls = neg + pos

    return ls

ls = [5, 1000, -16, 36, -27, 4, 733, 74, 34, 5]
print ls
print sort(ls)
