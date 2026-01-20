


# Just add 1
[Just a moment...](https://leetcode.com/problems/plus-one/editorial/)
 the observation, start from ends keep changing all 9 to 0, first non 9, add +1

```
class Solution {
    private void fillArray(int [] digits){
        int n= digits.length;
        digits[0]=1;
        for(int i=1;i<n;i++){
            digits[i]=0;
        }
    }

    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int idx=n-1;
        while(idx>=0 && digits[idx]==9){
            digits[idx]=0;
            idx--;
        }
        if(idx<0){
            // int[] newDigit=new int[n+1];
            // fillArray(newDigit);
            // return newDigit;  
            digits=new int[n+1];
            digits[0] = 1;
            return digits;
        }
        digits[idx]++;
        return digits;
        
    }
}
```

