### Shortest Prime Path
[Shortest Prime Path | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/shortest-prime-path--141631/1)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2792b4ff-f19d-4618-a040-f0578df00a3e--image.png)


```cpp
unordered_map<string,bool> primes_generate(ll n){
    unordered_map<string,bool> m;
    vector<ll> p(n+1,1); 
    p[0]=p[1]=0; 
    for(long long i=2;i<=n;i++){ 
        if(p[i]){
            m[to_string(i)];
            for(long long j=i;i*j<=n;j++){ 
                p[i*j]=0; 
            }       
        } 
    }
    return m;
}

int solve(int src,int de){
//more efficient will be using concpet of segmented sieve 1000 to 9999
    unordered_map<string,bool> primes= primes_generate(9999);
    unordered_map<string,bool> visited;
    visited[to_string(src)]=1;
    int n=4;
    queue<pair<string,int>> q;  
    q.push({to_string(src),0});
    while(!q.empty()){
        auto x=q.front();q.pop();  
        string temp=x.first;  
        if(temp==to_string(de)) return x.second;          
        for(int i=0;i<n;i++){
          char c=temp[i];
          for(int j=0;j<=9;j++){
              if(i==0 and j==0) continue;
              temp[i]='0'+j;
              if(primes.count(temp) and !visited.count(temp)){
                    visited[temp];
                    q.push({temp,x.second+1});              
              }
          }
          temp[i]=c;
        }
    }
return -1;
}
```