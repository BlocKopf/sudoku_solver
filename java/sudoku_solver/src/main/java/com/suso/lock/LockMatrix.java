package com.suso.lock;

public class LockMatrix {
//FIELDS
    private GenLock _sLock;
    private HardLock _hLock;
//CONSTRUCTOR
    public LockMatrix(){}
//SETTER
    public void set_soft(boolean value){if(!this._hLock.get()){this._sLock.set(value);}}
    public void set_hard(boolean value){this._hLock.set(value);}
//LOCKING
    public void lock_soft(){this.set_soft(true);}
    public void lock_hard(){this.set_hard(true);}
    public void unlock_soft(){this.set_soft(false);}
    public void unlock_hard(){this.set_hard(false);}
    public void change_soft(){this.set_soft(!this._sLock.get());}
    public void change_hard(){this.set_hard(!this._hLock.get());}
//GETTER
    public boolean get_soft(){return this._sLock.get();}
    public boolean get_hard(){return this._hLock.get();}
}
