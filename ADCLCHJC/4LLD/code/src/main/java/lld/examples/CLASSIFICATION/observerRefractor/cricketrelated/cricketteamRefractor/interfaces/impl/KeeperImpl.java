package code.src.main.java.lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl;

import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Keeper;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.Player;

public class KeeperImpl implements Keeper, Player{

    @Override
    public void keep() {
        // TODO Auto-generated method stub
        System.out.println("Keeper Keeping");
    }

    @Override
    public void bat() {
        // TODO Auto-generated method stub
        System.out.println("Keeper Batting");
    }
    
}
