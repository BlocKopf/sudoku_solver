package com.suso.lock;

public class GenLock implements ILockHandler{
    //FIELDS
    private boolean _val;
//SHADOWS
    private void _init(){this._val=false;}
//CONSTRUCTORS
    public GenLock(){this(false);}
    public GenLock(boolean value){this._val=false;}
//ACTIONS
    @Override
    public void set(boolean lock){this._val=lock;}
    @Override
    public void lock(){if(!this._val){this._val=!this._val;}}
    @Override
    public void unlock(){if(this._val){this._val=!this._val;}}
    @Override
    public void change(){this._val=!this._val;}
    @Override
    public boolean get(){return this._val;}
}
