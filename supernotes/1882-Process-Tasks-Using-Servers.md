[Just a moment...](https://leetcode.com/problems/process-tasks-using-servers/description/)

two heaps,after design guru

[Process Tasks Using Servers - Leetcode 1882 - Python - YouTube](https://youtu.be/XKA22PecuMQ?si=1JdTnlOzVUlKeXLp)


```cpp
vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
    int ns=servers.size();
    int nt=tasks.size();
    V ans(nt);    
    vector<V> tmp1;
    for(int i=0;i<ns;i++) tmp1.push_back({servers[i],i});
    priority_queue<V, vector<V>,greater<V>> freeServers(tmp1.begin(),tmp1.end());
    //weight,idx (identified by them)

    priority_queue<V, vector<V>,greater<V>> inUseServers;
    //timeAtWhichItWillBecomeFree,weight,idx

    //Doubt why not queue, why timeOfCompletion
    queue<V> waitingTasks;
    //idx,timeOfCompletion

    //for the period in which every second new task are added to task queue
    for(int t=0;t<nt;t++){
        //empty the inUseServers which will be freed at this t
        while(!inUseServers.empty() and inUseServers.top()[0]<=t){
            V tmp2={inUseServers.top()[1],inUseServers.top()[2]};inUseServers.pop();
            freeServers.push(tmp2);
        }

        //DOUBT
        waitingTasks.push({t,tasks[t]});

        while(!freeServers.empty() and !waitingTasks.empty()){
            V currServer = freeServers.top();freeServers.pop();


            V currTask = waitingTasks.front();waitingTasks.pop();

            int freeTime = t + currTask[1];
            int serverWeight=currServer[0];
            int serverIndex = currServer[1];

            inUseServers.push({freeTime, serverWeight, serverIndex});
            ans[currTask[0]] = serverIndex;
        }   
    }

    priority_queue<V, vector<V>,greater<V>> freeServers2(inUseServers);
    while(!freeServers.empty()){
        freeServers2.push({nt,freeServers.top()[0],freeServers.top()[1]});
        freeServers.pop();
    }

    while(!waitingTasks.empty() and !freeServers2.empty()){
        V currServer = freeServers2.top();freeServers2.pop();
        V currTask = waitingTasks.front();waitingTasks.pop();
        ans[currTask[0]]=currServer[2];
        freeServers2.push({currServer[0]+currTask[1],currServer[1],currServer[2]});
    }

    return ans;
}
```




--------------------------------------------------------------------

```cpp
vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
    int nt=tasks.size();
    int ns=servers.size();
    V ans(nt);    
    vector<V> tmp1;
    for(int i=0;i<ns;i++) tmp1.push_back({servers[i],i});
    priority_queue<V, vector<V>,greater<V>> freeServers(tmp1.begin(),tmp1.end());
    //weight,idx
    priority_queue<V, vector<V>,greater<V>> usedServers;
    //timeAtWhichItWillBecomeFree,weight,idx
    priority_queue<V, vector<V>,greater<V>> waitingTasks;
    //idx,timeOfCompletion
    for(int t=0;t<nt;t++){
        while(!usedServers.empty() and usedServers.top()[0]<=t){
            V tmp2={usedServers.top()[1],usedServers.top()[2]};
            usedServers.pop();
            freeServers.push(tmp2);
        }

        waitingTasks.push({t,tasks[t]});

        while(!freeServers.empty() and !waitingTasks.empty()){
            V currServer = freeServers.top();freeServers.pop();
            V currTask = waitingTasks.top();waitingTasks.pop();

            int freeTime = t + currTask[1];
            int serverIndex = currServer[1];

            usedServers.push({freeTime, currServer[0], serverIndex});
            ans[currTask[0]] = serverIndex;
        }   
    }
    while(!waitingTasks.empty()){
        V tmp2={usedServers.top()[1],usedServers.top()[2]};
        int ttt=usedServers.top()[0];
        usedServers.pop();
        freeServers.push(tmp2);

        V currServer = freeServers.top();freeServers.pop();
        V currTask = waitingTasks.top();waitingTasks.pop();

        int freeTime = ttt+currTask[1];
        int serverIndex = currServer[1];

        usedServers.push({freeTime, currServer[0], serverIndex});
        ans[currTask[0]] = serverIndex;
    }

    return ans;
}
```
