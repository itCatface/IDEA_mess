# 输入和输出
s = input('请输入：')
print('你输入的文本是：', s)  # ,在打印时会用空格代替

# 数据类型
a = 1
b = 1.11
b1 = 0xfff
b2 = 1.2e-5
c = 'I\'m \"OK\"!'
c1 = r'I\'m \"OK\"!'  # r'xxx': 内部的字符串(xxx)默认不转义
d = '''
11
22
qq
ww
'''
e1 = 3 > 5
e2 = 4 > 1
e3 = e1 and e2
e4 = e1 or e2
e5 = not e1
f = None  # 空值,不能理解为0

print(a, b, b1, b2, c, c1, d, e1, e2, e3, e4, e5, f)

# 变量和常量[一般全大写,可修改,纯靠自觉]
a = 'abc'
b = a
a = 'xyz'
print('a, b: ', a, b)

PI = 3.1415926
print(PI)

# 简单运算
print(10 / 3)
print(10 // 3)
print(10 % 3)

# Python对整数和浮点数无大小限制[但超过一定范围就直接表示为无限大(inf)]
