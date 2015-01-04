def answer(y, x):
    # your code here
    y.sort()
    x.sort()
    
    y = [round(n,2) for n in y]
    x = [round(n,2) for n in x]
    
    # assign the "before" list y and "after" list x, if there
    # is no difference b/w the lists, do nothing.
    if x[0] > y[0]:
        temp = y
        y = x
        x = temp
    
    # make a new list to store the difference b/w corresponding
    # items in the lists and get their improvement %.
    diff = [abs(y[i] - x[i]) for i in range(len(y))]
    improvement = [int(diff[i]/y[i]*100) for i in range(len(y))]
    
    return improvement[0]

answer([22.2, 46, 100.8], [23, 11.1, 50.4])
answer([2.2999999999998, 15.0, 102.40000000000001, 3486.800000000002], [23.0, 150.0, 1024.0, 34868.0])
answer([1.0],[1.0])
answer([1],[1.0])