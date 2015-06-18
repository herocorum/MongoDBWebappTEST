# MongoDBWebappTEST

CRUD Application with MongoDB 

Firstly Index.jsp need to be run and ListUser.jsp page shows us db records if
exist we can delete and update person records if it is not we can create.There is an CAPTCHA validation also for person creation.
It use Google API and I wrote verification class 
for creating part only.Whenever we try to do CRUD operation,each of it ,popup will make user sure or not 
during AJAX request it shows loading GIF and if response is successful or not it will show us the result with alert box
after we close or escape the pop up ListUser.jsp page will be refleshed.So we can see every changes.

In this project I tried to use Spring4 benefits so I made all configurations with java classes
but also I did xml base configuration and when it is worked out  I disabled that configuration
by deleting web.xml  so I did my config with Annotations

I created a Entity object named with Person and I created id,name,lastName fields for that object .
I created unique id and I used it to reach the person which we need . 
After I created an DAO and Service layer and this service do CRUD operations ,
I reached from controller and servlet classes named with PersonController.class ve AddPersonServlet.class ,

in view part my Index.jsp called ListUser.jsp file which is under WEB-INF/views/ListUser.jsp which is defined 
in configurations .

After I finished to design ListUser.jsp about javascript codes (I also used jquery library )
I passed to unit,functional and integration tests I wrote very simly test cases 


(if we want to run test classes enable AbstractMongoDbTest becuase Maven try to run this class)

Have a nice day 
Tayfun ÇELİK





