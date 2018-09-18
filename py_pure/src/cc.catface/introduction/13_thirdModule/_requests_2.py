### 使用requests处理URL资源


import requests

r = requests.get('https://www.douban.com')
print('status: %s\r\n\r\ncontent: %s' % (r.status_code, r.text))

r = requests.get('https://www.douban.com/search', params={'q': 'python', 'cat': '1001'})
print('url-->', r.url)
print('text-->', r.text)
print('content-->', r.content)

## 直接抓去json
r = requests.get('https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20%3D%202151330&format=json')
print('json-->', r.json())

## 传入dict作为头
r = requests.get('https://www.douban.com/', headers={'User-Agent': 'Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit'})
print('text with headers-->', r.text)
