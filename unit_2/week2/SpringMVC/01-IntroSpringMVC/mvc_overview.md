## Spring MVC Overview

### Objectives
* Describe the problems that the Spring Framework is fixing.

* Create a simple Spring MVC web application.

### What is Spring?
* The *Spring Framework* was originally created by Rod Johnson as an answer to the tedious coding model presented by Enterprise Java Beans (EJB).

  * Spring favors *Plain Old Java Objects* (POJOs) which do not extend classes or implement interfaces from Java EE packages.

    * This makes them easier to test and reuse since they can be utilized independently of the environment in which they were first deployed.

* The Spring Framework provides a container (called *Spring Core*) which is primarily concerned with decoupling the responsibility for object creation from your code to the framework itself.

  * You can use XML or Spring annotations to configure how you wish your beans to be created including what to pass to the constructor and which `set()` methods should be called to initialize them.

    * The process of populating objects' properties with values at creation is called ***Dependency Injection***.

    * An object that Spring instantiates, assembles, and otherwise manages is called a _bean_.

* Another key feature of Spring is integration.

  * Spring provides simple ways to integrate enterprise features like database access, transactions, and asynchronous messaging via additional configurations.

<hr>

### Hands On:
* Getting started with the Spring Framework, and configuring some beans:

* The objective of this exercise is to create a lottery application that, when run, will randomly draw 6 ping pong balls from a hopper. The twist is, that we are going to configure the hopper and the ping pong balls as Spring *beans* and use *Dependency Injection* to make them available to our application instead of creating them ourselves.

1: Create a new Java Project named "SpringLotto".  

2: Convert the project to a Maven project, and include the `spring-context` maven dependency:

```xml
<dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
  </dependencies>
```

3: We need two Java classes for this application to work, `Hopper` and `PingPongBall`. We will create these classes in a package named `lotto` with the following constraints:

* `Hopper` will have a `name` property, as well as a collection of `PingPongBall` objects. It should also have a `drawBall:PingPongBall` method which returns a random `PingPongBall`.

```java
package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hopper {
	private String name;
	private List<PingPongBall> pingPongBalls;
	private int counter = 0;

	public Hopper() {
		this.pingPongBalls = new ArrayList<>();
	}

	public PingPongBall drawBall() {
		return pingPongBalls.get(counter++);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void reset() {
		Collections.shuffle(pingPongBalls);
		counter = 0;
	}

	public List<PingPongBall> getPingPongBalls() {
		return pingPongBalls;
	}

	public void setPingPongBalls(List<PingPongBall> pingPongBalls) {
		this.pingPongBalls = pingPongBalls;
	}

}

```

* `PingPongBall` has a `value` property which will be a number, and a single argument constructor which assigns that value:

```java
package lotto;

public class PingPongBall {
	private String value;

	public PingPongBall(String v) {
		this.value = v;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

```

4: Create a `beans.xml` file in your project's `src` directory.  

5: In the `beans.xml` file you will add code to instantiate and inject the `Hopper` and `PingPongBall` beans your application will need:

* The following xml first creates an instance (bean) of the `Hopper` class, assigning it the name 'Lottery Numbers', and a list of pingPongBalls. The pingPongBalls property is a collection of instantiated `PingPongBall` objects created using the single argument constructor.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
  xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
  xsi:schemaLocation="
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
    http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
  <bean id="lottery" class="lotto.Hopper">
    <property name="name" value="Lottery Numbers" />
    <property name="pingPongBalls">
      <list>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="1" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="2" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="3" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="4" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="5" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="6" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="7" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="8" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="9" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="10" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="11" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="12" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="13" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="14" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="15" />
        </bean>
      </list>
    </property>
  </bean>
</beans>
```

6: Now that the `Hopper` bean has been configured, it will be available to use in our application, we simply need to retrieve it from the `ClassPathXmlApplicationContext`.

```java
package lotto;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuickPick {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    Hopper h = context.getBean("lottery", Hopper.class);
    h.reset();
    System.out.println(h.getName());
    for (int i = 0 ; i < 6 ; i++) {
      System.out.print(h.drawBall().getValue() + " ");
    }
    System.out.println();
    context.close();
  }
}
```

* Running the application should result in the Hopper's name being printed, followed by 6 of the lotter numbers:

```bash
Lottery Numbers
13 2 3 11 14 4
```

[Prev](README.md) | [Up](../README.md) | [Next](what_is_spring_mvc.md)
