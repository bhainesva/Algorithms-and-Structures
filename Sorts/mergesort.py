#!/bin/python2
def sort(list):
    if (len(list) == 1):
        return list

    left = list[:len(list)/2]
    right = list[len(list)/2:]
    final = merge(sort(left), sort(right))
    return final

def merge(left, right):
    result = []
    while (not (len(left) == 0 and len(right) == 0)):
        if (len(left) == 0):
            result += right
            return result
        if (len(right) == 0):
            result += left
            return result
        if (left[0] <= right[0]):
            result.append(left[0])
            left = left[1:]
        else:
            result.append(right[0])
            right = right[1:]
    return result


print sort([7, 8, 3, 6, 4, 1, 5])
