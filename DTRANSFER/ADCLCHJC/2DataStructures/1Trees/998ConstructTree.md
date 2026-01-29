---
title: 998ConstructTree
---

{% raw %}
Only when there are no duplicates in the tree   
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0001.png)

preorder and postorder ?

```python
TreeNode* f(int i1, int j1, int i2, int j2, vector<int>& preorder, vector<int>& inorder){
    if(i1>j1) return nullptr;
    TreeNode* root=new TreeNode(preorder[i1],nullptr,nullptr);
    //finding idx of root in inorder traversal
    int rootIdx;
    for(rootIdx=i2;rootIdx<=j2;rootIdx++) if(inorder[rootIdx]==preorder[i1]) break;
    root->left=f(i1+1,i1+rootIdx-i2,i2,rootIdx-1,preorder,inorder);
    root->right=f(i1+rootIdx-i2+1,j1,rootIdx+1,j2,preorder,inorder);
    //rootIdx-1-i2+1=X-i1-1+1
    //X=rootIdx+i1-i2
    return root;
}


TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    int n=preorder.size();
    return f(0,n-1,0,n-1,preorder,inorder);
}
```

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0002.png)

Finding the root effectively in the inorder traversal, so we dont have to traverse the whole inorder array every time.

```python
//Preprocessing
for(int i=0;i<n;i++) m[inorder[i]]=i;
//we can instantly tell the idx of any element in the inorder array
//hence for root also
```

```python
TreeNode* f(int i1, int j1, int i2, int j2, vector<int>& preorder, vector<int>& inorder, unordered_map<int,int>& mp){
    if(i1>j1) return nullptr;
    TreeNode* root=new TreeNode(preorder[i1],nullptr,nullptr);
    int idxRoot=mp[preorder[i1]];
    root->left=f(i1+1,i1+idxRoot-i2,i2,idxRoot-1,preorder,inorder,mp);
    root->right=f(i1+idxRoot-i2+1,j1,idxRoot+1,j2,preorder,inorder,mp);
    return root;
}


TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    int n=preorder.size();
    unordered_map<int,int> mp; 
    for(int idx=0;idx<n;idx++) mp[inorder[idx]]=idx; 
    return f(0,n-1,0,n-1,preorder,inorder,mp);
}
```

from inorder and postorder similarly

The last node of postorder traversal is the root

# Inorder and level order     
fit coder

https://www.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0003.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0004.png)

root of the tree will be the first node of the level order traversal

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0005.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0006.png)

first value at level order is always root value

```python
Node* build(vector<int> inorder, vector<int> levelOrder, int io1, int io2) {
    if(io1>io2){
        return nullptr;
    }
    Node* root= new Node(levelOrder[0]);
    if(io1==io2){
        return root;
    }
    int idxRoot;
    for(idxRoot=io1;idxRoot<=io2;idxRoot++){
        if(root->key==inorder[idxRoot]){
            break;
        }
    }
    unordered_set<int> leftTreeSet;
    for(int i=io1;i<idxRoot;i++){
        leftTreeSet.insert(inorder[i]);
    }
    
    vector<int> lLevel,rLevel;
    for(int i=1;i<levelOrder.size();i++){
        if(leftTreeSet.count(levelOrder[i])){
            lLevel.push_back(levelOrder[i]);
        }
        else{
            rLevel.push_back(levelOrder[i]);
        }
    }
    root->left=build(inorder,lLevel,io1,idxRoot-1);
    root->right=build(inorder,rLevel,idxRoot+1,io2);
    return root;
    
}

Node* buildTree(int inorder[], int levelOrder[], int io1, int io2, int n) {
    vector<int> inorderV,levelOrderV;
    for(int i=0;i<n;i++){
        inorderV.push_back(inorder[i]);
        levelOrderV.push_back(levelOrder[i]);
    }
    return build(inorderV,levelOrderV,0,n-1);
}
```

preorder and postorder ?

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0007.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0008.png)

counter example, I am getting same example from GPTs also

The above are not full binary trees

# MAANG

If the tree is known to be full, then preorder and postorder together are sufficient to uniquely reconstruct the binary tree.

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0009.png)

https://youtu.be/6JDV3kIFyjU?si=bFvhL-mUSlZykFes

it is wiser to return the full tree, but i dont know how to do that

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0010.png)

he also not done any thing different

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0011.png)

```python
class Solution {
public:
    TreeNode* f(int i1, int j1, int i2, vector<int>& preorder, vector<int>& postorder){
        if(i1>j1){
            return nullptr;
        }
        TreeNode* root=new TreeNode(preorder[i1]);
        if(i1==j1){
            return root;
        }
        int leftSubTreeRootVal=preorder[i1+1];
        //find this in postorder
        int leftSubTreeRootIdxInPostorder;
        for(leftSubTreeRootIdxInPostorder=i2;leftSubTreeRootIdxInPostorder<=j2;leftSubTreeRootIdxInPostorder++){
            if(postorder[leftSubTreeRootIdxInPostorder]==leftSubTreeRootVal) break;
        }
        int sizeOfLST=leftSubTreeRootIdxInPostorder-i2+1;
        //writing clean code
        root->left=f(i1+1, (i1+1)+sizeOfLST-1, i2, preorder, postorder);
        root->right=f((i1+1)+sizeOfLST,j1,i2+sizeOfLST,preorder,postorder);
        return root;
    }


    TreeNode* constructFromPrePost(vector<int>& preorder, vector<int>& postorder) {
        int n=preorder.size();
        return f(0,n-1,0,preorder,postorder);
    }
};
```

https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0012.png)

https://youtu.be/WN0quIK89F0?si=AhQ6kwxoegJ969ZF

```python
TreeNode* f(string &s, int &idx, int depth, int n){
    if(idx>=n) return nullptr;
    int dashes=0;

    int i=idx;
    while(i<n and s[i]=='-'){
        dashes++;
        i++;
    }

    if(dashes!=depth) return nullptr;
    idx+=dashes;

    string num="";
    while(i<n and isdigit(s[i])){
        num.push_back(s[i]);
        i++;
    }
    int lenOfNum=num.size();
    idx+=lenOfNum;

    TreeNode* root= new TreeNode(stoi(num));
    root->left=f(s,idx,depth+1,n);
    root->right=f(s,idx,depth+1,n);

    return root;
}


TreeNode* recoverFromPreorder(string s) {
    // If a node has only one child, that child is guaranteed to be the left child
    int n=s.size();
    int idx=0;
    int depth=0;
    return f(s,idx,depth,n);
}
```

an approach

```python
void heightMap2LevelOrder(map<int, vector<int>> &m, vector<int> &levelorder){
    for(auto p: m){
        for(int x: p.second){
            levelorder.push_back(x);
        }
    }
}

TreeNode* recoverFromPreorder(string s) {
    // If a node has only one child, that child is guaranteed to be the left child
    int n=s.size();
    int cnt=0;
    string num="";
    map<int, vector<int>> m;
    vector<int> preorder;
    for(int i=0;i<n;){
        while(i<n and s[i]=='-'){
            cnt++;
            i++;
        }
        while(i<n and isdigit(s[i])){
            num.push_back(s[i]);
            i++;
        }
        preorder.push_back(stoi(num));
        m[cnt].push_back(stoi(num));
        cnt=0;
        num="";
    }
    vector<int> levelorder;
    heightMap2LevelOrder(m,levelorder);
    int N=levelorder.size();
    return nullptr;
}
```

# Expression tree

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0013.png)

impimppimpimpimp

Inorder traversal of expression tree produces infix version sanity check them

postfix expression (same with postorder traversal it gives postfix expression) sanity check them

impimppimpimpimp

leetcode prem    
https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/description/

Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.

```python
/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

 class Node {
    public:
        virtual ~Node () {};
        virtual int evaluate() const = 0;
    protected:
        // define your fields here
    };
    
    
    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input 
     * and returns the expression tree representing it as a Node.
     */
    
    class TreeBuilder {
    public:
        Node* buildTree(vector<string>& postfix) {
            
        }
    };
    
    
    /**
     * Your TreeBuilder object will be instantiated and called as such:
     * TreeBuilder* obj = new TreeBuilder();
     * Node* expTree = obj->buildTree(postfix);
     * int ans = expTree->evaluate();
     */
```

from infix? Jenny recommned convert infix to postfix first, then construct the tree from postfix

# from postfix: the easiest  
https://youtu.be/WHs-wSo33MM?si=1U_1DA9kf2yA10ep

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0014.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0015.png)

```python
class Node {
    public:
        virtual ~Node () {};
        virtual int evaluate() const = 0;
    protected:
        // define your fields here
    };
    
    class CustomNode : public Node {
    public:
        string val;
        Node *left, *right;
    
        CustomNode(string v) : val(v), left(nullptr), right(nullptr) {}
    
        int evaluate() const override {
            if (val == "+") return left->evaluate() + right->evaluate();
            if (val == "-") return left->evaluate() - right->evaluate();
            if (val == "*") return left->evaluate() * right->evaluate();
            if (val == "/") return left->evaluate() / right->evaluate();
            return stoi(val); // it's a number
        }
    };
    
    
    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input 
     * and returns the expression tree representing it as a Node.
     */
    
    class TreeBuilder {
    public:
    
    Node* postfixToExpressionTree(vector<string>& postfix) {
        if (postfix.empty()) {
            return nullptr;
        }
    
        stack<CustomNode*> s;
    
        for (string st : postfix) {
            if (st=="+" or st=="-" or st=="/" or st=="*") { 
                CustomNode* rightChild = s.top();
                s.pop();
                CustomNode* leftChild = s.top();
                s.pop();
    
                CustomNode* operatorNode = new CustomNode(st);
                operatorNode->left = leftChild;
                operatorNode->right = rightChild;
                s.push(operatorNode);
            } 
            else{
                s.push(new CustomNode(st));
            }
        }
        return s.top();
    }
    
        Node* buildTree(vector<string>& postfix) {
            return postfixToExpressionTree(postfix);
        }
    };
```

# Evaluate expression tree

https://www.naukri.com/code360/problems/evaluate-expression-tree_975484?isSignin=true

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0016.png)

evaluate the lst and rst then involving the node

//base case: leaf node just return its value

```python
int evaluateExpression(BinaryTreeNode<string> *node) {
	if(!node) return 0;
	if(!node->left and !node->right) return stoi(node->data);
	int lVal=evaluateExpression(node->left);
	int rVal=evaluateExpression(node->right);
	if (node->data == "+") return lVal + rVal;
	if (node->data == "-") return lVal - rVal;
	if (node->data == "*") return lVal * rVal;
	return lVal / rVal;
}
```

# from infix

tough jenny

# New Problem

https://leetcode.com/discuss/

convert-a-ternary-expression-to-a-tree

https://www.naukri.com/code360/problems/ternarytotree_1102306

# MAANG++ VERY TOUGH

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0017.png)

https://www.geeksforgeeks.org/problems/redundant-parenthesis--170647/1

https://www.spoj.com/problems/CMEXPR/

remove as many brackets as possible such that the expression is still valid

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0018.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0019.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0020.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0021.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0022.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0023.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0024.png)

whenever we go from lower precedence to higher precedence, we need to add brackets

java and js have eval which uses this uth

Brackets should also be added when we have expressions like a-(b-c). Simply following this method will yield us a-b-c which is not correct

 think building Expression Tree from postfix expression would be more efficient,

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_998ConstructTree__att_0025.png)

I guess we can convert the given expression into post-fix expression (where we can eliminate all the parenthesis) and then we can evaluate the post-fix expression to generate the required in-fix expression(as you said when we move from lower precedence operator to higher precedence operator, we insert parenthesis)

https://www.spoj.com/problems/CMEXPR/

https://g.co/gemini/share/059e0423abfc

```python
using namespace std;
#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
typedef tree<long long, null_type, less_equal<long long>, rb_tree_tag, tree_order_statistics_node_update> pbds;
#define ll long long
#define inf 9*1e18
#define it(v) v.begin(),v.end() 
#define nl '\n'
#define vl vector<ll>
#define vd vector<long double>
#define vvl vector<vector<ll>>
#define vvd vector<vector<long double>>
#define iinp(x) ll x; cin>>x; cin.ignore(); 
#define vinp(name,size) vector<ll>name (size); for(int i=0;i<size;i++) {cin>>name[i];cin.ignore();}
#define sinp(x) string x; getline(cin,x);
#define vosi(x,n) vector<string> x(n);for(int i=0;i<n;i++){getline(cin, x[i]);}
void priv(vector<ll> &v){for(int i=0;i<v.size();i++){cout<<v[i]<<" ";}cout<<'\n';}
void prim(vector<vector<ll>> &ma){for(int i=0;i<ma.size();i++){for(int j=0;j<ma[i].size();j++){cout<<ma[i][j]<<" ";}cout<<'\n';}}
template<typename... T> void print(T&&... args){((cout << args <<" "), ...);cout<<'\n';}
template<typename... T> void inp(T&... args){((cin >> args && cin.ignore()), ...);}
// #define lld long double
// #define ull unsigned long long  
void _print(int t) {cerr << t<<'\n';}
void _print(ll t) {cerr << t<<'\n';}
void _print(string t) {cerr << t<<'\n';}
void _print(char t) {cerr << t<<'\n';}
// void _print(lld t) {cerr << t<<'\n';}
void _print(double t) {cerr << t<<'\n';}
// void _print(ull t) {cerr << t<<'\n';}  
template <class T, class V> void _print(pair <T, V> p);
template <class T> void _print(vector <T> v);
template <class T> void _print(set <T> v);
template <class T, class V> void _print(map <T, V> v);
template <class T> void _print(multiset <T> v);
template <class T, class V> void _print(pair <T, V> p) {_print(p.first); cerr << " "; _print(p.second); cerr << '\n';}
template <class T> void _print(vector <T> v) {for (T i : v){_print(i);}cerr <<'\n';}    
template <class T> void _print(set <T> v) {for (T i : v) {_print(i); } cerr << '\n';}
template <class T> void _print(multiset <T> v) {for (T i : v) {_print(i);} cerr << '\n';}
template <class T, class V> void _print(map <T, V> v) {for (auto i : v) {_print(i);} cerr <<'\n';}
#define mod 1000000007
// #define mod 998244353
ll moda(ll a, ll b) {a = a % mod; b = b % mod; return (((a + b) % mod) + mod) % mod;}
ll modm(ll a, ll b) {a = a % mod; b = b % mod; return (((a * b) % mod) + mod) % mod;}
ll mods(ll a, ll b) {a = a % mod; b = b % mod; return (((a - b) % mod) + mod) % mod;}
ll mpow(ll base, ll exp){base %= mod;ll result = 1;while (exp > 0) {if (exp & 1) result = ((long long)result * base) % mod;base = ((long long)base * base) % mod;exp >>= 1;}return result;}    
ll inv(ll a, ll m) {return mpow(a, m - 2);}
ll modd(ll a, ll b) {a = a % mod; b = b % mod; return (modm(a, inv(b, mod)) + mod) % mod;}
bool isValid(ll r, ll c , ll rr, ll cc){return r>=0 and r<rr and c>=0 and c<cc;	}

const int MAX = 1e5 + 5;
ll fact[MAX];

void computeFact() {
    fact[0] = 1;
    for (int i = 1; i < MAX; i++) {
        fact[i] = (fact[i - 1] * i) % mod;
    }
}

ll ncr(int n, int r) {
    if (r < 0 || r > n) return 0;
    ll numerator = fact[n];
    ll denominator = (fact[r] * fact[n - r]) % mod;
    return modd(numerator, denominator);  // a / b % mod
}  


// #define int ll
// #define ll int
// cout << fixed << setprecision(6) << ans << "\n";

/*


*/
char oneLevelBelowOp, twoLevelBelowOp;

int prec(char c){
    if(c=='^') return 3;
    if(c=='*' or c=='/') return 2;
    if(c=='+' or c=='-') return 1;
    return 0;
}

//brackets will be removed here
vector<string> i2p(string &s) {
    vector<string> ans;
    stack<string> st;
    int n = s.size();
    int i = 0;

    while (i < n) {
        char c = s[i];
        string tmp;

        if(isalpha(s[i])) {
            while(i < n and isalpha(s[i])) {
                tmp.push_back(s[i]);
                i++;
            }
            ans.push_back(tmp);
        }else if(c == '(') {
            st.push("(");
            i++;
        }else if(c == ')') {
            while(st.size() and st.top() != "(") {
                ans.push_back(st.top());
                st.pop();
            }
            if(st.size()) {
                st.pop();
            }
            i++;
           }
           else{
                while (st.size() && prec(st.top()[0]) >= prec(c)) {
                    ans.push_back(st.top());
                    st.pop();
                }
                string tmp(1,c);
                st.push(tmp);
                i++;
            }
        }

        while (st.size()) {
            ans.push_back(st.top());
            st.pop();
        }
        
        return ans;
    
    }

void removeSpace(string &s){
    string ans;
    int n=s.size();
    for(char c: s){
        if(c!=' ') ans.push_back(c);
    }
    s=ans;
}

void insertZero(string &s){
    string ans;
    int n=s.size();
    if(s[0]=='-') ans.push_back('0');
    for(int i=0;i<n;i++){
        ans.push_back(s[i]);
        if(i+1<n and s[i]=='(' and s[i+1]=='-'){
            ans.push_back('0');
        } 
    }
    s=ans;
}

string eval(vector<string> &vos) {
    stack<string> st;
    for(string s: vos){
        if(s=="+" or s=="-" or s=="/" or s=="*"){
            string oneLevelBelowExp=st.top();
            st.pop();
            string twoLevelBelowExp=st.top();
            st.pop();
            char currOp=s[0];
            if(oneLevelBelowOp!='$' and prec(oneLevelBelowOp)<prec(currOp)){
                oneLevelBelowExp="("+oneLevelBelowExp+")";
            }
            if(twoLevelBelowOp!='$' and prec(twoLevelBelowOp)<prec(currOp)){
                twoLevelBelowExp="("+twoLevelBelowExp+")";
            }
            string currExp;
            switch(currOp){
                case '+':
                    currExp=(twoLevelBelowExp+"+"+oneLevelBelowExp);
                    break;
                case '-':
                    currExp=(twoLevelBelowExp+"-"+oneLevelBelowExp);
                    break;
                case '*':
                    currExp=(twoLevelBelowExp+"*"+oneLevelBelowExp);
                    break;
                case '/':
                    currExp=(twoLevelBelowExp+"/"+oneLevelBelowExp);
                    break;                    
            }
            st.push(currExp);
            twoLevelBelowExp=oneLevelBelowOp;
            oneLevelBelowExp=currExp;
            twoLevelBelowOp=oneLevelBelowOp;
            oneLevelBelowOp=currOp;
        }
        else{
            st.push(s);
        }
        
    }
    return st.top();
}



string calculate(string &s) {
    vector<string> tmp= i2p(s);
    // for(auto ss: tmp){
    //     cout<<ss<<endl;
    // }
    // removeZero(s);
    oneLevelBelowOp='$';
    twoLevelBelowOp='$';
    return eval(tmp);
}

void solve(){
    sinp(s);
    string ans=calculate(s);
    print(ans);
}

void testcases(){
    int ttt;
    ttt=1;
    cin>>ttt;cin.ignore();
    //precomputaion
    // computeFact();



    //precomputaion
    for(int i=1;i<=ttt;i++){
        _print("TC "+to_string(i));
        solve();        
    }

    cerr<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
}

void initiate(){
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    #ifndef ONLINE_JUDGE
    freopen("/Users/tarunmali/yTM/code/HLD/2025/presentWorkingDirectory/input.txt", "r", stdin);
    freopen("/Users/tarunmali/yTM/code/HLD/2025/presentWorkingDirectory/output.txt", "w", stdout);
    freopen("/Users/tarunmali/yTM/code/HLD/2025/presentWorkingDirectory/error.txt", "w", stderr);
    #endif
}
int32_t main(){
    initiate();
    testcases();
}
```

# Perfect tree from level order traversal

unable to find the problem
{% endraw %}
