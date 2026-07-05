package com.suso.classes.lock;
import com.suso.classes.data.GenData;
public abstract class Lock extends GenData<Boolean>{
//FIELDS
    protected boolean _value;
//SHADOWS
    protected void _init(){this.set(false);};
//CONSTRUCTORS
    public Lock(){super(false);}
    public Lock(Boolean value){super(value);}
//SETTER
    public void set(Boolean value){this._value = value;}
//GETTER
    public Boolean get(){return this._value;};
//ACTIONS
    protected void lock(){if(!this.get()){this.set(this.get());}};
    protected void unlock(){if(this.get()){this.set(!this.get());}};
    protected void change(){this.set(!this.get());};
}
