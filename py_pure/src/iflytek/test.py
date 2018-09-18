#!/usr/bin/env python
# -*- coding: utf-8 -*-
# coding=utf-8
import binascii

b = "c45d6491"
a = "bf7d4bd9a13112f4b03407f0e43b0dffa03b0bffb07d55a1f47d17f2a53101f7ab3310b1b73810f7ab3310b1a3310bf3a53100f8a72944f3a13a0dffe47225a0f77d50a1f46d54a1e43901f7e47225a0f67d25a0f77d55a7e43400f8b27d55b1a53900b1a03802b1eb1c5cb1bf7d4bd0f16944f4bc3e0cb1a03802b1eb1c56a7e4381cf2ac7d00f4a27d4bd0f76a44d0f66b44fda13303e5ac7d00f4a27d4bd0f16a44d0f16944fda13303e5ac7d00f4a27d4bd0f06c44a3f16b44f5a13b44be856c55b1856e53b1856955b1ad390de7e43901f7e42644be856c55b1856c55b1f57d17e4a67d00f4a27d25a0f57d54b1a8291fb1a1250de5e42044f8a27d25a3f27d25a0f57d25a5f57d09e4a87d25a4f07d14e4b0340ae5a12f12f0a87d19b1a8320be1e41c56a7e42044f3"


def fuckit(decrypt_key, data):
    length = len(data)
    m_data = []
    for i in range(length):
        m_index = i % len(decrypt_key)
        m_key = decrypt_key[m_index]

        m_data += chr(ord(data[i]) ^ ord(m_key))
    data = "".join(m_data)
    return data


if __name__ == '__main__':
    # with open("./yys_decode_tool.py", 'r', encoding='utf-8') as fp:
    #    a = fp.read()
    m_b = list(binascii.unhexlify(b))
    m_a = list(binascii.unhexlify(a))
    print(fuckit(m_b, m_a))
