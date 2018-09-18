# -*- coding: utf-8 -*-
'''
Author:哈士奇说喵
UDate: 2016.7.21
'''
from tkinter import *
import difflib
import urllib  # python2.7才需要两个urllib
from urllib import request
import json

import requests

# ----------------------主框架部分----------------------

root = Tk()
root.title('翻译GUI&beta1')
root.geometry()
Label_root = Label(root)


# -----------------------定义规则------------------------

def translate(content):
    url = "http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule&smartresult=ugc&sessionFrom=null"
    data = {}  # 构造data，里面构造参数传入
    data['type'] = 'AUTO'
    data['i'] = content
    data['doctype'] = 'json'
    data['xmlVersion'] = '1.8'
    data['keyfrom'] = 'fanyi.web'
    data['ue'] = 'UTF-8'
    data['action'] = 'FY_BY_ENTER'
    data['typoResult'] = 'true'

    print(type(data))

    html = requests.post(url, data=json.dumps(data))
    print(html)

    # data = request.quote(data).encode('utf-8')  # 将构造的data编码
    # req = request.Request(url)  # 向浏览器发出请求
    # response = request.urlopen(req, data)   # 带参请求，返回执行结果
    # html = response.read().decode('utf-8')
    # print(html)  # 可以取消print的注释，查看其中效果，这边获取的结果是进行解析

    target = json.loads(html)  # 以json形式载入获取到的html字符串

    # print u"翻译的内容是："+target['translateResult'][0][0]['tgt']
    return target['translateResult'][0][0]['tgt'].encode('utf-8')


# 还可以继续增加规则函数，只要是两输入的参数都可以
# ----------------------触发函数-----------------------

def Answ():  # 规则函数

    Ans.insert(END, "翻译 %s: " % var_first.get().encode('utf-8') + translate(var_first.get().encode('utf-8')))


def Clea():  # 清空函数
    input_num_first.delete(0, END)  # 这里entry的delect用0
    Ans.delete(0, END)  # text中的用0.0


# ----------------------输入选择框架--------------------
frame_input = Frame(root)
Label_input = Label(frame_input, text='请输入需要翻译的内容', font=('', 15))
var_first = StringVar()
input_num_first = Entry(frame_input, textvariable=var_first)

# ---------------------计算结果框架---------------------
frame_output = Frame(root)
Label_output = Label(frame_output, font=('', 15))
Ans = Listbox(frame_output, height=5, width=30)  # text也可以，Listbox好处在于换行

# -----------------------Button-----------------------

calc = Button(frame_output, text='翻译', command=Answ)
cle = Button(frame_output, text='清空', command=Clea)

Label_root.pack(side=TOP)
frame_input.pack(side=TOP)
Label_input.pack(side=LEFT)

input_num_first.pack(side=LEFT)

frame_output.pack(side=TOP)
Label_output.pack(side=LEFT)
calc.pack(side=LEFT)
cle.pack(side=LEFT)
Ans.pack(side=LEFT)

# -------------------root.mainloop()------------------

root.mainloop()
