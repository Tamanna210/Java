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


