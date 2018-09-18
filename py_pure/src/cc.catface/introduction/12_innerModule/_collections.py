from collections import namedtuple

# namedtuple
Point = namedtuple('Point', ['x', 'y'])
p = Point(1, 2)
print(p, p.x, p.y, isinstance(p, Point), isinstance(p, tuple))


from collections import deque

# deque
q = deque(['a', 'b', 'c'])
q.append('d')
q.appendleft('z')
print(q)


from collections import defaultdict

# defaultdict[key不存在时返回默认值,其他与dict完全一样]
d = defaultdict(lambda: 'N/A')
d['key1'] = 'value1'
d['key2'] = 'value2'
print(d['key3'], d['key2'])

from collections import OrderedDict

# OrderedDict
d = dict([('key1', 'value1'), ('key2', 'value2'), ('key3', 'value3'), ('key4', 'value4'), ('a', 1), ('b', 2), ('c', 3)])
print(d, d.keys())

od = OrderedDict(d)
od['key2'] = 'value0002'
keys = list(od.keys())
print(od, keys)


from collections import Counter

# Counter[dict的子类]
c = Counter()
for ch in 'qwerdfqwer':
    c[ch] = c[ch] + 1

print(c)
