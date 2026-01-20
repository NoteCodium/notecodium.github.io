```cpp
bool flag=0;
for(int i=n-1;i>=0;i--){
  if(s[i]=='0'){
    s[i]='1';
    flag=1;
  }
  else{
    //it will be 1 which will be converted to 0
    s[i]='0';
  }
}
if(!flag) s='1'+s;
```