package code.src.main.java.lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl;

import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Bowler;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Fielder;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Player;

public class AllRounder implements Player, Fielder, Bowler{

    @Override
    public void bowl() {
        System.out.println("Allrounder Bowling");
    }

    @Override
    public void field() {
        System.out.println("Allrounder Fielding");
    }

    @Override
    public void bat() {
        System.out.println("Allrounder Batting");
    }
    
}
