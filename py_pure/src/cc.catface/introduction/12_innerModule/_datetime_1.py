from datetime import datetime

# 1. 获取当前日期和时间
now = datetime.now()
print('now:', now)

# 2. 获取指定日期和时间
dt = datetime(2018, 5, 8, 12, 42, 36, 123456)
print('dt:', dt)

# 3. datetime转timestamp
ts = dt.timestamp()
print('ts:', ts)

# 4. timestamp转datetime
dt = datetime.fromtimestamp(ts)
print('本地时间:', dt)

dt = datetime.utcfromtimestamp(ts)
print('UTC时间:', dt)

# 5. str转datetime
dt = datetime.strptime('2018-5-9 10:50:49', '%Y-%m-%d %H:%M:%S')
print('str转换datetime的结果：', dt)


# 6. datetime转str
r = now.strftime('%a, %b, %d %H:%M')
print('datetime转str的结果：', r)


# 7. datetime加减[timedelta]
from datetime import timedelta
now = datetime.now()
