Move zeros to the end while maintaining the order of the rest of the elements


```python
int s=0,f=0;
while(f<n){
    if(v[f]!=0){
        v[s]=v[f];
        s++;
    }
    f++;
}
while(s<n){
    v[s]=0;
    s++;
}
```

Removing duplicate elements any element can repeat at most once maintaining relative order



1. Array is sorted


```python
if(n==1) return;
int s=1,f=1;
while(f<n){ 
    if(v[f]!=v[s-1]){ 
        v[s]=v[f]; 
        s++; 
    } 
    f++; 
}
```

2. Array is not sorted


```python
int s=0,f=0; 
unordered_map<int,int> m; 
while(f<n){ 
    if(!m.count(v[f])){ 
        m[v[f]]; 
        v[s]=v[f];
        s++;
    } 
    f++;
} 
return s;
```

Delete all occurrences of an element k while maintaining the order of the rest of the elements


```python
int s=0,f=0;
while(f<n){
    if(v[f]!=k){
        v[s]=v[f];
        s++;
    }
    f++;
}
return s;

```

at most two times


sorted input


```python
if(n==1) return 1;
if(n==2) return 2;

int s=2,j=2;
while(f<n){
    if(v[f]!=v[s-2]){
        v[s]=v[f];
        s++;
    }
    f++;
}
return s;
```

unsorted input


```python
int s=1,f=1;
unordered_map<int,int> m;  
m[v[0]]++; 
while(f<n){  
    if(m.count(v[f])==0 or m[v[f]]==1){  
        v[s]=v[f];  
        s++;  
    }
    m[v[f]]++;  
    f++;  
}  
return s;
```
