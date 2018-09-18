print("Hello, World!");

if True:
    print("true")
    print("ss")
else:
    print("false")

# 同一行显示多条语句
import sys; x = 'runoob'; sys.stdout.write(x + '\n')

# print输出
x1 = 'a'
y1 = 'b'

# 换行输出
print(x1)
print(y1)

print('------')

# 不换行输出
print(x1, end="")
print(y1, end="")

# 导入sys模块
import sys
print("命令行参数为")
for i in sys.argv:
    print(i)
print('\n python 路径为', sys.path)


# 导入sys模块的argv，path成员
from sys import argv,path
print('path:',path)

# 等待用户输入
input("\n\n按下 enter键后退出")