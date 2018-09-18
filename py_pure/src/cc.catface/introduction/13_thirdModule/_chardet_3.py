import chardet

b = b'hello catface!'
c = chardet.detect(b)
print('chardet:', c)

s1 = s2 = '国破山河在，城春草木深'
s3 = '最新の主要ニュース'
r = s1.encode('gbk')
c = chardet.detect(r)
print('chardet:', c)

r = s2.encode('utf-8')
c = chardet.detect(r)
print('chardet:', c)

r = s3.encode('euc-jp')
c = chardet.detect(r)
print('chardet:', c)
