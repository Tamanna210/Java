# Java Bootcamp

Banuprakash C

Full Stack Architect, Co-founder Lucida Technologies Pvt Ltd., Corporate Trainer,

Email: banuprakashc@yahoo.co.in

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/Java

===================================

Softwares Required:
1) Java 8+
	https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html

2) Eclipse for JEE  
	https://www.eclipse.org/downloads/packages/release/2020-03/m1/eclipse-ide-enterprise-java-developers

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i <container_name> /bin/bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

```
======================================================================

OOP ==> Object Oriented Paradigm

Object contains state and behaviour

Tv --> State is on/off, channel, volume
	--> Actions/ Behaviour

Account --> State ==> Balance
	Behaviour ==> Credit / debit / interest Rate

Message thro interface

==> Abstraction

--------------

SOLID design principle

S --> Single Responsibility [Object to communitate with persistent layer [ CRUD]; should not handle UI]

O --> open Close Principle [ Closed for Change; open for extension]

L --> Liskov Substitution Principle

I --> Interface seggregation

D --> Dependency Injection [ Inversion Of Control ]

=======================================================

Java --> Technology

--> Platform to execute bytecode

Bytecode?

Source Code ==> Compile ==> bytecode

Groovy ==> Groovyc ==> bytecode
Kotlin  ==> KotlinC ==> bytecode
Java ==> javac ==> bytecode ==> JDK

=============

Example.java

public class Example {
	public static void main(String[] args) {
		doTask();
	}	

	private static void doTask() {
		String s1 = new String("Hello");
		String s2 = new String("World");
		System.out.println( s1 + s2);
		System.out.println("Bye!!!");
	}
}


javac Example.java ==> Example.class [ bytecode] ==> platform independent / Architecture neutral

Secondary Storage ==> Classloader ==> Primary Storage

ClassLoader methods:
findLoadedClass()
loadClass()
findSystemClass()
defineClass()


======================================

Person.java ==> javac Person.java ==> Person.class
public class Person {
	private String name;
	private int age;
 	
 	public void setName(String name) {
 		this.name = name;
 	}

 	public int getAge() {
 		return this.age;
 	}
}

Example.java ==> Example.class
public class Example {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("Kim");

		Person p2 = new Person();
		p2.setName("Anna");
			
	}
}



context.behaviour(argument);

p1.setName("kim") ==> setName(p1, "Kim");


======================

Logically grouping of classes/objects for enterprise application

1) Entity classes
	represent business data ==> long lived data; data survives system crash
	Amazon ==> Product, Customer, Order

	Product.java, Customer.java, Order.java

	==> contains fields like email, firstName, lastName, ...
	==> constructor
	==> getters / setters
		getName(), setName(), getAge(), setAge()
	==> equals() and hashCode() for object identifictaion

2) DAO classes ==> Data Access Object
	classes to interact with persistence mechansime like RDBMS / NoSQL like MongoDB	/ file
	CRUD operation
	like for RDBMS
	insert, select, update, delete code

3) Service classes ==> acts like a facade on DAO and business code

4) Exception classes ==> they represent any abnormal condition in application

5) Utility classes ==> helpers [ DateTime Format/ sorting / filtering]

6) UI classes ==> Andriod / Web Tech / Standalone


================


package ==> folder for logically grouping classes


Mac:
cmd + shift + o ==> organize imports

Windows:
cntrl + shift + o ==> organize imports

============================

In C++;

Account acc; // creates object on stack

In Java:
objects are always on Heap area

Reference types: array, object ==> always on heap area

======================

GC ==> Garbage Collector is responsilbe for cleaing up of any unused memory in heap area.

Not required:
delete acc;
free ptr;

System.gc();

Java 11 ==> G1GC

=============================

How many instances of Account are created?
use static variable for this

private static int count;

===

static methods can't access instance variables [ first argument implicit "this" is not passed to the method]
instance methods can access static variables

============================================================================

Relationship between objects:

1) Generalization and Specialization
2) Realization
3) Association
4) Uses A



Generalization and Specialization:

---

Static code analysis --> CI tool Jenkis 

SonarQube ==> FindBugs/ PMD , Checkstyle

CheckStyle ==> Coding conventions
* Naming conventions for class, method, var and constants
* Comments ==> single , multiline and JavaDoc

FindBugs / PMD:
* empty conditional statement
if(condition) {

} else {
	code
}

* empty catch block

try {

}catch(Exception ex){}

* Unreachable code

if(true) {
	return "a";
}

return "b";

* Copy paste code

===

DRY principle ==> Don't Repeat Yourself


Mobile Has a Tata Sky App

Mobile is a Tv

===========================================
"extends" for Generalization and Specialization relationship ==> inheritance

class Product {
	id, name , price
}

// mobile inherits product
class Mobile extends Product {
	connectivity;
	..
}

class Tv extends Product {

}

============

class Object {}

class Product extends Object {
	Product() {
		"p1"
	}

	Product(int id, String name) {
		"p2"
	}
}

class Mobile extends Product {
	Mobile() {
		"m1"
	}

	Mobile(int id, String name, String connectivity) {
		"m2"
	}
}


case 1:
new Mobile(); // p1 & m1

case 2:
new Mobile(52,"iPhone 12", 89000.00); // p1 & m2


With changes:
Mobile(int id, String name, String connectivity) {
		super(id, name);
		"m2"
	}


case 2:
new Mobile(52,"iPhone 12", 89000.00); // p2 & m2


================================

class Product {
	public int getPrice() {
		return 900;
	}

	public int getId() {
		return 100;
	}
}


class Mobile extends Product {
	// override
	public int getPrice() {
		return 555;
	}

	public String getConnectivity() {
		return "4G";
	}
}

Case 1:
Mobile m = new Mobile();
m.getId(); // 100
m.getPrice(); // 555
m.getConnectivity(); // 4G

Case 2:

Product p = new Mobile(); // upcasting ==> valid

p.getId(); // 100
p.getPrice(); // 555 ==> Runtime binding 
p.getConnectivity(); // Compilation ERROR

================================================================

Mobile[]
Tv[]
Microwave[] 

for(Mobile m : mobiles) {

}

for(Tv t : tvs) {

}

for(Microwave m : mws) {

}


============
 
* extends
* super()
* override
* abstract class 
* abstract methods
* Why Upcasting and OCP
* Before downcasting we need to do the typechecking
==> instanceof opertor
==> getClass()


Product p = new Tv();

p instanceof Product ==> true
p instanceof Tv ==> true
p instanceof Object ==> true
p instanceof Mobile ==> false

--

p.getClass() === Tv.class ==> true
p.getClass() === Product.class ==> false

all other conditions fail

=============================================
If we know the method names:

context.behaviour();

p.getId(); ==> getId(p); ==> within getId() "this" refers to "p"
p.getName();

====

Reflection API
m being a pointer to a method:

m.invoke(context);



"Hello".substring(1); // ello

"Hello".substring(1,3); // ell

"getName".substring(3); // Name

==================================================================

* Object is the root of all classes in Java

Object p = new Mobile();

Object p = new Tv();

Object a = new Account();

================

* extends is for inheritance; ==> java doesn't support multiple inheritance

class A extends B, C { // not valid

=============================================================

note on final keyword.

1) to declare a constant

private static final double PI = 3.14159;

2) to prevent inheritance

public final class System {

}

class ESystem extends System { // error

3) to prevent override

class Account {
	final boolean login(String user, String pwd) {///}
}

class SavingsAccount extends Account {
	 boolean login(String user, String pwd) {///}	// error
}


4) constant pointer

final int[] data = {62,22,6};

data[0] = 100; // valid

data = new int[2]; // error

---

final Product p = new Product("iphone", 89000.00);

p.setPrice(982122); // valid

p = new Product(...); // error

================================================

* Realization relationship

One object defines the protocol; other objects are realize them in order to communicate

"interface" used for realization relationship

"interface" can't have state and behaviour;

public interface EmployeeDao {
	void addEmployee(Employee e);
	Employee getEmployee(int id);
}

methods are abstract and public by default

Why program to interface?
* DESIGN
* IMPLMENTATION
* TESTING
* INTEGRATION
* LOOSE COUPLING ==> Switch between strategies
* OCP
---

In development we create entities and interfaces as common modules ==> used by all team members working on different modules.

========================

Task:

* Naming Conventions
* Comments ==> single, multiline and JavaDoc
* Checkstyle plugin for elipse 


====================

Day 2

Recap:
* Object and class
* Genaralization and Specialization
* abstract and final
* override ==> Dynamic binding / Polymorphism
* java.lang.reflect.Method ==> invoke()
* interface [ can't have state; contains public abstract methods]
* Realization relationship

======================================

Zero changes in client:

Android
BookDao bookDao = BookDaoFactory.getBookDao();

Web
BookDao bookDao = BookDaoFactory.getBookDao();

Standalone app
BookDao bookDao = BookDaoFactory.getBookDao();


=============
Make changes in Factory class:
public class BookDaoFactory {
	public static BookDao getBookDao() {
		return new BookDaoMongoDbImpl();
	}
}

=====================================================================

Switch between strategies without any changes in code

* configuration files

Class.forName("java.util.Date"); // load Date class into JRE

Class.forName("com.adobe.prj.entity.Book"); // load Book class into JRE

Class.forName("com.adobe.prj.entity.Book.BookDaoMongoDbImpl");// load BookDaoMongoDbImpl


ResourceBundle.getBundle("com.adobe.prj.dao.config")

ResourceBundle.getBundle("config.properites") // properties.properties in "config" package


BookDao b = (BookDao) new Object(); // downcasting

Object o = new BookDao(); // upcasting

i18N

messages.properties
DONE=Sucesss!!!

messages_hi.properties
DONE=message in hindi

messages_fr.properties
DONE= ....


============================================================

interface Dance {
	void dance();
}

interface Fight {
	void fight();
}

interface Swim {
	void swim();
}

// Actor knows to Dance // realizes to dance
class Actor implements Dance {
	dance() {...}
}

// Hero is a Actor [can dance ] and also knows to fight and swim
class Hero extends Actor implements Fight, Swim {
	fight() {//}
	swim() {//}
}


===========================================================

Generics

class IRectangle {
	int width, breadth;
}

class BRectangle {
	byte width, breadth;
}


class Rectangle<T> {
	T width;
	T breadth;
}


 Rectangle<Integer> r1 = new Rectangle<Integer>(3,4);

 Rectangle<Double> r2 = new Rectangle<Double>(3.2,4.4);

 Rectangle<String> r3 = new Rectangle<String>("A","B"); // valid

===

Generic type can be Object type, not primitive

Integer is a TypeWrapper for int
Float is a TypeWrapper for float
...


class Rectangle<T extends Number> {
	T width;
	T breadth;
}

 Rectangle<Integer> r1 = new Rectangle<Integer>(3,4);

 Rectangle<Double> r2 = new Rectangle<Double>(3.2,4.4);

 Rectangle<String> r3 = new Rectangle<String>("A","B"); // not valid



 class List<T extends Product> {
 	T data;
 }

 List<Mobile>
 List<Tv>
 List<WashingMachine>

 ======================================================


 interface Comparable {
 	int compare(Object other);
 }

 class Mobile implements Comparable {
 	public int compare(Object other) {
 		Mobile m = (Mobile) other;
 		/.
 	}
 }
 

 class Book implements Comparable {
 	public int compare(Object other) {
 		Book b = (Book) other;
 		/.
 	}
 }


 ========================


 interface Comparable<T> {
 	int compare(T other);
 }

 class Mobile implements Comparable<Mobile> {
 	public int compare(Mobile other) {
 	 	
 	}
 }
 

 class Book implements Comparable<Book> {
 	public int compare(Book other) {
 	}
 }

 =============================================================

 interface WindowListener {
 	windowOpen();
 	windowClose();
 	windowResize()
 	windowMinimze();
 	windowMaximze();
 }

 public abstract class WindowAdapter implements WindowListener {
 	windowOpen() {}
 	windowClose() {}
 	windowResize() {}
 	windowMinimze() {}
 	windowMaximze() {}
 }

// anonymouos class
 new WindowAdapter() {
 	windowOpen() {
 		// logic
 	}
 }

========================



 interface Flyable {
 	void fly();
 }


 Flyable f = new Flyable(); // Not valid

class Dummy implements Flyable {
	public void fly() {
		jumping with wings from 10th floor
	}
}


// Anonymous class
Flyable f = new Flyable() {
	public void fly() {
		jumping with wings from 10th floor
	}
}

class ==> if state and behaviour exists

class Bird implements Flyable {
	name; color; age; 
	eat() {}
	sound() {}
	fly() {}
}

eagle = new Bird();
sparrow = new Bird();


class AeroPlane implements Flyable {
	name; seating; power
	fly() {}
}


// i can pass bird, aeroplane or my anonymous class
void travel(Flyable f) {

}

===========================================

Builtin @FuntionalInterface

1) Predicate
@FunctionalInterface
public interface Predicate<T> {
	   boolean test(T t);
}

2) Comparator
@FunctionalInterface
public interface Comparator<T> {
	int compare(T o1, T o2);
}

3) Consumer
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

4) Function
@FunctionalInterface
public interface Function<T, R> {
	 R apply(T t);
}

5) Bifunction

===============================================================

Java Collection Framework

--------------------------

provides solution for datacontainers [ Data Structures]

* Array is a data container

JCF:
* interfaces
* implmentations
* Algorithm classes [ sort, max, min, binarySearch... , reverse, ...]

--

Comparable ==> Natural comparsion, logic is a part of object itself [ Primary Key]
Comparator ==> client specific way of compare, logic is in client code

public class Product implements Comparable<Product> {
	id, name, category, quantity, price;
	 public int compareTo(Product o) {
	 	// based on id
	 }
}

===

Client 1:

Comparator c1 = new Comparator() {
	int compare(o1, o2) {
		return price diff
	}
}


Comparator c2 = new Comparator() {
	int compare(o1, o2) {
		return quatity diff
	}
}

=====================================
Array --> limitations 

List is a data container.
* ordered
* duplicates
* index based operations supported [ get(29), add("a", 4); remove(10)]
* re-order [ sort , shuffle, reverse , ..]


List interface:
--> LinkedList [ no need for contiguos memory, adding and remove from arbitrary position is easy]
	Disadvantage: each data adds 8 bytes extra [ prev and next pointer]
	* AAdhar project
--> ArrayList
	--> like array; can grow or shrink
--> Vector (legacy)
--> Apache Commons Collection
--> Vavr ==> vavr.io

=============
Avoid:

List list = new ArrayList();
List list = new LinkedList();

list.add("a");
list.add(new Product());
list.add(new Date());

if(list.get(0) instanceof String) {
	String s = (String) list.get(0);
}

Better:

List<String> list = new ArrayList<String>(); 

String s = list.get(0);

============================================



Stream: sequence of data flowing from a channel

on Stream we can use the following HOF ==> High Order Functions

HOF ==> functions which accept other function as arguments / function return a function [ treat function as first-class member
like object or primitive]

* HOF 
1) filter
2) map
3) forEach
4) reduce
5) flatMap
 
https://rxmarbles.com/



Intermediary operations
filter
map
flatMap


Terminal operations
forEach()
collect()
reduce()

Data won;t flow if there are no Terminal operations

* Streams are lazy ==> only on connecting terminal operation ==> data flow


reduce() to get aggreate ==> sum(), count(), avg(), max(), min()

=====================

Task 1:
data

Input:
[6,3,11,20,25,10]

Get sum of even number


Task 2:
Read basics of Exception handling in Java

==========================================================

Day 3

Streams and Collections


int x = 10;
int y = 10;

x == y // true

Object equality: [ == vs equals()]

String s1 = new String("hello");
String s2 = new String("hello");

s1 == s2 // false ==> compares address locations

s1.equals(s2); // true

Rectangle r1 = new Rectangle(4,5);

Rectangle r2 = new Rectangle(4,5);

Rectangle r3 = r1; // reference

r1 == r3 // true

r1 == r2 // false

r1.equals(r2); // should evalute to true

Object.java
public boolean equals(Object obj) {
        return (this == obj);
}

================

Set is a data container like List
* unique elements
* not ordered
* index based operations are not supported
* can't re-order [ sort, shuffle, reverse --> not supported]

HashSet
	uses hashCode() and equals() to identify duplicate elements and placing element in container

HashCode:
* numerical value for a object
* similar objects should have same hashcode
* objects which are not similar can also have same hashcode

Read TreeSet [ with Comparable and Comparator ]
Red Black Tree

==================================

Map ==> stores data in key/value pair format
Key has to be unique; value can be duplicate

* Dictionary
* Registry

HashMap

==========

mbs.forEach(System.out::println); // method reference

mbs.forEach(p -> System.out.println(p)); 


===================================================

Docker is a set of platform as a service products that use OS-level virtualization to deliver software in packages called containers.


=============


$ docker exec -it local-mysql bash
# mysql -u "root" -p
Enter Password: Welcome123

mysql> create database java_bootcamp;
mysql> use java_bootcamp;

Create a table:

mysql> create table products(id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, quantity int);

mysql> desc products;

mysql> select * from products;


=======================================================================

JDBC ==> Java Database Connectivity ==> integration librarires for RDBMS [ MySQL / Oracle/ Postgres ..]

Java provides only interfaces; implmentation classes are provided by database vendors

String title; --> MySQL --> VARCHAR ; ORacle--> VARCHAR2 --> SQL Server --> Text

Date date;

rt.jar ==> provided by JDK

mysql-connector.jar
ojdbc.jar
postgress.jar 
...

----

Steps:

1) load database vendor classes into JVM
	Class.forName("driver");

	Class.forName("oracle.jdbc.Driver"); 
	Class.forName("com.mysql.jdbc.Driver"); 


2) Establish database connection:

	// Java application uses JDBC to connect to database
	Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

	DriverManager.getConnection() is a factory method
	Based on URL it creates OracleConnection / MySqlConnection ...

	URL
	jdbc:mysql://192.168.22.12:3306/java_bootcamp

	jdbc:oracle:thin:@198.33.112.4:1521:java_bootcamp


3) Interact/ send SQL with DB
	3 interfaces are avaialble to interact with database

	a) Statement
		if SQL is fixed ; all users same sql; SQL is not dependendent on IN parameters
		select * from products

	b) PreparedStatement
		ParameterizedStatement' Pre-compiled statement

		select * from users where username = ? and password = ?

		select * from products where id = ?


	c) CallableStatement

		Database can have StoredProcedures / functions:

		CREATE PROCEDURE calculateRent(vehicleId IN NUMBER, rentAmount OUT NUMBER) AS rentDuration NUMBER;
  		BEGIN
    
    		SELECT (return_date - rent_date) into rentDuration FROM vehiclerent
    		WHERE vehicle_id = vehicleId;
    	    rentAmount := rentDuration * 50;
  		END;	

  		to call storedProcedure from JAva we use CallableStatement

  		call({calculateRent(..)})

 4) ResultSet

 	ID  | NAME | PRICE
 	10     A    450.22
 	11     B    7820.22


 	REsultSet is a pointer/cursor to fetched records based on select statement

 	ResultSet rs = statement.executeQuery("select id, name, price from products");

 	boolean rs.next(); 

 	while(rs.next()) {
 		rs.getInt("ID")
 		rs.getString("NAME")
 		rs.getDouble("PRICE");
 	}

 5) always close connection in finally block

 	try {

 	} catch(SQLException ex) {

 	} finally {
 		con.close();
 	}

===

ResultSetMetaData can be use to identity column count and column names and types

======================================================

Java Build Tools to manage dependencies
1) Maven
2) Gradle
3) ANT

Maven is a build automation tool used primarily for Java projects. Maven can also be used to build and manage projects written in C#, Ruby, Scala, and other languages. 
Maven manages dependecies ==> pom.xml

pom.xml ==> Project Object model
* place where dependencies are configured
* goals are configured [ test, build , run, code analysis]

Maven projects ==> standard ==> can be imported and used in various IDEs

=====================

class PersistenceException extends Exception {
	..
}

interface UserDao {
	register(User u) throws PersistenceException
}

class UserDaoMongoImpl implements UserDao {
	register(User u)  throws PersistenceException {
		 try {
		 		// code
		 	} catch(MongoException ex) {
		 		throw new PeristenceException("User registration failed...")
		 	}
	}
}


class UserDaoDatabaseImpl implements UserDao {
	register(User u)  throws PersistenceException {
		 	try {
		 		SQL
		 	} catch(SQLException ex) {
		 		throw new PeristenceException("User registration failed...")
		 	}
	}
}

===

 Exceptions:
 	1) What went wrong? SQLSyntaxException
 	2) Where? line class method
 	3) Why?  Unknown column 'nasme'

 ===================================

 Web application Development

 Servlet Container / Web Container can host Servlet

 * Servlets are server side Java application

Popular Servlet containers
* Tomcat
* Jetty
* WildFly

===================

Request objects -> encapsulates all data from client ==> form data / browser data / os data
Response Object --> used to write the data back to client

HTTP methods:

GET
POST
PUT
DELETE
PATCH
OPTIONS

* GET
request from addressbar and hyperlinks are GET requests
--> to fetch data / READ
--> can send data to server --> data goes in URL and not payload

* POST
generally form data is POST
sends the data in payload / body

GET
http://localhost:8080/register


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {

	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
	}
	public void doDelete(HttpServletRequest req, HttpServletResponse res) {
		
	}
}


===============

Servlet API 3.5

Prior to Servlet 2.5

Deployment descriptor was web.xml

<servlet>
	<servlet-name>A</servlet-name>
	<servlet-class>com.adobe...RegisterServlet</servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name>A</servlet-name>
	<url-pattern>/register</url-pattern>
</servlet-mapping>

=================================

Run As ==> Maven build

Goals : package

Building war: C:\Trainings WS\Adobe Bootcamp\Java\database\target\database-1.0.0.war

take this war file onto any server and deploy

http://localhost:8080/database/


====


Step 1:
Run As ==> Maven build

Goals : package

this checks
<package>war</package>
default is "jar"

since package is mentioned as "war" looks for "plugin"

<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<version>2.3</version>
				<configuration>
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
</plugin>


creates : Building war: C:\Trainings WS\Adobe Bootcamp\Java\database\target\database-1.0.0.war

I can deploy this on any server

Step 2:
To write servlets we need servlet API

<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
</dependency>


Step 3:
Instead of having server installed we can have a server plugin handled by Maven

<plugin>
				<groupId>org.eclipse.jetty</groupId>
				<artifactId>jetty-maven-plugin</artifactId>
				<version>9.3.7.v20160115</version>
</plugin>


Run As ==> Maven build
Goals: jetty:run 

http://localhost:8080/

see index.html in "src/main/webapps" folder


==========================


index.html
addProduct.html

doPost() ProductServlet

===============

Goals: compile ==> javac
Goals: clean ==> delete .class files
Goals: package ==> jar or war
Goals: jetty:run
Goals: tomcat:run

===================

https://maven.apache.org/download.cgi

$ mvn clean package

$ mvn jetty:run

==========================

Day 4

Recap:
Maven build tool
* dependency [ "jar" files ]
	a.jar ==> b.jar ==> c.jar => trasitive dependencies

 pom.xml
 	<dependency>
 		<groupId>mysql</groupId>
 		<artifactId>mysql-connector.jar</artifactId>
 		<version>5.1.27</version>
 	</dependency>

 	Local repo [.m2] ==> Remote Respoisitry [ Adobe proxy server ] ==> Central Repository [ CDN ]


 pom.xml is what is shared and used by all team members



 Maven Goals:

 	 plugin
 	maven-compiler-plugin
 		source / output ==> 1.8


* mvn compile

Run As ==> Maven Build ==> Goal: compile


* mvn package
Run As ==> Maven Build ==> Goal: package

pom.xml
1)	<package>jar</package>

	Maven creates "jar" file for the project

2) <package>war</package>
	
	maven-war-plugin

	Maven creates "war" file for the project ==> can be deployed on server

	"war" can be taken to "jboss", "apache", "weblogic", "websphere", "glassfish" 

3) jetty-plugin
	plugin for web server ==> good for testing

	mvn jetty:run

	Run As ==> Maven Build ==> Goal: jetty:run

	war is deployed on 'jetty' server configured as plugin; jetty server starts on port 8080 by default

------------

"jar", "war", "ear" , "sar", "pom"

======================================================

Web Server ==> handles http request

Web Container / Servlet Container ==> to run Servlet [ server side java code] ==> dynamic content


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

http://localhost:8080/products

GET, POST, PUT, DELETE

address bar or hyperlink ==> GET request


Query Parameter
http://google.com?search=java

request.getParameter("search");

=============================



Exception handling

1) any exception which can be handled using conditional statement don't use try catch

Product p;

p.setName("Dell"); // NullPointerException

public void addProduct(Product p) {
	if(p ! = null) {
		p.getName();
	}
}

Avoid:


public void addProduct(Product p) {
	try {
		p.getName();
	} catch(NullPointerException ex) {

	}
	}
}

============================================================

Checked and Unchecked exceptions

Unchecked exceptions ==> exceptions which happen for reasons within JRE
NullPointer, ArithmeticException [ / 0], IndexOutOfBoundsExceptions, ClassCastException


int[] data = [5,2,11];

int val = data[9]; //IndexOutOfBoundsExceptions

==
Checked Exceptions

==> happen due to reasonse outside JRE

Class.forName("...")

====

JSP ==> Java Server Pages

static + dynamic content

JSP --> Servlet


${product.id} ===> product.getId()

${product.desc}  ==> product.getDesc()

===================

Web application devlopment ==> Frameworks "jersey" / "play"  "spring mvc"

=========================================================================================


Spring Framework and Hibernate Framework ==> Spring Boot


Spring Tool Suite

Help ==> Eclipse Market place ==> STS ==> Go

Spring Tools 4 (aka Spring Tool Suite) 4.15.1.RELEASE


===================================

Bean ==> reusable software component

Bean ==> object managed by spring container

Spring Framework

* provides a lightweight container for building enterprise application

Core Container provides 
1) Lifecycle managment of beans [ spring creates / destroys objects]
	new ProductDaoJdbcImpl(); // won't do this
2) Dependency Injection

Metadata 
1) XML
2) Annotation

public interface EmployeeDao {
	addEmployee()
}

public class EmployeeDaoJdbcImpl implments EmployeeDao {
	addEmployee() {}	
}


public class EmployeeDaoFileImpl implments EmployeeDao {
	addEmployee() {}	
}

EmployeeDao file = new EmployeeDaoFileImpl(); // not required

public class AppService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao edao) {
		this.employeeDao = edao;
	}

	public void doTask() {
		employeeDao.addEmployee();
	}
}


---

beans.xml

<bean id="jdbc" class="pkg.EmployeeDaoJdbcImpl" / >
<bean id="file" class="pkg.EmployeeDaoFileImpl" / >

<bean id="service" class="pkg.AppService">	
	<property name="employeeDao" ref="jdbc" />
</bean>

ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

ctx.getBean("service");


=========

Spring creates objects of classes which has one of these annotations:
1) Component
2) Repository
3) Service
4) Controller
5) RestController
6) Configuration



public interface EmployeeDao {
	addEmployee()
}

@Repository
public class EmployeeDaoJdbcImpl implments EmployeeDao {
	addEmployee() {}	
}


@Service
public class AppService {
	@Autowired
	private EmployeeDao employeeDao;
 
	public void doTask() {
		employeeDao.addEmployee();
	}
}


ApplicationContext ctx = new AnnotationConfigApplicationContext();


ctx.getBean("appService");


=================

Spring Boot ==> framework on top of Spring framework
Highly Opiniated framework

* easy to develop using Spring boot
* lots of configurations comes out of the box
for example:
1) if we are devlopping web applications
--> Tomcat embedded server is provided as plugin
--> war plugin
--> handling JSON 

2) if we are connecting to database
--> database connection pool comes out of the box
--> just provide driver, url. user, password in "application.properties"
--> Hikari library for connection pool

.........

https://start.spring.io



SpringApplication.run(DemoApplication.class, args);
@SpringBootApplication
 --> @ComponentScan("com.example.demo")
 	==> scan for aboe mentioned 6 annotations from this package onwards and create instances of
--> @EnableAutoConfiguration
	==> create datasource / Tomcat / built-in beans

--> it is @Configuration	
same as

ApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.scanPackages("com.example.demo");

===================

Problem --> 2 beans of EmployeeDao

Solution 1:
Mark one of the bean as @Primary

@Repository
@Primary
public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("added in database!!!");
	}

}


Solution 2:
use @Qualifier


@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("added in database!!!");
	}

}


@Repository
public class EmployeeDaoFileImpl implements EmployeeDao {

	@Override
	public void addEmployee() {
		System.out.println("file code...");
	}

}


@Service
public class AppService {
	@Autowired
	@Qualifier("employeeDaoJdbcImpl")
	private EmployeeDao empDao;
	
	public void doTask() {
		empDao.addEmployee();
	}
}


==============


Solution 3:

using @Profile


@Repository
@Profile("dev")
public class EmployeeDaoFileImpl implements EmployeeDao {


@Repository
@Profile("prod")
public class EmployeeDaoJdbcImpl implements EmployeeDao {



@Service
public class AppService {
	@Autowired
	private EmployeeDao empDao;
	
3.1)
application.properties
spring.profiles.active=dev

or

spring.profiles.active=prod


3.2)

application.properties ==> no entries

Run As ==> Run Configurations ==> Arguments => Program Arguments 
--spring.profiles.active=dev

======================================================================

Spring Modules:
1) Core Module
2) Database Integration Module
 2.1) jdbc
 2.2) ORM
 2.3) Transactions
 2.3) ODM
 ...
3) Spring Web
	building Servlet based applications

4) AOP [ pending....]

------------

ORM ==> Object Relational Mapping ==> Java Object is mapped to RDBMS table

* Hibernate
* TopLink
* Kodo
* OpenJPA


@Entity
@Table(name="products")
public class Product {

	@Id
	private int id;
	
	private String name;
	
	@Column(name="amount")
	private double price;
	
	@Column(name="qty")
	private int quantity;



Product p = new Product(13, "sdf", 343, 22);

save(p); // insert into products (id, name, amount, qty) values (? , ? ,? , ?)

findById(Product.class , 12); // select from products where id = 12


@Entity
@Table(name="customers")
public class Customer {
	@Id
	private String email;

}

=============

Spring Boot Project with following dependencies
1) MySqL
2) Spring Data JPA
	Java Persistence API ==> Layer on ORM
	ORM is a layer on top of JDBC

public interface ProductDao extends JpaRepository<Product, Integer>{

}

No need for DaoImplementation class like:
@Repository
class ProductDaoJpaImpl implements ProductDao {
	//
}

Spring Data JPA creates class for this interface and implements methods

List<T> findAll();
findById(ID id);
save(S entity);



Optional<Product> opt = productDao.findById(id);

if(opt.isPresent()) {
	return opt.get();
}	


application.properties
PART 1:
Spring data jpa creates a pool of database connections using below details:
spring.datasource.url=jdbc:mysql://localhost:3306/java_bootcamp
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=Welcome123

PART 2:
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect


DDL ==> Data Definition Language ==> create, alter , drop

spring.jpa.hibernate.ddl-auto=update
"update" ==> map class to existing table in database; if table doesn't exist create table; if required alter table	

spring.jpa.hibernate.ddl-auto=verify

"verify" ==> map class to existing table in database; no table present --> exception


spring.jpa.hibernate.ddl-auto=create

"create" ==> drop table and re-recreate every time application is executed ==> used only as testing env



org.hibernate.dialect.MySQL8Dialect
inform ORM to generate SQL compatable to MySQL8 version


org.hibernate.dialect.Oracle9Dialect
inform ORM to generate SQL compatable to Oracle9 version


===============================================================================
 



Day 5

Spring boot application
* mysql
* jpa ==> spring data jpa

ORM ==> Entity class <---> database table

ORM takes care of DDL (create, alter, drop) and DML (insert, delete, update , select) operations

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}

by adding above interface : methods for CRUD are made available in implmentation class genereated by Spring data jpa

we don't need to write a @Repository class

important ==> database config has to be done in "applicaiton.properties" => DRIVER, URL, USER, 



interface ProductDao {

}

JDBC code

@Repository 
class ProductdaoJdbcImpl implments ProductDao {
	@Override
	public void addProduct(Product p) throws DaoException {
		String SQL = "INSERT INTO products (id, name, price, quantity) VALUES (0, ?, ?, ?)";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate(); // INSERT, DELETE, UPDATE
		} catch (SQLException e) {
			throw new DaoException("unable to add product", e);
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
				
}

==========================

JP-QL ==> Java Persistence API query language

---

By default built-in methods of JpaRepository like save(), delete() have trasnaction settings done [ auto commit = true]

OrderService.java

productDao.save(p); // commits

----

@Transactional
public Product updateProduct(double price, int id) {
		productDao.updateProduct(price, id);
		return  getProductById(id);
}


If no exception occurs in this method ==> commit happens
if any exception ==> rollback


======================================

Entities association [ Relationship between entities]

Uber / OLA
* Customer
* Driver
* Vehicle
* Payment
* Trip
* Address ==> Source ; Destination

Customer books for a Trip
Driver and Vehicle is assigned for the Trip
Payment is done by customer for the trip


Swiggy / Amazon

* Product
* Customer
* Order
* Item
* Address
* Payment

Customer > one to many ==> Order

Order --> many to one --> Customer



mysql> select * from customers;


mysql> insert into customers values ('peter@adobe.com', 'Peter', 'Smith');


mysql> insert into customers values ('sam@adobe.com', 'Samantha', 'Rai');



@JoinColumn is to introduce a Foreign Key

* for ManyToOne ==> FK comes in the owning table
* for OneToMany ==> FK comes in the child


* OneToMany
* ManyToOne
* OneToOne
* ManyToMany

===========================


Order has 4 items;

save(order);
save(i1);
save(i2);
save(i3);
save(i4);

---

Delete

delete(order);
delete(i1);
delete(i2);
delete(i3);
delete(i4);

===

Cascade:

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="order_fk")
private List<Item> items = new ArrayList<>();


Order has 4 items;

save(order); // cascade takes care of saving items also

delete(order); // cascade takes care of deleting items also

UI ==> Checkout button ==> save order ==> saving items [thro cascade]


No need for ItemDao

=============================

orderDao.findAll();
	==> select * from orders;

itemDao.getItemByOrderId(int id); // execute n times based on number of orders

if 5 orders exist:
select * from orders ==> 5 records

select * from items where order_fk = 1;
select * from items where order_fk = 2;
select * from items where order_fk = 3;
select * from items where order_fk = 4;
select * from items where order_fk = 5;


Fetch:

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name="order_fk")
private List<Item> items = new ArrayList<>();


One call from application:
orderDao.findAll(); // gets orders and it's items also

==================================

ProductDao.java
CustomerDao.java
OrderDao.java

No need for ItemDao.java [ Cascade takes care]

============

Dao ==> one per table

Service ==> one per actor [ CustomerService, ManagerService]; one per application

@Transactional

==> Dirty checking
==> when data is pulled from database; any changes done entity ==> triggers update SQL

=============

RentalApp

* Rental.java entity

	@ManyToOne
	@JoinColumn(..)
	Vehicle vehicle;

	@ManyToOne
	@JoinColumn(...)
	Customer customer;


====================================

Spring Module:

* Spring MVC Module
==> Spring web along with mysql and jpa


<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
</dependency>

* Adds Tomcat Web embedded server running on port 8080
* DispatcherServlet  ==> will act like FrontController [ url-mapping ==> * ]

@WebServlet(' * ')
public class DispatcherServlet extends Servlet {

}

@WebServlet('/products')
public class ProductServlet extends Servlet {

}

if port has to be changed
application.properties
server.port=9999 





@RestController
@RequestMapping("/products") 
public class ProductController {

	@GetMapping()
	m1() {

	}

	@PostMapping()
	m2() {

	}

	@DeleteMapping()
	m3() {

	}
}




@RestController
@RequestMapping("/orders") 
public class OrderController {

	@GetMapping()
	m1() {

	}

	@PostMapping()
	m2() {

	}

	@DeleteMapping()
	m3() {

	}
}


===

Just using Servlet without Spring MVC


@WebServlet(" * ")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				String uri = request.getRequestUri();
				if(uri.endsWith("/products")) {
						if(reqest.getMethod().equals("GET")) {

						} else if(reqest.getMethod().equals("POST")) {

						}

					} else if uri.endsWith("/orders") {
							if(reqest.getMethod().equals("GET")) {

						} else if(reqest.getMethod().equals("POST")) {

						}
					}
	}
}



===========


@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

}


@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

=========================

Security / Encode / encryption / Conversion

============================

Spring MVC comes with DataConversion [sting to double, .. ] / HttpMessageHandlers / ContentNegotiationHandlers
* Jackson library
	Jackson ObjectMapper class and how to serialize Java objects into JSON and deserialize JSON string into Java objects

Other options are GSON / Jettison / Moxy

	JSON ==> JavaScript Object notation
	Product p = new Product(1, "iPhone", "mobiel", 124447.44);

	{"id":1,"name":"iPhone","price":124447.44,"category" : "mobile"}

============================

RESTful Web Services

Representational State Transfer

Resource ==> present on server [ database / file / printers]

State ==> value of the resource at a given point of time

Represention ==> XML / JSON / CSV / RSS / ATOM

Heterogenous clients:
web clients might need it in JSON [ React / Angular]
Stand alone client ==> XML 
Mobile [ Android]

====

@ResponseBody List<Product>

List<Product> is converted to json / xml based on "accept": "application/json" HTTP header and placed into response body

POSTMAN
==> To test REST APi

=============
Http Headers
accept ==> server to client
content-type: client --> server

Browser:
http://localhost:8080/api/products/
http://localhost:8080/api/products/2


To test PUT/ POST/ DELETE we need POSTMAN

POSTMAN

POST http://localhost:8080/api/products/
Headers:
Accept: application/json
Content-Type: application/json

Body (raw) :
{
    "name": "Panasonic Tv",
    "price": 98000.00,
    "quantity" : 100
}

===
PUT  http://localhost:8080/api/products/1
Headers:
Accept: application/json
Content-Type: application/json

Body (raw) :
{
    "price": 198000.00
}


=================

1)
GET
 http://localhost:8080/api/products/

 gets all products

2) Extra PathParameter @PathVariable (/)
to get based on PK

GET
 http://localhost:8080/api/products/3

 get product whose id is 3

3) QueryParameter (?)

GET
 http://localhost:8080/api/products?page=1&size=20
 http://localhost:8080/api/products?low=500&high=100

 => subset of data

 ================

 Task

 Add CustomerController

 GET http://localhost:8080/api/customers

 get all customers

 POST http://localhost:8080/api/customers

 body should have customer data ==> adding customer

=====

POST http://localhost:8080/api/orders

{
	"customer" : {"email": "peter@adobe.com"},
	"items": [
		{"product": {"id" : 2}, "qty": 3},
		{"product": {"id" : 3}, "qty": 1}
	]
}

============

orderDate	"2022-06-24T06:53:17.639+00:00"

application.properties
spring.jackson.date-format=dd/MMM/yyyy hh:mm:ss

orderDate 24/Jun/2022 06:53:17"

=============================================

@JsonFormat(pattern = "dd-MMMM-yyyy hh:mm:ss")
@Temporal(TemporalType.TIMESTAMP)
@Column(name="order_date")
private Date orderDate = new Date();

====================


RESTful Web services Documentation

==> OpenAPI

<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.8</version>
		</dependency>

http://localhost:8080/swagger-ui/index.html

================================================================

Read jpa.pdf => one-to-one; many-to-many

Problem Statements

1) Complete Vehicle Rental applicaiton ==> RESTful web services
	a) Add a Vehicle
	b) rent a Vehicle
	c) Return Vehicle


2) Project app
	Entities:
	a) Employee ==> email; firstName; lastName; joined_date; end_date
	b) Client ==> id; name; address [ Reliance; TataSky]
	c) Project ==> id; name ; client [ Association]; details; start_date; end_date
	d) EmployeeProject 
		id | email_fk | project_fk | start_date | end_date | role

		1 |  sam@adobe.com  | 121 | 12-10-2019 | 3-5-2021 | sr developer



	Task:
	1) add employee
	2) add client
	3) add project
	4) assign employee to project
	5) list employees working in a project

================================================


Monday: exception handling; validation; testing and Security



Actor 
aid | name

Movie 

mid | name

looks like many-to-many

* extra attributes
in a movie actor plays a role [ where should "role" field come? ]

ActorMovie
aid | mid | role
1     1     comedian
1     2     protoginst





Employee
name
email
start_date
end_date

Project

"jr developer"
"Tech Lead"

EmployeeProject
id | eid | pid | start_date | end_Date | role

class EmployeeProject {
	@ManyToOne
	@JoinColumn(name ="eid")
	Employee employee;
	@ManyToOne
	@JoinColumn(name = "pid")
	Project project;

}
==========

Day 6

interface EmployeeProjectDao extends JpaRepository<EmployeeProject, Integer> {

	@Query("select e.email, e.firstName,  ep.role, p.name from EmployeeProject ep inner join ep.project p inner join ep.employee")
	public List<Object[]> getReport();
}

// not a entity class ==> DTO class

public class EmployeeProjectReport {
	email
	firstName
	role
	name

	constructors and getters & setters
}



interface EmployeeProjectDao extends JpaRepository<EmployeeProject, Integer> {

	@Query("select new com.adobe.prj.entity(e.email, e.firstName,  ep.role, p.name) from EmployeeProject ep inner join ep.project p inner join ep.employee")
	public List<EmployeeProjectReport> getReport();
}



List<Object[]>
	[["Peter","Smith","24/June/2022 10:55:13",24680.0],["Samantha","Rai","24/June/2022 09:28:05",252040.0],["Samantha","Rai","24/June/2022 06:53:17",252040.0]]


@Query("select new com.adobe.prj.dto.OrderReport(c.firstName, c.lastName, o.orderDate, o.total) from Order o inner join o.customer c")
public List<OrderReport> getReport();


[{"firstName":"Peter","lastName":"Smith","orderDate":"24/June/2022 10:55:13","total":24680.0},{"firstName":"Samantha","lastName":"Rai","orderDate":"24/June/2022 09:28:05","total":252040.0},{"firstName":"Samantha","lastName":"Rai","orderDate":"24/June/2022 06:53:17","total":252040.0}]

==============================================================================

Exception Handling in RestController

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(name=NotFoundException.class)
	returntype m1(NotFoundException ex) {

	}

	@ExceptionHandler(name=PersistenceException.class)
	returntype m2(PersitenceException ex) {

	}
}

===============

@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}


or

@PostMapping()
public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		return new ResponseEntity<Product>(service.addProduct(p), HttpStatus.CREATED);
}

==========

Check:
1) NotFoundException.java
2) OrderService.java ==> throws NotFoundException
3) ProductController.java ==> throws NotException
4) GlobalExceptionHandler ==> @ControllerAdvice and @ExceptionHandler

5) update OrderAppApplication.java to handle exception

http://localhost:8080/api/products/2886
{"message":"Product with id 2886 doesn't exist!!!","timestamp":"27/June/2022 05:21:17"}


http://localhost:8080/api/products/2
{"id":2,"name":"Tata Sky","price":8000.0,"quantity":97,"desc":"hello"}

=====================================================

Validation of Payload

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
</dependency>

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	@NotBlank(message="Name is required")
	private String name;
	@Min(value = 10, message="Price ${validatedValue} should be more than {value}")
	private double price;
	
	@Min(value = 0, message="Quantity ${validatedValue} should be more than {value}")
	@Column(name="quantity")
	private int quantity;
	
---
@Validated
public class ProductController {
	public @ResponseBody Product addProduct(@RequestBody @Valid Product p) {
		///
}	


MethodArgumentNotValidException: 

Validation failed for argument [0] in 
public com.adobe.prj.entity.Product com.adobe.prj.api.ProductController.addProduct(com.adobe.prj.entity.Product) 

with 2 errors: 
[Field error in object 'product' on field 'price': rejected value [-999.0]; codes [Min.product.price,Min.price,Min.double,Min]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.price,price]; arguments []; default message [price],10]; 
default message [Price -999.0 should be more than 10]] 

[Field error in object 'product' on field 'name': rejected value []; codes [NotBlank.product.name,NotBlank.name,NotBlank.java.lang.String,NotBlank]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [product.name,name]; arguments []; 
default message [name]]; default message [Name is required]] ]

=============================================

Integration testing / E2E testing
* Browser
* Postman

Java Unit Testing 

The purpose of unit testing is to test the correctness of isolated code. 
A unit component is an individual function or code of the application.


Unit Testing Framework:
1) JUnit
2) TestNG

===

RestController to be tested


@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private OrderService service;


To Test ProductController ==> has OrderService dependency

Mock OrderService
Mocking Libraries
1) EasyMock
2) JMock
3) Mockito

---
Spring Test provides:
1) Mockito --> Mocking library
2) Hamcrest ==> provides lots of assertion apis / matchers
3) json-path ==> extract json data [ check https://jsonpath.com/]
4) JUnit

==================

MockMvc can be used to perform CRUD operations using GET, POST, PUT , DELETE, ...

================

Spring creates instances of classes which has one of these annotations:
1) @Component
2) @Repository
3) @Service
4) @Controller ==> jsp / Thmyeleaf for view ==> SSR
5) @RestController ==> JSON or XML or csv ==> CSR [ React / Angular / Android / Xamrin / Swift]
6) @Configuration

If there is a class provided by 3rd party library; this class has to be managed by spring container

public class ObjectMapper
    extends ObjectCodec
    implements Versioned,
        java.io.Serializable // as of 2.1
{
}


@Service
public class MyService {
	@Autowired
	ObjectMapper mapper; // this throws error
}

--

Spring uses default constructor for object creation; if a class doesnt have default constructor we can;t place any of the above annotations

Solution:
use factory method


@Configuration
public class AppConfig {
	@Value("${ip}")
	private String ip;
	@Value("${port}")
	private int port;
	// factory method
	@Bean
	public EmailConnection getEmailConnection() {
		return new EmailConnection(ip, port);
	}
}











