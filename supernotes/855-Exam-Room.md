[Just a moment...](https://leetcode.com/problems/exam-room/description/?envType=list&envId=ppzcw7vd)

[Exam Room | LeetCode 855 | Coding In Hindi | C++ - YouTube](https://www.youtube.com/watch?v=skoKsqsbYKA)


```cpp
class ExamRoom {
    set<int> s;
    int sz;
public:
    ExamRoom(int n) {
        sz=n;
    }
    
    int seat() {
        if(s.empty()){
            s.insert(0);
            return 0;
        }
        int idx=0;
        int maxx=*s.begin();
        auto it1=s.begin(),it2=s.begin();
        it2++;
        while(it2!=s.end()){
            int d=(*it2-*it1)/2;
            if(d>maxx){
                idx=*it1+d;
                maxx=d;
            }
            it1++;
            it2++;
        }
        if(sz-1-*it1>maxx){
            idx=sz-1;
        }   
        s.insert(idx);
        return idx;
    }
    
    void leave(int p) {
        s.erase(p);
    }
};
```