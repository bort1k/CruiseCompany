Task
8. Система Круизная Компания. У Компании имеется несколько
Кораблей. У Кораблей есть пассажиро-вместимость, маршрут, количество
посещаемых портов, длительность одного круиза, персонал. Клиент
выбирает и оплачивает круиз. Выбирает Экскурсии по прибытии в порт за
дополнительную плату. Администратор Корабля указывает бонусы для
пассажиров, учитывая класс билета (бассейн, спорт зал, кинозал,
косметические салоны...).

Installing instructions
You need to download project by click Clone or download project.

You can download zip or clone project , just write in git bush console git clone 
https://github.com/bort1k/CruiseCompany.git

Launching instruction
To run this app you should have installed Java and Maven on your local machine.

Launch cruise_company_en.sql from resources/database at your sql server
At src/main/resources/database.properties change properties for your sql server
Open console and specify path to project
Write mvn clean tomcat7:run
Open your browser and in the url write http://localhost:8082/eden-cruises/
