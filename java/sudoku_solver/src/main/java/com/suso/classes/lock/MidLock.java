package com.suso.classes.lock;

import com.suso.enums.LockAuth;

public class MidLock extends Lock{
//CONSTRUCTOR
    public MidLock(){super(false);}
    public MidLock(Boolean input){super(input);}
//SHADOWS
    @Override
    protected void _init(){super._init();}
    private Boolean auth(LockAuth need, LockAuth check){return need == check;}
//AUTH ACTIONS
    public void lock(LockAuth auth){if(this.auth(LockAuth.LOCK, auth)){super.lock();}}
    public void unlock(LockAuth auth){if(this.auth(LockAuth.UNLOCK, auth)){super.unlock();}}
    public void change(LockAuth auth){if(this.auth(LockAuth.CHANGE, auth)){super.change();}}
    public void set(LockAuth auth, Boolean input){if(this.auth(LockAuth.SET, auth)){super.set(input);}}
}
