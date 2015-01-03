def answer(x, y, z):
    # your code here
    intList = [x, y, z]
    intList.sort()

    if (isValidMonth(intList[0]) and isValidDay(intList[0], intList[1]) and isValidYear(intList[0], intList[1], intList[2])):
        month = intList[0]
        day = intList[1]
        year = intList[2]
    else:
        text = "Ambiguous"
        print text
        return text

    thisList = formatAnswer(month, day, year)
    text = thisList[0] + "/" + thisList[1] + "/" + thisList[2]
    print text
    return text

def isValidMonth(n):
    if n <= 12:
        return True
    else:
        return False

def isValidDay(month, n, year):
    if n <= 31:

        if n == month or n == year:
            return True
        
        if n <= 12:
            return False

		#check if n is a valid day for the given month
        if month == 2 and n > 28:
            return False
        elif month in {4, 6, 9, 11}:
            if n > 30:
                return False
        else:
            return True
    else:
        return False

def isValidYear(month, day, n):

    if n <= 99:
        
        if n == day or n == month:
            return True 

        #check if n is a valid year for the given month
        if month in {1, 3, 5, 7, 8, 10, 12}:
            if n > 31:
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
    else:
        return False

#format answer to match MM/DD/YY form
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
