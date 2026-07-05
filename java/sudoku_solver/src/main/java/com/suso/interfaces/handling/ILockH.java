package com.suso.interfaces.handling;

public interface ILockH {
    public void set(Boolean value);
    public void lock();
    public void unlock();
    public void change();
    public Boolean get();
}
