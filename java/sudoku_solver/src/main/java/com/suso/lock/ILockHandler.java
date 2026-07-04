package com.suso.lock;

public interface ILockHandler {
    public void set(boolean lock);
    public void lock();
    public void unlock();
    public void change();
    public boolean get();
}
