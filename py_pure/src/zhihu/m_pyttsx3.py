import pyttsx3

# 1. 初始化
engine = pyttsx3.init()
voices = engine.getProperty('voices')
print(voices)
for voice in voices:
    engine.setProperty('voice', voice.id)
    engine.setProperty('gender', 'man')
    engine.setProperty('age', 12)

    print(voice)

rate = engine.getProperty('rate')
engine.setProperty('rate', rate - 80)

volume = engine.getProperty('volume')
engine.setProperty('volume', volume + 0.9)

engine.say('all is well. 123. 2')
engine.runAndWait()
