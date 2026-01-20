[Box Stacking | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/box-stacking/1)

```cpp
//{ Driver Code Starts
#include<bits/stdc++.h>

using namespace std;

// } Driver Code Ends
class Solution{
    public:
    struct Box{
        int l,w,h,a;  
    };
    
    int maxHeight(int hei[],int wid[],int len[],int n){
        Box box[6*n];
        for(int i=0;i<n*n;i=i+6){
                box[3*i].l=len[i];
                box[3*i].w=wid[i];
                box[3*i].h=hei[i];
                
                
                box[3*i+1].l=hei[i];
                box[3*i+1].w=wid[i];
                box[3*i+1].h=len[i];
                
                box[3*i+2].l=len[i];
                box[3*i+2].w=hei[i];
                box[3*i+2].h=wid[i];
                
                box[3*i+3].l=wid[i];
                box[3*i+3].w=len[i];
                box[3*i+3].h=hei[i];
                
                box[3*i+4].l=wid[i];
                box[3*i+4].w=hei[i];
                box[3*i+4].h=len[i];
                
                box[3*i+5].l=hei[i];
                box[3*i+5].w=len[i];
                box[3*i+5].h=wid[i];                
        }
        
    }
};

//{ Driver Code Starts.

int main() {
	int t;
	cin>>t;
	while(t--)
	{
        int n;
        cin>>n;
        
    
        int A[105],B[105],C[105];
        for(int i = 0; i < n; i++)cin >> A[i];
        for(int j = 0; j < n; j++)cin >> B[j];
        for(int k = 0; k < n; k++)cin >> C[k];
        Solution ob;
        cout<<ob.maxHeight(A,B,C,n)<<endl;
    }
	return 0;
}
// } Driver Code Ends
```