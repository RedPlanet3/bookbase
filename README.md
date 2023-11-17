# bookbase

## Web-сервис “Библиотека”.
  
Данные по книгам и авторам  хранятся в БД в виде 3-х таблиц book, author и book_author (таблица связи). 
У книги может быть несколько авторов. В есть колонка идентификатор id, ориентируясь на требования к API. 
К проекту приложен скрипт для создания таблиц в виде файла init.sql


**ПО:**
-   Java 11
-   Maven
-   Spring 
-   Hibernate
-   REST
-   JSP
-   БД PostgreSQL 14

  
**Описание endpoints:**

 
**GET /books** – получение списка книг<br>
Данный endpoint выводит в браузере список книг

**GET /authors** – получение списка авторов<br>
Данный endpoint выводит в браузере таблицу со списком авторов с использованием jsp.

**POST /authoradd** – добавление автора в БД<br>
Данный endpoint добавляет в БД автора и выводит обновленный список всех авторов в браузере с использованием jsp.

**GET /updateAuthor** – изменение автора по ID<br>
Данный endpoint ищет по ID автора из соответствущей строки в браузере с нажатой кнопки "Update", выводит его данные на экран и сохраняет в уже существующую запись новые данные.

**GET /deleteAuthor** – удаление автора<br>
Данный endpoint ищет по ID автора из соответствущей строки в браузере с нажатой кнопки "Delete" и отображает измененный список авторов.

**GET /api/authors** - возврат списка авторов<br>
Данный endpoint возвращает информацию по всем авторам в формате JSON

**GET /api/authors/{id}** возврат информации по автору по его ID в формате JSON<br>
Данный endpoint ищет автора по его id, если id не найден в базе возвращается ошибка в формате JSON с информацией о некорректном id. 

Добавлен механизм логирования @Aspect.