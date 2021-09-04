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

![image](https://user-images.githubusercontent.com/62865086/132087163-08425503-d330-423b-8073-55ac2b6e3c7e.png)




click to the sign in button if your customer id and password same as database then you can visit to the home page. Otherwise 2 seconds later it you redirect to you in this page again. To do that i used interceptor directory where have two method prehandler,and addinterceptors in the log-in interceptor class and mvcConfig class. Home page picture is given below. 
homepage 

![image](https://user-images.githubusercontent.com/62865086/132087217-ffbdf198-97eb-4f80-8d26-66b970c03b21.png)




![image](https://user-images.githubusercontent.com/62865086/132087221-f64644b1-b657-4bac-8355-55178cc34e45.png)


 for this page which one is the home page for a user, here i read all the data from the database, to do that i had to create a java class inside bean package the class name is movie.java this class use for mapping data and i had application.yml to connect workbench to my project. Here i have use mybatis configuration.After that i create a movie mapper interface that did coordination with movieServie class in the service directory, then i created a movieController inside controller directory, i created method getMovieByTitle to retrieval all of the  data from a data the database. Where i show data in the client side, then i used thymeleaf one page application. 

Follow this procedure just create new methods i got data for the movie details page.


![image](https://user-images.githubusercontent.com/62865086/132087241-e1b2d376-7780-4660-a7f1-f985633dee80.png)

![image](https://user-images.githubusercontent.com/62865086/132087244-071bfa8c-665e-4dd8-86dd-bfee5527571d.png)

 Following same procedure like create class cart class inside bean and create cartController class under controller directory and create mapper interface under mapper directory, create a method in the carController, i fetch data from the database.



Same thing for the order page as well. Order page image is given below. 

![image](https://user-images.githubusercontent.com/62865086/132087254-f04455ab-5868-4995-aeed-4f7b4cfdaec3.png)


![image](https://user-images.githubusercontent.com/62865086/132087259-bbaccd8c-2dbf-4576-8bcf-8832947ecce6.png)



![image](https://user-images.githubusercontent.com/62865086/132087264-ae76e7fd-7b3f-4dfb-b3d6-46013ca4a696.png)




![image](https://user-images.githubusercontent.com/62865086/132087272-5fe0b7c3-b7c6-4cea-b517-91c92be94333.png)







