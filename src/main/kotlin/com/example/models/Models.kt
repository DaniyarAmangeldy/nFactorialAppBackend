package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val value: Double,
    val currency: String
)

@Serializable
data class Product(
    val id: String,
    val name: String,
    val price: Price,
    val image: String
)

@Serializable
data class Products(
    val products: List<Product>,
)

@Serializable
data class Rating(
    val average: Double,
    val count: Int
)

@Serializable
data class Store(
    val id: String,
    val name: String,
    val rating: Rating,
    val image: String,
    val products: List<Product> = emptyList(),
)

@Serializable
data class StoreLight(
    val id: String,
    val name: String,
    val rating: Rating
)

@Serializable
data class Profile(
    var name: String,
    var size: String
)

@Serializable
data class ProfileUpdateRequest(
    val name: String?,
    val size: String?
)

@Serializable
data class Collection(
    val id: String,
    val name: String,
    val products: List<Product>
)

@Serializable
data class StoreCollection(
    val id: String,
    val name: String,
    val stores: List<Store>
)

@Serializable
data class Banner(
    val id: String,
    val image: String,
    val title: String,
    val description: String,
)

@Serializable
data class Filter(
    val id: String,
    val name: String
)

@Serializable
data class HomeComponent(
    val filters: List<Filter>,
    val banner: Banner,
    val collections: List<Collection>,
    val storeCollections: List<StoreCollection>
)

@Serializable
data class StoreBanner(val imageUrl: String, val text: String)

@Serializable
data class Course(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val duration: String,
    val courseDetails: String,
    val tags: List<String>,
    val imageUrl: String
)

val courses = listOf(
    Course(
        id = 1,
        name = "nFactorial Start",
        description = "Программирование для начинающих",
        price = 590000.0,
        duration = "3 месяца",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/s5dj3CqtFCw8oIIkxeG3bVEH8Gg.jpg",
        courseDetails = "Данный курс подходит студентам, которые впервые сталкиваются с программированием и им необходимы базовые знания. \n" +
                "\n" +
                "Программа курса создана на основе 1-го курса Принстонского Университета, одного из самых престижных университетов США.",

    ),
    Course(
        id = 2,
        name = "nFactorial Data Analytics",
        description = "Аналитик данных",
        price = 690000.0,
        duration = "4 месяца",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/XzsDnxiwH2komRi1nqJdrMAVTuw.jpg",
        courseDetails = "Не нужно сложных математических знаний, чтобы начать работать с данными в Excel, SQL, PowerBI, Python. Вы научитесь обрабатывать массивы данных и предоставлять обоснованные наглядные отчеты, помогая компаниям улучшать процессы и увеличивать прибыл",
    ),
    Course(
        id = 3,
        name = "nFactorial iOS",
        description = "Разработчик iOS-приложений",
        price = 990000.0,
        duration = "6 месяцев",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/7xJnMO9USvjvJUgqIIVHwK7DI0.png",
        courseDetails = "Будете создавать приложения для Apple и учиться мобильной разработке. Вас ждет насыщенная программа с упором на практику\n" +
                "\n" +
                "\n" +
                "Мы первые в Казахстане, кто начал готовить специалистов по iOS-разработке, и предлагаем вам возможность присоединиться к лидерам рынка",
    ),
    Course(
        id = 4,
        name = "Generative AI",
        description = "Курс по генеративным нейросетям",
        price = 199990.0,
        duration = "4 недели",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/6eIXFFXbUppOGvwXHQJpOk4R1Q.jpg",
        courseDetails = "Четырехнедельный онлайн-курс по генеративному AI, включая глубокое изучение ChatGPT и других инструментов. \n" +
                "\n" +
                "\n" +
                "Основной акцент - на практические навыки и для раскрытия их профессионального потенциала и карьерного роста.",
    ),
    Course(
        id = 5,
        name = "nFactorial Data Science",
        description = "Специалист по Data Science",
        price = 990000.0,
        duration = "8 месяцев",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/DEmxtIkoKG1xezQbBSe1L6y9Q.jpg",
        courseDetails = "Data Science — это профессия, где вы не просто анализируете данные, а строите модели для прогнозов, решаете задачи с помощью машинного обучения и автоматизируете процессы. Упор сделан на изучение основ Data Science и анализа данных с использованием Python",
    ),
    Course(
        id = 6,
        name = "nFactorial SAT",
        description = "Хакнем SAT за 4 месяца",
        price = 590000.0,
        duration = "4 месяца",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/TySovgBXmUETuUnZN8Mgg4vFBo.png",
        courseDetails = "",
    ),
    Course(
        id = 7,
        name = "nFactorial Essays",
        description = "Креативные эссе для поступления в ВУЗы США",
        price = 590000.0,
        duration = "3 месяца",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/wY8H7ehYexsVzLxj0uMJIYM3M.jpg",
        courseDetails = "С нами вы сможете подготовиться к SAT и повысить свои шансы на поступление в ведущие мировые университеты. \n" +
                "\n" +
                "\n" +
                "Подготовьтесь к SAT с \n" +
                "\n" +
                "nFactorial Test Prep и достигайте высоких результатов благодаря уникальному подходу к обучению",
    ),
    Course(
        id = 8,
        name = "nFactorial Teens",
        description = "Программирование для детей",
        price = 590000.0,
        duration = "12 недель",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/TqAlMoeJqODCWlfi9Mol7qJqGs.png",
        courseDetails = "Курс по мобильной разработке приложений для iOS устройств – продуктов Apple.\n" +
                "\n" +
                "На курсе вы также получите основы дизайна. Студенты создают дизайны приложений в Figma вместе с бывшим продуктовым дизайнером Yandex.\n" +
                "\n" +
                "Наша программа является флагманом на рынке – мы первые в Казахстане начали готовить iOS-разработчиков. Сегодня многие топовые senior разработчики на казахстанском рынке - это выпускники nFactorial School 2015-2018 годов.",
    ),
    Course(
        id = 9,
        name = "nFactorial Data Analytics",
        description = "Power BI за 1 месяц",
        price = 290000.0,
        duration = "1 месяц",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/QRmOZlAGOOl2lf7XXP4vskWOXpI.jpg",
        courseDetails = "Не нужно сложных математических знаний, чтобы начать работать с данными в Excel, SQL, PowerBI, Python. Вы научитесь обрабатывать массивы данных и предоставлять обоснованные наглядные отчеты, помогая компаниям улучшать процессы и увеличивать прибыл",
    ),
    Course(
        id = 10,
        name = "nFactorial QA",
        description = "Инженер-тестировщик сайтов и приложений",
        price = 590000.0,
        duration = "3 месяца",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/LOe9JJONeNgel14mZ6f6msQv6Ks.png",
        courseDetails = "Курс nFactorial QA нацелен на погружение в мир разработки и обучение навыкам, необходимым для становления профессиональным QA инженером. \n" +
                "\n" +
                "Программа курса включает введение в основы тестирования, классификацию видов и уровней тестирования, техники тест-дизайна.",
    ),
    Course(
        id = 11,
        name = "nFactorial Frontend Pro",
        description = "Фронтенд разработчик за 3 месяца",
        price = 690000.0,
        duration = "3 месяца",
        tags = listOf("с базой"),
        imageUrl = "https://framerusercontent.com/images/s5dj3CqtFCw8oIIkxeG3bVEH8Gg.jpg",
        courseDetails = "Курс предназначен для тех, кто хочет научиться разрабатывать web-сайты. \n" +
                "\n" +
                "Обучение начинается с базы на HTML & CSS, после чего обучение проходит уже на React - библиотеке JavaScript, чтобы быстро и легко собирать сложные элементы из маленьких кусочков кода. \n" +
                "\n" +
                "После успешного прохождения курса вы сможете подаваться на стажировки для frontend-разработчиков.",
    ),
    Course(
        id = 12,
        name = "nFactorial Launch",
        description = "Bootcamp по запуску личных проектов",
        price = 870000.0,
        duration = "6 месяцев",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/XC6N5WU0baSqFKR0knXGhICffac.jpg",
        courseDetails = "n! Launch — это программа обучения предназначенная для запуска личных проектов с 0 за 6 месяцев.",
    ),
    Course(
        id = 13,
        name = "nFactorial Backend",
        description = "Введение в Python разработку",
        price = 890000.0,
        duration = "6 месяцев",
        tags = listOf("с базой"),
        imageUrl = "https://framerusercontent.com/images/zDF6r2VJYAJbGxC8kubkFCFXc.jpg",
        courseDetails = "Программа курса разработана для участников, имеющих базу в программировании, и основана на опыте профессионалов из индустрии, учитывающем последние требования рынка труда.",
    ),
    Course(
        id = 14,
        name = "nFactorial Algorithms and Data Structures",
        description = "Готовимся к интервью BigTech",
        price = 690000.0,
        duration = "15 недель",
        tags = listOf("с базой"),
        imageUrl = "https://framerusercontent.com/images/86VIgJlPclcGEnUvCuQqX4hxvk.jpg",
        courseDetails = "На курсе вы научитесь решать задачи по алгоритмам и структурам данных, разберете реальные кейсы интервью из BigTech и потренируетесь на пробных собеседованиях. Если вы готовы бросить себе вызов и мечтаете попасть в топовые IT-компании — это ваш шанс",
    ),
    Course(
        id = 15,
        name = "nFactorial Product Manager",
        description = "Продакт-менеджер",
        price = 690000.0,
        duration = "3 месяца",
        tags = listOf("с нуля"),
        imageUrl = "https://framerusercontent.com/images/m22IdB1WtvPsJyDkjdErAqEHpg.jpg",
        courseDetails = "Продакт-менеджер — это специалист, который отвечает за разработку и успех продукта. \n" +
                "\n" +
                "Он координирует работу разработчиков, дизайнеров, маркетологов и других команд, понимает потребности пользователей и выстраивает стратегию, чтобы сделать продукт востребованным и полезным для клиентов и бизнеса",
    )
)

val banners = listOf(
    StoreBanner("https://i.postimg.cc/k56MgVcH/IMG-4348-1-1.png", "2500+ выпускников в топовых IT компаниях"),
    StoreBanner("https://i.postimg.cc/vZSHy7W9/Group-5.png", "Существуем на рынке с 2013 года"),
    StoreBanner("https://i.postimg.cc/XvRjGV1Y/Group-6.png", "Дружное и большое комьюнити")
)

val tags = listOf(
    "с нуля",
    "с базой",
)

@Serializable
data class Testimonial(
    val id: Int,
    val name: String,
    val previousOccupation: String,
    val currentOccupation: String,
    val course: String,
    val feedback: String,
    val imageUrl: String? = null // URL фотографии, можно добавить позже
)

val testimonials = listOf(
    Testimonial(
        id = 1,
        name = "Айханым Кенжалина",
        previousOccupation = "Студентка",
        currentOccupation = "Backend-разработчица в Ioka",
        course = "nFactorial Backend",
        feedback = "Каждый день я взаимодействовала с потрясающим комьюнити, общалась с единомышленниками и постоянно улучшала свои знания. Курс дал мне не только технические навыки, но и уверенность в своих силах и компетенциях.",
        imageUrl = "https://framerusercontent.com/images/JHjVI9WRCBafWCwY1ByEhBa4mc.jpeg",
    ),
    Testimonial(
        id = 2,
        name = "Наиля Молутова",
        previousOccupation = "Рекрутер",
        currentOccupation = "Frontend-разработчица в Globerce Capital",
        course = "nFactorial Start, Frontend",
        feedback = "То, что мы проходили на курсах, помогло пройти техническое собеседование и получить оффер на работу.",
        imageUrl = "https://framerusercontent.com/images/hwpXOX0lwMZUy1A3sC6XYDGs.jpg",
    ),
    Testimonial(
        id = 3,
        name = "Лейла Нысанбаева",
        previousOccupation = "Студентка «Информационные технологии»",
        currentOccupation = "iOS-разработчица в Ozon",
        course = "nFactorial iOS",
        feedback = "Без знаний менторов я была абсолютным нулем в iOS-разработке. После курса я устроилась на работу, и меня оценили как сильного джуниора.",
        imageUrl = "https://framerusercontent.com/images/BAxZ7YEKJRwAc5f993mrl36eWY.jpg",
    ),
    Testimonial(
        id = 4,
        name = "Есенәлі Жанайдар",
        previousOccupation = "Студент",
        currentOccupation = "iOS-разработчик в стартапе MUSA",
        course = "nFactorial Start, iOS",
        feedback = "nFactorial-да алған білім жұмысқа тұрардың алдындағы интервью кезінде өте қатты көмектесті. Сол үшін nFactorial ұжымына үлкен алғысымды білдіремін.",
        imageUrl = "https://framerusercontent.com/images/TExAbuxd6JzS0FwABRyGAtTGI.jpg",
    ),
    Testimonial(
        id = 5,
        name = "Еркебулан Шарипов",
        previousOccupation = "HR на вахте",
        currentOccupation = "iOS-разработчик в Jusan Bank",
        course = "nFactorial Start, iOS",
        feedback = "После окончания курсов nFactorial я получил оффер на работу. nFactorial School помогла мне найти работу мечты — это именно та работа, на которую хочется ходить.",
        imageUrl = "https://framerusercontent.com/images/4mGpojWYL7oXZl9PUnnFHGPyE7Q.jpg",
    ),
    Testimonial(
        id = 6,
        name = "Алмас Киличов",
        previousOccupation = "Школьник",
        currentOccupation = "Frontend-разработчик в Kaspi",
        course = "nFactorial Incubator",
        feedback = "nFactorial Incubator дал мне возможность работать с реальными проектами и получить опыт, который ценится работодателями.",
        imageUrl = "https://framerusercontent.com/images/nyUc5ISOzBrqXLDIcjQEbszccKc.jpg",
    )
)

@Serializable
data class News(
    val id: Int,
    val title: String,
    val shortDescription: String,
    val fullText: String,
    val tags: List<String>,
    val imageUrl: String
)

val newsList = listOf(
    News(
        id = 1,
        title = "10 день челленджа nFactorial AI: финансовые итоги 2024 года",
        shortDescription = "Подводим финансовые итоги 2024 года в рамках 10-го дня челленджа nFactorial AI.",
        fullText = "Завершаем 10-дневный Ship-mas Challenge от nFactorial AI впритык к празднованию нового года. Из выводов в одно касание. Крутейший опыт для команды. Сильно улучшили продукт в кратчайшие сроки. Скорость получения информации с рынка выросла в разы. Действие создает информацию. Количество итераций в единицу времени решает. Получили потрясающий заряд творческой энергии на новый год. \n" +
                "\n" +
                "Устали от бесконечных таблиц с расходами? Наш новый ИИ-агент превратит ваши выписки из любого банка в четкую картину финансового года. \n" +
                "\n" +
                "Как это работает? Загружаете выписки из разных банков за весь год (за месяц, любой период), а мы создаем детальный Excel-файл с помесячной разбивкой доходов и расходов. Но это не просто сухие цифры! Наш анализ выявляет транзакции, требующие особого внимания, и предлагает конкретные рекомендации по улучшению бюджета на следующий год. Никаких общих фраз вроде \"тратьте меньше\" – только персонализированные инсайты, основанные на ваших реальных финансовых привычках.",
        tags = listOf("финансы", "челлендж", "2024"),
        imageUrl = "https://framerusercontent.com/images/rfky0iEriBTFS5rigjWTi3nseE.jpg"
    ),
    News(
        id = 2,
        title = "9 день челленджа nFactorial AI: викторина по подкасту Acquired",
        shortDescription = "Провели увлекательную викторину по мотивам подкаста Acquired на 9-й день челленджа.",
        fullText = "Челлендж nFactorial AI постепенно подходит к концу. За последние 9 дней мы выпустили 9 агентов ИИ, основанных на нашем флагманском продукте nFactorial Research. Сегодня мы с командой обращаемся ко всем фанатам подкаста Acquired — у нас есть кое-что особенное для вас!  \n" +
                "\n" +
                "Представляем викторину по Acquired — полное погружение в подкаст, который раскрывает величайшие истории в мире технологий и бизнеса.  \n" +
                "\n" +
                "Мы создали тысячи увлекательных вопросов, основанных на всех выпусках подкастов Acquired и ACQ2, чтобы вы могли проверить себя по темам:  \n" +
                "\n" +
                "- стратегий построения компаний,\n" +
                "\n" +
                "- поворотных решений основателей,\n" +
                "\n" +
                "- знаковых моментов в истории технологий, \n" +
                "\n" +
                "- приобретений и IPO, которые изменили индустрию.\n" +
                "\n" +
                "Соревнуйтесь с другими слушателями на нашем мировом рейтинге и докажите, что вы настоящий суперфан подкаста Acquired!  ",
        tags = listOf("викторина", "подкаст", "челлендж"),
        imageUrl = "https://framerusercontent.com/images/dhpVfgoxlJNHyewIe2o2tRhqaM4.jpg"
    ),
    News(
        id = 3,
        title = "Момент Ли Сидола",
        shortDescription = "Май 1997 года — Чемпион мира по шахматам Гарри Каспаров проиграл Deep Blue (IBM) 2½-3½ в Нью-Йорке. Это было первое поражение действующего чемпиона мира компьютеру в официальном турнире",
        fullText = "Май 1997 года — Чемпион мира по шахматам Гарри Каспаров проиграл Deep Blue (IBM) 2½-3½ в Нью-Йорке. Это было первое поражение действующего чемпиона мира компьютеру в официальном турнире. \n" +
                "\n" +
                "Март 2016 года — Чемпион мира по игре го Ли Сидол проиграл AlphaGo (Google DeepMind) 1-4 в Сеуле. До этого события считалось, что ИИ не сможет победить лучшего человека в го еще в течение 5-10 лет. Вот, что сказал Ли Сидол 8 лет спустя: \n" +
                "\n" +
                "Проигрыш ИИ в каком-то смысле означал, что мир, в котором я жил, разрушен. Я больше не мог получать удовольствие от игры, поэтому завершил карьеру.\n" +
                "\n" +
                "Январь 2025 года — Известный американский сценарист и режиссер Пол Шредер (“Таксист”, “Бешеный бык”, “Последнее искушение Христа”, “Воскрешая мертвецов”) написал следующее в своем Фейсбуке: \n" +
                "\n" +
                "ИИ. Я только что осознал, что ИИ умнее меня. Его идеи - лучше и у него более эффективные методы их реализации. Это экзистенциальный момент, похожий на то, что испытал Каспаров в 1997 году, когда понял, что Deep Blue победит его в шахматах.\n" +
                "\n" +
                "Ноам Браун, исследователь в OpenAI, один из создателей o1 и o3: \n" +
                "\n" +
                "Сложно ощутить “сильный ИИ” на кончиках своих пальцев, пока вы не увидите, как ИИ превосходит лучших людей в областях, которым они посвятили всю свою жизнь. Спортивные программисты почувствуют это уже через пару лет. Пол почувствовал это относительно рано, но, думаю, что писатели это тоже скоро почувствуют. У каждого будет свой “момент Ли Сидола”",
        tags = listOf("анализ", "Y Combinator", "стартапы"),
        imageUrl = "https://framerusercontent.com/images/xLG1e1zviETbX5aaQxpFxCvmnE.jpg"
    ),
    News(
        id = 6,
        title = "ИИ в медицине — под государственный контроль",
        shortDescription = "Обсуждаем необходимость государственного регулирования использования искусственного интеллекта в медицине.",
        fullText = "Новый закон Калифорнии запрещает использование ИИ для отклонения заявлений на страховые выплаты.\n" +
                "Законопроект SB 1120 предписывает, чтобы человеческое суждение оставалось центральным фактором при принятии решений о страховых выплатах.\n" +
                "В прошлом году в Калифорнии было отклонено около четверти всех заявлений на выплату медицинской страховки. Ситуация отразилась на всей территории США и вызвала широкий общественный резонанс. Медицинские компании подверглись обвинениям в том, что их решения зачастую лишены таких нормальных человеческих эмоций, как сочувствие и эмпатия.\n" +
                "\n" +
                "Теперь новый закон штата должен поставить точку в этой истории, гарантируя, что точка зрения человека не будет исключаться из таких решений. Отказы в страховых выплатах исключительно на основе алгоритмов искусственного интеллекта будут под запретом.\n" +
                "\n" +
                "В сентябре прошлого года губернатор Гэвин Ньюсом подписал законопроект Сената 1120 — «Physicians Make Decisions Act» (англ. «Закон о принятии решений врачами»). Законопроект появился на фоне общественного недовольства системой медицинского страхования в США. Громкое убийство руководителя UnitedHealthcare Брайана Томпсона в декабре 2024 года вызвало волну реакций, в том числе и гнев общественности. Незадолго до этого, в ноябре 2023 года, судебный процесс против UnitedHealthcare выдвинул компании обвинение по факту неправомерного использования ИИ при принятии решений о страховых выплатах. \n" +
                "\n" +
                "По данным California Nurses Association, за 2024 год в штате было отклонено примерно 26% заявлений о страховых выплатах. Это лишь один из многих факторов, на которые обращает внимание основной автор закона — сенатор штата Джош Беккер.\n" +
                "\n" +
                "«Только в 2021 году данные (по всей стране) показали, что компании медицинского страхования отклонили более 49 миллионов заявлений на выплаты», — отмечает Беккер, ссылаясь на информацию Kaiser Family Foundation. «При этом клиенты подали апелляции менее чем по 0,2% из них».\n" +
                "\n" +
                "Стоит отметить, что закон SB 1120 не запрещает любое использование технологий ИИ. Он предписывает, чтобы суждение человека играло основную роль при принятии решений о страховых выплатах. Инструменты ИИ также не могут быть использованы для отказа, задержки или изменения медицинских услуг, которые врачи назначают обязательными.\n" +
                "\n" +
                "«Алгоритм не способен полностью учесть такие факторы, как уникальная история болезни или особые потребности пациента. Поэтому его неправильное использование может привести к плачевным последствиям. Искусственный интеллект обладает огромным потенциалом для улучшения качества оказания медицинской помощи, но он ни в коем случае не должен заменять опыт и оценки живых врачей», — говорит Беккер. «Новый закон гарантирует: в основе решений, касающихся здравоохранения, будет сохранен человеческий надзор. Это в свою очередь гарантирует доступ калифорнийцев к качественной помощи».\n" +
                "\n" +
                "Департамент здравоохранения Калифорнии будет контролировать исполнение закона, проверять показатели отказов и обеспечивать прозрачность таких процедур. Закон также устанавливает строгие сроки: стандартные случаи требуют решения в течение пяти рабочих дней, срочные случаи — в течение 72 часов, а процессы оценивания после проведенного лечения — в течение 30 дней.\n" +
                "\n" +
                "Согласно законопроекту SB 1120, государственные регулирующие органы имеют право по своему усмотрению штрафовать страховые компании и определять суммы, положенные за нарушения сроков или ненадлежащее использование искусственного интеллекта.\n" +
                "\n" +
                "Эрин Меллон, представитель California Medical Association, которая является одним из авторов законопроекта, подчеркнула важность защиты отношений между врачом и пациентом.\n" +
                "\n" +
                "«Искусственный интеллект имеет потенциал для улучшения ухода за пациентами, но он не должен вредить этим отношениям или вовсе их вытеснять», — отметила Меллон. «Недавние отчеты освещают случаи, когда автоматика ошибочно отказывала пациентам в доступе к необходимой медицинской помощи. Врачи в целом поддерживают применение ИИ в здравоохранении. Но это при условии, что он помогает уходу за больным и учитывает особенности как врачей, так и пациентов».\n" +
                "\n" +
                "Паула Вольфсон, менеджер Avenidas Care Partners, некоммерческой организации, помогающей пожилым людям, рассказала о трудностях, с которыми сталкиваются ее клиенты при отказе в страховых выплатах.\n" +
                "\n" +
                "«Это прежде всего огромный стресс для клиентов», — говорит Вольфсон. «Со мной связываются целые семьи, которые нуждаются, но не могут получить доступ к необходимым медицинским услугам».\n" +
                "\n" +
                "Вольфсон приветствует активный подход Калифорнии к регулированию ИИ в здравоохранении.\n" +
                "\n" +
                "«У меня появляется капля надежды на то, что политики привнесут здравый смысл и благоразумие в эти решения», — сказала она.\n" +
                "\n" +
                "Сенатор Джош Беккер отмечает, что подход Калифорнии привлекает внимание всей Америки.\n" +
                "\n" +
                "«Сейчас 19 штатов рассматривают аналогичные законы», — сказал Беккер. «С нами даже связывались несколько офисов Конгресса, рассматривающих федеральное законодательство. Наш приоритет — помощь калифорнийцам, но установление общенациональной тенденции не менее важно».",
        tags = listOf("искусственный интеллект", "медицина", "регулирование"),
        imageUrl = "https://framerusercontent.com/images/jsJiWTVsolt9cWadbImHReVt3gE.jpg?scale-down-to=4096"
    )
)

val newsTags = newsList.flatMap { it.tags }.distinct()

@Serializable
data class ConsultationRequest(val name: String, val email: String, val phone: String)
