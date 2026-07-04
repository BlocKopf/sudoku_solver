package com.suso.component;

public class Index {
//FIELDS
    private int _value;
//CONSTRUCTOR
    public Index(){}
//SHADOWS
    private boolean sign(int value){return value<0;}
    private int flipSign(int value){return -value;}
//SETTER
    public void set(int index){this._value=index;}
//GETTER
    public int get(){return this._value;}
//INCREMENTOR
    public void increase(){this.set(this.get()+1);}
    public void incBy(int value){
        if(this.sign(value)){this.set(this.get()+this.flipSign(value));}
        else{this.set(this.get()+value);}
    }
    public void decrease(){this.set(this.get()-1);}
    public void decBy(int value){
        if(this.sign(value)){this.set(this.get()+value);}
        else{this.set(this.get()+this.flipSign(value));}
    }
//ACTIONS
    public void changeBy(int value){this.set(this.get()+value);}
}
