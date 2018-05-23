#!/usr/bin/python
import time
import datetime

from pip._vendor.distlib.compat import raw_input

raw_input("\n\nPress the  enter key to exit.")

a,b,c = 1,2,"john"
print(a)
print(b)
print(c)

localtime = time.localtime(time.time())
print("Local current time :", localtime)

localtime = time.asctime( time.localtime(time.time()) )
print("Local current time :", localtime)

d= "2018-12-02"
print(datetime.date)

def printme( str ):
    "This prints a passed string into this function"
    print (str)
    return

# Now you can call printme function
printme("I'm first call to user defined function!")
printme("Again second call to the same function")



#!/usr/bin/python

# Function definition is here
def changeme( mylist ):
    "This changes a passed list into this function"
    mylist.append([1,2,3,4])
    print ("Values inside the function: ", mylist)
    return

# Now you can call changeme function
mylist = [10,20,30];
changeme( mylist );
print ("Values outside the function: ", mylist)


# Function definition is here
# def changeme( mylist ):
#     "This changes a passed list into this function"
#     mylist = [1,2,3,4]; # This would assig new reference in mylist
#     print ("Values inside the function2: ", mylist)[1, 2, 3, 4]
#     return
#
# # Now you can call changeme function
# mylist = [10,20,30];
# changeme( mylist );
# print ("Values outside the function2: ", mylist) [10, 20, 30]

# Therefore, in order to assign a value to a global variable within a function, you must first use the global statement.
Money = 2000
def AddMoney():
    # Uncomment the following line to fix the code:
     global Money
     Money = Money + 1

print (Money)
AddMoney()
print (Money)
