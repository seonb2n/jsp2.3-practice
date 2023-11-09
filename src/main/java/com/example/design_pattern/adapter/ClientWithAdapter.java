package com.example.design_pattern.adapter;

public class ClientWithAdapter {

    public static void main(String[] args) {
        AdapterServiceA ada = new AdapterServiceA();
        AdapterServiceB adb = new AdapterServiceB();

        ada.runService();
        adb.runService();
    }

}
