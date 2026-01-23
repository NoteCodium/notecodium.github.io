# hashCode()

![image.png](/images/image-321.png)



```
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>
```

# @EqualsAndHashCode

![image.png](/images/image-322.png)

![image.png](/images/image-324.png)

>  see demo



![image.png](/images/image-318.png)

```
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
//Generates a constructor for final and @NonNull fields.
@ToString
@EqualsAndHashCode
@Data
```

# ToString()

a memory representation (default  output of an array object).

![image.png](/images/image-319.png)

![image.png](/images/image-320.png)



# @Data

used for dto

generate all except

@AllArgsConstructor

@NoArgsConstructor

![image.png](/images/image-323.png)



# @RequiredArgsConstructor



- DO NOT mix @RequiredArgsConstructor with @SuperBuilder unless you understand the constructor generation. Pick one approach.

Discussed in lld