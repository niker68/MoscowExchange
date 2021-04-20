# MoscowExchange

Приложение парсит xml файлы ценных бумаг и истории сделок с ними, полученные с московской фондовой биржи, добавляет полученные данные в бд, сохраняя связи между ценной бумагой и историей сделок по ней.  
У данного приложения есть веб-интерфейс, который отображает список ценных бумаг в базе и позволяет:
- Посмотреть историю сделок по ценным бумагам
- Загрузить данные из приложенных тестовых файлов xml или файлов xml такого же вида, полученных с сайта Московской Фондовой Биржи
- Вручную добавлять и удалять ценные бумаги.

### Требуемое ПО

Для сборки и запуска проекта требуются:
- [Java 11 (Open JDK)](https://openjdk.java.net/projects/jdk/11/)
- [Apache Maven 3.3+](https://maven.apache.org/)
- [Apache-tomcat-9.0.31](https://tomcat.apache.org/)

### Запуск приложения

Для развертывания приложения:
- Поместите базу данных [db_MoscowExchange](https://github.com/niker68/MoscowExchange/blob/master/db/db_MoscowExchange) в Apache-tomcat-x.x.x/bin/db
- Разверните [war-архив](https://github.com/niker68/MoscowExchange/blob/master/out/artifacts/MoscowExchange/MoscowExchange.war) в Apache-TomCat.
- В браузере домашняя страница приложения адрес_на_котором_вы_развернули_приложение/home 

<img src="https://github.com/niker68/MoscowExchange/blob/master/media/2021-04-20_13-49-06.png" width="953" height="469" /> 
<img src="https://github.com/niker68/MoscowExchange/blob/master/media/2021-04-20_13-49-37.png" width="959" height="469" /> 
  
## Контакты
  Created by [@niker68](mailto:niker68@yandex.ru)

