class Animal(object):
    pass


animal = Animal()
# 1. 给实例绑定属性
animal.name = 'lele'
print('animal.name:', animal.name)


# 2. 给实例绑定方法[对其他实例无作用]
def set_age(self, age):
    self.age = age


from types import MethodType

animal.set_age = MethodType(set_age, animal)

animal.set_age(17)
print('animal.age is:', animal.age)


# 3. 给class绑定方法
def set_name(self, name):
    self.name = name


Animal.set_name = set_name

d = Animal()
d.set_name('ashy')
print('d.name is:', d.name)


### 使用__slots__[限制实例的属性]
class Student(object):
    __slots__ = ('name', 'score')


s1 = Student()
s1.name = 'james'
s1.score = 100

# 以下为AttributeError
s1.sex = 'male'


def set_sex(self, sex):
    self.sex = sex


Student.set_sex = set_sex

s1.set_sex('girl')
print('s1.sex:', s1.sex)
