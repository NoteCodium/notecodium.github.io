package code.src.main.java.lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor;

import Zarchieve.LLD.examplesRefractor.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl.AllRounder;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Bowler;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Fielder;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Keeper;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Player;

public class CricGameHelper {
    //this class is only depending on interfaces  
    public void bat(Player player){
        player.bat();
    }

    public void bowl(AllRounder allRounder){
        allRounder.bowl();
    }   

    public void field(Fielder fielder){
        fielder.field();
    } 

    public void keep(Keeper keeper){
        keeper.keep();
    }   

}
