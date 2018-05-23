#!/usr/bin/python


from pip._vendor.distlib.compat import raw_input

import MySQLdb

#take input from the user
startDate = raw_input("Enter the backup start date: ")
print("Received input is : ", startDate)

endDate = raw_input("Enter the backup end date: ")
print("Received input is : ", endDate)




#write to the file
file_name="test.csv"
try:
    file = open(file_name,"w+")
    try:
        file.write("Python is a great language.\nYeah its great!!\n")
    finally:
        print("Written content in the file successfully")
        file.close()
except IOError:
    print("Unable to write to the file")







