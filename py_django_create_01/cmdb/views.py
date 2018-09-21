from django.shortcuts import render
from django.shortcuts import HttpResponse

# Create your views here.


user_list = [
    {'username': 'alistar', 'password': 'ali'},
    {'username': 'akali', 'password': 'aka'},
]


# def index3(request):
#     # return HttpResponse("hello world...")
#
#     # return render(request, "index.html")
#
#     if request.method == 'POST':
#         username = request.POST.get('username', None)
#         password = request.POST.get('password', None)
#         print(username, password)
#     # return render(request, 'index.html')
#
#     # 返回动态页面即返回数据
#     return render(request, 'index.html', {'data': user_list})


from cmdb import models


def index(request):
    if request.method == 'POST':
        username = request.POST.get('username', None)
        password = request.POST.get('password', None)
        models.UserInfo.objects.create(username=username, password=password)
    user_list = models.UserInfo.objects.all()
    return render(request, 'index.html', {'data': user_list})
