package code.src.main.java.lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl;

import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Fielder;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Player;

public class PureBatsman implements Player, Fielder{

    @Override
    public void bat() {
        // TODO Auto-generated method stub
        System.out.println("Pure Batsmen Batting");
    }

    @Override
    public void field() {
        // TODO Auto-generated method stub
        System.out.println("Pure Batsmen Fielding");
    }
    
}
