#### A -> map(f, Iterable): 接收两个参数[函数和Iterable]，map将传入的函数依次作用到序列的每个元素，并将结果作为新的Iterator[对应传入的Iterable]返回


l = [1, 3, 5, 7, 9]


# f(x) = x^2
def f(x):
    return x * x


r = map(f, [1, 3, 5, 7, 9])
print('r is:', r)
print('list(r) is:', list(r))


# 把list所有数字转为字符串
r = map(str, (1, 3, 5, 7, 9))
print(list(r))


from functools import reduce


### B -> reduce: reduce(f, [x1, x2, x3, x4]) = f(f(f(x1, x2), x3), x4)
def fn(x, y):
    return x + y


r = reduce(fn, [1, 3, 5, 7, 9])
print(r)


# 将英文名首字母变为大写
def practice(name):
    return name.lower().capitalize()


r = list(map(practice, ['Asdf', 'qwer', 'zxcv']))
print(r)


# --求和
def sum(x, y):
    return x + y


r = reduce(sum, l)
print('list:', l, ' 的和为：', r)


# --把[1, 3, 5, 7, 9]变换成13579
def fn(x, y):
    return x * 10 + y


r = reduce(fn, l)
print('list:', l, ' 的变换结果为：', r)


# --求积
def prod(x, y):
    return x * y


r = reduce(prod, l)
print('list:', l, ' 的积为：', r)


# --将名字的首字母变为大写，其余变为小写
names = ['zhanGSan', 'LIsI', 'AsHY', 'ivErSOn']


def change_name(name):
    if isinstance(name, str):
        return name[0].upper() + name[1:].lower()
    else:
        return ''


r = map(change_name, names)
print('names:', names, '格式化后结果为：', list(r))


# --使用map和reduce实现字符串转数字
DIGITS = {'1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9, '0': 0}


def char2num(s):
    return DIGITS[s]


def str2int(s):
    return reduce(lambda x, y: x * 10 + y, map(char2num, s))


print('字符串转数字：', str2int('13579'))


# 使用map和reduce实现字符串转浮点数

