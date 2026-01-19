void pq(queue<pair<TreeNode*,int>> q){
    cout<<"Main Queue"<<endl;
    while(q.size()){
        if((q.front()).first){
            cout<<((q.front()).first)->val<<" ";
        }
        q.pop();
    }
    cout<<endl;
}

void pq(queue<TreeNode*> q){
    cout<<"Check Queue"<<endl;
    while(q.size()){
        cout<<(q.front())->val<<" ";
        q.pop();
    }
    cout<<endl;
}