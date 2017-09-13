## _Singleton_ Beans

* When Spring creates a bean from your XML file or via scanning, it defaults to creating an _singleton_. This means there is only one instance of this object in the entire program.

* This means there is only one of each `@Controller` or `@Component`, so these beans should not hold any user-specific state.

* Similarly, there will be one instance created for each bean you define in your XML configuration file.

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

	<context:component-scan base-package="controllers"/>

	<bean id="dao" class="data.StateFileDAO"/> <!-- One instance for entire app -->

</beans>
```

[Prev](component.md) | [Up](../README.md) | [Next](modelattribute.md)
