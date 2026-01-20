[leetcode.com](https://leetcode.com/problems/path-with-minimum-effort/description/)

[G-37. Path With Minimum Effort - YouTube](https://youtu.be/0ytpZyiZFhA)




![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/eb76be69-0895-4c12-9c28-5d72e6d060c0--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/396bad27-5849-4060-84ac-01859f4153f3--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/7aefb95b-ef85-4053-b21d-6c7ac32052a2--image.png)


{% raw %}
```cpp
int minimumEffortPath(vector<vector<int>>& ma) {
    vector<vector<int>> dir={{1,0},{-1,0},{0,1},{0,-1}};
    int rr=ma.size(),cc=ma[0].size();
    vector<vector<int>> dis(rr,vector<int> (cc,INT_MAX));
    //distance x y
    priority_queue<vector<int>> pq;
    dis[0][0]=0;
    pq.push({0,0,0});
    while(!pq.empty()){
        int d=-pq.top()[0];
        int r=pq.top()[1];
        int c=pq.top()[2];
        pq.pop();
        if(r==rr-1 and c==cc-1) return d;
        for(auto dv: dir){
            int tr=r+dv[0],tc=c+dv[1];
            if(!(tr>=0 and tr<rr and tc>=0 and tc<cc)) continue;
            int newEff=abs(ma[tr][tc]-ma[r][c]);
            if(dis[tr][tc]<=max(d,newEff)) continue;
            dis[tr][tc]=max(d,newEff);
            pq.push({-dis[tr][tc],tr,tc});
        }            
    }
    return INT_MAX;
}
```
{% endraw %}