package com.suso;

import java.util.HashMap;

public class Row{
    private HashMap<Integer,Integer> _content;
    int _gamesize;
    
    public Row(int gamesize){
        this._init(gamesize);
    }

    private void _init(int size){
        this._content = new HashMap<Integer,Integer>();
        for(int index = 0 ; index < this._gamesize ; index++){this._content.put(index+1, 0);}    
    }

    public fill(int[] entries){
        if(entries.length == this._gamesize){
            for(int index = 0 ; index < this._gamesize ; index++){
                this._content.put(index+1, entries[index]);
            }
        }
    }
}