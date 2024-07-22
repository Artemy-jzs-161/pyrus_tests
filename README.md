# Дипломный проект автоматизации тестирования

<html>
 <body> 
   <p><a href="https://pyrus.com/ru"><img src="media/images/Pyrus_logo.png" width="800" 
   height="300" alt="Pyrus"></a></p>
 </body> 
</html>

## Содержание

* <a href="#description">Описание</a>
+ [Технологии и инструменты](#Технологии-и-инструменты)
+ [Реализованные проверки](#Реализованные-проверки)
+ [Запуск тестов](#)
    + [Допустимые комбинации](#Допустимые-комбинации)
    + [Локальный запуск тестов](#Локальный-запуск-тестов)
    + [Удаленный запуск тестов](#Удаленный-запуск-тестов)
+ [Cборка тестов в Jenkins](#jenkins)
+ [Интеграция с Allure Report](#allure)
    + [Диаграммы прохождения тестов](#Диаграммы-прохождения-тестов)
    + [Развернутый результат прохождения тестов](#Развернутый-результат-прохождения-тестов)
+ [Интеграция с Allure TestOps](#allure-testops)
+ [Интеграция с Jira](#jira)
+ [Уведомления в Telegram с использованием бота](#telegram)
+ [Пример выполнения теста в Selenoid](#video)

<a id="description"></a>
## Описание

Pyrus — это система для автоматизации рабочих процессов, бизнес-коммуникаций, управления задачами и согласования
документов. Pyrus является SaaS-приложением и представляет собой единую корпоративную коммуникационную среду, доступную
с любого устройства.

**Особенности проекта**:

- `Page Object` шаблон проектирования
- Использование техноголии `Owner` для придания тестам гибкости и легкости конфигурации
- Возможность запуска тестов: локально, удалённо, по тегам
- Использование `Faker` для генерации данных
- Использование `Lombok` для моделей в API тестах
- Использование собственных расширений:
    - `@Authorization` для предварительной авторизации
    - `@AuthToken` для получения токена
- Возможность запуска тестов напрямую из Allure TestOps
- Интеграция с Jira
- Уведомление о результатах прохождения в Telegram
- По итогу прохождения автотестов генерируется Allure отчет. Содержание отчета:
    - Шаги теста
    - Скриншот страницы на последнем шаге
    - Исходный код страницы в браузере
    - Логи консоли браузера
    - Видео выполнения автотеста

## Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="media/images/Idea.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="media/images/GitHub.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="media/images/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="media/images/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="media/images/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="media/images/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="media/images/Selenoid.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="media/images/RestAssured.svg" width="50"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="50" src="media/images/Browserstack.svg" width="50"/></a>
<a href="https://appium.io/"><img alt="Appium" height="50" src="media/images/Appium.svg" width="50"/></a>
<a href="https://developer.android.com/studio"><img alt="Android Studio" height="50" src="media/images/Android_Studio.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="media/images/Jenkins.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="media/images/Allure.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="media/images/Allure_TO.svg" width="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="media/images/Jira.svg" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="media/images/Telegram.svg" width="50"/></a>
</div>

## Реализованные проверки

### API

- [x] Отправка запроса на получение всех пользователей
- [x] Отправка запроса на получение пользователя по ID
- [x] Получение сотрудника по несуществующему ID
- [x] Добавление нового сотрудника
- [x] Изменение данных пользователя по ID
- [x] Блокировка пользователя по ID

### UI

- [x] Поиск по названию статьи
- [x] Поиске несуществующей статьи
- [x] Проверка ссылок при переключении языка
- [x] Успешная авторизация при вводе логина и пароля
- [x] Авторизации при вводе некорректного пароля
- [x] Авторизации при вводе некорректного логина
- [x] Создание задачи
- [x] Установка темной темы

### Mobile

- [x] Успешная авторизация при вводе логина и пароля
- [x] Проверка авторизации при вводе неверного пароля
- [x] Проверка авторизации при вводе неверного Email адреса

### Ручные проверки:

- [x] Создание задачи по форме "Отпуск"
- [x] Создание формы по шаблону "Кадры"
- [x] Проверка тарифов на сайте

## Запуски тестов

> [!NOTE]
> Убедитесь, что у вас установлены Java, Gradle, IntelliJ IDEA и в качестве браузера используется Chrome

Конфигурационные файлы `.properties` лежат в папке `resources`. <br/>
При необходимости можно изменить их.

### Допустимые комбинации

```mermaid 
flowchart LR
    A(gradle) --> B(clean)
    B --> C{Выбрать тег}
    C --> D[api]
    C --> E[ui]
    C --> G[mobile]
    E --> H[-DenvWeb=local]
    E --> I[-DenvWeb=remote]
    G --> M[-DdeviceHost=browserstack]
    G --> N[-DdeviceHost=emulation]
    G --> J[-DenvMobile=browserstack]
    G --> K[-DenvMobile=emulator]

```

### Локальный запуск тестов

#### Запуск всех тестов

Для запуска следует открыть IntelliJ IDEA и выполнить в терминале:

```
gradle clean test
```

#### UI

```
gradle clean ui
```

#### API

```
gradle clean api 
```

#### Mobile

```
gradle clean mobile -DdeviceHost=${DEVICEHOST} -DenvMobile=${ENV_MOBILE}
```

Тесты можно запустить в в облачной
платформе <a target="_blank" href="https://www.browserstack.com/"> Browserstack </a>, для этого нужно указать:

<code>-DdeviceHost=browserstack</code>
<code>-DenvMobile=browserstack</code>

Так же тесты можно запустить в эмуляторе, созданном средствами Appium Server & Appium
Inspector. <br/> <a target="_blank" href="https://autotest.how/appium-setup-for-local-android-tutorial-md"> Инструкция
по
настройке </a>

Для запуска мобильных тестов нужно определить следующие значения deviceHost и envMobile:

<code>-DdeviceHost=emulation</code>
<code>-DenvMobile=emulator</code>

<details>
   <summary>Дополнительные команды:</summary>

1. Выполнить запрос на формирование отчета:

```
gradle allureReport
```

2. Открыть отчет в браузере:

```
gradle allureServe
```

</details>

### Удаленный запуск тестов

Тесты можно запустить из терминала IntelliJ IDEA, а выполнены они будут в удаленно запущенном браузере в
Docker-контейнере Selenoid:

```
gradle clean test -Denv=remote
```

Параметры, которыми можно управлять:

```
-Dbrowser - наименование браузера. По умолчанию chrome
-Dbrowser_version - номер версии браузера. По умолчанию 122.0
-Dbrowser_size - размер окна браузера. По умолчанию 1980x1080
-DbaseUrl - по умолчанию https://pyrus.com/
-Dremote_url - адрес удаленного сервера, на котором будут запускаться тесты
```

<a id="jenkins"></a>

## <img height="25" src="data/images/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/BorovikA_diplom_pyrus/)</a>

### По результатам каждого запуска тестов в Jenkins создается Allure отчет с подробной информацией по каждому пройденному тесту.

<details>

Для запуска сборки необходимо перейти в раздел `Build with Parameters` и нажать кнопку `Build`.
Сборка с параметрами позволяет перед запуском задать нужные параметры для сборки:

<img src="media/screenshot/jenkins.png">

</details>

<a id="allure"></a>

## <img height="25" src="data/images/Allure.svg" width="25"/></a> <a name="Allure"></a>Интеграция с [Allure Report](https://jenkins.autotests.cloud/job/BorovikA_diplom_pyrus/allure/)</a>

### По результатам каждого запуска тестов в Jenkins создается Allure отчет с подробной информацией по каждому пройденному тесту.

<details>

Диаграммы прохождения тестов

`ALLURE REPORT` - отображает дату и время теста, общее количество запущенных тестов, а также диаграмму с процентом и
количеством успешных, упавших и сломавшихся в процессе выполнения тестов <br/>
`TREND` - отображает тенденцию выполнения тестов для всех запусков <br/>
`SUITES` - отображает распределение тестов по сьютам <br/>
`CATEGORIES` - отображает распределение неудачных тестов по типам дефектов

<img src="media/screenshot/allure.png">

#### Развернутый результат прохождения тестов:

1. Общий список автотестов
2. Содержание автотеста
3. Вложения <img src="data/screenshot/allure_suites.png">

</details>

<a id="allure-testops"></a>

## <img height="25" src="data/images/Allure_TO.svg" width="25"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/4316/">Allure TestOps</a>

### Полная статистика по прохождению тест-кейсов, отчёты и приложения к ним хранятся в Allure TestOps(запрос доступа admin@qa.guru).

<details>

Пример тест кейсов в Allure TestOps

<img src="media/screenshot/allure_testOps.png">

</details>

<a id="jira"></a>

## <img height="25" src="data/images/Jira.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1290">Jira</a>

### Реализована интеграция Allure TestOps с Jira, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона

<details>
В Jira создана задача HOMEWORK-1290

В разделе `Allure:Test Cases` отображаются интегрированные автоматизированные и ручные тесты

<img src="media/screenshot/jira.png">
</details>

<a id="telegram"></a>

## <img height="25" src="data/images/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота

### Бот, созданный в Telegram, после завершения сборки отправляет сообщение с отчетом о прохождении тестов

<details>
<img src="media/screenshot/telegram.png">
</details>

<a id="video"></a>

## <img height="25" src="data/images/Selenoid.svg" width="25"/></a>Видео запуска тестов в Selenoid
<details>

### К каждому UI-тесту в отчете прилагается видео

<img title="Selenoid Video" src="media/video/ui.gif" width="550" height="350"  alt="video">   

### К каждому мобильному тесту, выполняемому в Browserstack, к отчету прилагается видео

<img title="Selenoid Video" src="media/video/mobile.gif" width="550" height="350"  alt="video">   

</details>