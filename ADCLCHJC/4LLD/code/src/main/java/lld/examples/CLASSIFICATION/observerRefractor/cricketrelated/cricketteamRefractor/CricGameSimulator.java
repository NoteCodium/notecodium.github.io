package code.src.main.java.lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor;

import java.util.List;

import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl.AllRounder;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl.KeeperImpl;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl.PureBatsman;

@RequiredArgsConstructor
public class CricGameSimulator {
    //Team
    //change to private?
    public final List<PureBatsman> pureBatsmen;
    public final List<AllRounder> allRounders;
    public final KeeperImpl keeperImpl;
    //This is important
    //Getting the methods of the interface
    public final CricGameHelper cricGameHelper;


    public void simulate(){
        System.out.println("Starting Simulation");

        startBatting();
        startBowling();
        startFielding();
        startKeeping();

        System.out.println("Ending Simulation");
    }

    public void startBatting(){
        System.out.println("Starting Batting");
        for(PureBatsmanImpl pureBatsmanImpl: pureBatsmen){
            cricGameHelper.bat(pureBatsman);
        }
        cricGameHelper.bat(keeperImpl);
        for(AllRounder allRounder: allRounders){
            cricGameHelper.bat(allRounder);
        }
        System.out.println("Ending Batting");
    }    

    public void startBowling(){
        System.out.println("Starting Bowling");
        for(PureBatsmanImpl pureBatsmanImpl: pureBatsmenList){
            cricGameHelper.bat(pureBatsmanImpl);
        }
        for(AllRounder allRounder: allRounders){
            cricGameHelper.bowl(allRounder);
        }
        System.out.println("Ending Bowling");
    }

    public void startFielding(){
        System.out.println("Starting Fielding");
        for(PureBatsmanImpl pureBatsmanImpl: pureBatsmenList){
            cricGameHelper.field(pureBatsmanImpl);
        }
        for(AllRounderImpl allRounderImpl: allRoundersImpl){
            cricGameHelper.field(allRounderImpl);
        }
        System.out.println("Ending Fielding");
    }

    public void startKeeping(){
        System.out.println("Starting Keeping");
        cricGameHelper.keep(keeperImpl);
        System.out.println("Ending Keeping");
    }

    public void startBowling(){
        System.out.println("Starting Bowling");
        for(AllRounder allRounder: allRounders){
            cricGameHelper.bowl(allRounder);
        }
        System.out.println("Ending Bowling");
    }

}
