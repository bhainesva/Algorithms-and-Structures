#!/bin/python2
def sort(ls):
    for pos in range(1, len(ls)):
        compare = pos
        while compare > 0 and ls[compare] < ls[compare-1]:
            ls[compare-1], ls[compare] = ls[compare], ls[compare-1]
            compare = compare - 1
    return ls

ls = [1, 4, 2, 5, 3,6, 8, 7, 9]
print ls
print sort(ls)


