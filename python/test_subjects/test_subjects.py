# Of the subjects that have survived, each has a distinct file, with anywhere from 1 to 100 
# measurements of completion time for the tests. The measurements from the before and after cases are 
# listed separately, but the ordering has been mixed up. You have to figure out the degree of 
#improvement (0% to 99%, rounded to the nearest whole number) based on the two lists of results.

# For example, if the first list of times is [22.2, 46, 100.8] and the second list is [23, 11.1, 50.4] 
# you would return 50, because the times got 50% shorter: the 22.2 entry improved to 11.1, the 46 improved 
# to 23, and the 100.8 improved to 50.4. Even though the data points are in different order, each improves by the same amount.

# Write a function answer(x, y) which takes two lists of floating point performance scores and returns 
# the improvement percentage, rounded to the nearest integer.

def answer(list1, list2):

	#sort the lists
	list1.sort()
	list2.sort()

	list1 = [round(x,2) for x in list1]
	list2 = [round(x,2) for x in list2]

	# assign the "before" list1 and "after" list2, if there is 
	# no difference between the lists, do nothing.
	if list2[0] > list1[0]:
		temp = list1
		list1 = list2
		list2 = temp

	# make a new list of the difference between the corresponding
	# items of each list. Use list comp.
	diff = [abs(list1[i] - list2[i]) for i in range(len(list1))]

	improvement = [int(diff[i]/list1[i]* 100) for i in range(len(list1))]
	print improvement[0]
	return improvement[0]

answer([22.2, 46, 100.8], [23, 11.1, 50.4])
answer([2.2999999999998, 15.0, 102.40000000000001, 3486.800000000002], [23.0, 150.0, 1024.0, 34868.0])
answer([1.0],[1.0])
answer([1],[1.0])