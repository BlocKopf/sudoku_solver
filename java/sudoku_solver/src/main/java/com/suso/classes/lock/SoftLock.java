package com.suso.classes.lock;

public class SoftLock extends Lock{
//CONSTRUCTOR
    public SoftLock(){this._init();}
    public SoftLock(Boolean value){this();this.set(value);}
//SHADOWS
    @Override
    protected void _init(){super.set(false);}
//ACTIONS
    @Override
    public void lock(){if(!this.get()){this.change();}}
    @Override
    public void unlock(){if(this.get()){this.change();}}
    @Override
    public void change(){this.set(!get());}
}
