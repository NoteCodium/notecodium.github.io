```
package com.example.one;

public class Apple {
    void eatApple(){
        System.out.println("I eat apple");
    }
}
```

```
@SpringBootApplication
public class OneApplication {
	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
		Apple apple = new Apple();
		apple.eatApple();
	}
}
```

work as usual

Tight coupling 

Suppose We want to write Unit test for OneAppplication class main method but we can not easily mock Apple object (eatApple method)

Suppose in future we have different type of Apples? we cannot change the Apple type dynamically

- Trying to make the code cleaner

```
@SpringBootApplication
public class OneApplication {
	Apple apple = new Apple();
	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
		apple.eatApple();
	}
}
```

non-static variable apple cannot be referenced from a static context

- To make it work

```
package com.example.one;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneApplication implements CommandLineRunner {
	Apple apple = new Apple();
	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		apple.eatApple();
	}
}
```

# CommandLineRunner

for arguments?

# Autowired

for @Autowired to work, you have to make Apple a component

```
package com.example.one;

import org.springframework.stereotype.Component;

@Component
public class Apple {
    void eatApple(){
        System.out.println("I eat apple");
    }
}

```

```
@SpringBootApplication
public class OneApplication {
	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
		@Autowired
		Apple apple;
		//Autowired is not applicable to local variables
		apple.eatApple();
	}
}
```

I have read in SonarQube @Autowired using is bad, see it

```
package com.example.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneApplication implements CommandLineRunner {
	@Autowired
	Apple apple;
	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		apple.eatApple();
	}
}
```

@Component follows convention over configuration

![image.png](/images/image-90.png)

![image.png](/images/image-91.png)

![image.png](/images/image-92.png)

SpringBoot will use the default constructor

![image.png](/images/image-95.png)

By default the Bean name is same as class name

Making a bean having name different from the class name

@Component("name")

# When a class have two implementations

![image.png](/images/image-102.png)

1. You want to use by interface name

![image.png](/images/image-103.png)

2. You want to use by class name

```
DevDB devDB
```

//Name Autowiring

spring is intelligent enough that it will figure it out