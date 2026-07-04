package com.suso.component;

import com.suso.Types.GameObject;

public class Declaration {
//FIELDS
    private GameObject _type;
    private String _value;
//INITIATION
    public void _initType(){this._type = GameObject.get(0);}
//CONSTRUCTOR
    public Declaration(){}
//SETTER
    public void set(String value){this._value=value;}
//GETTER
    public String get(){return this._value;}

}
