---
title: 0StringInput
---

{% raw %}

```cpp
string s;
getline(cin,s);
```

```cpp
cin.ignore();
```

This is used after taking a number is input, and next you are taking a string as input

```python
string s;
stringstream ss(s);
string tok;
/////////////////////////////////////////////
while(getline(ss,tok,',')){
    vos.push_back(tok);
}
/////////////////////////////////////////////

//if the delimeter is space, there is a separate code for the same process
/////////////////////////////////////////////
//no getline
while(ss>>tok){
    vos.push_back(tok);
}
/////////////////////////////////////////////
```

# Usage

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_50Strings_0StringInput__att_0001.png)

after reversing the string, we have to reverse each word separately

```python
string s;
stringstream ss(s);
string tok;
while(ss>>tok){
    reverse(it(tok));
    //see how beautifully we are reversing it in place
}
//you see not in the above codes not only while taking input but also while processing
```

Suppose you have to just do  
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_50Strings_0StringInput__att_0002.png)

reverse each word, and you are getting the sentence as an input

```python
//traditional
string s;
getline(cin,s);
stringstream ss(s);
string tok;
while(ss>>tok){
    reverse(it(tok));
}
```

or

# The codechef yashesh learning

https://www.codechef.com/problems/TSHIRTS?tab=statement

```python
void solve(){
    iinp(N);
    vvl ma;
    while(N--){
        string s;
        getline(cin,s);
        stringstream ss(s);
        vl tmp;
        ll xtmp;
        while(ss>>xtmp){
            tmp.push_back(xtmp);
        }
        ma.push_back(tmp);
    }
    prim(ma);
}
```

# DO AZ problem

? I am not sure it is there or not
{% endraw %}
