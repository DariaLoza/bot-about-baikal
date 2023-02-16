require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Привет! Я могу рассказать тебе много интересного о Байкале. Например о телескопе или медведях. Я только учусь, но уже знаю о нейтрино, медведях, Иркутской ГЭС и многом дургом.Задавай мне вопросы, а попробую на них ответить 😊
    
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
            a: Хорошо! а у тебя? 
            a: Если честно не очень, но я держусь! Что тебе интересно узнать?
            a: отлично!
    state: Bye
        intent!: /пока
        random:
            a: Пока!
            a: До скорого!
        

    state: KnowledgeBase
        intentGroup!: /KnowledgeBase
        a: Нашёл ответ в базе знаний!
        script: $faq.pushReplies();

    state: NoMatch
        event!: noMatch
        random:
            a: Я не понял. Ты  сказал: {{$request.query}}. Попробуй перефразировать 
            a: {{$request.query}}? Не знаю, но зато знаю о нейтринном телескопе, рассказать?
            a: {{$request.query}}? Об этом я не знаю, могу только про выставку рассказать
