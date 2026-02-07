
![image.png](../images/db3bb441-401b-4035-9269-080ce5d6803d--image.png)


# Pascal triangle

1. do questions from ppa
2. do questions from tle 
\
![image.png](../images/e64be96e-4cd2-4c66-8bd6-537ac2cae7a1--image.png)
![image.png](../images/3f1fe240-f86e-4e22-8ab2-727ef7482cf4--image.png)

The row has same number of colums as number of rows
![image.png](../images/2776f763-b95f-41d1-808b-baa252cfc778--image.png)

![image.png](../images/5cf576d1-e1cd-49dd-a367-b1ed52c2b77b--image.png)

![image.png](../images/132b80f9-41c0-4c93-8df3-2a9f1afa5749--image.png)



[leetcode.com](https://leetcode.com/problems/pascals-triangle/solutions/)
This matrix will directly give you ncr, so to calculature ncr you need a matrix of size n+1 * r+1 

```cpp
vector<vector<int>> generate(int rr) {
    vector<vector<int>> ma(rr,vector<int>(rr));
    for(int r=0;r<rr;r++){
        ma[r].resize(r+1);
        ma[r][0]=ma[r][r]=1;
        for(int c=1;c<r;c++){
            ma[r][c]=ma[r-1][c-1]+ma[r-1][c];
        }
    }
    return ma;
}
```


# Do without without creating the initial matrix 
```cpp
vector<vector<int>> generate(int rr) {
    vector<vector<int>> ma;
    vector<int> tmp;
    ma.push_back({1});
    for(int r=1;r<rr;r++){
        tmp.push_back(1);
        for(int c=1;c<r;c++){
            tmp.push_back(ma[r-1][c-1]+ma[r-1][c]);
        }
        tmp.push_back(1);
        ma.push_back(tmp);
        tmp.clear();
    }
    return ma;
}
```

# Optimal IS for generting a row
 ![image.png](../images/a1c44d79-2d52-44bb-9028-5a3735af0a7f--image.png)
 ![image.png](../images/221fdbf6-6d26-4889-acc6-10f9b300a0dd--image.png)
 

# Getting rows efficiently
```cpp
vector<int> getRow(int rr) {
    rr++;
    vector<int> ans;
    ans.push_back(1);
    for(int c=1; c<rr;c++) ans.push_back(((long long)ans[c-1]*(rr-c))/c);
    return ans;
}
```

You could use this answer answer to generate the matrix in the same time complexity
