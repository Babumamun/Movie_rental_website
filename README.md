# Movie_rental_website

To make this website i have to use some key knowledge such as:
Theymleaf 
Html5
CSS
bootstrap
JavaScript 
JSP
Annotation 
Mybaits 
Mysql 
CRUD
Let me explain how did my project create

login page 





click to the sign in button if your customer id and password same as database then you can visit to the home page. Otherwise 2 seconds later it you redirect to you in this page again. To do that i used interceptor directory where have two method prehandler,and addinterceptors in the log-in interceptor class and mvcConfig class. Home page picture is given below. 
homepage 









 for this page which one is the home page for a user, here i read all the data from the database, to do that i had to create a java class inside bean package the class name is movie.java this class use for mapping data and i had application.yml to connect workbench to my project. Here i have use mybatis configuration.After that i create a movie mapper interface that did coordination with movieServie class in the service directory, then i created a movieController inside controller directory, i created method getMovieByTitle to retrieval all of the  data from a data the database. Where i show data in the client side, then i used thymeleaf one page application. 

Follow this procedure just create new methods i got data for the movie details page.





 Following same procedure like create class cart class inside bean and create cartController class under controller directory and create mapper interface under mapper directory, create a method in the carController, i fetch data from the database.



Same thing for the order page as well. Order page image is given below. 









