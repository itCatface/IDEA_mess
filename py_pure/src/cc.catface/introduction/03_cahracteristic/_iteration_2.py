from collections import Iterable


print(isinstance('abc', Iterable))                  # True
print(isinstance([1, 2, 3], Iterable))              # True
print(isinstance({'name': 'catface'}, Iterable))    # True
print(isinstance(123, Iterable))                    # False

l = [1, 'a', True, None]
d = {'a': 1, 'b': 2, 'c': 3}
for v in l:
    print(v)
for key in d:
    print(key, d[key])                              # a 1 ...
for value in d.values():
    print(value)                                    # 1 ...
for s in 'abcd':
    print(s)                                        # a ...


# 类似java的索引和值
str = 'abcd'
for i, value in enumerate(str):
    print(i, value)                                 # 0 a ...

for index, key in enumerate(d):
    print(index, key)                               # 0 a ...
    print(key, d[key])                              # a 1 ...


# 同时引用两个变量
for i, value in [(1, 1), (2, 2), (3, 3)]:
    print(i, value)                                 # 1 1 ...
