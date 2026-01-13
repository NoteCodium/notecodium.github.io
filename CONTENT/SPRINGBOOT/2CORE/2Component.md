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

