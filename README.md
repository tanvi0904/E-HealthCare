# E-HealthCare

A HealthCare WebApp created using JSP while following OOPs principles. The WebApp can be used by Healthcare specialists as well as patients depending on the user role. 

Having separate Views for each webpage to follow the MVC architecture.
To run this one needs to have Apache Tomcat servers running locally.

Running the following commands
dir /s /b * .java > sources.txt && javac -cp WEB-INF\lib\* -d WEB-INF\classes @sources.txt

jar -cvf myapp.war *

copy myapp.war C:\xampp\tomcat\webapps

This should establish the connection of the web app with the localhost and it should start running
The landing page

![image](https://github.com/UtkarshBagaria/E-HealthCare/assets/79400700/8f06efeb-6799-485a-acf6-3c1227e88752)


Patient Dashboard

![image](https://github.com/UtkarshBagaria/E-HealthCare/assets/79400700/50bbf3bf-fbd5-4957-af41-78a2779dda71)


Doctor Dashboard

![image](https://github.com/UtkarshBagaria/E-HealthCare/assets/79400700/335efd41-80b2-4795-bb9d-6eb60795481b)


Admin Dashboard

![image](https://github.com/UtkarshBagaria/E-HealthCare/assets/79400700/b34e0c74-2199-44e1-9a43-32b8aa4c9808)


While the front end is coded using JSP, the Model connects the application the DataBase in MySQL.
The following tables are created beforehand.

![image](https://github.com/UtkarshBagaria/E-HealthCare/assets/79400700/9e67c494-754f-4ba3-94ee-51bc35f1cce7)


