x+y+z+w == 0
x+y= -(z+w)

```cpp
for(int x:a){
  for(int y:b){
    m[-(x+y)]++;
  }
}

for(int z:c){
  for(int w:d){
    cnt+=m[w+z];
  }
}


```