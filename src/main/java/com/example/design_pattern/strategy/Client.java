package com.example.design_pattern.strategy;

public class Client {

    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext(new StrategyGun());
        soldier.runContext(new StrategySword());
    }

}
