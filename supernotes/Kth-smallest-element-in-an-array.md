[](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)
1. f(x)====> no of elements <=x
2. If f(x)>=k then x can be the kth smallest, but elements smaller then it can still exist
3. f(x)<k then x can not be the kth smallest element

# Writing an efficient cnt function if the array is sorted 
# If the array is not sorted, we are doing the problem in nlogn without destroying the array => binary search on answer


