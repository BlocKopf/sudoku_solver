package com.suso.interfaces.handling;

public interface IGenH<DType> {
//INTERACTIONS
    public void _init();
    public void set(DType input);
    public DType get();
}
