from django.db import models


# Create your models here.

# 创建model
class UserInfo(models.Model):
    username = models.CharField(max_length=32)
    password = models.CharField(max_length=32)
