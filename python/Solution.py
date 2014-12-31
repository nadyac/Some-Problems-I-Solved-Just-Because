#Solution.py

def isMonth(n):
	if n <= 12:
		return True
	else:
		return False

def isDay(month, n):
	if n <= 31:

		if n == month:
			return True

		#check if n is a valid day for the given month
		if month == 2 and n > 28 or n <= 12:
			return False
		elif month in {4, 6, 9, 11}:
			if n >= 30 or n <= 12:
				return False
		elif month in {1, 3, 5, 7, 8, 10, 12}:
			if n <= 12:
				return False
			else:
				return True
		else:
			return True

def isValidYear(month, day, n):
	#print "month " + str(month) + " day " + str(day) + " n " + str(n)
	if n <= 99:
		#check if n is a valid year for the given month
		if month in {1, 3, 5, 7, 8, 10, 12}:
			if n > 31 or n == day:
				return True
			else:
				return False
		elif month in {4, 6, 9, 11}:
			if n > 30:
				return True
			else:
				return False
		elif month == 2 and n > 28:
			return True
		elif month == 0:
			return True
	else:
		return False

def formatAnswer(month, day, year):
	if month < 10:
		month = "0" + str(month)
	else:
		month = str(month)

	if day < 10:
		day = "0" + str(day)
	else:
		day = str(day)

	if year < 10:
		year = "0" + str(year)
	else:
		year = str(year)
	newList = [month, day, year]
	return newList

def answer(x, y, z):

	intList = [x, y, z]
	month = 0
	day = 0 
	year = 0
	n = x

	#iterate over each int
	for n in intList:
		if isMonth(n) == True and month == 0:
			month = n
			n = y
		elif isMonth(n) == False and month != 0 and n != day and n != year:
			text = "Ambiguous"
			print text
			return text

		if isDay(month, n) == True and day == 0:
			day = n
			n = z
		elif isDay(month,n) == False and n != day and n != month and n!= year:
			text = "Ambiguous"
			print text
			return text

		if isValidYear(month, day, n) == True:
			year = n
		elif isValidYear(month, day, n) == False and n != year and  n != month and n != day:
			text = "Ambiguous"
			print text
			return text

	thisList = formatAnswer(month, day, year)
	print thisList[0] + "/" + thisList[1] + "/" + thisList[2]

#answer (4,31,14) #4/14/31 or 4/14/31 so Ambiguous
#answer (2,3,14) #Ambiguous OK
#answer (1, 23, 14) #1/23/14 or 1/14/23 so Ambiguous OK
#answer (2, 13, 14) #2/13/14 outputs 2/13/0 PLS FIX should be Ambiguous OK
#answer (4, 4, 14) #4/4/14 or 4/14/4 so ambiguous OK
#answer (14, 12, 30) # 12/14/30 or 12/30/14 so ambiguous OK
#answer (12, 5, 34) #should be ambiguous OK
#answer (13,45,5) #should be 5/13/45 OK
answer (19,19,3)
#answer (2, 30, 3)
#answer (3,19,19)


