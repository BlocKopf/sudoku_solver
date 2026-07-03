package com.suso;

public class Field {
    private int _gameSize;
    private int _fieldValue;
    private DataList<String,Integer> _marks;
    
    public Field(int gameSize){
        this._gameSize = gameSize;
        this._marks = new DataList<String,Integer>(gameSize);
        this._marks.lockSize();
    }

}
