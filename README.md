# MoscowExchange

### Требуемое ПО

Для сборки и запуска проекта требуются:
- [Java 11 (Open JDK)](https://openjdk.java.net/projects/jdk/11/)
- [Apache Maven 3.3+](https://maven.apache.org/)
- -[Apache-tomcat-9.0.31]

### Запуск приложения

Для развертывания приложения:
- Поместите базу данных [db_MoscowExchange](https://github.com/niker68/MoscowExchange/blob/master/db/db_MoscowExchange) в Apache-tomcat-x.x.x/bin/db
- Разверните [war-архив](https://github.com/niker68/MoscowExchange/blob/master/out/artifacts/MoscowExchange/MoscowExchange.war) в Apache-TomCat.

### Интерфейс

  
## Контакты
  Created by [@niker68](mailto:niker68@yandex.ru)

Приложение парсит xml файлы ценных бумаг и истории сделок с ними, полученные с московской фондовой биржи, добавляет полученные данные в бд, сохраняя связи между ценной бумагой и историей сделок по ней.
У данного приложения есть веб-интерфейс, который отображает список ценных бумаг в базе, позволяет посмотреть историю по ним, загрузить данные из приложенных тестовых файлов, загрузить другие файлы в определенном виде, вручную добавлять и удалять ценные бумаги.
При запуске на локальном сервере стартовая страница /home.
