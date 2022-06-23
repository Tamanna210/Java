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









