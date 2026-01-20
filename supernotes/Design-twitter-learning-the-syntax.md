[leetcode.com](https://leetcode.com/problems/design-twitter/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c97d9b0b-f65e-4a87-ae9e-1963c064988b--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c8c8bbb5-e7dc-4927-a574-9e4f61e82a56--image.png)

```cpp
class Twitter {
public:
    Twitter() {
        
    }
    
    void postTweet(int userId, int tweetId) {
        
    }
    
    vector<int> getNewsFeed(int userId) {
        
    }
    
    void follow(int followerId, int followeeId) {
        
    }
    
    void unfollow(int followerId, int followeeId) {
        
    }
};
```

```cpp
class Twitter {
    int t;
    unordered_map<int,unordered_set<int>> following;
    unordered_map<int,vector<vector<int>>> listOfTweets;
    //time, tweetId
    vector<int> alg(vector<vector<vector<int>>> &ma){
        int k=10;
        vector<int> ans;
        int rr=ma.size();
        vector<vector<int>> tmp;
        for(int r=0;r<rr;r++){
            if(ma[r].size()){
                tmp.push_back({r,(int)ma[r].size()-1});        
            }
        } 

        auto cmp=[&](vector<int> &a, vector<int> &b){
            auto x=ma[a[0]][a[1]],y=ma[b[0]][b[1]];
            return x[0]<y[0];
        };
        priority_queue<vector<int> ,vector<vector<int>>,decltype(cmp)> pq(cmp,tmp);
        while(!pq.empty() and k--){
            auto vv=pq.top();pq.pop();
            int r=vv[0],c=vv[1];
            ans.push_back(ma[r][c][1]);
            if(c-1>=0) pq.push({r,c-1});
        }
        
        return ans;
    }

    vector<int> api2(vector<int> &person2Track){
        vector<vector<vector<int>>> ma;
        for(int id: person2Track){
            ma.push_back(listOfTweets[id]);
        }
        //ma is individually row wise sorted
        return alg(ma);
    }

    vector<int> api1(int userId){
        vector<int> tmp;
        //own
        tmp.push_back(userId);
        //following
        for(auto id: following[userId]){
            tmp.push_back(id);
        } 
        //tmp is populated with all the persons of which we have to track listOfTweets
        return api2(tmp);
    }

public:
    Twitter() {
        t=0;
    }
    
    void postTweet(int userId, int tweetId) {
        listOfTweets[userId].push_back({++t,tweetId});
    }
    
    vector<int> getNewsFeed(int userId) {
        return api1(userId);
    }
    
    void follow(int followerId, int followeeId) {
        following[followerId].insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        following[followerId].erase(followeeId);
    }
};
```



-----------------------------------------------

```cpp
class Twitter {
    int t;
    unordered_map<int,unordered_set<int>> following;
    unordered_map<int,vector<vector<int>>> listOfTweets;
    //time, tweetId
    vector<int> alg(vector<vector<vector<int>>> &ma){
        int k=10;
        vector<int> ans;
        int rr=ma.size();
        vector<vector<int>> tmp;
        for(int r=0;r<rr;r++){
            if(ma[r].size()){
                tmp.push_back({r,(int)ma[r].size()-1});        
            }
        } 

        auto cmp=[&](vector<int> &a, vector<int> &b){
            auto x=ma[a[0]][a[1]],y=ma[b[0]][b[1]];
            return x[0]<y[0];
        };
        priority_queue<vector<int> ,vector<vector<int>>,decltype(cmp)> pq(cmp,tmp);
        while(!pq.empty() and k--){
            auto vv=pq.top();pq.pop();
            int r=vv[0],c=vv[1];
            ans.push_back(ma[r][c][1]);
            if(c-1>=0) pq.push({r,c-1});
        }
        
        return ans;
    }


    vector<int> api(vector<int> &tmp){
        //generate a matrix which is rowwise sorted accoridng to ma[r][c][0]
        vector<vector<vector<int>>> ma;
        for(int id: tmp){
            ma.push_back(listOfTweets[id]);
        }
        return alg(ma);
    }

public:
    Twitter() {
        t=0;
    }
    
    void postTweet(int userId, int tweetId) {
        listOfTweets[userId].push_back({++t,tweetId});
    }
    
    vector<int> getNewsFeed(int userId) {
        vector<int> tmp;
        //own
        tmp.push_back(userId);
        //following
        for(auto id: following[userId]){
            tmp.push_back(id);
        } 
        return api(tmp);
    }
    
    void follow(int followerId, int followeeId) {
        following[followerId].insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        following[followerId].erase(followeeId);
    }
};

```

---------------------------=======================
```cpp
class Twitter {
    int t;
    unordered_map<int,unordered_set<int>> following;
    unordered_map<int,vector<pair<int,int>>> listOfTweets;

    //our main algorithem to get 10 most recent tweets 
    vector<int> f(vector<vector< pair<int,int>>> &ma ){
        vector<int> ans;
        priority_queue<pair<int,int>> pq;
        for(auto v: ma){
            for(auto p:v){
                pq.push(p);
            }
        }
        //return 10 most recent

        int k=min(10,(int)pq.size());
        while(k--){
            ans.push_back(pq.top().second);
            pq.pop();
        }
        return ans;
    }

public:
    Twitter() {
        t=0;
    }
    
    void postTweet(int userId, int tweetId) {
        listOfTweets[userId].push_back({++t,tweetId});
    }
    
    vector<int> getNewsFeed(int userId) {
        vector<vector<pair<int,int>>> ma;
        //own
        ma.push_back(listOfTweets[userId]);
        //following
        for(auto id: following[userId]){
            ma.push_back(listOfTweets[id]);
        } 
        return f(ma);
    }
    
    void follow(int followerId, int followeeId) {
        following[followerId].insert(followeeId);
    }
    
    void unfollow(int followerId, int followeeId) {
        following[followerId].erase(followeeId);
    }
};

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter* obj = new Twitter();
 * obj->postTweet(userId,tweetId);
 * vector<int> param_2 = obj->getNewsFeed(userId);
 * obj->follow(followerId,followeeId);
 * obj->unfollow(followerId,followeeId);
 */
```
