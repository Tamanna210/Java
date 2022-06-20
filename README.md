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

===

static methods can't access instance variables [ first argument implicit "this" is not passed to the method]
instance methods can access static variables

===============

