Do related grokking conceots


# Easy O(n) solution of finding the number of intersections
# 3
![image.png](../images/8c7b11df-1af4-4c83-bbb8-acbdaafd7741--image.png)
```cpp
class MyCalendarThree {
    map<int,int> m;
public:
    MyCalendarThree() {
        
    }
    
    int book(int s, int e){
        int maxx=0;
        m[s]++;
        m[e]--;

        int sum=0;
        for(auto p: m){
            sum+=p.second;
            maxx=max(maxx,sum);
        }
        return maxx;
    }
};
```

# 2
![image.png](../images/c2607b17-db2f-4c64-8e6b-5b1187081eac--image.png)
```cpp
class MyCalendarTwo {
        map<int,int> m;
public:
    MyCalendarTwo() {
        
    }
    
    bool book(int s, int e) {
        int maxx=0;
        m[s]++;
        m[e]--;

        int sum=0;
        for(auto p: m){
            sum+=p.second;
            maxx=max(maxx,sum);
            if(maxx>=3){
                m[s]--;
                m[e]++;
                return 0;
            } 
        }
        return 1;
    }
};

```
# 1
![image.png](../images/2c14bd79-c9d6-4cd6-af97-5850e994854c--image.png)


```cpp
class MyCalendar {
    map<int,int> m;
public:
    MyCalendar() {
        
    }
    
    bool book(int s, int e) {
        int maxx=0;
        m[s]++;
        m[e]--;

        int sum=0;
        for(auto p: m){
            sum+=p.second;
            maxx=max(maxx,sum);
            if(maxx>1){
                m[s]--;
                m[e]++;
                return 0;
            } 
        }
        return 1;
    }
};

```
