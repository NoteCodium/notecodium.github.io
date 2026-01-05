1. Generate all subsets, if the set is 1 to n

```cpp
void f(int num){
  if(num==0){
    ans.push_back(tmp);
    return;
  }

//take
tmp.push_back(num);
f(num-1);
tmp.pop_back()

//not take
f(num-1);

}

int main(){
vector<vector<int>> ans;
vector<int> tmp;
f(n);
}

```
