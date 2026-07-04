package com.suso.lock;

public class HardLock extends GenLock{
    public HardLock(){super();}
    @Override
    public void lock(){if(!super.get()){super.lock();}}
    @Override
    public void change(){if(!super.get()){super.lock();}}
}