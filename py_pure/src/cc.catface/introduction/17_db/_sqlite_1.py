import sqlite3


def create_table():
    conn = sqlite3.connect('test.db')
    cursor = conn.cursor()
    # r = cursor.execute('CREATE TABLE user (id VARCHAR(20) PRIMARY KEY , name VARCHAR(20))')
    # print('create table-->', r)


def insert():
    conn = sqlite3.connect('test.db')
    cursor = conn.cursor()
    r = cursor.execute('INSERT INTO user (id, name) VALUES (\'4\', \'Michael\')')
    r = cursor.execute('INSERT INTO user (id, name) VALUES (\'2\', \'Rose\')')
    r = cursor.execute('INSERT INTO user (id, name) VALUES (\'3\', \'Iverson\')')
    print('insert-->', r)
    print('rowcount-->', cursor.rowcount)
    cursor.close()
    conn.commit()
    conn.close()


def select():
    conn = sqlite3.connect('test.db')
    cursor = conn.cursor()
    r = cursor.execute('SELECT * FROM user WHERE id>?', ('1',))
    values = cursor.fetchall()
    print('values-->', values)
    cursor.close()
    conn.close()


if __name__ == '__main__':
    # insert()
    select()
