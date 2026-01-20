![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ca84c315-3146-4c56-943d-fe8bd232494b--image.png)

# Generate the string and run the queries


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ad3c1174-7b56-4d9f-80d9-92ddcf5c589a--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a81a3e9f-9c1a-4c48-aea2-7d6574bb72d9--image.png)

# When this is not possible
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/4a9ad8e3-6145-492e-bba0-32ba20790329--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/9e4859df-2154-4767-b24c-2f838bd60803--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/052aa121-fc86-4ecd-8e2f-f68488480896--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2017c346-2006-40d2-b392-4f6aa2ce0356--image.png)


[Count Total Setbits | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/sherlock-and-his-enemies2304/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/9a0ac2a2-ad77-4097-8cfa-6ecbdb5ce84c--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/be4f61b3-bacf-4719-a6d9-da1a72455acf--image.png)

pattern
 periof
 ![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2f7201f6-1019-4780-9363-bbbe2cd52fd1--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c019657f-a1e5-466b-b996-4227b640eacf--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/8e6a7006-e0e8-47f1-9f2e-d4579281b908--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/808c1dec-fea4-4c4e-87cb-0e6e683e01bb--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ee4871d8-e86f-4151-a86d-465f44b67a04--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/1d3c9604-526b-446e-83fa-425a7e570051--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a52a32db-4caa-411b-97ea-bcefdd107040--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/73642759-d8e6-48c8-a97e-14c7e5b70b15--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/234b15cc-77c1-4a72-b6c4-5c082dd4908b--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/f658e6b5-85a6-40ad-958b-e7efff8fbc81--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/40792c09-dc7d-4271-a92b-8c9b20d726d0--image.png)

## Negative when
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b5e97ef6-6dcf-491e-93a6-da728e2b03ff--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/617d1020-c5d7-4427-9130-1b03bf411822--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/49af1912-c503-4e9c-9527-ed17e41f86b6--image.png)

```cpp
int countBits(int n) {
    int ans=0;  
    int tot=n+1;
    for(int i=0;i<31;i++){
        int full=tot/(1<<(i+1));
        int left=tot%(1<<(i+1));
        int extra=max(left-(1<<i),0);
        ans+=full*(1<<i)+extra;
    }
    
    return ans;
}
```
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/bc86b773-1e39-4ec0-8c60-5a44f62a74e6--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/0dedca1d-3ffa-421d-9400-cd668b7d17be--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/f60efadf-359d-4e93-b05b-2825a962dd7d--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/8db6866b-8873-4402-8e10-3dba67771fc6--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/d3a1cd7c-06e0-4927-8fae-762b5c799503--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c7a44d18-cd32-47fc-83b7-b25d8aa0c5ce--image.png)
  
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/5e3eb0c5-a4ef-497e-9787-6b957764070e--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/cc60a8b2-6d49-49b8-b1ba-418d5292980a--image.png)

# count set bits in 0 to x

[Count Total Setbits | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/sherlock-and-his-enemies2304/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article)

```cpp
int countBits(int n) {
    int ans=0;  
    int tot=n+1;
    for(int i=0;i<31;i++){
        int full=tot/(1<<(i+1));
        int left=tot%(1<<(i+1));
        int extra=max(left-(1<<i),0);
        ans+=full*(1<<i)+extra;
    }
    
    return ans;
}
```