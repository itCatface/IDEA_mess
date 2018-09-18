### 多重继承
### 定制类
## 1. __slots__


## 2. __str__
class Animal(object):

    def __init__(self, name):
        self._name = name

    def __str__(self):
        return 'name is: %s' % self._name

    __repr__ = __str__


a = Animal('ashy')
print(a)
print(a.__str__())


## 3. __iter__
class Fib(object):

    def __init__(self):
        self.a, self.b = 0, 1

    def __iter__(self):
        return self

    def __next__(self):
        self.a, self.b = self.b, self.a + self.b
        if self.a > 1000:
            raise StopIteration()
        return self.a


for n in Fib():
    print(n)


## 4. __getitem__
class Fib2(object):

    # def __init__(self):
    #     self.a, self.b = 0, 1
    #
    # def __iter__(self):
    #     return self
    #
    # def __next__(self):
    #     self.a, self.b = self.b, self.a + self.b
    #     if self.a > 1000:
    #         raise StopIteration()
    #     return self.a

    def __getitem__(self, n):
        a, b = 1, 1
        for x in range(n):
            a, b = b, a + b
        return a


f = Fib2()
print(f[100])


## 5. __getattr__


## 6. __call__[直接对实例进行调用]


## 6.1 callable()[判断一个变量是函数还是对象]
