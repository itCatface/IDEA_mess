# 1. 读文件

# encoding 为字符编码
# error 为遇到非法编码的字符，最简单操作的是直接忽略
# 使用with语句后系统会自动帮我们调用close()方法
with open('../../newDir/test.txt', 'r', encoding='utf-8', errors='ignore') as f:
    print(f.read())

print('-----------------')

with open('../../newDir/test.txt', 'r', encoding='utf-8') as f:
    # 每次最多读size个字节的内容
    print(f.read(5))

print('-----------------')

with open('../../newDir/test.txt', 'r', encoding='utf-8') as f:
    for line in f.readlines():
        # strip()删掉末尾的\n
        print(line.strip())

print('-----------------')

with open('../../newDir/test.txt', 'r', encoding='utf-8') as f:
    print(f.readline())

# 2. 读取二进制文件rb[图片、视频etc. 使用rb打开]
with open('../../newDir/1.png', 'rb') as f:
    print('读取二进制文件rb:', f.read())

# 3. 写文件[w-->写文件(覆盖) || a-->在文件末尾追加内容]
import time

# with open('../../newDir/testA.txt', 'w', encoding='utf-8') as f:
with open('../../newDir/testA.txt', 'a', encoding='utf-8') as f:
    f.write('测试test: %s%s' % (time.time(), '\r\n'))

###
print('---------------------\r\n')
with open('d:\\t\\l.jpg', 'rb') as f:
    print('读取二进制文件rb:', f.read())

###
with open('d:\\catface\\java\\py\\src\\cc.catface\\introduction\\cainiao\\python_100_examples.py', 'a', encoding='utf-8') as f:
    for i in range(96, 101):
        f.write('### %s. \r' % i)
        f.write('def ex%s():\r\n' % i)
        f.write('    pass\r\n')
