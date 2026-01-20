```cpp
void union_(int i, int j){
    if(find(i)==find(j)) return;
    int rooti=find(i),rootj=find(j);
    int sizei=size[rooti],sizej=size[rootj];
    if(size[rooti]<size[rootj]) swap(rooti,rootj);
    par[rootj]=rooti;
    size[rooti]+=size[rootj];
}

```