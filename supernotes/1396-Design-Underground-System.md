```cpp

//volatile memory
//manu users at a sinle time 
//small small task, so not all the conpute power can be given it to it alone
class UndergroundSystem {
    unordered_map<string,pair<double,int>>travelTime;
    unordered_map<int,pair<string,int>> checkInInfo;
public:
    UndergroundSystem() {
        
    }
    
    void checkIn(int id, string station, int t) {
        checkInInfo[id]={station,t};
    }
    
    void checkOut(int id, string station, int t) {
        auto c=checkInInfo[id];
        checkInInfo.erase(id);
        string jour=c.first+"-"+station;
        int tt=t-c.second;
        travelTime[jour].first+=tt;
        travelTime[jour].second++;
    }
    
    double getAverageTime(string start, string end) {
        string journ=start+"-"+end;
        // if(!travelTime.count(journ)) return 0;
        int totalTime=travelTime[journ].first;
        int cnt=travelTime[journ].second;
        return totalTime*1.0/cnt;
    }
};

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem* obj = new UndergroundSystem();
 * obj->checkIn(id,stationName,t);
 * obj->checkOut(id,stationName,t);
 * double param_3 = obj->getAverageTime(startStation,endStation);
 */

 ```