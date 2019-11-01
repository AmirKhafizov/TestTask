1)Склонировать репозиторий
2)Зайти в папку с проектом используя командную строку
3)Ввести команду mvn clean package
4)Ввести команду java -jar /target/project-name.jar
5)Зайти в Postman (https://www.getpostman.com/downloads/)
6)В поле "Enter Request URL" введите "http://localhost:8080/horse/rest/count?start=A1&end=B2&height=8&width=8"
 или "http://localhost:8080/horse/servlet/count?start=A1&end=B2&height=8&width=8"
 start=A1 - точка старта
 end=B2 - конечная точка
 height=8 - высота шахматной доски(цифры)
 width=8 - ширина шахматной доски(заглавные латинские буквы)
7) нажмите кнопку Send