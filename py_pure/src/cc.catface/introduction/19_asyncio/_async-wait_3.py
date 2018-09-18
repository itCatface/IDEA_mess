import asyncio


async def hello():
    print('hi catface')
    r = await asyncio.sleep(2)
    print('hello again')


loop = asyncio.get_event_loop()
loop.run_until_complete(hello())
loop.close()
