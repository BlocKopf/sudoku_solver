package com.suso;

public class Field {
    private int _gameSize;
    private int _fieldValue;
    private DataList<String,Boolean> _marks;
    
    public Field(int gameSize){
        this._gameSize = gameSize;
        this._marks = new DataList<String,Boolean>(gameSize);
        this._marks.lockSize();
    }

    public void mtFill(){
        for(int index=0;index<this._gameSize;index++){
            this._marks.editPos(
                index, 
                String.join(":", "M",String.valueOf(index+1)), 
                false
            );
        }
    }
}
