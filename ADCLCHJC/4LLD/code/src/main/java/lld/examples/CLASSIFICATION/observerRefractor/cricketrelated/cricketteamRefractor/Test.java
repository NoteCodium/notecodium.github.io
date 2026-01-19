package code.src.main.java.lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor;

import java.util.List;

import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl.AllRounder;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl.KeeperImpl;
import lld.examples.CLASSIFICATION.observerRefractor.cricketrelated.cricketteamRefractor.interfaces.impl.PureBatsman;

import java.util.ArrayList;


public class Test {
    private static final int noOfBatsmen = 5;
    private static final int noOfAllRounders = 5;
    public static void main(String[] args) {
        List<PureBatsman> pureBatsmenList = new ArrayList<>();
        for(int i = 0; i < noOfBatsmen; i++){
            pureBatsmenList.add(new PureBatsman());
        }

        List<AllRounder> allRoundersList = new ArrayList<>();
        for(int i = 0; i < noOfAllRounders; i++){
            allRoundersList.add(new AllRounder());
        }
        CricGameSimulator cricGameSimulator = new CricGameSimulator(
            pureBatsmenList, allRoundersList, new KeeperImpl(), new CricGameHelper()
        );
        cricGameSimulator.simulate();
        
    }
}
