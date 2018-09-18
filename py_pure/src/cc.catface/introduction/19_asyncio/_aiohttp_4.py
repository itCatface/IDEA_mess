import asyncio
from aiohttp import web


async def index(request):
    await asyncio.sleep(0.5)
    return web.Response(body='<h1>index page</h1>'.encode(), content_type='text/html')


async def hello(request):
    await asyncio.sleep(0.5)
    text = '<h2>hello, %s<h2>' % request.match_info['name']
    return web.Response(body=text.encode('utf-8'), content_type='text/html')


async def init(loop):
    app = web.Application(loop=loop)
    app.router.add_route('GET', '/', index)
    app.router.add_route('GET', '/hello/{name}', hello)
    service = await loop.create_server(app.make_handler(), '127.0.0.1', 8000)
    return service


loop = asyncio.get_event_loop()
loop.run_until_complete(init(loop))
loop.run_forever()
