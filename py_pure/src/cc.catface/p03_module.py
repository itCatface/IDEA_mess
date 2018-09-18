# import p02_

from p02_ import add

print(add(2, 3, 7))

globalNum = 3

def test01():
    globalNum = 5
    print(globalNum)

test01()
print(globalNum)

file = open("girl01.jpg", "r")
print(file.name, file.closed, file.mode)


import os

# os.mkdir('newDir')
os.chdir('newDir')

print(os.getcwd())

os.rmdir('a')

from learn import Student

s = Student('ll', 20, 'male')
print(s._sex)
print(s.__sex)
