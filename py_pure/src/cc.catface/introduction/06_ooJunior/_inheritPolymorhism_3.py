### 继承和多态


class Animal(object):

    def run(self):
        print('Animal is running...')


class Dog(Animal):
    def run(self):
        print('dog is running...')


class Cat(Animal):
    def run(self):
        print('cat is running...')


a = Animal()
d = Dog()
c = Cat()
d.run()
c.run()


# 多态
def run_open(animal):
    animal.run()
    animal.run()


run_open(a)
run_open(d)
run_open(c)


class Timer(object):
    def run(self):
        print('start running...')
