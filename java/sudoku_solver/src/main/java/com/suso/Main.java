package com.suso;

public class Main {
    public static void main(String[] args) {
        DataList Test = new DataList<Integer,Integer>(0);
        Test.add(0, 0).add(1, 1);
        Test.print();
        Test.remByPos(1);
        Test.print();
    }
}