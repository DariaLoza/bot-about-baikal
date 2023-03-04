require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        random:
            a: Привет! Добро пожаловать на выставку "Байкал для каждого". Рядом с некоторыми фотография ты увидишь номера. Можешь написать мне номер интересующей фотографии и я расскажу о ней подробнее. Также, я могу рассказать тебе много интересного о Байкале. Я только учусь, но уже знаю о нейтрино, медведях, Иркутской ГЭС и многом другом.Задавай мне вопросы, а попробую на них ответить😊 
            a: Привет! Добро пожаловать на выставку "Байкал для каждого". Рядом с некоторыми фотография ты увидишь номера. Можешь написать мне номер интересующей фотографии и я расскажу о ней подробнее. Ещё я знаю много интересного о Байкале. Вот список того, о чем я могу рассказать: костоломы, национальная кухня, ГЭС, медведи, нейтрино, майнинг. Про что тебе рассказать? 😊 
            a: Привет! Добро пожаловать на выставку "Байкал для каждого". Рядом с некоторыми фотография ты увидишь номера. Можешь написать мне номер интересующей фотографии и я расскажу о ней подробнее. Также, я могу расказать тебе о Байкале много всего интересного, например, о майнинге или о костоломах😊 Про что тебе рассказать? 😊
    
    state: Answer
        intent!: /хорошо
        random:
            a: О чем тебе рассказать? Могу рассказать о национальном спорте или блюдах. Также, ты можешь ввести номер фотографии и я расскжу тебе о ней.😊
            a: Что тебе интересно узнать? Могу рассказать о майнинге или о костоломах.  Также, ты можешь ввести номер фотографии и я расскжу тебе о ней.😊
            a: О чем я могу тебе рассказать? Могу рассказать о ГЭС или о дацанах. Также, ты можешь ввести номер фотографии и я расскжу тебе о ней.😊
   
    state: Else
        intent!: /ещё
        a: Рядом с фотографиями лежат бумажные путеводители, там можно найти больше информации😊
    
    state: Can
        intent!: /умеешь
        a: Я умею рассказывать про фотографии по номеру и отвечать на вопросы про выставку.Вот список того, о чем я могу рассказать: костоломы, национальная кухня, ГЭС, медведи, нейтрино, майнинг. Про что тебе рассказать? 😊 😊

    state: Hello
        intent!: /привет
        random:
            a: Привет привет! О чем тебе рассказать? Могу рассказать о национальном спорте или блюдах.  Также, ты можешь ввести номер фотографии и я расскжу тебе о ней.😊
            a: Привет! Что тебе интересно узнать? Могу рассказать о майнинге или о костоломах. Также, ты можешь ввести номер фотографии и я расскжу тебе о ней.😊
            a: Здравствуй! О чем тебе рассказать? Могу рассказать о ГЭС или о дацанах. Также, ты можешь ввести номер фотографии и я расскжу тебе о ней.😊

    state: Name
        intent!: /имя
        random:
            a: Меня зовут Байкал.😊  
            a: Я Байкал😊
            a: Байкал😊
    
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
            a: Кажестся, я знаю ответ!😊
            a: Это я знаю! 😊
            a: Нашёл ответ в базе знаний!😊
        script: $faq.pushReplies();

    state: NoMatch
        event!: noMatch
        random:
            a: Не очень понятно. Что ты имеешь ввиду? {{$request.query}}? Попробуй перефразировать. 
            a: {{$request.query}}? Не знаю, я еще не выучил это. Вот список тем, которые я знаю: нейтрино, медведи, Иркутская ГЭС 
            a: {{$request.query}}? Об этом я не знаю, еще не выучил
