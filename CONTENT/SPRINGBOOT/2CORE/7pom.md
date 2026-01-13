![image.png](/images/image-129.png)

```
	<groupId>com.example</groupId>
	<artifactId>one</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>one</name>
	<description>Demo project for Spring Boot</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
```

> see the meaning of snapshot later

# groupId

resonates with the organization

![image.png](/images/image-130.png)

# artifactId

project name

1. artifactId (The Technical ID)

The artifactId is the unique name of your project within the build ecosystem. It is used to generate the final file (like a .jar or .war) and to identify the project when other projects want to use it as a dependency.

Usage: It forms part of the project's coordinates: 

```
groupId:artifactId:version
```

Constraints: It should be lowercase, contain no spaces, and use hyphens to separate words (e.g., user-service).

Result: If your artifactId is my-app and your version is 1.0.0, Maven will generate a file named my-app-1.0.0.jar

## name 

2. name (The Display Label)

The name is purely descriptive. It is the "pretty" name of the project used in documentation, IDEs, and build logs.

Usage: It makes it easier for developers to distinguish projects in a large workspace.

Constraints: It can contain spaces, uppercase letters, and special characters (e.g., My Enterprise Application).

Optional: If you omit the <name> tag, Maven will simply default to using the artifactId as the name

![image.png](/images/image-131.png)

```
groupId.artifactId
```



```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
```

![image.png](/images/image-132.png)

```
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.5.9</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
```

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.5.9</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>one</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>one</name>
	<description>Demo project for Spring Boot</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```

#  plugins like code generator

```
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

![image.png](/images/image-134.png)

![image.png](/images/image-135.png)