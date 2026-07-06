package com.subu.comp.field;
public class Board {
//FIELDS
    private int _size;
    private int[] _fields;
//SHADOWS
    private void _initFields(){this._fields = new int[this._size];}
    private boolean _checkPos(int pos){return (pos>=0 && pos<this._fields.length);}
//CONSTRUCTOR
    public Board(){}
//SETTER
    public void set(int size){this._size = size;}
    public void editPos(int value,int pos){if(this._checkPos(pos)){this._fields[pos] = value;};}
}