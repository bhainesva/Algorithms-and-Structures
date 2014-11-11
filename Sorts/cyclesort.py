#!/bin/python2
def sort(ls):
    for start in range(len(ls)-1):
        item = ls[start]
        pos = start
        for i in range(start+1, len(ls)):
            if (ls[i] < item):
                pos+=1

        if pos == start:
            continue
        else:
            while ls[pos] == item and pos < len(ls)-1:
                pos+=1
            item, ls[pos] = ls[pos], item

        while pos != start:
            pos = start
            for i in range (start+1, len(ls)):
                if (ls[i] < item):
                    pos+=1

            while ls[pos] == item and pos < len(ls)-1:
                pos += 1
            item, ls[pos] = ls[pos], item

    return ls


ls = [5, 5, 5, 5, 5, 5, 5]
print sort(ls)
