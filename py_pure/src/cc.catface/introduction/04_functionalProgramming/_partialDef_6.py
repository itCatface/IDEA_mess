import functools  # 固定函数的部分参数

# int2函数默认为转换二进制数字
int2 = functools.partial(int, base=2)

print(int2('100110101'))

max2 = functools.partial(max, 19)  # 将19作为*args的一部分自动加到左边

print(max2(2, 6, 0, 20))
print(max2(2, 1, 4))

##############################################################
print('-------------------------\r\n')
print(int('1234'))
print(int('111', base=2))

import functools

int = functools.partial(int, base=2)

print(int('111'))  # 相当于如下

kw = {'base': 10}
print(int('110', **kw))
