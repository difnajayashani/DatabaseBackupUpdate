#!/usr/bin/python


from pip._vendor.distlib.compat import raw_input

str = raw_input("Enter your input: ");
print("Received input is : ", str)

file_name="test.csv"
try:
    file = open(file_name,"w+")
    try:
        file.write( "Python is a great language.\nYeah its great!!\n")
    finally:
        print("Written content in the file successfully")
        file.close()
except IOError:
    print("Unable to write to the file")




