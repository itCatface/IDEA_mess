
import time

counter = 100  # 整型变量
miles = 100.0  # 浮点型变量
name = "catface"  # 字符串

print(counter, miles, name)

# 标准数据类型:
# 1. Number -> 1. int 2. float 3. bool 4. complex(复数)

# 查变量的类型
# type(x): <class 'int'> [不认为子类是父类类型]
# isinstance(x, int): True


# 2. String
#
#
#
#  List Tuple Sets Dictionary
'''
ddfsdf
sdfa
'''
"""
sadfdas
"""


print(r"\a")
str1 = 'qwer'
print(str1.capitalize())
print(str1.swapcase())
print(str1.zfill(5))

gg = ('adf', 23, 232, 'sa')
print(gg.__len__())


a, b = 0, 1
while b  < 10:

    # end 可以将结果输出到同一行
    print(b)
    a, b = b, a + b

    # 该实例演示了数字猜谜游戏
# number = 7
# guess = -1
# print("数字猜谜游戏!")
# while guess != number:
#     guess = int(input("请输入你猜的数字："))
#
#     if guess == number:
#         print("恭喜，你猜对了！")
#     elif guess < number:
#         print("猜的数字小了...")
#     elif guess > number:
#         print("猜的数字大了...")
#     else:
#         break

# import random


for letter in 'Runoob':
    if letter == 'o':
        pass
        print ('执行 pass 块')
    print ('当前字母 :', letter)

print ("Good bye!")


list=[1,3,5,2,4]
for x in list:
    print (x)
    break
# it = list.__iter__():


ticks = time.time()
print("time stamp is: ", ticks)

ticks = time.localtime(ticks)
print(ticks)

ticks = time.asctime(ticks)
print(ticks)

import calendar

cal = calendar.month(2017, 9)
print(cal)

print(time.clock())

print(time.timezone)

print(time.tzname)

def printName(str):
    print(str)
    return

printName("wangyehan")


def add(*nums):
    sum=0
    for x in nums:
        sum += x
    return sum

def sum(a, b):
    return a + b

printName(sum(1, 4))

print(add(1, 2, 3, 4))