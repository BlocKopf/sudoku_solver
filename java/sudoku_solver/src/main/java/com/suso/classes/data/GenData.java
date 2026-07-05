package com.suso.classes.data;

public abstract class GenData<DType>{
//FIELDS
    private DType _content;
//IGNITOR
    protected abstract void _init();
//CONSTRUCTORS
    public GenData(){this(null);}
    public GenData(DType input){this._init();this.set(_content);};
//SETTER
    public abstract void set(DType input);
//GETTER
    public abstract DType get();
}
