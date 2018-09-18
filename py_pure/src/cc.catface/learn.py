#!/usr/bin/env python3
# -*- coding: utf-8 -*-

__author__ = 'catface'


# print("你好", "世界")



# import wx
# app = wx.

def abs_t(x):
    if x < 0:
        return -x
    else:
        return x


# print(abs_t(-1))
#
# print(abs(-9))
# print(abs)
#
# # 函数式编程
# f = abs
# print(f(-10))


def count():
    fs = []
    for i in range(1, 4):
        def f():
            return i * i

        fs.append(f)
    return fs


f1, f2, f3 = count()

# print(f1())


# import Student

# s1 = Student('zhangsan', 27)
# s2 = Student('lisi', 31)

import logging

# logging的级别
logging.basicConfig(level=logging.INFO)


def exc_01():
    # raise Exception('xxx')主动抛异常

    try:
        print("try...")
        r = 3 / 0
        print(r)
        logging.info('n = %f' % r)

    except ZeroDivisionError as e:
        print(e)

    # except ...

    # 没有错误发生时会执行
    else:
        print('no error')

    finally:
        print("finally")

    print("end")


# exc_01()



def file_1():
    try:
        file = open('./newDir/test.txt', 'r', encoding='UTF-8')
        print(file.read())

        for line in file.readlines():
            print(line.strip())

    finally:
        if file:
            file.close()


def file_2():
    with open('d:/pjs/common/javaT/python/newDir/test.txt', 'r', encoding='UTF-8') as file1:
        print(file1.read())


def file_3():
    file = open('./newDir/girl.jpg', 'rb')
    print(file.read())


def file_4():
    with open('./newDir/test.txt', 'w', encoding='UTF-8') as file:
        file.write("你好啊hello")


from io import StringIO


def stringio_1():
    str = StringIO()
    str.write('hi')
    str.write('你好')
    print(str.getvalue())


from io import BytesIO


def byteio_1():
    f = BytesIO()
    f.write('你好'.encode('utf-8'))
    f.write('hi'.encode('utf-8'))
    print(f.getvalue())


import os


def filedir_1():
    print(os.name + '\n-----')
    print(os.path.abspath('.'))

    os.path.join('./newDir', 'testDir')
    # os.mkdir('./newDir/testDir')
    os.rmdir('./newDir/testDir')


def filedir_2():
    y = [x for x in os.listdir('.') if os.path.isdir(x)]
    print(y)


import pickle


def pickling_1():
    f = open('./newDir/test.txt', 'wb')
    d = dict(name='wang', age=27, score=-1)
    pickle.dump(d, f)
    f.close()


def unpickling_2():
    f = open('./newDir/test.txt', 'rb')
    d = pickle.load(f)
    f.close()
    print(d)


def thread_1():
    print('process id is %s' % os.getpid())
    # windows 不支持fork()
    # pid = os.fork()
    # print(pid)


from multiprocessing import Process


def thread_2(name):
    print('process %s: %s' % (name, os.getpid()))


from PIL import Image


def pil_01():
    img = Image.open('./newDir/girl.jpg')
    w, h = img.size
    print(w, h)


from tkinter import *


class App(Frame):
    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.pack()
        self.createWidget()

    def createWidget(self):
        self.helloLabel = Label(self, text='Hello, world!')
        self.helloLabel.pack()
        self.quitButton = Button(self, text='Quit', command=self.quit)
        self.quitButton.pack()


def gui_1():
    app = App()
    app.master.title('你好hi')
    app.mainloop()


import tkinter.messagebox as messagebox


class App1(Frame):
    def __init__(self, master=None):
        Frame.__init__(self, master)
        self.pack()
        self.createWidget()

    def createWidget(self):
        self.nameInput = Entry(self)
        self.nameInput.pack()
        self.alertButton = Button(self, text='hi', command=self.hello)
        self.alertButton.pack()

    def hello(self):
        name = self.nameInput.get() or 'world'
        messagebox.showinfo('Msg', '--%s' % name)


def gui_2():
    app = App1()
    app.master.title('Hi')
    app.mainloop()


gui_2()


# 第一天
# print()输出函数
# input()输入函数
def _1_hello_world():
    print('hello world')  # hello world


def _2_hellow_word():
    # print()接受多个字符串并使用','隔开，输出时遇到逗号就会用空格代替
    # print()可打印整数、布尔等
    print('hello', 'world', 11, 0xff, True)  # hello world 11 255 True


def _3_hellow():
    # input()搜集用户输入并可添加提示字符串
    name = input('plz enter your name: ')

    # print()正常输出，还记得遇到逗号就会用空格代替吧
    print('hello ', name)  # hello  wyh
    # print()还可像C语言一样使用占位符
    print('hello %s' % name)  # hello wyh


# 练习：输出a * b = result
def p_4():
    a = input('a:')
    b = input('b:')
    # input()获取的值是str类型，运算的话需要转型的
    print(a, '*', b, '=', int(a) * int(b))  # 3 * 5 = 15


# 第二天
# 2.1 数据类型
def _5_date_type():
    # 1. 整数
    a = 3
    # 2. 浮点数
    b = 3.15
    # 3. 字符串，注意特殊字符需转义
    c = 'i\'m catface'
    # 多行字符串可用'''或者"""包裹
    d = '''你
    还
    好
    吗'''
    # 4. 布尔
    e = True
    f = 1 > 2
    # 5. 空
    g = None
    print(a, b, c, d, e, f, g)  # 3 3.15 i'm catface 你
    # 还
    # 好
    # 吗 True False None

    # isinstance()判断类型
    print(isinstance(1, int))  # True
    print(isinstance(1, str))  # False


# 布尔计算：1. and 2. or 3. not
def _6_bool_calc():
    a = 5 > 2
    b = 6 > 8
    print(a and b, a or b, not b)  # False True True


# 2.2 变量
# 同一变量可反复赋值且可以是不同类型的变量
def _7_variable():
    x = 7
    print(x, 'type is', type(x))  # 7 type is <class 'int'>
    x = '7'
    print(x, 'type is', type(x))  # 7 type is <class 'str'>

    # x指向的字符串复制了一份，且被y指向了
    y = x
    y = '8'
    print('y is:', y, 'x is:', x)  # y is: 8 x is: 7
    return


# 2.3 常量
def _8_const():
    # python中常量使用大写命名，但你非要修改，那也是可以的
    PI = 3.15159265354
    print('PI is:', PI)  # PI is: 3.15159265354


# 2.4 字符串和编码
def _9_str():
    # 字符串的格式化输出：类似C的占位符
    print('name is %s, age is %d, weight is %f, test is %x' % (
    'zhangsan', 18, 57.46, 0xff))  # name is zhangsan, age is 18, weight is 57.460000, test is ff
    print('name is %s, age is %3d, weight is %.1f, test is %x' % (
    'zhangsan', 18, 57.46, 0xff))  # name is zhangsan, age is  18, weight is 57.5, test is ff
    print('name is %s, age is %03d, weight is %.1f, test is %x' % (
    'zhangsan', 18, 57.46, 0xff))  # name is zhangsan, age is 018, weight is 57.5, test is ff

    # 字符串方法
    # 1. find()第一次索引，无则-1
    str = 'aa bb vv bb'
    print(str.find('bb'))  # 3
    print(str.find('dd'))  # -1

    # 2. join()和split()互为反函数???

    # 3. lower()小写

    # 4. replace()替换子串

    # 5. split()分割并返回子串list


    # 6. strip()去除两侧空格

    # 7. translate()


# 练习
def _10_practice():
    producet_list = [('iphone', 5888), ('mac', 13000), ('xiaomi', 2000), ('kotlin', 30)]

    for item in enumerate(producet_list):
        index = item[0]
        name = item[1][0]
        price = item[1][1]

        print(index, name, price)


_10_practice()


# 2.5 list和tuple
def _10_list():
    # list是可变、有序集合，且元素不必是同一类型，可随时添加和删除元素
    info = ['zhangsan', 'lisi', 19, 57.46, True, None]
    print(info)  # ['zhangsan', 'lisi', 19, 57.46, True, None]

    print(info[4])  # True
    # 最后一个索引可用-1表示
    print(info[-2])  # True

    print(len(info))  # 6

    info.append('extra')
    print(info)  # ['zhangsan', 'lisi', 19, 57.46, True, None, 'extra']

    # 在指定索引处插入元素
    info.insert(1, 'add to index 1')  # ['zhangsan', 'add to index 1', 'lisi', 19, 57.46, True, None, 'extra']
    print(info)

    # 删除最后一个元素
    print(info.pop())
    print(info)  # ['zhangsan', 'add to index 1', 'lisi', 19, 57.46, True, None]

    # 删除指定位置的元素
    # pop()删除并返回该元素值
    info.pop(1)  # extra
    print(info)  # ['zhangsan', 'lisi', 19, 57.46, True, None]

    # 修改指定索引的值
    info[0] = 'first blood'
    print(info)  # ['first blood', 'lisi', 19, 57.46, True, None]

    # 多维list
    info.insert(-1, [3, 2, 'str1'])
    print(info)  # ['first blood', 'lisi', 19, 57.46, True, [3, 2, 'str1'], None]
    print(len(info))  # 7

    # 同上删除元素
    del info[3]
    print(info)  # ['first blood', 'lisi', 19, True, [3, 2, 'str1'], None]

    # 序列可相加
    print([1, 2, 4] + [3, 6, 9])  # [1, 2, 4, 3, 6, 9]

    # 乘法
    print([1, 3, 4] * 2)  # [1, 3, 4, 1, 3, 4]
    print('hehe' * 3)  # hehehehehehe

    # len()、min()、max()
    nums = [1, 3, 4, 2, 6, 5]
    print('len: %s, min: %s, max: %s' % (len(nums), min(nums), max(nums)))  # len: 6, min: 1, max: 6

    # python基础教程补充
    # 1. append()在列表末尾追加元素
    # 2. count()统计某个元素出现次数
    # 3. extend()追加新列表
    # 4. index()第一个匹配元素的索引
    # 5. insert()插入元素到指定索引
    # 6. pop()移除并返回该元素
    # 7. remove()移除列表中第一个匹配的元素
    # 8. reverse(): void逆序列表()
    # 9. reversed(): iterator
    # 10. sort()排序覆盖原列表并返回
    # 11. 高级排序key&reverse
    l = ['jobs', 'catface', 'ash']
    l.sort()
    print(l)  # ['ash', 'catface', 'jobs']
    l.sort(key=len)
    print(l)  # ['ash', 'jobs', 'catface']
    l.sort(reverse=True)
    print(l)  # ['jobs', 'catface', 'ash']


def _11_tuple():
    # tuple是不可变的list，没有append、insert、info[index] = -1等修改操作
    info = ('zhangsan', 'lisi', 19, 57.46, True, None)
    print(info)  # ('zhangsan', 'lisi', 19, 57.46, True, None)

    # 空tuple
    empty = ()
    print(empty)  # ()

    # 只有一个元素的tuple，需要加个逗号，不然还以为是括号操作呢
    one_1 = (1)
    one_2 = (1,)
    print(one_1, '::', one_2)  # 1 :: (1,)

    # 注意下面是可变tuple，但是实际开发中尽量避免
    values = (1, 2, [3, 4, 5], 6)
    print(values)  # (1, 2, [3, 4, 5], 6)
    values[-2][1] = 99
    print(values)  # (1, 2, [3, 99, 5], 6)
    # tuple的第三个元素是个list，但是list指向的


# 2.6 条件判断
def _12_if(age):
    # 赋值方式 --> 序列解包
    x, y = 1, 3
    print('x: %d, y: %d' % (x, y))  # x: 1, y: 3
    # 交换x，y
    x, y = y, x
    print('x: %d, y: %d' % (x, y))  # x: 3, y: 1

    # 赋值方式 --> 链式赋值
    c = d = e = 1
    print('c: %d, d: %d, e: %d' % (c, d, e))  # c: 1, d: 1, e: 1

    # 布尔False可用如下表示 --> False, None, 0, "", (), [], {}

    # if语句可用if ... elif ... elif ... else表达
    # 注意嵌套if

    # 比较运算符 --> ==, >=, <=, >, <, !=, is | is not(是不是同一个对象) in | not in(是成员)



    age = int(age)
    if age < 27:
        print('你比我小')
    elif age < 50:
        print('阿姨你好')
    else:
        print('大伯您好')


# 联系：计算BMI(体重除以身高的平方)
def p_13():
    weight = input('enter your weight:')
    height = input('enter your height:')

    bmi = float(weight) / float(height) / float(height)

    if bmi < 18.5:
        print('过轻')
    elif bmi < 25:
        print('正常')
    else:
        print('过胖')


# 2.7 循环
def _14_for():
    nums = (1, 2, 3, 4, 5)
    sum = 0
    for x in nums:
        sum += x
    print(sum)  # 15

    nums2 = list(range(10))
    print(nums2)  # [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]


def _15_while():
    sum = 0
    num = 100
    while num > 0:
        sum += num
        num -= 1
    print(sum)  # 5050


# 练习：循环打印['zhangsan', ...]
def p_16():
    names = ['zhangsan', 'lisi', 'wanger', 'mazi']
    for name in names:
        print('hi:', name)


def _17_break():
    n = 0
    while n < 5:
        n += 1
        if n > 3:
            # break可退出循环
            break
        print(n)  # 1 2 3


def _18_continue():
    n = 0
    while n < 6:
        n += 1
        if n % 2 == 0:
            # continue结束本次循环并开始下一轮循环，通常配合if使用
            continue
        print(n)  # 1 3 5


# 2.8 dict和set
# dict的key必须是不可变对象(list就是可变对象)
# dict：查找、插入快但是占用内存很大[空间换时间]
def _19_dict():
    info = {'zhangsan': 99, 'lisi': 88, 'wanger': 77}
    print(info)  # {'zhangsan': 99, 'lisi': 88, 'wanger': 77}
    print(info['zhangsan'])  # 99

    # 没有key则创建key
    info['mazi'] = 66
    print(info)  # {'zhangsan': 99, 'lisi': 88, 'wanger': 77, 'mazi': 66}

    # key已存在则冲掉之前的值
    info['mazi'] = 100
    print(info)  # {'zhangsan': 99, 'lisi': 88, 'wanger': 77, 'mazi': 100}

    # 判断dict中是否存在指定的key
    print(('tt' in info))  # False

    # key不存在返回None
    score = info.get('zhang')
    print(score)  # None

    # key不存在返回-1
    score = info.get('zhangsan', -1)
    print(score)  # 99 如果该key不存在则返回-1

    # 删除指定key-value对
    info.pop('mazi')
    print(info)  # {'zhangsan': 99, 'lisi': 88, 'wanger': 77}

    # python基础教程补充
    # 1. clear() --> {}


    # 2. copy() --> 得到dict副本

    # 3. fromkeys()
    d = {}.fromkeys(['name', 'age'])
    print(d)  # {'name': None, 'age': None}

    # 4. get(key, defaultValue)

    # 5. has_key() --> 是否含有该键

    # 6. items --> 以列表方式返回{(k1, v1), (k2, v2)...}

    # 7. iteritems() --> iterator

    # 8. keys() & iterkeys()

    # 9. pop(key)

    # 10. popitem() --> 弹出随机键值

    # 11. setdefault() --> 类似get，但可在dict无该key时添加该k-v

    # 12. update() --> 将新dict添加至旧dicr，若有相同key则覆盖

    # 13. values --> 以列表形式返回所有值 & itervalues()


# set
# key不重复，需要提供一个list作为输入集合
def _20_set():
    names = ['zhangsan', 1, 2, 'lisi', 1]
    s = set(names)
    print(s)  # {1, 2, 'lisi', 'zhangsan'}

    # add()添加元素，且重复添加无效果
    s.add('wanger')
    # 重复添加不会有效果
    s.add('wanger')
    print(s)  # {1, 2, 'zhangsan', 'lisi', 'wanger'}

    s.remove('wanger')
    print(s)  # {1, 2, 'lisi', 'zhangsan'}


# set和数学上的集合类似
def _21_set():
    s1 = set([1, 2, 3, 4, 5])
    s2 = set([2, 3, 4, 5, 6])
    print(s1 & s2)  # {2, 3, 4, 5}
    print(s1 | s2)  # {1, 2, 3, 4, 5, 6}
    print(s1 ^ s2)  # {1, 6}


def _22_sort():
    chars = ['b', 'd', 'a', 'c']
    chars.sort()
    print(chars)  # ['a', 'b', 'c', 'd']

    str = 'abc'
    # replace()创建了一个新字符串'Abc'并返回
    print(str.replace('a', 'D'))  # Dbc
    print(str)  # abc


def _23_def():
    # abs()求绝对值
    print(abs(-100))  # 100

    print(max(-1, 1, 3, 2))  # 3

    print(hex(255), hex(1000))  # 0xff 0x3e8


# python的返回多值其实是一个tuple
def _24_def(x, y):
    return x - y, x + y  # (-1, 3)


# 联系：求一元二次方程的两个根
import math


def p_25(a, b, c):
    z = b ^ 2 - 4 * a * c
    if z == 0:
        return (-b) / (2 * a)
    elif z > 0:
        r1 = (-b + math.sqrt(z)) / (2 * a)
        r2 = (-b - math.sqrt(z)) / (2 * a)
        return r1, r2
    else:
        return


# 函数的参数
# 默认参数在后
# 默认参数必须指向不变对象
def _26_def(x, n=2):
    result = 1
    while n > 0:
        result *= x
        n -= 1
    return result


def _27_def(name, age, city='合肥', sex='girl'):
    print('name:', name, 'age:', age, 'city:', city, 'sex:', sex)

    # _27_def('zhangsan', 27, sex = 'boy')      # name: zhangsan age: 27 city: 合肥 sex: boy


# 可变参数
# 可变参数会将list或tuple的元素变成可变参数->func(*(1, 2, 3))
# 会自动组装成一个tuple
def _28_def(*nums):
    sum = 0
    for i in nums:
        sum += i
    return sum

    # print(_28_def(1, 2, 3))       # 6
    # print(_28_def(*[2, 3, 4]))    # 9
    # print(_28_def(*(3, 4, 5)))    # 12


# 关键字参数
# 会自动组装成dict->func(**{'1':1, '2':2, '3':3})
def _29_def(name, age, **kv):
    print('name:', name, 'age:', age, 'kv:', kv)

    # _29_def('zhangsan', 18)                           # name: zhangsan age: 18 kv: {}

    # _29_def('lisi', 19, city='hefei', xex='male')     # name: lisi age: 19 kv: {'city': 'hefei', 'xex': 'male'}
    # extra = {'city': 'demaxiya', 'job': 'adc'}
    # _29_def('wanger', 20, **extra)                     # name: wanger age: 20 kv: {'city': 'demaxiya', 'job': 'adc'}


# 限制关键字参数
# *, 后面的参数是必须要传的
def _30_def(name, age, *, city='hefei', sex):
    print('name:', name, 'age:', age, 'city:', city, 'sex;', sex)

    # _30_def('zhangsan', 24, sex='girl')                   # name: zhangsan age: 24 city: hefei sex; girl
    # _30_def('zhangsan', 24, city='china', sex='girl')     # name: zhangsan age: 24 city: china sex; girl


# 可变参数后跟着的命名关键字参数不再需要特殊分隔符*,了
def _31_def(name, age, *city, sex):
    print('name:', name, 'age:', age, 'city:', city, 'sex;', sex)

    # _31_def('zhangsan', 29, 2, 2, sex='girl')              # name: zhangsan age: 29 city: (2, 2) sex; girl


# 2.9 递归函数
# 阶乘
def _32_re_def(n):
    if n == 1:
        return 1
    return n * _32_re_def(n - 1)

    # print(_32_re_def(4))          # 6


# 幂
def _32(x, n):
    result = 1
    for i in range(n):
        result *= x
    return result

    # print(_32(3, 3))                # 27


# 高级特性
# 1. 切片->list | tuple
def _33_list_tuple():
    names = ['tom', 'bob', 'ivan', 'kin', 'catface']
    print(names[:])  # ['tom', 'bob', 'ivan', 'kin', 'catface']
    print(names[:3])  # ['tom', 'bob', 'ivan']
    print(names[1:3])  # ['bob', 'ivan']
    print(names[1:6])  # ['bob', 'ivan', 'kin', 'catface']

    print(names[-3])  # ivan
    print(names[-3:-1])  # ['ivan', 'kin']
    print(names[-3:0])  # []
    print(names[-3:])  # ['ivan', 'kin', 'catface']

    nums = list(range(7))
    print(nums)  # [0, 1, 2, 3, 4, 5, 6]
    print(nums[1::2])  # [1, 3, 5]
    print(nums[:5:2])  # [0, 2, 4]
    print(nums[::-2])  # [6, 4, 2, 0]
    print(nums[::2])  # [0, 2, 4, 6]

    # tuple和字符串操作是一样一样的
    str = 'abcdefg'
    print(str[-5:-1])  # cdef
    for char in str[:]:
        print(char)


# 2. 迭代
# 只要是可迭代对象就可以迭代，不管是否有下标如dict

# 实现了__iter__方法的对象是可迭代的
# 实现了next方法的对象是迭代器
def _34_for():
    d = {'name': 'catface', 'age': 27, 'sex': 'male'}
    for key in d:
        print(key, '-->', d[key])  # name --> catface ...


# 判断是否是可迭代对象
from collections import Iterable


def _35_for():
    print(isinstance('abc', Iterable))  # True
    print(isinstance([1, 2, 3], Iterable))  # True
    print(isinstance({'name': 'catface'}, Iterable))  # True
    print(isinstance(123, Iterable))  # False

    # 类似java的索引和值
    str = 'abcd'
    for i, value in enumerate(str):
        print(i, value)  # 0 a ...

    for i, value in [(1, 1), (2, 2), (3, 3)]:
        print(i, value)  # 1 1 ...


# 3. 列表生成式[List Comprehensions] --> 创建list的生成式
def _36_t():
    l = list(range(2, 9))
    print(l)  # [2, 3, 4, 5, 6, 7, 8]

    # 列表生成式：要生成的元素 + for (+ if)
    l = [x * x for x in range(1, 5)]
    print(l)  # [1, 4, 9, 16]

    l = [x * x for x in range(2, 6) if x % 2 == 0]
    print(l)  # [4, 16]

    # 两层循环生成成全排列
    l = [x + y for x in range(1, 4) for y in range(5, 11)]
    print(l)  # [6, 7, 8, 9, 10, 11, 7, 8, 9, 10, 11, 12, 8, 9, 10, 11, 12, 13]
    l = [x + y for x in 'abc' for y in 'xyz']
    print(l)  # ['ax', 'ay', 'az', 'bx', 'by', 'bz', 'cx', 'cy', 'cz']

    # 列举当前目录所有文件和目录名
    l = [d for d in os.listdir('../')]
    print(l)  # ['.idea', 'javaT.iml', 'lib', 'out', 'python', 'src']

    # 使用两个变量生成list
    l = [k + '=' + v for k, v in {'name': 'catface', 'age': '27', 'sex': 'male'}.items()]
    print(l)  # ['name=catface', 'age=27', 'sex=male']

    l = [x.lower() for x in ['Q', 'W', 'E', 'R', 'd', 'F']]
    print(l)  # ['q', 'w', 'e', 'r', 'd', 'f']

    #
    d = ['Hello', 'World', 18, 'Apple', None]
    l = [x.lower() for x in d if isinstance(x, str)]
    print(l)  # ['hello', 'world', 'apple']


# 4. 生成器：就是把列表生成式最外层[]换成() --> 创建generator：通过next()获得下一个返回值
def _37_t():
    l = (x for x in range(1, 5))
    for x in l:
        print(x)


# 若函数定义中包含关键字yield，则这个函数是一个generator*******************************
def _38_fibonacci(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b
        a, b = b, a + b
        n += 1
    return 'done'


# 迭代器：list、tuple、dict、set、str、generator等都是Iterable可迭代对象(可使用isinstance判断)，int不是
# 可被next()函数不断返回下一个值的对象是迭代器Iterator(可使用isinstance判断)
# 生成器都是Iterator对象，但list、dict、str虽然是Iterable，却不是Iterator
# 把list、dict、str等Iterable变成Iterator可以使用iter()函数

# 凡是可作用于for循环的对象都是Iterable类型
# 凡是可作用于next()函数的对象都是Iterator类型，它们表示一个惰性计算的序列(需要时才计算下一个数据)
# 集合数据类型如list、dict、str等是Iterable但不是Iterator，不过可以通过iter()函数获得一个Iterator对象


# PART
# 1. 高阶函数->传入函数
def _39(x, y, f):
    return f(x) + f(y)

    # 函数名也是变量名，现在f也是求绝对值函数了
    # f = abs
    # print(_39(-1, 2, f))            # 3


# 2. map() & reduce()
# map(函数, Iterable)************************************************************
def f(x):
    return x * x

    # r = map(f, [1, 2, 3, 4])
    # print(list(r))                        # [1, 4, 9, 16]


    # print(list(map(str, [1, 2, 3, 4])))   # ['1', '2', '3', '4']


# reduce(f, [x1, x2, x3, x4]) = f(f(f(x1, x2), x3), x4)

# 练习：利用map()函数，把用户输入的不规范的英文名字，变为首字母大写，其他小写的规范名字。输入：['adam', 'LISA', 'barT']，输出：['Adam', 'Lisa', 'Bart']


# 3. 匿名函数：lambda x: x * x 其中冒号前x是函数参数
# 匿名函数也可作返回值返回： return lambda: x * x + y * y
def _40():
    l = list(map(lambda x: x * x, [1, 2, 3, 4]))
    print(l)  # [1, 4, 9, 16]


# 4. 装饰器decorator
# 函数对象有__name__属性可看函数的名字
def _41():
    pass

    # print(_41.__name__)     # _41


import functools


def log(func):
    @functools.wraps(func)
    def wrapper(*args, **kv):
        print('call %s():' % func.__name__)
        return func(*args, **kv)

    return wrapper


# 等同于log(_42())
@log
def _42():
    print('_42...')  # call _42():
    # _42...


# 自定义log文本
def log1(text):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kv):
            print('%s %s():' % (text, func.__name__))
            return func(*args, **kv)

        return wrapper

    return decorator


@log1('heihei')
def _43():
    print('_43..')  # heihei _43():
    # _43..


# 5. 偏函数
# 使用functools.partial可以创建一个新的函数，这个新函数可以固定住原函数的部分参数，从而在调用时更简单
def _44():
    print(int('123456', base=8))  # 42798

    # 接收函数对象、*args和**kw这3个参数
    int2 = functools.partial(int, base=2)
    print(int2('1010101'))  # 85


# 使用模块
def _45():
    args = sys.argv
    print(args)  # ['D:/pjs/common/javaT/python/introduction.py']
    if len(args) == 1:
        print("1")  # 1
    elif len(args) == 2:
        print("2")
    else:
        print('3')

    # _或者__开头的变量或函数一般是非公开引用的哦，这是规范
    _private_num = 7
    print(_private_num)  # 7


# PART 面向对象编程
class Student(object):
    # 类属性
    id = 1

    def __init__(self, name, score, sex):
        # name, score, sex是实例属性
        self.name = name
        self.score = score

        # 添加_该属性不能在外部访问
        self._sex = sex

    def p(self):
        print('name: %s score: %s sex: %s' % (self.name, self.score, self._sex))


s = Student('catface', 12, 'male')

# print(s._sex)
# print(print(s._Student_sex))

# s.p()          # name: catface score: 12

# dir()列出对象的所有属性和方法
# print(dir(sys))
# print(dir('aa'))

# getattr()、setattr()以及hasattr()可对对象操作


# 枚举类
from enum import Enum

Month = Enum('Month', ('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'))


# for name, member in Month.__members__.items():
# print('name: %s value: %s' %(name, member))     # name: Jan value: Month.Jan ...


# PART IO
def _46_io_file():
    # with语句自动调用close()
    with open('./newDir/test.txt', 'r', encoding='utf-8') as file:
        print(file)

        # read()将文件全部内容读取到内存中
        # read(size)反复读防止内存溢出
        # readline()读取一行
        # readlines()读取所有内容并返回list[读配置文件比较方便]
        print(file.read())

        print(file.read(5))  # ??

        l = file.readline()
        print(l.__sizeof__())
        print(l)

        for line in file.readlines():
            print(line.strip())

    # rb读二进制文件
    with open('./newDir/girl.jpg', 'rb') as pic:
        print(pic.read())

    with open('./newDir/test.txt', 'w', encoding='utf-8') as file:
        file.write('hehe呵呵')


# chap14网络
from urllib import request


def _47():
    with request.urlopen('https://baidu.com') as f:
        data = f.read()
        print(data)


# http://python.jobbole.com/81332/

# TODO 常用内建模块
# 1. datetime
from datetime import datetime


def _48():
    now = datetime.now()
    print(now)

    print(datetime(2017, 10, 23, 12, 12, 55, 123457).timestamp())
    print(datetime.fromtimestamp(1508731975.123457))


_48()
