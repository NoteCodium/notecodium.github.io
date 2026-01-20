1. xor

```java
    public static void swapCoreLogic(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        arr[index1]=arr[index1]^arr[index2];
        arr[index2]=arr[index1]^arr[index2];
        arr[index1]=arr[index1]^arr[index2];
        //121 1^2

        arr[index1]=arr[index1]+arr[index2];
        arr[index2]=arr[index1]-arr[index2];
        arr[index1]=arr[index1]-arr[index2];

    }
```
