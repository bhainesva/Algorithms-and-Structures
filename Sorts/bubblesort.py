#!/bin/python2
def sort(list):
    done = False
    while not done:
        done = True
        for i in range(1, len(ls)):
            if ls[i] < ls[i-1]:
                done = False
                ls[i], ls[i-1] = ls[i-1], ls[i]
    return ls

ls = [1, 4, 2, 5, 3, 6, 7, 9, 8]
print ls
print sort(ls)

