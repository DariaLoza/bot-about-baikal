require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        random:
        a: Привет! Я могу рассказать тебе много интересного о Байкале. Я только учусь, но уже знаю о нейтрино, медведях, Иркутской ГЭС и многом другом.Задавай мне вопросы, а попробую на них ответить😊
        a: Привет! Я знаю много интересного о Байкале. Вот список того, о чем я могу рассказать: костеломы, национальная кухня, ГЭС, медведи, нейтрино, майнинг. Про что тебе рассказать? 😊
        a: Привет! Я могу расказать тебе о Байкале много всего интересного, например, о майнинге или о костеломах😊 Задавай мне вопросы, а попробую на них ответить 😊
    
    
    state: Answer
        intent!: /хорошо
        random:
            a: О чем тебе рассказать? Могу рассказать о национальном спорте или блюдах
            a: Что тебе интересно узнать? Могу рассказать о майнинге или о костеломах
            a: О чем я могу тебе рассказать? Я знаю о степях и ГЭС
    

    state: Hello
        intent!: /привет
        random:
            a: Привет привет! О чем тебе рассказать?
            a: Привет! Что тебе интересно узнать?
            a: Здравствуй! О чем тебе рассказать?

    state: Name
        intent!: /имя
        random:
            a: Меня зовут Байкал.  
            a: Я зовусь Байкалом
            a: Байкал
    
    state: Kakdela
        intent!: /дела
        random:
            a: Хорошо! Что тебе интересно узнать?
            a: Замечательно! Что тебе интересно узнать?
            a: Отлично! Давай лучше про Байкал расскажу. Что тебе интересно?
    state: Bye
        intent!: /пока
        random:
            a: Пока!
            a: До скорого!
        

    state: KnowledgeBase
        intentGroup!: /KnowledgeBase
        random:
            a: Кажестся, я знаю ответ!
            a: Это я знаю! 
            a: Нашёл ответ в базе знаний!
        script: $faq.pushReplies();

    state: NoMatch
        event!: noMatch
        random:
            a: Не очень понятно. Что ты имеешь ввиду? {{$request.query}}? Попробуй перефразировать. 
            a: {{$request.query}}? Не знаю, я еще не выучил это. Вот список тем, которые я знаю: нейтрино, медведи, Иркутская ГЭС 
            a: {{$request.query}}? Об этом я не знаю, еще не выучил
